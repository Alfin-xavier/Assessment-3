package com.atmecs.yatra.page;

import java.util.Properties;
import org.openqa.selenium.WebDriver;

import com.atmecs.yatra.constants.FilePathConstants;
import com.atmecs.yatra.methods.YatraMonumentsMethods;
import com.atmecs.yatra.utils.Logging;
import com.atmecs.yatra.utils.PropertyReader;

public class YatraMonumentsPage 
{
	public WebDriver driver;

	YatraMonumentsMethods methods;

	Properties cruiseProps;

	Logging log;

	public YatraMonumentsPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void monumentsPage()
	{
		methods = new YatraMonumentsMethods(driver);

		log = new Logging();

		cruiseProps = PropertyReader.readProperties(FilePathConstants.MONUMENTS_LOCATORS);
		
		log.info("Clicking the + More option");

		methods.clickMoreLink(cruiseProps.getProperty("more_link"));
		
		log.info("Clicking the Monument tab");
		
		methods.clickMonumentTab(cruiseProps.getProperty("monuments_menu"));
		
		log.info("Checking the top monument section");
		
		methods.sectionDisplayed(cruiseProps.getProperty("top_monuments_section"), cruiseProps.getProperty("view_all"));
	}
}