package com.allinaz.order.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.allianz.order.main.OrderMain;

public class readProperty {
	
	private static Logger loggerSlf4J = LoggerFactory.getLogger(readProperty.class);
	
	public Properties readProperties(){
		
		loggerSlf4J.info("Getting the file");
		File  conffile = new File("./Resources/config/config.properties");
//		InputStream stream = getClass().getClassLoader().getResourceAsStream(conffile);
		
//		InputStream stream = OrderMain.class.getResourceAsStream("M:/DESKTOP/LatestDesktop/workspace/OrderProcessingSystem/Properties/properties.file.txt");
		
		Properties p = new Properties();
		try {
			if (conffile != null){
				loggerSlf4J.info("Loading the file as properties");
				p.loadFromXML(new FileInputStream(conffile));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}
	
}
