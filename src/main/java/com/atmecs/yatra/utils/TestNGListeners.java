package com.atmecs.yatra.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener
{
	public static WebDriver driver;

	public void onTestStart(ITestResult result)
	{
		System.out.println(result.getName()+" "+"Strated!!");
	}

	public void onTestSuccess(ITestResult result)
	{
		System.out.println(result.getName()+" "+"Passed!!");
	}

	public void onTestFailure(ITestResult result)
	{
		System.out.println(result.getName()+" "+"Failed!!");

		TakeScreenShots.takeScreenshot(driver, result.getName());
	}

	public void onTestSkipped(ITestResult result) 
	{
		System.out.println(result.getName()+" "+"Skipped!!");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result)
	{
		
	}

	public void onStart(ITestContext context) 
	{
		
	}

	public void onFinish(ITestContext context) 
	{
		
	}

}
