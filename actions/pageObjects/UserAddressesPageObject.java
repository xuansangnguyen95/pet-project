package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class UserAddressesPageObject extends AbstractPage {
	WebDriver driver;

	public UserAddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
