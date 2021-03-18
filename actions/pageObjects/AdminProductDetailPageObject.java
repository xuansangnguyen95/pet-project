package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AdminDashboardPageUI;
import pageUIs.AdminLoginPageUI;
import pageUIs.AdminProductDetailPageUI;

public class AdminProductDetailPageObject extends AbstractPage {
	WebDriver driver;

	public AdminProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean doesPageTitleContainEditProductDetail() {
		return isElementDisplayed(driver, AdminProductDetailPageUI.PAGE_TITLE);
	}
	
	
	
	
	
	
	
}
