package com.sampleProject.testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sampleProject.pageObjects.LoginPage;
import com.sampleProject.testUtilities.ReadExcel;

public class TC_DD_Login extends BaseClass {
	
	@Test(dataProvider="GURULogin")
	public void GuruLogin(String uname, String passwd)
	{
		
		driver.get(baseUrl);
	      
		 LoginPage lp = new LoginPage(driver);
		 lp.setUserName(uname);
		 logger.info("username entered");
		 lp.setPassword(passwd);
		 logger.info("password entered");
		 lp.clickLogin();
		 
		 if(isAlertPresent()==true)
		 {   System.out.println("Alert text is: "+driver.switchTo().alert().getText());
			 driver.switchTo().alert().accept();
			 driver.switchTo().defaultContent();
			 //Assert.assertTrue(false);
		
		 }
		 else{
			 //Assert.assertTrue(false);
			 Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
			 
		 }
		 	 

	}
	
	@DataProvider(name="GURULogin")
	public Object getExcelData() throws InvalidFormatException, IOException
	{
		Object data[][]=ReadExcel.readExcel(System.getProperty("user.dir")+"/src/test/java/com/sampleProject/testData/TestData.xlsx", "sheet1", 2);
	
		return data;
		
	}
	
	public boolean isAlertPresent()
	{
		try {
			driver.switchTo().alert(); 
			return true;
			
		} catch (NoAlertPresentException e) {
			return false;
		}
	    
	
	}

}
