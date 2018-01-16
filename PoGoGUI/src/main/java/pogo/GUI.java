package pogo;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JComboBox;

public class GUI extends JFrame implements ItemListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	final JFileChooser fc = new JFileChooser();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JList<String> list;
	private DefaultListModel<String> listModel;
	private JButton btnDelete;
	private JCheckBox chckbxAll;
	private JCheckBox chckbxBed;
	private JCheckBox chckbxPtmBed;
	private JCheckBox chckbxGtf;
	private JCheckBox chckbxGct;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public GUI() {
		setTitle("PoGo");
		setResizable(false);
		
		final ArrayList<BufferedImage> pogoimages = new ArrayList<BufferedImage>();
		
		try {
			pogoimages.add(ImageIO.read(GUI.class.getResourceAsStream("pogo.png")));
			pogoimages.add(ImageIO.read(GUI.class.getResourceAsStream("pogo_57x57.png")));
			pogoimages.add(ImageIO.read(GUI.class.getResourceAsStream("pogo_72x72.png")));
			pogoimages.add(ImageIO.read(GUI.class.getResourceAsStream("pogo_76x76.png")));
			pogoimages.add(ImageIO.read(GUI.class.getResourceAsStream("pogo_114x114.png")));
			pogoimages.add(ImageIO.read(GUI.class.getResourceAsStream("pogo_120x120.png")));
			pogoimages.add(ImageIO.read(GUI.class.getResourceAsStream("pogo_144x144.png")));
			pogoimages.add(ImageIO.read(GUI.class.getResourceAsStream("pogo_152x152.png")));
			pogoimages.add(ImageIO.read(GUI.class.getResourceAsStream("pogo_180x180.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Species species[] = new Species[25];
		species[0] = new Species("Homo sapiens","Human",9606);
		species[1] = new Species("Mus musculus","Mouse",10090);
		species[2] = new Species("Bos taurus","Cow",9913);
		species[3] = new Species("Callithrix jacchus","Marmoset",9483);
		species[4] = new Species("Canis lupus familiaris","Dog",9615);
		species[5] = new Species("Chlorocebus sabaeus","Vervet_AGM",60711);
		species[6] = new Species("Ciona intestinalis","C.intestinalis",7719);
		species[7] = new Species("Equus caballus","Horse",9796);
		species[8] = new Species("Felis catus","Cat",9685);
		species[9] = new Species("Gallus gallus","Chicken",9031);
		species[10] = new Species("Gorilla gorilla gorilla","Gorilla",9595);
		species[11] = new Species("Macaca mulatta","Macaque",9544);
		species[12] = new Species("Meleagris gallopavo","Turkey",9103);
		species[13] = new Species("Monodelphis domestica","Opossum",13616);
		species[14] = new Species("Ornithorhynchus anatinus","Platypus",9258);
		species[15] = new Species("Oryctolagus cuniculus","Rabbit",9986);
		species[16] = new Species("Oryzias latipes","Medaka",8090);
		species[17] = new Species("Ovis aries","Sheep",9940);
		species[18] = new Species("Pan troglodytes","Chimpazee",9598);
		species[19] = new Species("Papio anubis","Olive baboon",9555);
		species[20] = new Species("Pongo abelii","Orangutan",9601);
		species[21] = new Species("Rattus norvegicus","Rat",10116);
		species[22] = new Species("Sus scrofa","Pig",9823);
		species[23] = new Species("Taeniopygia guttata","Zebra Finch",59729);
		species[24] = new Species("Tetraodon nigroviridid","Tetraodon",99883);
				
		this.setIconImages(pogoimages);
		
		fc.setCurrentDirectory(new File(System.getProperty("user.home")));
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblOptions = new JLabel("Options");
		lblOptions.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblOptions = new GridBagConstraints();
		gbc_lblOptions.gridwidth = 3;
		gbc_lblOptions.anchor = GridBagConstraints.WEST;
		gbc_lblOptions.insets = new Insets(0, 0, 5, 0);
		gbc_lblOptions.gridx = 0;
		gbc_lblOptions.gridy = 0;
		panel.add(lblOptions, gbc_lblOptions);
		
		final JRadioButton rdbtnMergeMultipleInput = new JRadioButton("Merge multiple input files into single output");
		rdbtnMergeMultipleInput.setEnabled(false);
		GridBagConstraints gbc_rdbtnMergeMultipleInput = new GridBagConstraints();
		gbc_rdbtnMergeMultipleInput.gridwidth = 3;
		gbc_rdbtnMergeMultipleInput.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnMergeMultipleInput.gridx = 0;
		gbc_rdbtnMergeMultipleInput.gridy = 1;
		panel.add(rdbtnMergeMultipleInput, gbc_rdbtnMergeMultipleInput);
		
		JLabel lblOutputFormats = new JLabel("Output Formats");
		GridBagConstraints gbc_lblOutputFormats = new GridBagConstraints();
		gbc_lblOutputFormats.gridwidth = 3;
		gbc_lblOutputFormats.anchor = GridBagConstraints.WEST;
		gbc_lblOutputFormats.insets = new Insets(0, 0, 5, 0);
		gbc_lblOutputFormats.gridx = 0;
		gbc_lblOutputFormats.gridy = 2;
		panel.add(lblOutputFormats, gbc_lblOutputFormats);
		
		chckbxBed = new JCheckBox("BED");
		chckbxBed.setSelected(true);
		GridBagConstraints gbc_chckbxBed = new GridBagConstraints();
		gbc_chckbxBed.anchor = GridBagConstraints.WEST;
		gbc_chckbxBed.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxBed.gridx = 0;
		gbc_chckbxBed.gridy = 3;
		panel.add(chckbxBed, gbc_chckbxBed);
		chckbxBed.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				if(!abstractButton.isSelected()) {
					chckbxAll.setSelected(false);
				}
			}
			
		});
		
		chckbxPtmBed = new JCheckBox("PTM BED");
		chckbxPtmBed.setSelected(true);
		GridBagConstraints gbc_chckbxPtmBed = new GridBagConstraints();
		gbc_chckbxPtmBed.anchor = GridBagConstraints.WEST;
		gbc_chckbxPtmBed.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxPtmBed.gridx = 1;
		gbc_chckbxPtmBed.gridy = 3;
		panel.add(chckbxPtmBed, gbc_chckbxPtmBed);
		chckbxPtmBed.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				if(!abstractButton.isSelected()) {
					chckbxAll.setSelected(false);
				}
			}
			
		});
		
		chckbxAll = new JCheckBox("ALL");
		chckbxAll.setSelected(true);
		GridBagConstraints gbc_chckbxAll = new GridBagConstraints();
		gbc_chckbxAll.gridheight = 2;
		gbc_chckbxAll.anchor = GridBagConstraints.WEST;
		gbc_chckbxAll.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxAll.gridx = 2;
		gbc_chckbxAll.gridy = 3;
		panel.add(chckbxAll, gbc_chckbxAll);
		chckbxAll.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				if(abstractButton.isSelected()) {
					chckbxBed.setSelected(true);
					chckbxPtmBed.setSelected(true);
					chckbxGtf.setSelected(true);
					chckbxGct.setSelected(true);
				}
			}
			
		});
		
		chckbxGtf = new JCheckBox("GTF");
		chckbxGtf.setSelected(true);
		GridBagConstraints gbc_chckbxGtf = new GridBagConstraints();
		gbc_chckbxGtf.anchor = GridBagConstraints.WEST;
		gbc_chckbxGtf.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGtf.gridx = 0;
		gbc_chckbxGtf.gridy = 4;
		panel.add(chckbxGtf, gbc_chckbxGtf);
		chckbxGtf.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				if(!abstractButton.isSelected()) {
					chckbxAll.setSelected(false);
				}
			}
			
		});
		
		chckbxGct = new JCheckBox("GCT");
		chckbxGct.setSelected(true);
		GridBagConstraints gbc_chckbxGct = new GridBagConstraints();
		gbc_chckbxGct.anchor = GridBagConstraints.WEST;
		gbc_chckbxGct.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGct.gridx = 1;
		gbc_chckbxGct.gridy = 4;
		panel.add(chckbxGct, gbc_chckbxGct);
		chckbxGct.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				if(!abstractButton.isSelected()) {
					chckbxAll.setSelected(false);
				}
			}
			
		});
		
		JLabel lblAllowedAminoAcid = new JLabel("Allowed Amino Acid Mismatches");
		GridBagConstraints gbc_lblAllowedAminoAcid = new GridBagConstraints();
		gbc_lblAllowedAminoAcid.gridwidth = 3;
		gbc_lblAllowedAminoAcid.anchor = GridBagConstraints.WEST;
		gbc_lblAllowedAminoAcid.insets = new Insets(0, 0, 5, 0);
		gbc_lblAllowedAminoAcid.gridx = 0;
		gbc_lblAllowedAminoAcid.gridy = 5;
		panel.add(lblAllowedAminoAcid, gbc_lblAllowedAminoAcid);
		
		final JRadioButton radioButton_1 = new JRadioButton("0");
		radioButton_1.setSelected(true);
		GridBagConstraints gbc_radioButton_1 = new GridBagConstraints();
		gbc_radioButton_1.anchor = GridBagConstraints.WEST;
		gbc_radioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_1.gridx = 0;
		gbc_radioButton_1.gridy = 6;
		panel.add(radioButton_1, gbc_radioButton_1);
		
		final JRadioButton rdbtnI = new JRadioButton("2 (1 in window of 5 amino acids)");
		GridBagConstraints gbc_rdbtnI = new GridBagConstraints();
		gbc_rdbtnI.gridwidth = 2;
		gbc_rdbtnI.anchor = GridBagConstraints.WEST;
		gbc_rdbtnI.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnI.gridx = 1;
		gbc_rdbtnI.gridy = 6;
		panel.add(rdbtnI, gbc_rdbtnI);
		
		final JRadioButton radioButton_2 = new JRadioButton("1");
		GridBagConstraints gbc_radioButton_2 = new GridBagConstraints();
		gbc_radioButton_2.anchor = GridBagConstraints.WEST;
		gbc_radioButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_2.gridx = 0;
		gbc_radioButton_2.gridy = 7;
		panel.add(radioButton_2, gbc_radioButton_2);
		
		final JRadioButton radioButton = new JRadioButton("2");
		GridBagConstraints gbc_radioButton = new GridBagConstraints();
		gbc_radioButton.insets = new Insets(0, 0, 5, 0);
		gbc_radioButton.gridwidth = 2;
		gbc_radioButton.anchor = GridBagConstraints.WEST;
		gbc_radioButton.gridx = 1;
		gbc_radioButton.gridy = 7;
		panel.add(radioButton, gbc_radioButton);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButton_1);
		buttonGroup.add(radioButton_2);
		buttonGroup.add(rdbtnI);
		buttonGroup.add(radioButton);
		
		JLabel lblSpecies = new JLabel("Species");
		GridBagConstraints gbc_lblSpecies = new GridBagConstraints();
		gbc_lblSpecies.anchor = GridBagConstraints.WEST;
		gbc_lblSpecies.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpecies.gridx = 0;
		gbc_lblSpecies.gridy = 8;
		panel.add(lblSpecies, gbc_lblSpecies);
		
		final JComboBox<Species> comboBox = new JComboBox<Species>(species);
		comboBox.setSelectedItem("Human (Homo sapiens)");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 8;
		panel.add(comboBox, gbc_comboBox);
		
		JLabel lblSourceName = new JLabel("Source Name");
		GridBagConstraints gbc_lblSourceName = new GridBagConstraints();
		gbc_lblSourceName.anchor = GridBagConstraints.EAST;
		gbc_lblSourceName.insets = new Insets(0, 0, 5, 5);
		gbc_lblSourceName.gridx = 0;
		gbc_lblSourceName.gridy = 9;
		panel.add(lblSourceName, gbc_lblSourceName);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 2;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 9;
		panel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel label = new JLabel();
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridheight = 2;
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 10;
		panel.add(label, gbc_label);
		label.setIcon(new ImageIcon(GUI.class.getResource("pogo_57x57.png")));
		
		JLabel lblPogowebsite = new JLabel("<html> <a href=\"\">PoGo github page</a></html>");
		lblPogowebsite.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPogowebsite.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblPogowebsite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://github.com/cschlaffner/PoGoGUI"));
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		
		final JButton btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pogo = textField.getText();
				String fasta = textField_1.getText();
				String gtf = textField_2.getText();

				String source = textField_3.getText();
				String outf = "";
				if(chckbxAll.isSelected()) {
					outf = "ALL";
				} else {
					if(chckbxBed.isSelected()) {
						if(!outf.equals("")) {
							outf = outf + ",";
						}
						outf = outf + "BED";
					}
					if(chckbxPtmBed.isSelected()) {
						if(!outf.equals("")) {
							outf = outf + ",";
						}
						outf = outf + "PTMBED";
					}
					if(chckbxGtf.isSelected()) {
						if(!outf.equals("")) {
							outf = outf + ",";
						}
						outf = outf + "GTF";
					}
					if(chckbxGct.isSelected()) {
						if(!outf.equals("")) {
							outf = outf + ",";
						}
						outf = outf + "GCT";
					}
				}
				boolean merge = rdbtnMergeMultipleInput.isSelected();
				int mismatches = -1;
				if(rdbtnI.isSelected() || radioButton.isSelected()) {
					mismatches = 2;
				} else if (radioButton_1.isSelected()) {
					mismatches = 0;
				} else if (radioButton_2.isSelected()) {
					mismatches = 1;
				}
				boolean mismatchmode = rdbtnI.isSelected();
				String selectedSpeciesName = "homo sapiens";
				Species selectedSpecies = (Species)comboBox.getSelectedItem();
				selectedSpeciesName = selectedSpecies.getScientificName();
				
				String command = "";
				boolean able_to_run_pogo = false;
				boolean able_to_run_fasta = false;
				boolean able_to_run_gtf = false;
				boolean able_to_run_input = false;
				
				File execfile = new File(pogo);
				boolean exec = execfile.canExecute();
				String execfilename = execfile.getName();
				
				if(exec && (execfilename.startsWith("PoGo") || execfilename.startsWith("pogo") || (execfilename.startsWith("PoGo") && execfilename.endsWith("exe")) || (execfilename.startsWith("pogo") && execfilename.endsWith("exe")))) {
					File f = new File(pogo);
					if(f.exists() && !f.isDirectory()) {
						command = command + pogo + " ";
						able_to_run_pogo = true;
					} else {
						JOptionPane.showMessageDialog(GUI.this, "No valid executable file for PoGo found.\nPlease specify.","PoGo Executable Error",JOptionPane.ERROR_MESSAGE, new ImageIcon(GUI.class.getResource("fileError_57x57.png")));
					}
				}
				if(fasta.endsWith("fasta") || fasta.endsWith("fa") || fasta.endsWith("FASTA")) {
					File f = new File(fasta);
					if(f.exists() && !f.isDirectory()) {
						command = command + "-fasta " + fasta + " ";
						able_to_run_fasta = true;
					} else {
							JOptionPane.showMessageDialog(GUI.this, "No valid FASTA file found or file does not have valid file ending:\n  - *.fa, *.fasta, *.FASTA\nPlease specify.","FASTA File Error",JOptionPane.ERROR_MESSAGE, new ImageIcon(GUI.class.getResource("fileError_57x57.png")));
						}
				}
				if(gtf.endsWith("GTF") || gtf.endsWith("gtf")) {
					File f = new File(fasta);
					if(f.exists() && !f.isDirectory()) {
						command = command + "-gtf " + gtf + " ";
						able_to_run_gtf = true;
					} else {
						JOptionPane.showMessageDialog(GUI.this, "No valid GTF file found or file does not have valid file ending:\n  - *.gtf, *.GTF\nPlease specify.","GTF File Error",JOptionPane.ERROR_MESSAGE, new ImageIcon(GUI.class.getResource("fileError_57x57.png")));
					}
				}
				if(!listModel.isEmpty()) {
					String files = "";
					for(int idx = 0; idx < listModel.size(); idx++) {
						String filename = listModel.getElementAt(idx);
						File f = new File(filename);
						if(f.exists() && !f.isDirectory()) {
							String extension = filename.substring(filename.lastIndexOf(".")+1);
							if(extension.equalsIgnoreCase("mzid") || extension.equalsIgnoreCase("mzidentml") || extension.equalsIgnoreCase("mztab")) {
								try {
									filename = convertToPoGoInput(filename);
								} catch (IOException e1) {
									JOptionPane.showMessageDialog(GUI.this, "The conversion of " + filename + " failed.\nPlease ensure that the file has a valid format:\n  - *.mzid, *.mzId, *.mzidentml, *.mzIdentML, *.mztab, *.mzTab","Peptide File Conversion Error",JOptionPane.ERROR_MESSAGE, new ImageIcon(GUI.class.getResource("fileconverterError_57x57.png")));
									filename = "";
								}
							} else if (!extension.equalsIgnoreCase("txt") && !extension.equalsIgnoreCase("tsv") && !extension.equalsIgnoreCase("pogo")) {
								JOptionPane.showMessageDialog(GUI.this, "No valid peptide input file found or file does not have valid file ending:\n  - *.pogo, *.txt, *.tsv, *.mzid, *.mzId, *.mzidentml, *.mzIdentML, *.mztab, *.mzTab","Peptide File Error",JOptionPane.ERROR_MESSAGE, new ImageIcon(GUI.class.getResource("fileError_57x57.png")));
							}
							if(!filename.equals("")) {
								if(!files.equals("")) {
									files = files + ",";
								}
								files = files + filename;
							} else {
								JOptionPane.showMessageDialog(GUI.this, "No valid peptide input file found.\nPlease specify.","Peptide File Error",JOptionPane.ERROR_MESSAGE, new ImageIcon(GUI.class.getResource("fileError_57x57.png")));
							}
						}
					}
					command = command + "-in " + files + " ";
					able_to_run_input = files != "";
				}
				
				command = command + "-format " + outf + " ";
				if(!source.equals("")) {
					command = command + "-source " + source + " ";
				}
				if(merge) {
					command = command + "-merge TRUE ";
				}
				command = command + "-mm " + mismatches;
				if(mismatchmode) {
					command = command + " -mmmode TRUE";
				}
				command = command + " -species " + selectedSpeciesName;
				
				if(able_to_run_pogo && able_to_run_fasta && able_to_run_gtf && able_to_run_input) {
					
						btnNewButton.setEnabled(false);

						final JOptionPane mapping2 = new JOptionPane();
						mapping2.setMessageType(JOptionPane.INFORMATION_MESSAGE);
						mapping2.setOptions(new Object[] {});
						mapping2.setIcon(new ImageIcon(GUI.class.getResource("pogo_57x57.png")));
						mapping2.setMessage("PoGo is mapping your peptides.\nPlease wait.");
						
						final JDialog mapping = mapping2.createDialog(GUI.this, "PoGo is working hard...");
						mapping.setIconImages(pogoimages);
						mapping.setLocationRelativeTo(GUI.this);
						mapping.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
						mapping.setModal(true);
						
						
						class Worker extends SwingWorker<Void,Void> {
							private String command;
							
							public void setCommand(String comm) {
								command = comm;
							}
							
							@Override
							protected Void doInBackground() {
								
								try {	
									Runtime rt = Runtime.getRuntime();
									Process pr = rt.exec(command);
									pr.waitFor();
									int exitcode = pr.exitValue();
									if(exitcode!=0) {
										JOptionPane.showMessageDialog(GUI.this, "PoGo terminated unexpectedly.\nPlease check input files and restart.", "PoGo Execution Error", JOptionPane.ERROR_MESSAGE, new ImageIcon(GUI.class.getResource("pogoError_57x57.png")));
									}
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									JOptionPane.showMessageDialog(GUI.this, "Please ensure that\n  - PoGo executable,\n  - protein sequence (FASTA),\n  - transcript annotations (GTF) and\n  -at lease one peptide input file\nare provided and valid.", "Command Execution Error", JOptionPane.ERROR_MESSAGE, new ImageIcon(GUI.class.getResource("commandError_57x57.png")));
									e1.printStackTrace();
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									JOptionPane.showMessageDialog(GUI.this, "The execution of PoGo was interrupted.\nPlease check your input files.", "Command Interruption Error", JOptionPane.ERROR_MESSAGE, new ImageIcon(GUI.class.getResource("commandError_57x57.png")));
									e1.printStackTrace();
								}
								
								return null;
							}
							
							@Override
							protected void done() {
								mapping.dispose();
							}
						};
						Worker myworker = new Worker();
						System.out.println(command);
						myworker.setCommand(command);
						myworker.execute(); 
						mapping.setVisible(true);
						try{
							myworker.get();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(GUI.this, "PoGo terminated successfully.\nYou can now load the output data into your genome browser.", "PoGo Finished", JOptionPane.OK_OPTION, new ImageIcon(GUI.class.getResource("pogoFinished_57x57.png")));
						btnNewButton.setEnabled(true);

				} else {
					JOptionPane.showMessageDialog(GUI.this, "Not all required files are specified.\nPlease ensure that\n  - PoGo executable,\n  - protein sequence (FASTA),\n  - transcript annotations (GTF) and\n  -at lease one peptide input file\nare provided.", "Missing File Error", JOptionPane.ERROR_MESSAGE, new ImageIcon(GUI.class.getResource("fileError_57x57.png")));
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 10;
		panel.add(btnNewButton, gbc_btnNewButton);
		GridBagConstraints gbc_lblPogowebsite = new GridBagConstraints();
		gbc_lblPogowebsite.anchor = GridBagConstraints.EAST;
		gbc_lblPogowebsite.gridx = 2;
		gbc_lblPogowebsite.gridy = 11;
		panel.add(lblPogowebsite, gbc_lblPogowebsite);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblPogoExecutable = new JLabel("PoGo Executable");
		lblPogoExecutable.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblPogoExecutable = new GridBagConstraints();
		gbc_lblPogoExecutable.gridwidth = 3;
		gbc_lblPogoExecutable.anchor = GridBagConstraints.WEST;
		gbc_lblPogoExecutable.insets = new Insets(0, 0, 5, 0);
		gbc_lblPogoExecutable.gridx = 0;
		gbc_lblPogoExecutable.gridy = 0;
		panel_1.add(lblPogoExecutable, gbc_lblPogoExecutable);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fc.setMultiSelectionEnabled(false);
				fc.setAcceptAllFileFilterUsed(true);
				int refVal = fc.showOpenDialog(GUI.this);
				if(refVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					textField.setText(file.getAbsolutePath());
				}
			}
		});
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelect.gridx = 2;
		gbc_btnSelect.gridy = 1;
		panel_1.add(btnSelect, gbc_btnSelect);
		
		JLabel lblReferenceInput = new JLabel("Reference Input");
		lblReferenceInput.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblReferenceInput = new GridBagConstraints();
		gbc_lblReferenceInput.gridwidth = 3;
		gbc_lblReferenceInput.anchor = GridBagConstraints.WEST;
		gbc_lblReferenceInput.insets = new Insets(0, 0, 5, 0);
		gbc_lblReferenceInput.gridx = 0;
		gbc_lblReferenceInput.gridy = 2;
		panel_1.add(lblReferenceInput, gbc_lblReferenceInput);
		
		JLabel lblProteinSequencesfasta = new JLabel("Protein Sequences (FASTA)");
		GridBagConstraints gbc_lblProteinSequencesfasta = new GridBagConstraints();
		gbc_lblProteinSequencesfasta.gridwidth = 3;
		gbc_lblProteinSequencesfasta.anchor = GridBagConstraints.WEST;
		gbc_lblProteinSequencesfasta.insets = new Insets(0, 0, 5, 0);
		gbc_lblProteinSequencesfasta.gridx = 0;
		gbc_lblProteinSequencesfasta.gridy = 3;
		panel_1.add(lblProteinSequencesfasta, gbc_lblProteinSequencesfasta);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 4;
		panel_1.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton btnSelect_1 = new JButton("Select");
		btnSelect_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fc.setMultiSelectionEnabled(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Protein sequences in FASTA format","fa","fasta");
				fc.addChoosableFileFilter(filter);
				fc.setAcceptAllFileFilterUsed(false);
				int refVal = fc.showOpenDialog(GUI.this);
				if(refVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					textField_1.setText(file.getAbsolutePath());
				}
				fc.removeChoosableFileFilter(filter);
				
			}
		});
		GridBagConstraints gbc_btnSelect_1 = new GridBagConstraints();
		gbc_btnSelect_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelect_1.gridx = 2;
		gbc_btnSelect_1.gridy = 4;
		panel_1.add(btnSelect_1, gbc_btnSelect_1);
		
		JLabel lblTranscriptAnnotationgtf = new JLabel("Transcript Annotation (GTF)");
		GridBagConstraints gbc_lblTranscriptAnnotationgtf = new GridBagConstraints();
		gbc_lblTranscriptAnnotationgtf.gridwidth = 3;
		gbc_lblTranscriptAnnotationgtf.anchor = GridBagConstraints.WEST;
		gbc_lblTranscriptAnnotationgtf.insets = new Insets(0, 0, 5, 0);
		gbc_lblTranscriptAnnotationgtf.gridx = 0;
		gbc_lblTranscriptAnnotationgtf.gridy = 5;
		panel_1.add(lblTranscriptAnnotationgtf, gbc_lblTranscriptAnnotationgtf);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 6;
		panel_1.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JButton btnSelect_2 = new JButton("Select");
		btnSelect_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fc.setMultiSelectionEnabled(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Annotation file in general transfer format","gtf");
				fc.setAcceptAllFileFilterUsed(false);
				fc.addChoosableFileFilter(filter);
				int refVal = fc.showOpenDialog(GUI.this);
				if(refVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					textField_2.setText(file.getAbsolutePath());
				}
				fc.removeChoosableFileFilter(filter);
			}
		});
		GridBagConstraints gbc_btnSelect_2 = new GridBagConstraints();
		gbc_btnSelect_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelect_2.gridx = 2;
		gbc_btnSelect_2.gridy = 6;
		panel_1.add(btnSelect_2, gbc_btnSelect_2);
		
		JLabel lblPeptideFiles = new JLabel("Peptide Files");
		lblPeptideFiles.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblPeptideFiles = new GridBagConstraints();
		gbc_lblPeptideFiles.insets = new Insets(0, 0, 5, 5);
		gbc_lblPeptideFiles.anchor = GridBagConstraints.WEST;
		gbc_lblPeptideFiles.gridx = 0;
		gbc_lblPeptideFiles.gridy = 7;
		panel_1.add(lblPeptideFiles, gbc_lblPeptideFiles);
		
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!list.isSelectionEmpty()) {
					int index  = list.getSelectedIndices().length - 1;
					while(list.getSelectedIndices().length!=0) {
						listModel.removeElementAt(list.getSelectedIndices()[index--]);
					}
					if(listModel.getSize()<2) {
						rdbtnMergeMultipleInput.setSelected(false);
						rdbtnMergeMultipleInput.setEnabled(false);
					}
				}
				btnDelete.setEnabled(false);
			}
		});
		btnDelete.setEnabled(false);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.gridx = 2;
		gbc_btnDelete.gridy = 7;
		panel_1.add(btnDelete, gbc_btnDelete);
		
		listModel = new DefaultListModel<String>();
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fc.setMultiSelectionEnabled(true);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Peptide Identifications","pogo","txt","tsv","mzidetml","mzid","mztab");
				fc.addChoosableFileFilter(filter);
				fc.setAcceptAllFileFilterUsed(false);
				int refVal = fc.showOpenDialog(GUI.this);
				if(refVal == JFileChooser.APPROVE_OPTION) {
					File[] files = fc.getSelectedFiles();
					if(files.length>0) {
						btnDelete.setEnabled(true);
					}
					for(File file : files) {
						if(!listModel.contains(file.getAbsolutePath()))
							listModel.addElement(file.getAbsolutePath());
					}
					if(listModel.getSize()>1) {
						rdbtnMergeMultipleInput.setEnabled(true);
					}
				}
				fc.removeChoosableFileFilter(filter);
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 7;
		panel_1.add(btnAdd, gbc_btnAdd);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 8;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		list = new JList<String>(listModel);
		scrollPane.setViewportView(list);
		list.setDropTarget(new DropTarget() {
	        public synchronized void drop(DropTargetDropEvent evt) {
	            try {
	                evt.acceptDrop(DnDConstants.ACTION_COPY);
	                @SuppressWarnings("unchecked")
					List<File> droppedFiles = (List<File>) evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
	                for (File file : droppedFiles) {
	                	if(!listModel.contains(file.getAbsolutePath()))
	                		listModel.addElement(file.getAbsolutePath());
	                }
	                if(listModel.getSize()>1) {
	                	rdbtnMergeMultipleInput.setEnabled(true);
	                }
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	    });
		list.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent evt) {
				if(evt.getValueIsAdjusting()) {
					return;
				}
				if(!list.isSelectionEmpty()) {
					btnDelete.setEnabled(true);
				}
				
			}
		});
	}
	
	public String convertToPoGoInput(String filename) throws IOException {
		
		final ArrayList<BufferedImage> fileconverterimages = new ArrayList<BufferedImage>();
		String oldfilename = filename;
		
		try {
			fileconverterimages.add(ImageIO.read(GUI.class.getResourceAsStream("fileconverter.png")));
			fileconverterimages.add(ImageIO.read(GUI.class.getResourceAsStream("fileconverter_57x57.png")));
			fileconverterimages.add(ImageIO.read(GUI.class.getResourceAsStream("fileconverter_72x72.png")));
			fileconverterimages.add(ImageIO.read(GUI.class.getResourceAsStream("fileconverter_76x76.png")));
			fileconverterimages.add(ImageIO.read(GUI.class.getResourceAsStream("fileconverter_114x114.png")));
			fileconverterimages.add(ImageIO.read(GUI.class.getResourceAsStream("fileconverter_120x120.png")));
			fileconverterimages.add(ImageIO.read(GUI.class.getResourceAsStream("fileconverter_144x144.png")));
			fileconverterimages.add(ImageIO.read(GUI.class.getResourceAsStream("fileconverter_152x152.png")));
			fileconverterimages.add(ImageIO.read(GUI.class.getResourceAsStream("fileconverter_180x180.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		final JOptionPane mapping2 = new JOptionPane();
		mapping2.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		mapping2.setIcon(new ImageIcon(GUI.class.getResource("fileconverter_57x57.png")));
		mapping2.setOptions(new Object[] {});
		mapping2.setMessage("FileConverter is converting input file to PoGo format.\nPlease wait.");
		
		final JDialog mapping = mapping2.createDialog(GUI.this, "FileConverter is working hard...");
		mapping.setIconImages(fileconverterimages);
		mapping.pack();
		mapping.setLocationRelativeTo(GUI.this);
		mapping.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		mapping.setModal(true);
		
		class Worker extends SwingWorker<Void,Void> {
			private String filename;
			
			public void setFilename(String name) {
				filename = name;
			}
			
			public String getFilename() {
				return filename;
			}
			
			@Override
			protected Void doInBackground() {
				
				try {	
					filename = FileConverter.convert(filename);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(GUI.this, "FileConverter was not able to convert your input file.\nPlease check that your peptide input files are valid.", "FileConverter Error", JOptionPane.ERROR_MESSAGE, new ImageIcon(GUI.class.getResource("fileconverterError_57x57.png")));
					e1.printStackTrace();
				}
				
				return null;
			}
			
			@Override
			protected void done() {
				mapping.dispose();
			}
		};
		Worker myworker = new Worker();
		myworker.setFilename(filename);
		try{
			myworker.execute(); 
			mapping.setVisible(true);
		
			myworker.get();
			filename = myworker.getFilename();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(oldfilename==filename) {
			filename="";
			throw new IOException();
		} else {
			return filename;
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}


