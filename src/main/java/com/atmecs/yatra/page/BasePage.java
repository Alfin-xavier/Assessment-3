package com.atmecs.yatra.page;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.atmecs.yatra.constants.FilePathConstants;
import com.atmecs.yatra.utils.PropertyReader;
import com.atmecs.yatra.utils.TestNGListeners;

public class BasePage 
{
	public WebDriver driver;
	Properties properties;
	String baseUrl;
	String browserUrl;

	@BeforeMethod
	@Parameters("browser")
	
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
		}
		
		else if(browser.equalsIgnoreCase("firefox")) 
		{
			System.setProperty(FilePathConstants.GECKO_DIR, FilePathConstants.GECKO_PATH);
			driver = new FirefoxDriver();
			driver.get(baseUrl);
		}

		System.out.println(driver.getCurrentUrl()); 
	  Assert.assertTrue(true);
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
	  
	  TestNGListeners.driver = driver;
	  }
	
		@BeforeTest
		public void initBrowser() throws MalformedURLException 
		{
			String gridUrl = "http://192.168.163.1:4445/wd/hub";
			Capabilities cabs = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL(gridUrl), cabs);
		}

		@AfterMethod
		public void afterTest() 
		{
			driver.close();

		}
		 
}
