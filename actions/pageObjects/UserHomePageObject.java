package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.UserHomePageUI;

public class UserHomePageObject extends AbstractPage {
	WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPageObject clickToRegisterLink() {
		waitToElementClickable(driver, UserHomePageUI.REGISTER_LINK);		
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}
	
	public UserLoginPageObject clickToLoginLink() {
		waitToElementClickable(driver, UserHomePageUI.LOGIN_LINK);		
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public UserHomePageObject clickToLogoutLink() {
		waitToElementClickable(driver, UserHomePageUI.LOGOUT_LINK);		
		clickToElement(driver, UserHomePageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisible(driver, UserHomePageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.LOGOUT_LINK);
	}

	public UserCustomerInforPageObject clickToMyAccountLink() {
		waitToElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);		
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}

	public boolean isRegisterLinkDisplayed() {
		return isElementDisplayed(driver, UserHomePageUI.REGISTER_LINK);
	}

	public boolean isLoginLinkDisplayed() {
		return isElementDisplayed(driver, UserHomePageUI.LOGIN_LINK);
	}

	public boolean isRegisterLinkUndisplayed() {
		waitToElementInvisible(driver, UserHomePageUI.REGISTER_LINK);
		return isElementUndisplayed(driver, UserHomePageUI.REGISTER_LINK);
	}

	public boolean isLoginLinkUndisplayed() {
		waitToElementInvisible(driver, UserHomePageUI.LOGIN_LINK);
		return isElementUndisplayed(driver, UserHomePageUI.LOGIN_LINK);
	}

	public void clickToSearchLink() {
		waitToElementClickable(driver, UserHomePageUI.SEARCH_LINK);		
		clickToElement(driver, UserHomePageUI.SEARCH_LINK);
	}


}
