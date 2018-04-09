package com.example.txttoexcel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WrireTxtToExcel {

	private static final String FILENAME = "C:\\AZ_DATEN\\MainframeFiles\\LebenMigration\\AG2050.txt";
	static String wProtoStart = "PROTOKOLL AV2197 -";
	static String start;
	static String wDate = "PROTOKOLL AV2197 -";
	static String date;
	static String wJobname = "JOB P2050T39 (";
	static String jobNumber;
	static String wTotalCount = "EINGABENACHRICHTEN:       ";
	static String Totalcount;
	static String wAKOZims = "AKO AN ZIMS:             ";
	static String akoCount;
	static String wNotiz = "NOTIZEN AN ZIMS:         ";
	static String notizCount;
	static String wMemo = "MEMOS/MAILS AN ZIMS:      ";
	static String memoCount;
	static String wDoknicht = "DOKS NICHT VORHANDEN:    ";
	static String dokNichtCount;
	static String wKeinDokZims = "KEINE DOKS FÜR ZIMS:   ";
	static String keinZimsCount;
	static String wProtoEnd = "ENDE PROTOKOLL AV2197 -";
	static String end; 
	
	static FileInputStream file;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static File dbFile;
	static int a;
	static FileOutputStream out;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		getTheExcel();
		readTextFile();
		System.out.println("Processing completed");

	}


	private static void getTheExcel() {
		// TODO Auto-generated method stub
		dbFile = new File("C:\\AZ_DATEN\\MainframeFiles\\LebenMigration\\AG2050_OUT.xlsx");
		try {
			file = new FileInputStream(dbFile);
			workbook = new XSSFWorkbook(file);
			LocalDateTime  localDate = LocalDateTime .now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
	        System.out.println();
			sheet = workbook.createSheet("AG2050"+dtf.format(localDate));
			a = sheet.getLastRowNum();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private static void readTextFile() {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		FileReader fr = null;

		try {
			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.indexOf(wProtoStart) == 1) {
					date = sCurrentLine.substring(19);   
//					System.out.println(date.trim());
				}
				else if (sCurrentLine.contains(wJobname)) {
					jobNumber = sCurrentLine.substring(15);
					jobNumber = jobNumber.replace(")",	"");
//					System.out.println(jobNumber.trim());
				}
				else if (sCurrentLine.contains(wTotalCount)) {
					Totalcount = sCurrentLine.substring(22);
//					System.out.println(Totalcount.trim());
				}
				else if (sCurrentLine.contains(wAKOZims)) {
					akoCount = sCurrentLine.substring(22);
//					System.out.println(akoCount.trim());
				}
				else if (sCurrentLine.contains(wNotiz)) {
					notizCount = sCurrentLine.substring(22);  
//					System.out.println(notizCount.trim());
				}
				else if (sCurrentLine.contains(wMemo)) {
					memoCount = sCurrentLine.substring(22);  
//					System.out.println(memoCount.trim());
				}
				else if (sCurrentLine.contains(wDoknicht)) {
					dokNichtCount = sCurrentLine.substring(22); 
//					System.out.println(dokNichtCount.trim());
				}
				else if (sCurrentLine.contains(wKeinDokZims)) {
					keinZimsCount = sCurrentLine.substring(22); 
//					System.out.println(keinZimsCount.trim());
				}
				else if (sCurrentLine.contains(wProtoEnd)) {
					addToDB();
				}
				
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {
				
			    //Write the workbook in file system
			    out = new FileOutputStream(dbFile);
			    workbook.write(out);

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();
				
				if (out != null)
					out.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}
	
	
	public static void addToDB() {
		
		int i=0;
		
		try {
			
			a++;
			int countRows = a;
			
			
		    //This data needs to be written (Object[])
		    Map<Integer, Object[]> data = new TreeMap<Integer, Object[]>();
		    data.put(i, new Object[]{Integer.parseInt(jobNumber.trim()),date.trim(),Totalcount.trim(),akoCount.trim(),notizCount.trim(),memoCount.trim(),dokNichtCount.trim(),keinZimsCount.trim()});				
		    
		    //Iterate over data and write to sheet
		    Set<Integer> keyset = data.keySet();
	
		    int rownum = countRows;
		    for (Integer key : keyset) 
		    {
		        //create a row of excelsheet
		        Row row = sheet.createRow(rownum++);
	
		        //get object array of prerticuler key
		        Object[] objArr = data.get(key);
	
		        int cellnum = 0;
	
		        for (Object obj : objArr) 
		        {
		            Cell cell = row.createCell(cellnum++);
		            if (obj instanceof String) 
		            {
		                cell.setCellValue((String) obj);
		            }
		            else if (obj instanceof Double) 
		            {
		                cell.setCellValue((Double) obj);
		            }
		            else if (obj instanceof Integer) 
		            {
		                cell.setCellValue((Integer) obj);
		            }
		        }
		    }
		    
		}
		catch (Exception e)
	    {
			e.printStackTrace();
	    }
		
	}

}
