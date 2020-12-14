package com.atmecs.yatra.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.atmecs.yatra.constants.FilePathConstants;

public class ReadDataFromExcel 
{
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	public static Object[][] data;
	
	public static Object[][] readExcelData(String sheetname)
	{		
		
		FileInputStream finput = null;
		try
		{
			finput = new FileInputStream(FilePathConstants.TESTDATAS);
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		
		try 
		{
			workbook = new XSSFWorkbook(finput);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		
		sheet= workbook.getSheet(sheetname); 
		
		 data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++) 
		{ 
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) 
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				
			}
		}
		return data;
    }
}
