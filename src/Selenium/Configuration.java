package Selenium;

import java.io.FileInputStream;
import java.util.Properties;

public class Configuration {
	
	private static Properties prop = new Properties();
	private static FileInputStream input = null;
	
	public static Properties getConfiguration() {
		try 
		{
			input = new FileInputStream("config.properties");
			prop.load(input);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return prop;
	}

	//private static FileInputStream input = null;
}
