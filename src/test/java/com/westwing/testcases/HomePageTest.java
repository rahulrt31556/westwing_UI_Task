package com.westwing.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.westwing.base.TestBase;
import com.westwing.pages.HomePage;
import com.westwing.util.TestUtil;

public class HomePageTest extends TestBase {

	TestUtil testUtil;
	HomePage homePage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws MalformedURLException {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();

	}
	
	@Test
	public void openAndValidateHomePage() {
		
		String pageTitle=homePage.getHomePageTitle();
		Assert.assertEquals(pageTitle, prop.getProperty("homePageTitle"));

	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
}
