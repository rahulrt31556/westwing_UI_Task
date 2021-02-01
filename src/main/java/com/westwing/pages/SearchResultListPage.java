package com.westwing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.westwing.base.TestBase;

public class SearchResultListPage extends TestBase {
	
	HomePage homePage = new HomePage();
	
	@FindBy(xpath = "//div[@data-testid='wishlist-icon']")
	private WebElement wishListButton;
	
	@FindBy(xpath = "//button[@data-testid='login_reg_switch_btn']")
	private WebElement logInHere;
	
	@FindBy(xpath = "//div[@data-testid='wishlist-bubble']")
	private WebElement wishListPage;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@data-testid='login_reg_submit_btn']")
	private WebElement register;
	
	@FindBy(xpath = "//button[@class='blockListProduct__addToCart qaBlockListProduct__addToCart']")
	private WebElement wishListedItem;
	
	
	// Initializing the Page Objects:
		public SearchResultListPage() {
			PageFactory.initElements(driver, this);
		}
		
		public String searchResultListPageTitle() {
			
				return driver.getTitle();	
		}
	
		public WishListPage addToWishList() {
        	
			homePage.navigateToSearchFurnitureResult();
        	wishListButton.click();
        	logInHere.click();
        	logIn();
        	wishListPage.click();
        	return new WishListPage();
     
        }
		
		public void logIn() {
        	
        	email.sendKeys(prop.getProperty("username"));
        	password.sendKeys(prop.getProperty("password"));
        	register.click();
        	
        }
       
}
