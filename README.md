# PoGoGUI

## Overview
In proteogenomic analyses it is essential to know the loci giving rise to peptides in order to improve genomic annotation and the functional characterization of protein products in their biological context. With next-generation sequencing of DNA and RNA for each sample studied by proteomic mass spectrometry integration and visualisation in a common coordinate system, i.e. the genome, is vital for systems biology. Advances in technology in mass spectrometry now allow almost complete quantification of the sample proteome. With research moving to protein quantitative trait loci (pQTL) to identify genomic alterations with functional effects on the proteome and the high complexity of combinations thereof integration and visualisation of protein and peptide quantification on genomic loci is paramount for this type of analysis. Furthermore, moving towards more personal multi-omics studies comparative visualisation of proteomic data on a genome has been lacking. Not only genomic variation affecting proteins have come into focus of functional integration studies but also post-translational modifications (PTM), the effect of single nucleotide variants and other alterations on PTMs and alternative modification loci, and the effects of alternative PTMs on protein abundance have become more a centre of attention for researchers. To facilitate this type of integration not only the genomic locations of modified peptides but specifically the genomic loci of associated with these modifications is required. Here, we provide a graphical user interface (GUI) for the mapping tool, PoGo, to quickly and efficiently allow access to PoGo for non-bioinformaticians. To further enable wide use of PoGo this GUI also integrated FileConverter providing conversion functionality for standardized mass spectrometry peptide identifications in mzid, mzIdentML and mzTab formats to the four column file format required by PoGo.

## Download and Instiallation
PoGoGUI source code is written to support execution on Windows, Mac and Linux systems. A ready to use JAR file can be downloaded here: ftp://ftp.sanger.ac.uk/pub/teams/17/software/PoGo/.
To enable the successfull execution of PoGoGUI the PoGo commandline tool is required and can be downloaded for different operating systems from here: ftp://ftp.sanger.ac.uk/pub/teams/17/software/PoGo/.

## Learn and Support
PoGoGUI uses transcript translations and reference gene annotations as well as peptide identification files in four column tab separated format, mzid, mzIdentML, and mzTab formats to pass on to the specified PoGo executable. Additional parameters to select outputformats, enable mapping with amino acid substitutions or merging output of multiple peptide identification files can be selected through checkboxes and buttons.
For additional information about parameters, output formats and the algorithm please refer to http://www.sanger.ac.uk/science/tools/pogo.

<img src="http://ngs.sanger.ac.uk/production/proteogenomics/suppl/PoGoGUI_description.png" height="500px">

### Step by step
<ol><li>Download annotation and translated sequences for human from GENCODE, e.g. release 25. Go to www.gencodegenes.org/release/25.html and download the GTF file containing 'Comprehensive gene annotation' and the 'Protein-coding transcript translation sequences' as Fasta file. Store and unzip both files into a folder, e.g. ${POGO_DIR}/input/</li>
<li>Navigate to the folder that contains the PoGoGUI JAR (cd ${POGOGUI}) and execute the JAR using
<pre>java -jar ${POGOGUI}/PoGoGUI.jar</pre>
</li>
<li>In the user interface select the PoGo executable via the selection button.</li>
<li>Select the translated protein coding sequence file (FASTA) and the transcript annotation file (GTF) through the resprective Select buttons.</li>
<li>Add the input files with peptides for mapping in tsv, txt, mzid, mzIdentML, mzTab formats either through the Add button or through drag and drop into the list field. The GUI will create intermediate files in PoGo input format from mzid, mzIdentML and mzTab files if required</li>
<li>You can now choose optional parameter settings or keep the default seetings.</li>
<li>Through clicking the Start button the FileConverter, if required, is started followed by PoGo.</li>
<li>You can load the generated BED and/or GTF files into a genome browser or create an web accessible track hub for your data through the TrackHub Generator (http://www.sanger.ac.uk/science/tools/trackhub-generator). Here the example is shown for visualisation in the UCSC genome browser.<br><newline>To load the data into the browser please follow these steps:</newline>
<ol type='a'><li>Go to https://genome.ucsc.edu and navigate to 'My Data' -&gt; 'Custom Tracks'.</li><li>After clicking 'Choose File' select the file you want to upload and submit via the 'Submit' button.</li><li>You will be redirected to the 'Manage Custom Tracks' webpage.</li><li>Proceed from the 'Manage Custom Tracks' page by selecting 'Genome Browser' and confirm ('go').</li><li>Now you can browse the peptides mapped to their genomic loci on the reference genome.</li></ol></li></ol>

## Contact
Christoph Schlaffner (christoph.schlaffner@sanger.ac.uk)
