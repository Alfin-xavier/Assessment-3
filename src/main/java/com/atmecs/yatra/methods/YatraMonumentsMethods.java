package com.atmecs.yatra.methods;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class YatraMonumentsMethods 
{
	WebDriver driver;
	
	public YatraMonumentsMethods(WebDriver driver) 
	{
		this .driver = driver;
	}
	
	public void clickMoreLink(String xpath)
	{
		driver.findElement(By.xpath(xpath)).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	}
	
	public void clickMonumentTab(String xpath)
	{
		driver.findElement(By.xpath(xpath)).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	}
	
	public void sectionDisplayed(String xpath1) throws InterruptedException
	{
		WebElement monumentsSection = driver.findElement(By.xpath(xpath1));
		
		Assert.assertTrue(monumentsSection.isDisplayed());
		
		if(monumentsSection.isDisplayed()==true)
		{
			Thread.sleep(2000);

			List<WebElement> img = monumentsSection.findElements(By.className("image-holder"));

			System.out.println("Monuments are displayed under the Top Monuments section:" + img.size());
		}
		
	}
	
	public void verifyMonuments(String xpath,String msg)
	{
		WebElement verifyMonument = driver.findElement(By.xpath(xpath));
		
		Assert.assertTrue(verifyMonument.isDisplayed());
		
		if(verifyMonument.isDisplayed()== true)
		{
			System.out.println(msg);
		}
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	}
}
