package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties properties;
	
	/**
	 * 
	 * @return
	 */
	public Properties initProp() {
		properties=new Properties();
		try {
			FileInputStream inputStream=new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties");
			try {
				properties.load(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}
}
