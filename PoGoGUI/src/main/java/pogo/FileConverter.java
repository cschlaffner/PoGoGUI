package pogo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.ac.ebi.pride.utilities.data.controller.impl.ControllerImpl.AbstractDataAccessController;
import uk.ac.ebi.pride.utilities.data.controller.impl.ControllerImpl.MzIdentMLControllerImpl;
import uk.ac.ebi.pride.utilities.data.controller.impl.ControllerImpl.MzTabControllerImpl;
import uk.ac.ebi.pride.utilities.data.core.Modification;
import uk.ac.ebi.pride.utilities.data.core.Peptide;
import uk.ac.ebi.pride.utilities.data.core.Protein;
import uk.ac.ebi.pride.utilities.data.core.Sample;

public class FileConverter {

	@SuppressWarnings("rawtypes")
	public static String convert(String filename) throws IOException{
		
		File inFile = new File(filename);
		String outname = inFile.getAbsolutePath();
		outname = outname.substring(0,outname.lastIndexOf(File.separator));
		String name = inFile.getName();
		String extension = name.substring(name.lastIndexOf(".")+1);
		name = name.substring(0,name.lastIndexOf("."));
		
		String outfilename = outname + File.separator + name + ".txt";
		
		Map<String, Map<String,Pair<Integer, Double>>> map = new HashMap<String, Map<String, Pair<Integer,Double>>>();
		
		AbstractDataAccessController controller = null;
		if(extension.equalsIgnoreCase("mzid") || extension.equalsIgnoreCase("mzidentml")) {
			controller = new MzIdentMLControllerImpl(inFile);
		} else if (extension.equalsIgnoreCase("mztab")) {
			controller = new MzTabControllerImpl(inFile);
		}

		if(controller != null) {
			List<String> samples = new ArrayList<String>();
			if(!controller.getExperimentMetaData().getSamples().isEmpty()) {
				List<Sample> origsamples = controller.getExperimentMetaData().getSamples();
				for(Sample sample : origsamples) {
					samples.add(sample.getName().replaceAll(" ", "_").replaceAll(",", ""));
				}
			} else {
				samples.add(name.replaceAll(" ", "_"));
			}
			
			Collection<Comparable> proteinIds = controller.getProteinIds();
			for(Comparable proteinId : proteinIds) {
				Protein msProtein = controller.getProteinById(proteinId);
				List<Peptide> peptides = msProtein.getPeptides();
				for(Peptide pep : peptides) {
					List<Modification> mods = pep.getModifications();
					String seq = pep.getPeptideSequence().getSequence();
					String newseq = "";
					for(int l = 0; l < seq.length(); ++l) {
						newseq = newseq + seq.charAt(l);
						for(Modification mod : mods) {
							if((mod.getLocation()-1)==l) {
								newseq = newseq + "(" + mod.getName().replaceAll(" ", "_").replaceAll(",", "-").replaceAll("\\.", "-") + ")";
							}
						}
					}
					if(map.containsKey(newseq)) {
						Map<String,Pair<Integer,Double>> tmpmap = map.remove(newseq);
						for(String sample : samples) {
							if(tmpmap.containsKey(sample)) {
								Pair<Integer,Double> tmppair = tmpmap.remove(sample);
								tmppair.setFirst(tmppair.getFirst()+1);
								tmpmap.put(sample, tmppair);
							} else {
								Pair<Integer,Double> tmppair = new Pair<Integer,Double>(1,0.0);
								tmpmap.put(sample, tmppair);
							}
						}
						map.put(newseq, tmpmap);
					} else {
						Map<String,Pair<Integer,Double>> tmpmap = new HashMap<String,Pair<Integer,Double>>();
						Pair<Integer,Double> tmppair = new Pair<Integer,Double>(1,0.0);
						for(String sample : samples) {
							tmpmap.put(sample, tmppair);
						}
						map.put(newseq,tmpmap);
					}
				}
			}
		
		}
		
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outfilename)));
		
		writer.write("Experiment\tPeptide\tPSMs\tQuant\n");
		
		for(String peptide : map.keySet()) {
			for(String sample : map.get(peptide).keySet()) {
				writer.write(sample + "\t" + peptide + "\t" + map.get(peptide).get(sample).getFirst() + "\t" + map.get(peptide).get(sample).getSecond() + "\n");
			}
		}
		
		writer.close();

		return outfilename;
	}
	
}
