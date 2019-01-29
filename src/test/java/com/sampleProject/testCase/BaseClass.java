package com.sampleProject.testCase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.sampleProject.testUtilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseUrl = readconfig.getBaseUrl();
	public String username = readconfig.getU_Name();
	public String password = readconfig.getPaswd();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters({"browser"})
	@BeforeMethod
	public void setup(String br) {
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxPath());
			driver = new FirefoxDriver();
		} else if (br.equals("IE")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		logger = Logger.getLogger("sampleProject");
		PropertyConfigurator.configure("Log4j.properties");

		// driver.get(baseUrl);

	}
	
	@AfterMethod
	public void tearDown() {
		
//		if(result.getStatus()==ITestResult.FAILURE)
//		{
//			getScreenshot(result.getName());
//		}
		driver.quit();
	}
	
	
	
	public static void getScreenshot(String screenshotName) throws IOException
	{
		String date= new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("./Screenshot/myReport-"+date+"-"+screenshotName+".png");
		FileUtils.copyFile(src, destination);
	}

}
