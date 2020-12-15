package com.atmecs.yatra.page;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.atmecs.yatra.constants.FilePathConstants;
import com.atmecs.yatra.methods.YatraCruiseMethods;
import com.atmecs.yatra.utils.Logging;
import com.atmecs.yatra.utils.PropertyReader;

public class YatraCruisePage 
{
	public WebDriver driver;

	YatraCruiseMethods methods;

	Properties cruiseProps;

	Logging log;

	public YatraCruisePage(WebDriver driver) 
	{
		this.driver = driver;
	}

	public void cruisePage() throws InterruptedException 
	{
		methods = new YatraCruiseMethods(driver);

		log = new Logging();

		cruiseProps = PropertyReader.readProperties(FilePathConstants.CRUISE_LOCATORS);

		log.info("Clicking the + More option");

		methods.clickMoreLink(cruiseProps.getProperty("more_link"));

		log.info("Clicking the cruise menu");

		methods.clickCruiseTab(cruiseProps.getProperty("cruise_menu"));
		
		log.info("Clicking the river/destination");
		
		methods.selectValue(cruiseProps.getProperty("cruise_booking"), cruiseProps.getProperty("river_destination"));
		
		log.info("Clicking depature date");
		
		methods.selectValue(cruiseProps.getProperty("cruise_booking"), cruiseProps.getProperty("depature_date"));

		log.info("Clicking days duration");
		
		methods.selectValue(cruiseProps.getProperty("cruise_booking"), cruiseProps.getProperty("day_duration"));

		log.info("Clicking cruiselines");
		
		methods.selectValue(cruiseProps.getProperty("cruise_booking"), cruiseProps.getProperty("cruiseline_input"));
		
		log.info("Clicking search button");
		
		methods.clickSearchCruise(cruiseProps.getProperty("search_cruise"));
		
		log.info("Switching to new tab");
		
		methods.switchingWindow();
		
		log.info("Clicking the Itineraries tab and verifying days of plan under Itinerary");
		
		methods.verifyItineraries(cruiseProps.getProperty("itineraries_menu"),cruiseProps.getProperty("itineraries_list"));
		
		log.info("Verifying days of plan");
		
		methods.verifyItinerariesList(cruiseProps.getProperty("itineraries_reuslt_menu"),cruiseProps.getProperty("itineraries_reuslt"));
		
		log.info("Clicking search button");
		
		methods.clickBookButton(cruiseProps.getProperty("book_button"));

	}
}
