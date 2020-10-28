package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.CustomerInfoPageUI;

public class CustomerInforPageObject extends AbstractPage {
	WebDriver driver;

	public CustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isGenderMaleRadioButtonSelected() {
		waitToElementVisible(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
	}

	public String getFirstNameTextboxValue() {
		waitToElementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxValue() {
		waitToElementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getSelectedTextInDayDropdown() {
		waitToElementVisible(driver, CustomerInfoPageUI.DAY_DROPDOWN);
		return getFirstSelectedText(driver, CustomerInfoPageUI.DAY_DROPDOWN);
	}

	public String getSelectedTextInMonthDropdown() {
		waitToElementVisible(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
		return getFirstSelectedText(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
	}

	public String getSelectedTextInYearDropdown() {
		waitToElementVisible(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
		return getFirstSelectedText(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
	}

	public String getEmailTextboxValue() {
		waitToElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyTextboxValue() {
		waitToElementVisible(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX, "value");
	}


}
