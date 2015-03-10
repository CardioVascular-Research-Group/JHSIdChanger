/* Copyright 2015 Cardiovascular Research Grid
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 * 
 *	All rights reserved
 * 	
 * 	@author Stephen J Granite (Email: sgranite@jhu.edu)
 */

package org.cvrgrid.ui;

/*
 * This is the main class to change the identifiers of Jackson Heart Study subjects, based upon the
 * information in an Excel file and a folder of corresponding GE MUSE XML files.
 * It is a variation of the Real's How To example of selecting a directory with a JFileChooser.
 * Those software can be found here: http://www.rgagnon.com/javadetails/java-0370.html.
 * 
 * The tool itself is a Java Swing GUI that expects a user to select an Excel file and a folder 
 * containing GE MUSE XML files.  These selections are made by clicking corresponding buttons that 
 * then invoke JFileChoosers, tailored to get an Excel file or a folder.  After each selection, a 
 * JLabel updates showing the path of the file or folder chosen next to the corresponding button.  Once
 * both JLabels are populated, a third button becomes enabled.  The enabled button, once clicked, causes
 * the ID change process to occur.  In that process, the tool opens the Excel file and creates a HashMap,
 * mapping new IDs to old IDs.  With the HashMap, the tool then goes through all the files in the chosen
 * folder, reading in the XML for files with the names of the old IDs. In memory, the tool replaces the
 * old ID with the new ID.  The tool then writes the to a new file, naming the new file with the new ID.  
 * 
 * The tool requires the Apache POI libraries to work with Excel files and the JAXB libraries to work 
 * with the GE MUSE XML.  All these dependencies are stored in the pom.xml.  In addition, the tool uses
 * a JAXB library rendered from an XML schema representing GE MUSE XML.  Both are included in the source 
 * code.  Finally, as GE MUSE actually uses a DTD for its XML, the restingecg.dtd must be in the folder
 * that the tool processes.
 */

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.cvrgrid.gemuse.jaxb.beans.PatientDemographics;
import org.cvrgrid.gemuse.jaxb.beans.RestingECG;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;


public class JHSIdChanger extends JPanel implements ActionListener {


	private static final long serialVersionUID = 247625339404793666L;
	JButton excelButton, folderButton, processButton;
	JLabel excelFileInfo, folderChosen, processComplete;
	JFileChooser chooser;
	String lastDirectory, excelFilePath, xmlFolderPath, excelExtension;
	HashMap<String,String> idMapping;


