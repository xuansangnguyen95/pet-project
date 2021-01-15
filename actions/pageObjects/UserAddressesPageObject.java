package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserAddressesPageUI;

public class UserAddressesPageObject extends AbstractPage {
	WebDriver driver;

	public UserAddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getInfoByClass(WebDriver driver, String infoClass) {
		waitToElementVisible(driver, UserAddressesPageUI.DYNAMIC_INFO, infoClass);
		return getElementText(driver, UserAddressesPageUI.DYNAMIC_INFO, infoClass);
	}
}
