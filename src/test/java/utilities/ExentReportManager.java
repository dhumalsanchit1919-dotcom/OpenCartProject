package utilities;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseTestClass;

public class ExentReportManager  implements ITestListener {
	
	public ExtentSparkReporter extentReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	
	 public void onStart(ITestContext context) {
		 
		String timeStamp = new SimpleDateFormat("yyyy.mm.dd.MH.mm.ss").format(new Date());
		 
		 repName = "Test-Report" + timeStamp + ".html";
		 
		 extentReporter = new ExtentSparkReporter(System.getProperty("user.dir") + ".\\reports\\" + repName);
		 
		 extentReporter.config().setDocumentTitle("Open Chart Report");
		 extentReporter.config().setReportName("OpenChart");
		 extentReporter.config().setTheme(Theme.DARK); 
		 
		 extent = new ExtentReports();
		 extent.attachReporter(extentReporter); 
		 
		 extent.setSystemInfo("Name", "OpenChart");
		 extent.setSystemInfo("Tester Name", "Sanchit");
		 extent.setSystemInfo("Browser", "Chrome");
		 extent.setSystemInfo("OS", "Window");
		 extent.setSystemInfo("path", System.getProperty("user.dir"));
		 
			/*
			 * String os = context.getCurrentXmlTest().getParameter("os");
			 * extent.setSystemInfo("OS", os);
			 */
		 
		    
		  }
	 
	  
	 public void onTestSuccess(ITestResult result) {
		  
		 test= extent.createTest(result.getTestClass().getName());
		 test.assignCategory(result.getMethod().getGroups());
		 test.log(Status.PASS, result.getName());
		 
		  }
	  
	 public void onTestFailure(ITestResult result) {
		 
		 test= extent.createTest(result.getTestClass().getName());
		 test.assignCategory(result.getMethod().getGroups());
		 test.log(Status.FAIL, result.getName());
		 test.log(Status.INFO, result.getThrowable().getMessage());
		 
		 try {
		 String data = new BaseTestClass().captureScreen(result.getName());		 
         test.addScreenCaptureFromPath(data);
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		  }
	  
	 public void onTestSkipped(ITestResult result) {
	    
		 test= extent.createTest(result.getTestClass().getName());
		 test.assignCategory(result.getMethod().getGroups());
		 test.log(Status.SKIP, result.getName());
		 test.log(Status.INFO, result.getThrowable().getMessage());
	   }
	   
	 public void onFinish(ITestContext context) {
		 
		 extent.flush();
		 
		 try {
			 
			 String path  = System.getProperty("user.dir") + ".\\reports\\" + repName;
			 
			 File myFile = new File(path);
			 Desktop.getDesktop().browse(myFile.toURI());
			 
		 }
		 catch(Exception e) {
			e.printStackTrace(); 
		 }
		   
		  }

}
