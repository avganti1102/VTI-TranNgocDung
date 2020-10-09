package com.vti.final_exam.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DatabaseProperties {
	public static final String RESOURCE_URL = "C:\\Users\\Dzungg\\Desktop\\New folder\\final_exam\\src\\main\\java\\com\\vti\\final_exam\\resource\\";
	private Properties pr;
	
	public DatabaseProperties() throws FileNotFoundException, IOException {
		pr = new Properties();
		pr.load(new FileInputStream(RESOURCE_URL + "ConfigDataBase.properties"));
	}
	
	public String getProperty(String key) {
		return pr.getProperty(key);
	}
	
}
