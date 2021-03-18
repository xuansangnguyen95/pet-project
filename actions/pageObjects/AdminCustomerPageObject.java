package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AdminCustomerDetailPageUI;
import pageUIs.AdminCustomerPageUI;
import pageUIs.AdminLoginPageUI;
import pageUIs.AdminProductPageUI;

public class AdminCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public AdminCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitAjaxLoadingInvisible(driver);
		waitToElementClickable(driver, AdminCustomerPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminCustomerPageUI.ADD_NEW_BUTTON);
		waitAjaxLoadingInvisible(driver);
	}
	
	public void removeCustomerRoleByValue(String value) {
		waitToElementClickable(driver, AdminCustomerPageUI.DYNAMIC_REMOVE_CUSTOMER_ROLE, value);
		clickToElement(driver, AdminCustomerPageUI.DYNAMIC_REMOVE_CUSTOMER_ROLE, value);
	}

	public void addCustomerRoleByValue(String value) {
		waitToElementVisible(driver, AdminCustomerPageUI.CUSTOMER_ROLE);
		selectItemInCustomDropdown(driver, AdminCustomerPageUI.CUSTOMER_ROLE, AdminCustomerPageUI.CUSTOMER_ROLE_OPTIONS, value);
	}

	public boolean isCustomerDisplayed(String customerName, String customerRole, String companyName, String activeStatus) {
		return isElementDisplayed(driver, AdminCustomerPageUI.DYNAMIC_CUSTOMER_TABLE_ROW, customerName, customerRole, companyName, activeStatus);
	}

	public String getNumberOfCustomer() {
		waitAjaxLoadingInvisible(driver);
		waitToElementVisible(driver, AdminCustomerPageUI.NUMBER_OF_CUSTOMER);
		return getElementText(driver, AdminCustomerPageUI.NUMBER_OF_CUSTOMER);
	}

	public void clickToEditButton(String customerName, String customerRole, String companyName) {
		waitToElementClickable(driver, AdminCustomerPageUI.DYNAMIC_CUSTOMER_EDIT_BUTTON, customerName, customerRole, companyName);
		clickToElement(driver, AdminCustomerPageUI.DYNAMIC_CUSTOMER_EDIT_BUTTON, customerName, customerRole, companyName);
	}
	
	
	
	
	
}
