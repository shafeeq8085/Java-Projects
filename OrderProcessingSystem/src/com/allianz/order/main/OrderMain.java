package com.allianz.order.main;

import java.io.File;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.allianz.order.Exception.FileNotFoundException1;
import com.allianz.order.conversion.OrderConversion;
import com.allianz.order.conversion.OrderConversionImpl;
import com.allianz.order.file.OrderFile;
import com.allianz.order.helper.ProcessingHelper;
import com.allianz.order.helper.ProcessingHelperImpl;
import com.allianz.order.item.OrderItem;
import com.allianz.order.person.OrderDetails;
import com.allianz.order.person.OrderPerson;
import com.allianz.order.stock.Stock;
import com.allianz.order.stock.StockImpl;
import com.allianz.order.xml.EmployeeJDomXML;
import com.allianz.order.xml.EmployeeXML;
import com.allianz.order.xml.XMLDoc;
import com.allinaz.order.config.readProperty;

public class OrderMain {
	public static  Integer arg_count,orderCount=0,resp; 
	public static String[] order_detail = new String[4];
	private static Logger loggerSlf4J = LoggerFactory.getLogger(OrderMain.class);

	/**
	 * @param args
//	 
	 * @throws FileNotFoundException1 */
	public static void main(String[] args) throws FileNotFoundException1 {
		
		// TODO Auto-generated method stub
//		String log4jConfPath = "./log4j/log4j.properties.xml";
//		PropertyConfigurator.configure(log4jConfPath);
//		FileInputStream propFile = null;
//		
//		try
//		{
//		propFile = new FileInputStream(new File("./properties/SystemProperty.sh"));
//		}
//		catch(FileNotFoundException e){
//			e.printStackTrace();
//			System.out.println("Error");
//		}
//		Properties sysp = System.getProperties();
//		try {
//			System.out.println(propFile.read());
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try{
//		sysp.load(propFile);
//		}
//		catch(IOException e){
//			e.printStackTrace();
//		}
//		System.setProperties(sysp);
//		System.out.println(System.getProperty("config.filename"));
		loggerSlf4J.info("=== Order Processing starting ===");
		loggerSlf4J.debug("hi debug");
		loggerSlf4J.error("=== Order Processing starting ===");
		
		//Read Order text file
		OrderFile orderFile = new OrderFile();
		orderFile.readFile();
		System.out.println("Started Sleeping");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ended Sleeping");
 
		// Read config file
		readProperty a = new readProperty();
		Properties p = a.readProperties();
		System.out.println(p.getProperty("DbSchema"));
		
		//Read Order XML File
//		OrderXML oXML = new OrderXML();
//		oXML.orderParser();
		
		//Read Employee XML File
		EmployeeXML empXML = new EmployeeXML();
		empXML.employeeParser();
		
		//create XML
		EmployeeJDomXML jDomXML = new EmployeeJDomXML();
		jDomXML.buildXML();
			
		
		@SuppressWarnings("unused")
		OrderDetails thisOrderDetails = new OrderDetails();
		jDomXML.setStock(thisOrderDetails, new File("./Resources/Input/Stock.xml"));
		jDomXML.setOrder(thisOrderDetails, new File("./Resources/Input/Order.xml"));
		Stock stk = new StockImpl(thisOrderDetails,jDomXML);
		
		//Create an conversion object
		OrderConversion newOrderConv = new OrderConversionImpl();
		Integer order_count=5;
		
		arg_count = args.length;
		arg_count--;
		while(orderCount <= arg_count)
		{
			//Convert the input to details
			order_detail = newOrderConv.convertOrder(args[orderCount]);
			OrderPerson thisOrderPerson = new OrderPerson(order_detail[0],order_detail[1]);
			
			//Set the details
			order_count = Integer.parseInt(order_detail[3]);
			OrderItem thisOrderItem = new OrderItem(order_detail[2],order_count);
			
			//Create the Object
			thisOrderDetails.setThisPerson(thisOrderPerson);
			thisOrderDetails.setThisItem(thisOrderItem);
			thisOrderDetails.setVsnr(order_detail[4]);
			
			//Convert to XML
			jDomXML.createXML(thisOrderDetails);
//			jDomXML.readXML(thisOrderDetails);
//			jDomXML.modifyXML(thisOrderDetails);
//			jDomXML.buildXML();
			
			
			//Get the stock details
			ProcessingHelper ph = new ProcessingHelperImpl();
			thisOrderDetails = ph.processOrder(thisOrderDetails);
			ph.createMessage(thisOrderDetails);
			ph.orderMessage(thisOrderDetails);
			orderCount++;
		}
		
		jDomXML.updateStock(thisOrderDetails);
		jDomXML.writeOrder(thisOrderDetails);
		
	}
	
	
//	   public static void main(String args[]) {
//		      Enumeration days;
//		      Vector stocks = new Vector();
//		      
//		      Stock_Details stkd = new Stock_Details("PEN",10);
//		      stocks.add(stkd);
//		      Stock_Details stkd1 = new Stock_Details("PENCIL",15);
//		      stocks.add(stkd1);		      
//		      days = stocks.elements();
//		      while (days.hasMoreElements()){
//		    	 Stock_Details stkd2 = new Stock_Details("PENCIL",15);
//		    	 stkd = (Stock_Details)days.nextElement(); 
//		    	 Boolean ss = stkd.equals(stkd2);
//		    	 System.out.println(stkd.getItemName());
//		    	 System.out.println(stkd.getItemValue());
//		    	 System.out.println(ss);
//		         System.out.println(stkd.getItemName());
//		        }
//		   }
	
}
