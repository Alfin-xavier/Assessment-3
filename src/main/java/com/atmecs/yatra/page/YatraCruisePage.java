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

	public void cruisePage(String destination, String depature, String duration, String cruiseline) 
	{
		methods = new YatraCruiseMethods(driver);

		log = new Logging();

		cruiseProps = PropertyReader.readProperties(FilePathConstants.CRUISE_LOCATORS);

		log.info("Clicking the + More option");

		methods.clickMoreLink(cruiseProps.getProperty("more_link"));

		log.info("Clicking the cruise menu");

		methods.clickCruiseTab(cruiseProps.getProperty("cruise_menu"));

		log.info("Entering destination");

		methods.selectValue(cruiseProps.getProperty("river/destination"), cruiseProps.getProperty("cruise_booking"),
				destination);

		log.info("Entering depature date");

		methods.selectValue(cruiseProps.getProperty("depature_date"), cruiseProps.getProperty("cruise_booking"),
				depature);

		log.info("Entering day_duration");

		methods.selectValue(cruiseProps.getProperty("day_duration"), cruiseProps.getProperty("cruise_booking"),
				duration);

		log.info("Entering cruiseline");

		methods.selectValue(cruiseProps.getProperty("cruiseline_input"), cruiseProps.getProperty("cruise_booking"),
				cruiseline);

		log.info("Clicking search cruise button");

		methods.clickSearch(cruiseProps.getProperty("search_cruise"), cruiseProps.getProperty("cruise_booking"));

		/*
		 * log.info("Clicking itinaries icon");
		 * 
		 * methods.clickItineraryIcon(cruiseProps.getProperty("itineraries_menu"));
		 * 
		 * log.info("Getting number of itineraries ");
		 * 
		 * methods.getItinerariesList(cruiseProps.getProperty("itineraries_list"));
		 */

	}
}
