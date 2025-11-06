package com.ninja.crm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtilities {
	public String getDataFromjsonFile(String key) throws IOException, ParseException {
		FileReader fr= new FileReader("./src/test/resources/name.json");
		JSONParser obj= new JSONParser();
		Object obj1 = obj.parse(fr);
		 JSONObject obj2 = (JSONObject)obj1	 ;
		String data = obj2.get(key).toString();
	
		return data;
	}


}
