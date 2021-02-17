package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserRecentlyViewedProductPageUI;

public class UserRecentlyViewedProductPageObject extends AbstractPage {
	WebDriver driver;

	public UserRecentlyViewedProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductNameDisplayed(String productName) {
		return isElementDisplayed(driver, UserRecentlyViewedProductPageUI.DYNAMIC_PRODUCT_NAME, productName);
	}
	
	public boolean isProductNameUndisplayed(String productName) {
		return isElementUndisplayed(driver, UserRecentlyViewedProductPageUI.DYNAMIC_PRODUCT_NAME, productName);
	}
 
	

}
		