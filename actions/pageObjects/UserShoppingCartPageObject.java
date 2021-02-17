package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AdminProductPageUI;
import pageUIs.UserShoppingCartPageUI;
import pageUIs.UserWishListPageUI;

public class UserShoppingCartPageObject extends AbstractPage {
	WebDriver driver;

	public UserShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isProductAddedToCartSuccessfully(String productName) {
		waitToElementVisible(driver, UserShoppingCartPageUI.DYNAMIC_PRODUCT, productName);
		return isElementDisplayed(driver, UserShoppingCartPageUI.DYNAMIC_PRODUCT, productName);
	}

	public void clickToEditProduct() {
		waitToElementClickable(driver, UserShoppingCartPageUI.EDIT_LINK);
		clickToElement(driver, UserShoppingCartPageUI.EDIT_LINK);
	}

	public void clickToRemoveProductCheckbox(String productName) {
		waitToElementClickable(driver, UserShoppingCartPageUI.DYNAMIC_REMOVE_CHECKBOX, productName);
		clickToElement(driver, UserShoppingCartPageUI.DYNAMIC_REMOVE_CHECKBOX, productName);
	}

	public void clickToUpdateShoppingCartButton() {
		waitToElementClickable(driver, UserShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
		clickToElement(driver, UserShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
	}

	public String getSummaryMessage() {
		waitToElementVisible(driver, UserShoppingCartPageUI.ORDER_SUMMARY_MESSAGE);
		return getElementText(driver, UserShoppingCartPageUI.ORDER_SUMMARY_MESSAGE);
	}

	public void editProductQuantity(String productName, String productQuantity) {
		waitToElementClickable(driver, UserShoppingCartPageUI.DYNAMIC_PRODUCT_QUANTITY, productName);
		sendKeysToElement(driver, UserShoppingCartPageUI.DYNAMIC_PRODUCT_QUANTITY, productQuantity, productName);
	}

	public String getProductTotalPrice(String productName) {
		waitToElementVisible(driver, UserShoppingCartPageUI.DYNAMIC_PRODUCT_TOTAL_PRICE, productName);
		return getElementText(driver, UserShoppingCartPageUI.DYNAMIC_PRODUCT_TOTAL_PRICE, productName);
	}

	public void waitShippingOptionsLoadingInvisible(WebDriver driver) {
		waitToElementInvisible(driver, AdminProductPageUI.LOADING_ICON);
	}

	public void clickToEstimateShippingButton() {
		waitToElementClickable(driver, UserShoppingCartPageUI.ESTIMATE_SHIPPING_BUTTON);
		clickToElement(driver, UserShoppingCartPageUI.ESTIMATE_SHIPPING_BUTTON);
	}

	public void waitShippingOptionsLoadingInivisible() {
		waitToElementInvisible(driver, UserShoppingCartPageUI.SHIPPING_OPTIONS_LOADING);
	}

	public void clickToButtonByCheckout() {
		waitToElementClickable(driver, UserShoppingCartPageUI.CHECKOUT_BUTTON);
		clickToElement(driver, UserShoppingCartPageUI.CHECKOUT_BUTTON);
	}

	
	
	
}
		