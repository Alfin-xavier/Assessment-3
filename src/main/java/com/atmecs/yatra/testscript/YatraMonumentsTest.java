package com.atmecs.yatra.testscript;

import org.testng.annotations.Test;

import com.atmecs.yatra.page.BasePage;
import com.atmecs.yatra.page.YatraMonumentsPage;

public class YatraMonumentsTest extends BasePage
{
	@Test
	public void yatraMonuments()
	{
		YatraMonumentsPage monumentPage = new YatraMonumentsPage(driver);
		
		monumentPage.monumentsPage();
	}
}
