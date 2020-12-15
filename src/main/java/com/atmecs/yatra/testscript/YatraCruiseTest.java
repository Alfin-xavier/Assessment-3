package com.atmecs.yatra.testscript;

import org.testng.annotations.Test;

import com.atmecs.yatra.page.BasePage;
import com.atmecs.yatra.page.YatraCruisePage;

public class YatraCruiseTest extends BasePage 
{
	@Test( /* dataProvider = "testData", dataProviderClass = DataProviderClass.class */ )
	public void cruiseTest() throws InterruptedException
	{
		YatraCruisePage  yatraCruisePage = new YatraCruisePage(driver);
		
		yatraCruisePage.cruisePage();
	}
}
