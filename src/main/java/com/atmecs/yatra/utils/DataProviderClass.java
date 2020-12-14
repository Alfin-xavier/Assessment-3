package com.atmecs.yatra.utils;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviderClass 
{
	@DataProvider(name = "testData")
	public Object[][] readData(Method method)
	{
		Object[][] data = ReadDataFromExcel.readExcelData(method.getName());
		
		return data;
	}
	
}
