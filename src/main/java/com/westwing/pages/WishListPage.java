package com.westwing.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.westwing.base.TestBase;

public class WishListPage extends TestBase {
	
	
	SearchResultListPage searchResultListPage = new SearchResultListPage();
	
	@FindBy(xpath = "//button[@class='blockListProduct__delete qaBlockListProduct__delete']")
	private WebElement deleteFromWishList;
	
	@FindBy(xpath ="//p[@class='wishlistNoProducts__text wishlistNoProducts__text_bold']")
	private WebElement wishListDeleteStatus;
	
	
	public WishListPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String wishListPageTitle() {
		
		return driver.getTitle();	
	}
	
	public String deleteFromWishList() {
    	
		searchResultListPage.addToWishList();
    	deleteFromWishList.click();
    	return wishListDeleteStatus.getText();
    	
    }
}
