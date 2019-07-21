package com.learnAutomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnAutomation.utility.BrowserFactory;
import com.learnAutomation.utility.ConfigDataProvider;
import com.learnAutomation.utility.ExcelDataProvider;
import com.learnAutomation.utility.Listner;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Setting up report and test is getting ready", true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Amazon_"+Listner.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setting Done - Test can be started", true);
	}
	
	@BeforeClass
	public void launchApp(){
		Reporter.log("Trying to start Browser and Getting application ready", true);
		driver = BrowserFactory.startBrowser(driver, config.getBrowser(), config.getTestURL());
		Reporter.log("Browser and Application is up and running", true);
	}
	
	@AfterClass
	public void closeApp(){
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMeth(ITestResult result) throws IOException {
		
		Reporter.log("Test is about to end", true);
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Listner.captureScreenShot(driver)).build());
		} else if(result.getStatus() == ITestResult.FAILURE) {
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Listner.captureScreenShot(driver)).build());
		} else if(result.getStatus() == ITestResult.SKIP) {
			
			logger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(Listner.captureScreenShot(driver)).build());
		}
		report.flush();
		Reporter.log("Test Completed >> Report Generated", true);
	}

}
