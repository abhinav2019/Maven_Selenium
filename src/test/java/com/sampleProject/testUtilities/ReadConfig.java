package com.sampleProject.testUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		File src = new File("./Configuration/configuration.properties");


		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is :" + e.getMessage());
				
		}

	}
	
	public String getBaseUrl()
	{
		
		String baseURL= pro.getProperty("baseUrl");
		return baseURL;
	}
	public String getU_Name()
	{
		
		String u_name= pro.getProperty("username");
		return u_name;
	}
	public String getPaswd()
	{
		
		String passwd= pro.getProperty("password");
		return passwd;
	}
	
	public String getChromePath()
	{
		
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getIEPath()
	{
		
		String iepath=pro.getProperty("iepath");
		return iepath;
	}
	
	public String getFireFoxPath()
	{
		
		String ffpath=pro.getProperty("firefoxpath");
		return ffpath;
	}
	

}
