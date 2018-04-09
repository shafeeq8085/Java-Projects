package com.allianz.order.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.allinaz.order.config.readProperty;

public class OrderXML {
	
	private static Logger loggerSlf4J = LoggerFactory.getLogger(OrderXML.class);
	
	public void orderParser(){
		
		File xmlFile = new File("./Resources/Input/OrderFile.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Document doc = null;
		try {
			doc = db.parse(xmlFile);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		doc.getDocumentElement().normalize();
		System.out.println("Root element " + doc.getDocumentElement().getNodeName());
		NodeList nodeLst = doc.getElementsByTagName("item");
		System.out.println("Information of all employees");
		for (int s = 0; s < nodeLst.getLength(); s++) {
			 
		    Node fstNode = nodeLst.item(s);
		     
		     if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
		   
		       Element fstElmnt = (Element) fstNode;
		       NodeList nameElmntLst = fstElmnt.getElementsByTagName("name");
		       Element nameElmnt = (Element) nameElmntLst.item(0);
		       NodeList name = nameElmnt.getChildNodes();
		       System.out.println("Name : "  + ((Node) name.item(0)).getNodeValue());
		       NodeList quantityElmntLst = fstElmnt.getElementsByTagName("lastname");
		       Element quantityElmnt = (Element) quantityElmntLst.item(0);
		       NodeList quantity = quantityElmnt.getChildNodes();
		       System.out.println("Quantity : " + ((Node) quantity.item(0)).getNodeValue());
		     }
		 
		}
		  
	}

}
