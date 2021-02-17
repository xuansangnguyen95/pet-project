package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import pageUIs.UserComputersPageUI;

public class UserComputersPageObject extends AbstractPage {
	WebDriver driver;

	public UserComputersPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToNotebooksSubmenu() {
		waitToElementClickable(driver, UserComputersPageUI.NOTEBOOKS_LINK);
		clickToElement(driver, UserComputersPageUI.NOTEBOOKS_LINK);
	}

	public boolean isProductNameSortAtoZ() {
		List<WebElement> productName = getElements(driver, UserComputersPageUI.PRODUCT_TITLE);
		return false;
	}
}
		