package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCheckoutPageUI;
import pageUIs.UserOrderDetailPageUI;
import pageUIs.UserOrderListPageUI;

public class UserOrderListPageObject extends AbstractPage {
	WebDriver driver;

	public UserOrderListPageObject(WebDriver driver) {
		this.driver = driver;
	}
	

	public boolean isOrderNumberDisplayedInOrderList(String orderNumber) {
		return isElementDisplayed(driver, UserOrderListPageUI.DYNAMIC_ORDER_NUMBER_IN_ORDER_LIST, orderNumber);
	}

	public void clickToDetailButtonByOrderNumber(String orderNumber) {
		waitToElementClickable(driver, UserOrderListPageUI.DYNAMIC_DETAIL_BUTTON_BY_ORDER_NUMBER, orderNumber);
		clickToElement(driver, UserOrderListPageUI.DYNAMIC_DETAIL_BUTTON_BY_ORDER_NUMBER, orderNumber);
	}



}
		