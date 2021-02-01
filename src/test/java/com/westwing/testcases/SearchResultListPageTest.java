package com.westwing.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.westwing.base.TestBase;
import com.westwing.pages.HomePage;
import com.westwing.pages.SearchResultListPage;
import com.westwing.util.TestUtil;

public class SearchResultListPageTest extends TestBase {

	TestUtil testUtil;
	HomePage homePage;
	SearchResultListPage searchResultListPage;
	
	public SearchResultListPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws MalformedURLException {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		searchResultListPage = new SearchResultListPage();

	}
	
	@Test
	public void searchFurnitureTest() {
		
	SearchResultListPage searchResult = homePage.navigateToSearchFurnitureResult();
	Assert.assertEquals(searchResult.searchResultListPageTitle(), prop.getProperty("furnitureSearchPageTitle"));
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
}
