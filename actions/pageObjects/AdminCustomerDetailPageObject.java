package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AdminCustomerDetailPageUI;
import pageUIs.AdminCustomerPageUI;
import pageUIs.AdminLoginPageUI;

public class AdminCustomerDetailPageObject extends AbstractPage {
	WebDriver driver;

	public AdminCustomerDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSaveAndContinueCustomerButton() {
		waitToElementClickable(driver, AdminCustomerDetailPageUI.SAVE_AND_CONTINUE_CUSTOMER_BUTTON);
		clickToElement(driver, AdminCustomerDetailPageUI.SAVE_AND_CONTINUE_CUSTOMER_BUTTON);
	}

	public void removeCustomerRoleByValue(String value) {
		waitToElementClickable(driver, AdminCustomerDetailPageUI.DYNAMIC_REMOVE_CUSTOMER_ROLE, value);
		clickToElement(driver, AdminCustomerDetailPageUI.DYNAMIC_REMOVE_CUSTOMER_ROLE, value);
	}

	public void addCustomerRoleByValue(String value) {
		waitToElementVisible(driver, AdminCustomerDetailPageUI.CUSTOMER_ROLE);
		selectItemInCustomDropdown(driver, AdminCustomerDetailPageUI.CUSTOMER_ROLE, AdminCustomerDetailPageUI.CUSTOMER_ROLE_OPTIONS, value);
	}

	public void inputToAdminCommment(String adminComment) {
		waitToElementClickable(driver, AdminCustomerDetailPageUI.ADMIN_COMMENT);
		sendKeysToElement(driver, AdminCustomerDetailPageUI.ADMIN_COMMENT, adminComment);
	}
	
	public String getAdminCommment() {
		return getElementText(driver, AdminCustomerDetailPageUI.ADMIN_COMMENT);
	}
	
	public boolean isCustomerRoleDisplayedByValue(String value) {
		return isElementDisplayed(driver, AdminCustomerDetailPageUI.DYNAMIC_REMOVE_CUSTOMER_ROLE, value);
	}

	public boolean isActiveCheckboxChecked() {
		return isElementSelected(driver, AdminCustomerDetailPageUI.ACTIVE_CHECKBOX);
	}

	public void clickToBackToCustomerList() {
		waitToElementClickable(driver, AdminCustomerDetailPageUI.BACK_TO_CUSTOMER_LIST);
		clickToElement(driver, AdminCustomerDetailPageUI.BACK_TO_CUSTOMER_LIST);	
	}

	public void clickToSaveCustomerButton() {
		waitToElementClickable(driver, AdminCustomerDetailPageUI.SAVE_CUSTOMER_BUTTON);
		clickToElement(driver, AdminCustomerDetailPageUI.SAVE_CUSTOMER_BUTTON);
	}

	public void clickToAddressesSection() {
		waitAjaxLoadingInvisible(driver);
		scrollToElement(driver, AdminCustomerDetailPageUI.ADDRESS_SECTION);
		
		if(isElementUndisplayed(driver, AdminCustomerDetailPageUI.ADDRESS_SECTION_PLUS_SIGN)) {
			
		} else {
			waitToElementClickable(driver, AdminCustomerDetailPageUI.ADDRESS_SECTION);
			clickToElement(driver, AdminCustomerDetailPageUI.ADDRESS_SECTION);
		}
		
	}

	public void clickToAddNewAddressButton() {
		waitToElementClickable(driver, AdminCustomerDetailPageUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElement(driver, AdminCustomerDetailPageUI.ADD_NEW_ADDRESS_BUTTON);
	}

	public void clickToSaveAddressButton() {
		waitToElementClickable(driver, AdminCustomerDetailPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver, AdminCustomerDetailPageUI.SAVE_ADDRESS_BUTTON);
	}

	public void clickToBackToCustomerDetail() {
		waitToElementClickable(driver, AdminCustomerDetailPageUI.BACK_TO_CUSTOMER_DETAIL);
		clickToElement(driver, AdminCustomerDetailPageUI.BACK_TO_CUSTOMER_DETAIL);
	}

	public String getAddressRow(String firstName, String lastName, String email, String phoneNumber, String faxNumber) {
		return getElementText(driver, AdminCustomerDetailPageUI.ADDRESS_ROW, firstName, lastName, email, phoneNumber, faxNumber);
	}

	public void clickToEditButton(String firstName, String lastName, String email, String phoneNumber,
			String faxNumber) {
		waitToElementClickable(driver, AdminCustomerDetailPageUI.ADDRESS_ROW_EDIT_BUTTON, firstName, lastName, email, phoneNumber, faxNumber);
		clickToElement(driver, AdminCustomerDetailPageUI.ADDRESS_ROW_EDIT_BUTTON, firstName, lastName, email, phoneNumber, faxNumber);
	}

	public void clickToSaveEditedAddressButton() {
		waitToElementClickable(driver, AdminCustomerDetailPageUI.SAVE_EDITED_ADDRESS_BUTTON);
		clickToElement(driver, AdminCustomerDetailPageUI.SAVE_EDITED_ADDRESS_BUTTON);
	}

	public void clickToDeleteButton(String firstName, String lastName, String email, String phoneNumber,
			String faxNumber) {
		waitToElementClickable(driver, AdminCustomerDetailPageUI.ADDRESS_ROW_DELETE_BUTTON, firstName, lastName, email, phoneNumber, faxNumber);
		clickToElement(driver, AdminCustomerDetailPageUI.ADDRESS_ROW_DELETE_BUTTON, firstName, lastName, email, phoneNumber, faxNumber);
		
		acceptAlert(driver);
		waitAjaxLoadingInvisible(driver);
	}

	public String getAddressTableAlert() {
		return getElementText(driver, AdminCustomerDetailPageUI.TABLE_EMPTY_ALERT);
	}


}
