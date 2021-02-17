package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserOrderDetailPageUI;
import pageUIs.UserOrderDetailPageUI;

public class UserOrderDetailPageObject extends AbstractPage {
	WebDriver driver;

	public UserOrderDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getBillingAddress() {
		waitToElementVisible(driver, UserOrderDetailPageUI.BILLING_ADDRESS);
		return getElementText(driver, UserOrderDetailPageUI.BILLING_ADDRESS);
	}

	public String getShippingAddress() {
		waitToElementVisible(driver, UserOrderDetailPageUI.SHIPPING_ADDRESS);
		return getElementText(driver, UserOrderDetailPageUI.SHIPPING_ADDRESS);
	}
	
	public String getPaymentMethod() {
		waitToElementVisible(driver, UserOrderDetailPageUI.PAYMENT_METHOD);
		return getElementText(driver, UserOrderDetailPageUI.PAYMENT_METHOD);
	}

	public String getShippingMethod() {
		waitToElementVisible(driver, UserOrderDetailPageUI.SHIPPING_METHOD);
		return getElementText(driver, UserOrderDetailPageUI.SHIPPING_METHOD);
	}

	public String getGiftWrappingStatus() {
		waitToElementVisible(driver, UserOrderDetailPageUI.GIFT_WRAPPING_STATUS);
		return getElementText(driver, UserOrderDetailPageUI.GIFT_WRAPPING_STATUS);
	}
	
	public String getProductInfoByNameAndAttribute(String productName, String productAttribute) {
		waitToElementVisible(driver, UserOrderDetailPageUI.DYNAMIC_PRODUCT_CHECKOUT_INFO, productName, productAttribute);
		return getElementText(driver, UserOrderDetailPageUI.DYNAMIC_PRODUCT_CHECKOUT_INFO, productName, productAttribute);
	}

	public boolean isOrderNumberIsDisplayed(String orderNumber) {
		return isElementDisplayed(driver, UserOrderDetailPageUI.DYNAMIC_ORDER_NUMBER, orderNumber);
	}

	public String getOrderStatusSummary() {
		waitToElementVisible(driver, UserOrderDetailPageUI.ORDER_STATUS_SUMMARY);
		return getElementText(driver, UserOrderDetailPageUI.ORDER_STATUS_SUMMARY);
	}

	public String getOrderTotalSummary() {
		waitToElementVisible(driver, UserOrderDetailPageUI.ORDER_TOTAL_SUMMARY);
		return getElementText(driver, UserOrderDetailPageUI.ORDER_TOTAL_SUMMARY);
	}

	public String getOrderSubtotal() {
		waitToElementVisible(driver, UserOrderDetailPageUI.ORDER_SUBTOTAL);
		return getElementText(driver, UserOrderDetailPageUI.ORDER_SUBTOTAL);
	}

	public String getOrderShippingCost() {
		waitToElementVisible(driver, UserOrderDetailPageUI.SHIPPING_COST);
		return getElementText(driver, UserOrderDetailPageUI.SHIPPING_COST);
	}

	public String getOrderTaxValue() {
		waitToElementVisible(driver, UserOrderDetailPageUI.TAX_VALUE);
		return getElementText(driver, UserOrderDetailPageUI.TAX_VALUE);
	}

	public String getOrderTotal() {
		waitToElementVisible(driver, UserOrderDetailPageUI.ORDER_TOTAL);
		return getElementText(driver, UserOrderDetailPageUI.ORDER_TOTAL);
	}
	
	
	
	
	
	

}
		