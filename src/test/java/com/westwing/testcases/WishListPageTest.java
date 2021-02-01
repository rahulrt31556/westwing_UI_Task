package com.westwing.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.westwing.base.TestBase;
import com.westwing.pages.HomePage;
import com.westwing.pages.SearchResultListPage;
import com.westwing.pages.WishListPage;
import com.westwing.util.TestUtil;

public class WishListPageTest extends TestBase {

	TestUtil testUtil;
	HomePage homePage;
	SearchResultListPage searchResultListPage;
	WishListPage wishListPage;
	
	public WishListPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws MalformedURLException {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		searchResultListPage = new SearchResultListPage();
		wishListPage = new WishListPage();

	}
	
	@Test
	public void addToWishListTest() {
		
	WishListPage searchResult = searchResultListPage.addToWishList();
	Assert.assertEquals(searchResult.wishListPageTitle(), "Meine Wunschliste | WestwingNow");
		
	}
	
	@Test
	public void deleteFromWishListTest() {
		
	String searchResult = wishListPage.deleteFromWishList();
	Assert.assertEquals(searchResult, "Die Wunschliste ist momentan leer");
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
}
