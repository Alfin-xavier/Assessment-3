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
	
	public void sectionDisplayed(String xpath1, String xpath2)
	{
		WebElement monumentsSection = driver.findElement(By.xpath(xpath1));
		Assert.assertTrue(monumentsSection.isDisplayed());
		
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
			List<WebElement> img = monumentsSection.findElements(By.className("image-holder"));
			
			System.out.println("Monuments are displayed under the Top Monuments section:"+img.size());
			
			for(int i= 0; i<img.size();i++)
			{
				boolean text = img.get(i).isDisplayed();
				System.out.println("Top Monuments:"+ text);
				
			}
			
	}
}
