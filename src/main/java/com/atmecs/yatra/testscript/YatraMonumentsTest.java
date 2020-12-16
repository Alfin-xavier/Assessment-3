package com.atmecs.yatra.testscript;

import java.util.Properties;

import org.testng.annotations.Test;

import com.atmecs.yatra.constants.FilePathConstants;
import com.atmecs.yatra.methods.YatraMonumentsMethods;
import com.atmecs.yatra.page.BasePage;
import com.atmecs.yatra.utils.PropertyReader;
import com.aventstack.extentreports.Status;

public class YatraMonumentsTest extends BasePage
{

	 YatraMonumentsMethods methods;

	 Properties cruiseProps;
	 
	@Test
	public void monumentsTest() throws InterruptedException
	{
		test = extent.createTest("YatraMonuments");
		
		methods = new YatraMonumentsMethods(driver);

		cruiseProps = PropertyReader.readProperties(FilePathConstants.MONUMENTS_LOCATORS);
		
		test.log(Status.INFO,"Clicking the + More option");

		methods.clickMoreLink(cruiseProps.getProperty("more_link"));
		
		test.log(Status.INFO,"Clicking the Monument tab");
		
		methods.clickMonumentTab(cruiseProps.getProperty("monuments_menu"));
		
		test.log(Status.INFO,"Checking the top monument section and verify the monuments");
		
		methods.sectionDisplayed(cruiseProps.getProperty("top_monuments_section"), cruiseProps.getProperty("view_all"));
	}
}
