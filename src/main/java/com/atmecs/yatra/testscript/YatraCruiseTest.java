package com.atmecs.yatra.testscript;

import java.util.Properties;

import org.testng.annotations.Test;

import com.atmecs.yatra.constants.FilePathConstants;
import com.atmecs.yatra.methods.YatraCruiseMethods;
import com.atmecs.yatra.page.BasePage;
import com.atmecs.yatra.utils.PropertyReader;
import com.aventstack.extentreports.Status;

public class YatraCruiseTest extends BasePage
{
	YatraCruiseMethods methods;

	Properties cruiseProps;

	@Test
	public void cruiseTest() throws InterruptedException 
	{
		test = extent.createTest("YatraCruiseTest");
		
		methods = new YatraCruiseMethods(driver);

		cruiseProps = PropertyReader.readProperties(FilePathConstants.CRUISE_LOCATORS);

		test.log(Status.INFO,"Clicking the + More option");

		methods.clickMoreLink(cruiseProps.getProperty("more_link"));

		test.log(Status.INFO,"Clicking the cruise menu");

		methods.clickCruiseTab(cruiseProps.getProperty("cruise_menu"));
		
		test.log(Status.INFO,"Clicking the river/destination");
		
		methods.selectValue(cruiseProps.getProperty("cruise_booking"), cruiseProps.getProperty("river_destination"));
		
		test.log(Status.INFO,"Clicking depature date");
		
		methods.selectValue(cruiseProps.getProperty("cruise_booking"), cruiseProps.getProperty("depature_date"));

		test.log(Status.INFO,"Clicking days duration");
		
		methods.selectValue(cruiseProps.getProperty("cruise_booking"), cruiseProps.getProperty("day_duration"));

		test.log(Status.INFO,"Clicking cruiselines");
		
		methods.selectValue(cruiseProps.getProperty("cruise_booking"), cruiseProps.getProperty("cruiseline_input"));
		
		test.log(Status.INFO,"Clicking search button");
		
		methods.clickSearchCruise(cruiseProps.getProperty("search_cruise"));
		
		test.log(Status.INFO,"Switching to new tab");
		
		methods.switchingWindow();
		
		test.log(Status.INFO, "Verifying given datas");
		
		methods.verifyDatas(cruiseProps.getProperty("itineraries_reuslt"));
		
		test.log(Status.INFO,"Clicking the Itineraries tab and verifying days of plan under Itinerary");
		
		methods.verifyItineraries(cruiseProps.getProperty("itineraries_menu"),cruiseProps.getProperty("itineraries_list"));
		
		test.log(Status.INFO,"Verifying days of plan");
		
		methods.verifyItinerariesList(cruiseProps.getProperty("itineraries_reuslt_menu"),cruiseProps.getProperty("itineraries_reuslt"));
		
		test.log(Status.INFO,"Clicking search button");
		
		methods.clickBookButton(cruiseProps.getProperty("book_button"));

	}
}
