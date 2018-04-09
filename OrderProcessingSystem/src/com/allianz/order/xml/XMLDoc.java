package com.allianz.order.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class XMLDoc {
	
	File xmlFile;
	DocumentBuilderFactory dFactory;
	DocumentBuilder dBuilder;
	Document dDoc;
	public File getXmlFile() {
		return xmlFile;
	}
	public void setXmlFile(File xmlFile) {
		this.xmlFile = xmlFile;
	}
	public DocumentBuilderFactory getdFactory() {
		return dFactory;
	}
	public void setdFactory(DocumentBuilderFactory dFactory) {
		this.dFactory = dFactory;
	}
	public DocumentBuilder getdBuilder() {
		return dBuilder;
	}
	public void setdBuilder(DocumentBuilder dBuilder) {
		this.dBuilder = dBuilder;
	}
	public Document getdDoc() {
		return dDoc;
	}
	public void setdDoc(Document dDoc) {
		this.dDoc = dDoc;
	}
	
	
}
