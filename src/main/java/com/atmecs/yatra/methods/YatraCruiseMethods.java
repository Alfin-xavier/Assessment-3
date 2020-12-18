package com.atmecs.yatra.methods;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class YatraCruiseMethods 
{
	WebDriver driver;

	public YatraCruiseMethods(WebDriver driver)
	{
		this.driver = driver;
	}

	public void clickMoreLink(String xpath) 
	{
		driver.findElement(By.xpath(xpath)).click();
	}

	public void clickCruiseTab(String xpath) 
	{
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.findElement(By.xpath(xpath)).click();
	}

	public void selectValue(String xpath1, String xpath2) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath(xpath1)).click();
		driver.findElement(By.xpath(xpath2)).click();
	}
	
	public void clickSearchCruise(String xpath)
	{
		driver.findElement(By.xpath(xpath)).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	}
	
	public void switchingWindow() throws InterruptedException 
	{
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> id = ids.iterator();
		String parent = id.next();
		driver.close();
		String child = id.next();
		driver.switchTo().window(child);
		String title = driver.getTitle();
		System.out.println("Current window title:" +title);
		System.out.println("Current Url:" + driver.getCurrentUrl());
	}
	
	public void verifyItineraries(String xpath1, String xpath2) throws InterruptedException
	{
		WebElement itineraries = driver.findElement(By.xpath(xpath1));
		itineraries.click();
		List<WebElement> itinerary = driver.findElements(By.xpath(xpath2));
		Assert.assertFalse(itinerary.isEmpty());
		if(itinerary.isEmpty()==false)
		{
			System.out.println("Number of days plan under Itinerary:"+itinerary.size());
		}
		Thread.sleep(3000);
	}
	
	public void verifyItinerariesList(String xpath1, String xpath2) throws InterruptedException
	{
		driver.findElement(By.xpath(xpath1)).click();
		List<WebElement> itinerariesList = driver.findElements(By.xpath(xpath2));
		Assert.assertFalse(itinerariesList.isEmpty());
		if(itinerariesList.isEmpty()==false)
		{
			System.out.println("Number of days plan:"+itinerariesList.size());
		}
		Thread.sleep(3000);
	}
	
	public void clickBookButton(String xpath) throws InterruptedException
	{
		driver.findElement(By.xpath(xpath)).click();
		Thread.sleep(3000);
	}
	
	public void verifyDatas(String xpath)
	{
		String expectedPlanDatas = "4 Nights | Australia | Carnival Cruise Lines: Spirit";
		String actualPlanDatas = driver.findElement(By.xpath(xpath)).getText();
		Assert.assertEquals(actualPlanDatas, expectedPlanDatas, "Plan datas verified");
	}
}
