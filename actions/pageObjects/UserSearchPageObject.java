package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;

public class UserSearchPageObject extends AbstractPage {
	WebDriver driver;

	public UserSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}


}
		