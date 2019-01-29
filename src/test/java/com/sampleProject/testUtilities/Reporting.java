package com.sampleProject.testUtilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;

	
public void onStart(ITestContext textContex)
 
 {      
	String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	String repName= "Test-Report"+timestamp+".html";
	
	//Specify location to test report
	htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
	
	//Load extent-config file
	htmlreporter.loadConfig(System.getProperty("user.dir")+"/extent-config.xml");
	
	extent= new ExtentReports();
	extent.attachReporter(htmlreporter);
	
	extent.setSystemInfo("Env", "Test");
	extent.setSystemInfo("Browser", "Chrome");
	extent.setSystemInfo("Tester", "Rajashri");
	extent.setSystemInfo("Application", "Guru99");
	
	htmlreporter.config().setDocumentTitle("Automation Report");
	htmlreporter.config().setReportName("UAT Test report");
	htmlreporter.config().setTheme(Theme.DARK);
}
	
public void onTestSuccess(ITestResult result)
{
	test=extent.createTest(result.getName());
	test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	
  
}
public void onTestFailure(ITestResult result)
{ 
	test=extent.createTest(result.getName());
	test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
	
}
public void onTestSkipped(ITestResult result)
{
	test=extent.createTest(result.getName());
	test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
}
public void onFinish(ITestContext textContex)

{
	extent.flush();
}

}



