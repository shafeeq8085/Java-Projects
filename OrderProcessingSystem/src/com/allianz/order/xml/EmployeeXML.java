package com.allianz.order.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.allianz.order.person.Employee;

public class EmployeeXML extends XMLDoc{
	
	Node nNode;
	NodeList nList;
	Element eElement;
	
	
	public XMLDoc employeeParser(){
		
		xmlFile = new File("./Resources/Input/Employee.xml");
		dFactory = DocumentBuilderFactory.newInstance();
		
		try {
			dBuilder = dFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			dDoc = dBuilder.parse(xmlFile);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XMLDoc xmlDoc  = new XMLDoc();
		xmlDoc.setdBuilder(dBuilder);
		xmlDoc.setdFactory(dFactory);
		xmlDoc.setdDoc(dDoc);
		xmlDoc.setXmlFile(xmlFile);
		parseIt(dDoc);
		return xmlDoc;
				
	}
	
	public void parseIt(Document dDoc){
		
		Employee employee = new Employee(); 
		
		Element rootElement = dDoc.getDocumentElement();
		System.out.println(rootElement.getNodeName());
		
		nList = rootElement.getElementsByTagName("Company");
		if(nList.getLength()>0){
			for(int i=0;i<nList.getLength();i++){
				Element compElement = (Element) nList.item(i);
				NodeList deptList = compElement.getElementsByTagName("Department");
				if(deptList.getLength()>0){
					for(int j=0;j<deptList.getLength();j++){
						Element deptElement = (Element) deptList.item(j);
						NodeList teamList = deptElement.getElementsByTagName("Team");
						if(teamList.getLength()>0){
							for(int k=0;k<teamList.getLength();k++){
								Element teamElement = (Element) teamList.item(k);
								NodeList empList = teamElement.getElementsByTagName("Employee");
								if(empList.getLength()>0){
									for(int n=0;n<empList.getLength();n++){
										Element empElement = (Element) empList.item(n);
										NodeList nameList = empElement.getElementsByTagName("Name");
										if(nameList.getLength()>0){
											Element nameElement = (Element) nameList.item(0);
											employee.setName(nameElement.getFirstChild().getNodeValue());
										}
										NodeList ageList = empElement.getElementsByTagName("Age");
										if(ageList.getLength()>0){
											Element ageElement = (Element) ageList.item(0);
											employee.setAge(Integer.parseInt(ageElement.getFirstChild().getNodeValue()));
										}	
										employee.setCompany(compElement.getAttribute("id"));
										employee.setDepartment(deptElement.getAttribute("id"));
										employee.setEmpID(empElement.getAttribute("id"));
										employee.setTeam(teamElement.getAttribute("id"));
										printIt(employee);
										
									}
								}
								
								
							}
						}
					}
				}
			}
			
		}
		
	}
	
	public void printIt(Employee employee){
		
		System.out.println("The Employee "+ employee.getName() + " with Employee ID "+ employee.getEmpID() + " is working in company called "+ employee.getCompany() + " in Department "+ employee.getDepartment() + " for the team "+employee.getTeam()+ " have an age of "+ employee.getAge()+".");
	}
	

}
