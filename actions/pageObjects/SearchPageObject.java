package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;

public class SearchPageObject extends AbstractPage {
	WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}


}
		