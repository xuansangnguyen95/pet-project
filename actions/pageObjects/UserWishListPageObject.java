package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserWishListPageUI;

public class UserWishListPageObject extends AbstractPage {
	WebDriver driver;

	public UserWishListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductAddedToWishlistSuccessfully(String productName) {
		waitToElementVisible(driver, UserWishListPageUI.DYNAMIC_PRODUCT, productName);
		return isElementDisplayed(driver, UserWishListPageUI.DYNAMIC_PRODUCT, productName);
	}

	public void clickToURLWishlist() {
		waitToElementClickable(driver, UserWishListPageUI.URL_WISHLIST);
		clickToElement(driver, UserWishListPageUI.URL_WISHLIST);
	}

	public String getWishlistName() {
		waitToElementVisible(driver, UserWishListPageUI.NAME_WISHLIST);
		return getElementText(driver, UserWishListPageUI.NAME_WISHLIST);
	}

	public void clickAddToCartCheckbox() {
		waitToElementClickable(driver, UserWishListPageUI.ADD_TO_CART_CHECKBOX);
		clickToElement(driver, UserWishListPageUI.ADD_TO_CART_CHECKBOX);
	}

	public void clickRemoveCheckbox() {
		waitToElementClickable(driver, UserWishListPageUI.REMOVE_CHECKBOX);
		clickToElement(driver, UserWishListPageUI.REMOVE_CHECKBOX);
	}

	public String getWishlishMessage() {
		waitToElementVisible(driver, UserWishListPageUI.WISHLIST_MESSAGE);
		return getElementText(driver, UserWishListPageUI.WISHLIST_MESSAGE);
	}

}
		