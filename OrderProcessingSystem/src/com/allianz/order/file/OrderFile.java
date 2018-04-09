package com.allianz.order.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.server.ObjID;

import com.allianz.order.Exception.FileNotFoundException1;

@SuppressWarnings("serial")
public class OrderFile implements java.io.Serializable {
		
		FileInputStream inStream;
		FileOutputStream outStream;
		FileReader inReader;
		FileWriter outWriter;
		int c;
		BufferedReader br;
		String sCurrentLine;
		BufferedWriter bw;
		
		public void readFile() throws FileNotFoundException1 {
			
			try {
				inStream = new FileInputStream(new File("./Resources/Input/Orderin.txt"));
				outStream = new FileOutputStream(new File("./Resources/Input/Orderout.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				while((c = inStream.read())!= -1){
					
					System.out.println(c);
					outStream.write(c);
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					inStream.close();
					outStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			try {
				
				inReader = new FileReader(new File("./Resources/Input/OrderFilein.txt"));
				outWriter = new FileWriter(new File("./Resources/Input/OrderFileout.txt"));
				try {
					
					throw new FileNotFoundException1("File reading Exception");
				} catch (FileNotFoundException1 e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				while((c=inReader.read())!= -1){
					outWriter.write(c);
					System.out.println(c);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					inReader.close();
					outWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			try {
				br = new BufferedReader(new FileReader("./Resources/Input/Orderin.txt"));
				bw = new BufferedWriter(new FileWriter("./Resources/Input/Orderout1.txt"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				while((sCurrentLine=br.readLine()) != null){
					if (sCurrentLine.substring(0,4).equalsIgnoreCase("NAME")){
						System.out.println(sCurrentLine.substring(4, 14));
						bw.write(sCurrentLine.substring(4, 14));
						bw.newLine();
					}
				}
				br.close();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			System.out.println("Enter Anything to Continue the Execution");
			InputStreamReader inStreamReader = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(inStreamReader);
			try {
				String str = br.readLine();
				System.out.println("Entered Value is: - " + str);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			OrderFile oFile = new OrderFile();
			oFile.c = 10;
			try {
				
				FileOutputStream fileOStream = new FileOutputStream(new File("./Resources/Input/object.ser"));
				ObjectOutputStream objOStream = new ObjectOutputStream(fileOStream);
				objOStream.writeObject(oFile);
				fileOStream.close();
				fileOStream.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				FileInputStream fileIStream = new FileInputStream(new File("./Resources/Input/object.ser"));
				ObjectInputStream objISteam = new ObjectInputStream(fileIStream);
				OrderFile ooFile = (OrderFile) objISteam.readObject();
				System.out.println("Deserializing of Objects");
				System.out.println("Value of c is: " + ooFile.c);
				fileIStream.close();
				objISteam.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
