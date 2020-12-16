package com.atmecs.yatra.page;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.atmecs.yatra.constants.FilePathConstants;
import com.atmecs.yatra.utils.PropertyReader;
import com.atmecs.yatra.utils.TestNGListeners;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BasePage 
{
	public WebDriver driver;
	Properties properties;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public static ExtentTest test;
	String baseUrl;
	String browserUrl;

	@BeforeTest
	public void initBrowser() throws MalformedURLException
	{
		htmlReporter = new ExtentHtmlReporter("./onlineShopExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(String browser) throws InterruptedException, IOException 
	{
		properties = PropertyReader.readProperties(FilePathConstants.CONFIG);
		baseUrl = properties.getProperty("url");
		browserUrl = properties.getProperty("browser");
		
		if (browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty(FilePathConstants.CHROME_DIR, FilePathConstants.CHROME_PATH);
			driver = new ChromeDriver();
			driver.get(baseUrl);
			Assert.assertEquals(baseUrl, "https://www.yatra.com/", "Verified the Url");
		}
		
		else if(browser.equalsIgnoreCase("firefox")) 
		{
			System.setProperty(FilePathConstants.GECKO_DIR, FilePathConstants.GECKO_PATH);
			driver = new FirefoxDriver();
			driver.get(baseUrl);
			Assert.assertEquals(baseUrl, "https://www.yatra.com/", "Verified the Url");
		}
		
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
	  
	  TestNGListeners.driver = driver;
	  }
	
	@AfterMethod
	public void afterMethod()
	{
		driver.close();

	}
	
	@AfterTest
	public void closeReport()
	{
		extent.flush();
	}
}