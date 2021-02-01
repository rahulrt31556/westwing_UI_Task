package com.westwing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.westwing.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath = "//button[contains(text(),'Cookies akzeptieren')]")
	private WebElement acceptCookies;
	
	@FindBy(xpath = "//input[@placeholder='Produktsuche...']")
	private WebElement searchProduct;
	
	@FindBy(xpath = "//button[@data-identifier='LOGIN_AND_REGISTER']")
	private WebElement cancelButton;
	
	@FindBy(xpath = "//button[@data-testid='login-button']")
	private WebElement logInLink;
	
	// Initializing the Page Objects:
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public SearchResultListPage navigateToSearchFurnitureResult() {
			
			acceptCookies.click();
			WebDriverWait wait=new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(searchProduct)).sendKeys(prop.getProperty("searchInput")+ "\n");
			wait.until(ExpectedConditions.visibilityOf(email));
			logInLink.click();
			wait.until(ExpectedConditions.visibilityOf(cancelButton)).click();
			return new SearchResultListPage();
		}
		
		public String getHomePageTitle() {
			
			acceptCookies.click();	
		    return driver.getTitle();	
		
		}
}
