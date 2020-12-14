package com.atmecs.yatra.testscript;

import org.testng.annotations.Test;

import com.atmecs.yatra.page.BasePage;
import com.atmecs.yatra.page.YatraCruisePage;
import com.atmecs.yatra.utils.DataProviderClass;

public class YatraCruiseTest extends BasePage 
{
	@Test( dataProvider = "testData", dataProviderClass = DataProviderClass.class )
	public void cruiseTest( String destination, String depature, String duration, String cruiseline )
	{
		YatraCruisePage  yatraCruisePage = new YatraCruisePage(driver);
		
		yatraCruisePage.cruisePage( destination,depature,duration,cruiseline );
	}
}