	public JHSIdChanger() {
		//Initialize Variables and Layout
		setLastDirectory("");
		setExcelFilePath("");
		setXmlFolderPath("");
		setExcelExtension("");
		setIdMapping(new HashMap<String,String>());
		setLayout(new GridLayout(0,2,20,20));
		setExcelButton(new JButton("Select the Excel file"));
		JButton excelButton = getExcelButton();
		excelButton.addActionListener(this);
		add(excelButton);
		setExcelFileInfo(new JLabel(""));
		JLabel excelFileInfo = getExcelFileInfo();
		add(excelFileInfo);
		setFolderButton(new JButton("Select the folder with XML files"));
		JButton folderButton = getFolderButton();
		folderButton.addActionListener(this);
		add(folderButton);
		setFolderChosen(new JLabel(""));
		JLabel folderChosen = getFolderChosen();
		add(folderChosen);
		setProcessButton(new JButton("Process the XML Files"));
		JButton processButton = getProcessButton();
		processButton.setEnabled(false);
		processButton.addActionListener(this);
		add(processButton);
		setProcessComplete(new JLabel("<-- Click this button to process"));
		JLabel processComplete = getProcessComplete();
		add(processComplete);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equalsIgnoreCase(getProcessButton().getActionCommand())) {
			try {
				if (getExcelExtension().equalsIgnoreCase("xls")) {
					setIdMapping(readXlsFile(getExcelFilePath()));
				} else {
					setIdMapping(readXlsxFile(getExcelFilePath()));			
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			Set<String> keys = getIdMapping().keySet();
			TreeSet<String> sortedKeys = new TreeSet<String>(keys);
			for (String subjectMapping : sortedKeys) {
				try {
					process(new File(getXmlFolderPath() +  "\\" + subjectMapping + ".xml"), new File(getXmlFolderPath() +  "\\" + getIdMapping().get(subjectMapping) + ".xml"), getIdMapping().get(subjectMapping));
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (JAXBException jaxb) {
					jaxb.printStackTrace();
				}
			}
			JLabel temp = getProcessComplete();
			temp.setText("Process Complete");
		} else { //then you need to select either the Excel file or the folder to activate the process button
			JLabel temp = getProcessComplete();
			temp.setText("<-- Click this button to process");
			setChooser(new JFileChooser()); 
			JFileChooser chooser = getChooser();
			if (getLastDirectory().equalsIgnoreCase("")) {
				chooser.setCurrentDirectory(new File("."));
			} else {
				chooser.setCurrentDirectory(new File(getLastDirectory()));			
			}
			if (e.getActionCommand().equalsIgnoreCase(getExcelButton().getActionCommand())) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files (xls, xlsx)", "xls", "xlsx");
				chooser.setFileFilter(filter);
			} else { //then you are looking to set a folder for the XML files
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);			
			}
			if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
				lastDirectory = chooser.getCurrentDirectory().toString();
				if (e.getActionCommand().equalsIgnoreCase(getExcelButton().getActionCommand())) {
					setExcelFilePath(chooser.getSelectedFile().toString());
					setExcelExtension(getExcelFilePath().split("\\.")[1]);
					temp = getExcelFileInfo();
					temp.setText("Excel file: " + getExcelFilePath());
				} else {
					setXmlFolderPath(chooser.getSelectedFile().toString());
					temp = getFolderChosen();
					temp.setText("XML Folder: " + getXmlFolderPath());
				}
			}
			if ((!(getExcelFilePath().equalsIgnoreCase("")) && !(getXmlFolderPath().equalsIgnoreCase("")))) {
				getProcessButton().setEnabled(true);			
			}
		}
	}

	public static void process(File input, File output, String subjectId) throws IOException, JAXBException {
		JAXBContext context = JAXBContext.newInstance("org.cvrgrid.gemuse.jaxb.beans");

		RestingECG restingecg = preprocess(context, input, subjectId);

		Marshaller writer = context.createMarshaller();
		writer.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		writer.marshal(restingecg, output);
	}

	private static RestingECG preprocess(JAXBContext context, File input, String subjectId) throws JAXBException, IOException {
		Unmarshaller reader = context.createUnmarshaller();
		RestingECG restingecg = (RestingECG)reader.unmarshal(input);
		PatientDemographics patdemo = restingecg.getPatientDemographics();
		patdemo.setPatientID(subjectId);

		return restingecg;
	}


	public Dimension getPreferredSize(){
		return new Dimension(600, 200);
	}

	/**
	 * @return the excelButton
	 */
	public JButton getExcelButton() {
		return excelButton;
	}

	/**
	 * @param excelButton the excelButton to set
	 */
	public void setExcelButton(JButton excelButton) {
		this.excelButton = excelButton;
	}

	/**
	 * @return the folderButton
	 */
	public JButton getFolderButton() {
		return folderButton;
	}

	/**
	 * @param folderButton the folderButton to set
	 */
	public void setFolderButton(JButton folderButton) {
		this.folderButton = folderButton;
	}

	/**
	 * @return the processButton
	 */
	public JButton getProcessButton() {
		return processButton;
	}

	/**
	 * @param processButton the processButton to set
	 */
	public void setProcessButton(JButton processButton) {
		this.processButton = processButton;
	}

	/**
	 * @return the excelFileInfo
	 */
	public JLabel getExcelFileInfo() {
		return excelFileInfo;
	}

	/**
	 * @param excelFileInfo the excelFileInfo to set
	 */
	public void setExcelFileInfo(JLabel excelFileInfo) {
		this.excelFileInfo = excelFileInfo;
	}

	/**
	 * @return the folderChosen
	 */
	public JLabel getFolderChosen() {
		return folderChosen;
	}

	/**
	 * @param folderChosen the folderChosen to set
	 */
	public void setFolderChosen(JLabel folderChosen) {
		this.folderChosen = folderChosen;
	}

	/**
	 * @return the processComplete
	 */
	public JLabel getProcessComplete() {
		return processComplete;
	}

	/**
	 * @param processComplete the processComplete to set
	 */
	public void setProcessComplete(JLabel processComplete) {
		this.processComplete = processComplete;
	}

	/**
	 * @return the chooser
	 */
	public JFileChooser getChooser() {
		return chooser;
	}

	/**
	 * @param chooser the chooser to set
	 */
	public void setChooser(JFileChooser chooser) {
		this.chooser = chooser;
	}

	/**
	 * @return the lastDirectory
	 */
	public String getLastDirectory() {
		return lastDirectory;
	}

	/**
	 * @param lastDirectory the lastDirectory to set
	 */
	public void setLastDirectory(String lastDirectory) {
		this.lastDirectory = lastDirectory;
	}

	/**
	 * @return the excelFilePath
	 */
	public String getExcelFilePath() {
		return excelFilePath;
	}

	/**
	 * @param excelFilePath the excelFilePath to set
	 */
	public void setExcelFilePath(String excelFilePath) {
		this.excelFilePath = excelFilePath;
	}

	/**
	 * @return the xmlFolderPath
	 */
	public String getXmlFolderPath() {
		return xmlFolderPath;
	}

	/**
	 * @param xmlFolderPath the xmlFolderPath to set
	 */
	public void setXmlFolderPath(String xmlFolderPath) {
		this.xmlFolderPath = xmlFolderPath;
	}

	/**
	 * @return the excelExtension
	 */
	public String getExcelExtension() {
		return excelExtension;
	}

	/**
	 * @param excelExtension the excelExtension to set
	 */
	public void setExcelExtension(String excelExtension) {
		this.excelExtension = excelExtension;
	}

	/**
	 * @return the idMapping
	 */
	public HashMap<String, String> getIdMapping() {
		return idMapping;
	}

	/**
	 * @param idMapping the idMapping to set
	 */
	public void setIdMapping(HashMap<String, String> idMapping) {
		this.idMapping = idMapping;
	}

	/**
	 * creates an {@link XSSFWorkbook} the specified OS filename.
	 */
	private HashMap<String,String> readXlsxFile(String filename) throws IOException {
		HashMap<String,String> temp = getIdMapping();
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(filename));
		XSSFSheet sheet = wb.getSheetAt(0);
		for (int r = 1; r < sheet.getLastRowNum()+1; r++) {
			XSSFRow row = sheet.getRow(r);
			if (row == null) {
				continue;
			}
			temp.put(row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue());
		}
		return temp;
	}

	/**
	 * creates an {@link HSSFWorkbook} the specified OS filename.
	 */
	private HashMap<String,String> readXlsFile(String filename) throws IOException {
		HashMap<String,String> temp = getIdMapping();
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(filename));
		HSSFSheet sheet = wb.getSheetAt(0);
		for (int r = 1; r < sheet.getLastRowNum()+1; r++) {
			HSSFRow row = sheet.getRow(r);
			if (row == null) {
				continue;
			}
			temp.put(row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue());
		}
		return temp;

	}


	public static void main(String s[]) {
		JFrame frame = new JFrame("Create new deidentified XML Files");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/3-frame.getSize().width/2, dim.height/3-frame.getSize().height/2);
		JHSIdChanger panel = new JHSIdChanger();
		frame.addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				}
				);
		frame.getContentPane().add(panel,"Center");
		frame.setSize(panel.getPreferredSize());
		frame.setVisible(true);
	}
}
