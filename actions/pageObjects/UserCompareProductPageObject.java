package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCompareProductPageUI;
import pageUIs.UserWishListPageUI;

public class UserCompareProductPageObject extends AbstractPage {
	WebDriver driver;

	public UserCompareProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isRemoveButton01Displayed() {
		waitToElementVisible(driver, UserCompareProductPageUI.REMOVE_BUTTON_01);
		return isElementDisplayed(driver, UserCompareProductPageUI.REMOVE_BUTTON_01);
	}
	
	public boolean isRemoveButton02Displayed() {
		waitToElementVisible(driver, UserCompareProductPageUI.REMOVE_BUTTON_02);
		return isElementDisplayed(driver, UserCompareProductPageUI.REMOVE_BUTTON_02);
	}

	public boolean isProductNameDisplayed(String productName) {
		waitToElementVisible(driver, UserCompareProductPageUI.DYNAMIC_PRODUCT_NAME, productName);
		return isElementDisplayed(driver, UserCompareProductPageUI.DYNAMIC_PRODUCT_NAME, productName);
	}

	public boolean isPriceDisplayed(String productPrice) {
		waitToElementVisible(driver, UserCompareProductPageUI.DYNAMIC_PRODUCT_PRICE, productPrice);
		return isElementDisplayed(driver, UserCompareProductPageUI.DYNAMIC_PRODUCT_PRICE, productPrice);
	}

	public boolean isClearListButtonDisplayed() {
		waitToElementVisible(driver, UserCompareProductPageUI.CLEAR_LIST_BUTTON);
		return isElementDisplayed(driver, UserCompareProductPageUI.CLEAR_LIST_BUTTON);
	}

	public void clickToClearListButton() {
		waitToElementClickable(driver, UserCompareProductPageUI.CLEAR_LIST_BUTTON);
		clickToElement(driver, UserCompareProductPageUI.CLEAR_LIST_BUTTON);
	}

	public String getCompareMessage() {
		waitAjaxLoadingInvisible(driver);
		waitToElementVisible(driver, UserCompareProductPageUI.COMPARE_MESSAGE);
		return getElementText(driver, UserCompareProductPageUI.COMPARE_MESSAGE);
	}

	
	
	

}
		