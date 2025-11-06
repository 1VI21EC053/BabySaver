package com.ninja.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtilities {
	public String getDataFromProperties(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties pp= new Properties();
		pp.load(fis);
		String data = pp.getProperty(key);
		return data;
		}

}
