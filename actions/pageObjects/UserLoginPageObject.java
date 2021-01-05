package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserLoginPageUI;
import pageUIs.UserRegisterPageUI;

public class UserLoginPageObject extends AbstractPage {
	WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public UserHomePageObject clickToLoginButton() {
		waitToElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getSummaryErrorMessage() {
		waitToElementVisible(driver, UserLoginPageUI.SUMMARY_ERROR);
		return getElementText(driver, UserLoginPageUI.SUMMARY_ERROR);
	}

}
