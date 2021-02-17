package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCheckoutPageUI;
import pageUIs.UserWishListPageUI;

public class UserCheckoutPageObject extends AbstractPage {
	WebDriver driver;

	public UserCheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToBillingAddressContinueButton() {
		waitToElementClickable(driver, UserCheckoutPageUI.BILLING_ADDRESS_CONTINUE_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.BILLING_ADDRESS_CONTINUE_BUTTON);
	}
	
	public void clickToShippingAddressContinueButton() {
		waitToElementClickable(driver, UserCheckoutPageUI.SHIPPING_ADDRESS_CONTINUE_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.SHIPPING_ADDRESS_CONTINUE_BUTTON);
	}
	
	public void clickToShippingMethodContinueButton() {
		waitToElementClickable(driver, UserCheckoutPageUI.SHIPPING_METHOD_CONTINUE_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.SHIPPING_METHOD_CONTINUE_BUTTON);
	}
	
	public void clickToPaymentMethodContinueButton() {
		waitToElementClickable(driver, UserCheckoutPageUI.PAYMENT_METHOD_CONTINUE_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.PAYMENT_METHOD_CONTINUE_BUTTON);
	}
	
	public void clickToPaymentInformationContinueButton() {
		waitToElementClickable(driver, UserCheckoutPageUI.PAYMENT_INFO_CONTINUE_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.PAYMENT_INFO_CONTINUE_BUTTON);
	}

	public String getPaymentInfo() {
		waitToElementVisible(driver, UserCheckoutPageUI.PAYMENT_INFO);
		return getElementText(driver, UserCheckoutPageUI.PAYMENT_INFO);
	}

	public String getBillingAddress() {
		waitToElementVisible(driver, UserCheckoutPageUI.BILLING_ADDRESS);
		return getElementText(driver, UserCheckoutPageUI.BILLING_ADDRESS);
	}

	public String getShippingAddress() {
		waitToElementVisible(driver, UserCheckoutPageUI.SHIPPING_ADDRESS);
		return getElementText(driver, UserCheckoutPageUI.SHIPPING_ADDRESS);
	}
	
	public String getPaymentMethod() {
		waitToElementVisible(driver, UserCheckoutPageUI.PAYMENT_METHOD);
		return getElementText(driver, UserCheckoutPageUI.PAYMENT_METHOD);
	}

	public String getShippingMethod() {
		waitToElementVisible(driver, UserCheckoutPageUI.SHIPPING_METHOD);
		return getElementText(driver, UserCheckoutPageUI.SHIPPING_METHOD);
	}

	public String getProductInfoByNameAndAttribute(String productName, String productAttribute) {
		waitToElementVisible(driver, UserCheckoutPageUI.DYNAMIC_PRODUCT_CHECKOUT_INFO, productName, productAttribute);
		return getElementText(driver, UserCheckoutPageUI.DYNAMIC_PRODUCT_CHECKOUT_INFO, productName, productAttribute);
	}

	public String getGiftWrappingStatus() {
		waitToElementVisible(driver, UserCheckoutPageUI.GIFT_WRAPPING_STATUS);
		return getElementText(driver, UserCheckoutPageUI.GIFT_WRAPPING_STATUS);
	}

	public boolean isOrderCompleteMessageDisplayed() {
		return isElementDisplayed(driver, UserCheckoutPageUI.ORDER_COMPLETE_MESSAGE);
	}

	public boolean isOrderNumberDisplayed() {
		return isElementDisplayed(driver, UserCheckoutPageUI.ORDER_NUMBER);
	}

	public String getOrderNumber() {
		waitToElementVisible(driver, UserCheckoutPageUI.ORDER_NUMBER);
		return getElementText(driver, UserCheckoutPageUI.ORDER_NUMBER).substring(14, 18);
	}



}
		