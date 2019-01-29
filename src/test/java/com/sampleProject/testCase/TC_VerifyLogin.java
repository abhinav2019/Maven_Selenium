package com.sampleProject.testCase;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sampleProject.pageObjects.LoginPage;

public class TC_VerifyLogin extends BaseClass {

	@Test
	public void login() {

        driver.get(baseUrl);
      
//		JavascriptExecutor js = ((JavascriptExecutor) driver);
//
//		for (int i = 1; i < 4; i++) {
//			js.executeScript("window.open()");
//			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//			driver.switchTo().window(tabs.get(i));
//			switch (i) {
//			case 1:
//				driver.get("https://www.google.com");
//				logger.info("Google opened");
//				break;
//			case 2:
//				driver.get("https://www.youtube.com");
//				logger.info("youtube opened");
//				break;
//			case 3:
//				driver.get("https://www.google.com");
//				logger.info("Google opened");
//				break;
//
//			default:
//				System.out.println("No URL provided");
//				break;
//			}
//
//		}
//		js.executeScript("window.open()");
//		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(tabs.get(1));
//		driver.get("https://www.google.com");
//
//		js.executeScript("window.open()");
//		ArrayList<String> tabss = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(tabss.get(2));
//		driver.get("https://www.youtube.com");
//
//		js.executeScript("window.open()");
//		ArrayList<String> tabsss = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(tabsss.get(3));
//		driver.get("https://www.google.com");

		 LoginPage lp = new LoginPage(driver);
		 lp.setUserName(username);
		 logger.info("username entered");
		 lp.setPassword(password);
		 logger.info("password entered");
		 lp.clickLogin();
		 System.out.println("Title is :"+driver.getTitle());
		 Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
		 //getScreenshot("HomePage");
		 logger.info("Navigated to login page");

	}

	@Test
	public void loginfailed() {

        driver.get(baseUrl);
      
		 LoginPage lp = new LoginPage(driver);
		 lp.setUserName(username);
		 logger.info("username entered");
		 lp.setPassword(password);
		 logger.info("password entered");
		 lp.clickLogin();
		 System.out.println("Title is :"+driver.getTitle());
		 Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage123");
		 //getScreenshot("HomePage");
		 logger.info("Navigated to login page");

	}

}
