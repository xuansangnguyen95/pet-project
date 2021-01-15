package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.UserAddressesPageUI;
import pageUIs.UserChangePasswordPageUI;

public class UserChangePasswordPageObject extends AbstractPage {
	WebDriver driver;

	public UserChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getChangePasswordResult() {
		waitToElementVisible(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_RESULT);
		return getElementText(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_RESULT);
	}

	public void clickToLogoutLink() {
		waitToElementClickable(driver, AbstractPageUI.LOGOUT_LINK);
		clickToElement(driver, AbstractPageUI.LOGOUT_LINK);
	}
	

}
