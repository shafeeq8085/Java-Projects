package com.allainz.k2.output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.allianz.k2.db2dao.K2object;

public class K2output {

		BufferedWriter bw; 
		public void outcreator(){
			
			File fileOut = null;
			try {
				System.out.println("Creating Out File");
				fileOut = new File("/l/bin/vo40_emailing/jbridgeprofiltest/Output.txt");
				bw = new BufferedWriter(new FileWriter(fileOut));
				
			} catch (Exception  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error while creating output file: "+e.getMessage());
				System.out.println("File Name: "+fileOut);
			} 
			
			
			
		}
		
		public void outWriter(K2object thiK2object){
			
			try {
				System.out.println("Writing started");
				String fileOut = thiK2object.getVsnr()+thiK2object.gethinweise();
				System.out.println("Record Details: "+fileOut);
				bw.write(fileOut);
				bw.newLine();
				System.out.println("Writing ended for one VSNR");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("File Write Failed"+e.getMessage());
				e.printStackTrace();
			}
		}
		
		public void closeWriter(){
			
			try {
				System.out.println("Closing File");
				bw.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("File Closing Failed"+e.getMessage());
				e.printStackTrace();
			}
		}
}
