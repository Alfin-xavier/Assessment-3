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

	 Properties monumentProps;
	 
	@Test
	public void monumentsTest() throws InterruptedException
	{
		test = extent.createTest("YatraMonumentTest");
		
		methods = new YatraMonumentsMethods(driver);

		monumentProps = PropertyReader.readProperties(FilePathConstants.MONUMENTS_LOCATORS);
		
		test.log(Status.INFO,"Clicking the + More option");

		methods.clickMoreLink(monumentProps.getProperty("more_link"));
		
		test.log(Status.INFO,"Clicking the Monument tab");
		
		methods.clickMonumentTab(monumentProps.getProperty("monuments_menu"));
		
		test.log(Status.INFO,"Checking the top monument section");
		
		methods.sectionDisplayed(monumentProps.getProperty("top_monuments_section"));
		
		test.log(Status.INFO, "Verifying QUTUB MINAR monumnet");
		
		methods.verifyMonuments(monumentProps.getProperty("qutubMinarMonument"), "QUTUB MINAR is verified");
		
		test.log(Status.INFO, "Verifying HUMAYUNS TOMB monumnet");
		
		methods.verifyMonuments(monumentProps.getProperty("humayunsTombMonument"), "HUMAYUNS TOMB is verified");
	}
}
