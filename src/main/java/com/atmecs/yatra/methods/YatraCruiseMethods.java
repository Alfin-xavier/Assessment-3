package com.atmecs.yatra.methods;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		driver.findElement(By.xpath(xpath)).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	}

	public void selectValue(String xpath1, String xpath2, String value)
	{
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		WebElement cruise_section = driver.findElement(By.xpath(xpath1));
		WebElement selectValue = cruise_section.findElement(By.xpath(xpath2));
		selectValue.click();
	}
	
	public void clickSearch(String xpath1, String xpath2)
	{
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		WebElement cruise_section = driver.findElement(By.xpath(xpath1));
		WebElement searchButton = cruise_section.findElement(By.xpath(xpath2));
		searchButton.click();
	}
	
	public void switchingWindow() 
	{
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> id = ids.iterator();
		String parent = id.next();
		String child = id.next();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.switchTo().window(child);
		System.out.println("Child window title:" + driver.getTitle());
		System.out.println("Current Url:" + driver.getCurrentUrl());
	}
	
	public void clickItineraryIcon(String xpath)
	{
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void getItinerariesList(String xpath)
	{
		List<WebElement> itinerarier_List = driver.findElements(By.xpath(xpath));
		
		System.out.println("Number of day plans under Itinerary tab:"+itinerarier_List.size());
		
	}
}
