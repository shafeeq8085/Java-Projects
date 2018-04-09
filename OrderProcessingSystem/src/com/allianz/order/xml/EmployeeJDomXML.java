package com.allianz.order.xml;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.allianz.order.person.OrderDetails;

public class EmployeeJDomXML {
	
	public void writeOrder(OrderDetails thisOrderDetails){
		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		try {
			xmlOutput.output(thisOrderDetails.getOrderXML(), new FileWriter("./Resources/Input/Order.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setStock(OrderDetails thisOrderDetails, File xmlFile){
		
		Document document =null;
		SAXBuilder sBuilder = new SAXBuilder();
		try {
			document = sBuilder.build(xmlFile);
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thisOrderDetails.setStockXML(document);
		
	}
	
	public void setOrder(OrderDetails thisOrderDetails, File xmlFile){
		
		Document document = new Document();		
		Element rootElement = new Element("Orders");
		document.setRootElement(rootElement);
		thisOrderDetails.setOrderXML(document);
		
	}
	
	public void buildXML(){

		Document document = new Document();
		Element rootElement = new Element("Cars");
		document.setRootElement(rootElement);
		
		Element superCars = new Element("Supercars");
		superCars.setAttribute(new Attribute("Company", "Ferrari"));
		
		Element carName1 = new Element("Carname");
		carName1.setAttribute(new Attribute("Type", "Formula one"));
		carName1.setText("ferrari 101");
		
		Element carName2 = new Element("Carname");
		carName2.setAttribute(new Attribute("Type", "Sports"));
		carName2.setText("Ferrari 202");
		
		superCars.addContent(carName1);
		superCars.addContent(carName2);
		
		document.getRootElement().addContent(superCars);
		
		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		try {
			xmlOutput.output(document, new FileWriter("./Resources/Input/cars.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		xmlOutput.setFormat(Format.getCompactFormat());
		try {
			xmlOutput.output(document, System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		xmlOutput.setFormat(Format.getRawFormat());
		try {
			xmlOutput.output(document, System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void createXML(OrderDetails thisOrderDetails){

				
		Element superOrder = new Element("Order");
		superOrder.setAttribute(new Attribute("Customer", thisOrderDetails.getThisPerson().getName()));
		
		Element contact = new Element("Contact");
		contact.setAttribute(new Attribute("Mobile", thisOrderDetails.getThisPerson().getMobile()));
		
		Element orderDetails = new Element("Details");	
		
		Element itemName = new Element("Item");
		itemName.setText(thisOrderDetails.getThisItem().getItem());
		
		Element itemCount =  new Element("Count");
		itemCount.setText(Integer.toString(thisOrderDetails.getThisItem().getItem_count()));
		
		orderDetails.addContent(itemName);
		orderDetails.addContent(itemCount);
		
		
		contact.addContent(orderDetails);
		
		superOrder.addContent(contact);
		
		thisOrderDetails.getOrderXML().getRootElement().addContent(superOrder);
		
		
	}
	
	public void readXML(OrderDetails thisOrderDetails){
		Document document = null;
		
		SAXBuilder sBuilder = new SAXBuilder();
		try {
			document = sBuilder.build(new File("./Resources/Input/Employee.xml"));
		} catch (JDOMException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Element park = document.getRootElement();
		
		List<Element> compList = park.getChildren("Company");
		for (int i=0;i<compList.size();i++){
			Element comp = compList.get(i);
			List<Element> deptList = comp.getChildren("Department");
			for(int j=0;j<deptList.size();j++){
				Element dept = deptList.get(j);
				List<Element> teamList = dept.getChildren("Team");
				for(int k=0; k < teamList.size();k++){
					Element team = teamList.get(k);
					List<Element> empList = team.getChildren("Employee");
					for(int l=0; l<empList.size();l++){
						Element emp = empList.get(l);
						Element name = emp.getChild("Name");
						System.out.println("Employee Name: "+name.getText());
						Element age = emp.getChild("Age");
						System.out.println("Employee Age: "+age.getText());
						
					}
				}
			}
		}
		
	}
	
	public void readStock(OrderDetails thisOrderDetails){
		
		HashMap<String, Integer> stocklist = new HashMap<String, Integer>();
		Document document = thisOrderDetails.getStockXML();
		Element stocks = document.getRootElement();
		
		List<Element> stockList = stocks.getChildren("Stock");
		for (int i=0;i<stockList.size();i++){
			Element stock = stockList.get(i);
			Element itemElement = stock.getChild("Item");
			String item = itemElement.getText();
			Element countElement = stock.getChild("Count");
			String count = countElement.getText();
			stocklist.put(item, Integer.parseInt(count));
				
		}
		
		thisOrderDetails.setStocklist(stocklist);
	}
	
	@SuppressWarnings("rawtypes")
	public void updateStock(OrderDetails thisOrderDetails){
		
		HashMap<String, Integer> stocklist = new HashMap<String, Integer>();
		stocklist = thisOrderDetails.getStocklist();
		Document document = thisOrderDetails.getStockXML();
		Element stocks = new Element("Stocks");
		document.setRootElement(stocks);
		Iterator<Entry<String, Integer>> itr = stocklist.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry mEntry = (Map.Entry)itr.next();
			Element stock = new Element("Stock");
			Element item = new Element("Item");
			Element count = new Element("Count");
			item.setText((String) mEntry.getKey());
			count.setText(Integer.toString((Integer) mEntry.getValue()));
			stock.addContent(item);
			stock.addContent(count);
			document.getRootElement().addContent(stock);
			
		}
		
		XMLOutputter xmlOut = new XMLOutputter();
		xmlOut.setFormat(Format.getPrettyFormat());
		try {
			xmlOut.output(document, new FileWriter("./resources/Input/Stock.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public void modifyXML(OrderDetails thisOrderDetails){
		
		Document document = null;
		
		SAXBuilder sBuilder = new SAXBuilder();
		try {
			document = sBuilder.build(new File("./Resources/Input/Employee.xml"));
		} catch (JDOMException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Element park = document.getRootElement();
		
		List<Element> compList = park.getChildren("Company");
		for (int i=0;i<compList.size();i++){
			Element comp = compList.get(i);
			List<Element> deptList = comp.getChildren("Department");
			for(int j=0;j<deptList.size();j++){
				Element dept = deptList.get(j);
				List<Element> teamList = dept.getChildren("Team");
				for(int k=0; k < teamList.size();k++){
					Element team = teamList.get(k);
					List<Element> empList = team.getChildren("Employee");
					for(int l=0; l<empList.size();l++){
						Element emp = empList.get(l);
						Element name = emp.getChild("Name");
						System.out.println("Employee Name: "+name.getText());
						Element age = emp.getChild("Age");
						System.out.println("Employee Age: "+age.getText());
						if (name.getText().equalsIgnoreCase("Shafeeque")){
							emp.getChild("Age").setText("31");
						}
						
						age = emp.getChild("Age");
						System.out.println("Employee Age resetted: "+age.getText());
						
					}
				}
			}
		}
		
		XMLOutputter xmlOut = new XMLOutputter();
		xmlOut.setFormat(Format.getPrettyFormat());
		try {
			xmlOut.output(document, new FileWriter("./Resources/Input/Employee.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
