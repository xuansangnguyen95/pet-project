package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserRegisterPageUI;

public class UserRegisterPageObject extends AbstractPage {
	WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToGenderMaleRadioButton() {
		waitToElementClickable(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitToElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitToElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void selectDayDropdown(String day) {
		waitToElementClickable(driver, UserRegisterPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.DAY_DROPDOWN, day);
	}

	public void selectMonthDropdown(String month) {
		waitToElementClickable(driver, UserRegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.MONTH_DROPDOWN, month);
	}

	public void selectYearDropdown(String year) {
		waitToElementClickable(driver, UserRegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.YEAR_DROPDOWN, year);
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToCompanyTextbox(String companyName) {
		waitToElementVisible(driver, UserRegisterPageUI.COMPANY_NAME_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToConfirmPasswordTextbox(String password) {
		waitToElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
	}

	public String getRegisterSuccessMessage() {
		waitToElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public UserHomePageObject clickToLogoutLink() {
		waitToElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getSummaryErrorMessage() {
		waitToElementVisible(driver, UserRegisterPageUI.SUMMARY_ERROR);
		return getElementText(driver, UserRegisterPageUI.SUMMARY_ERROR);
	}

}
