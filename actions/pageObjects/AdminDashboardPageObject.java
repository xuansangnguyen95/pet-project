package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AdminDashboardPageUI;
import pageUIs.AdminLoginPageUI;

public class AdminDashboardPageObject extends AbstractPage {
	WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AdminProductPageObject openProductPage() {
		waitToElementClickable(driver, AdminDashboardPageUI.CATALOG_LINK_AT_SIDEBAR);
		clickToElement(driver, AdminDashboardPageUI.CATALOG_LINK_AT_SIDEBAR);
		waitToElementClickable(driver, AdminDashboardPageUI.PRODUCT_LINK_AT_SIDEBAR);
		clickToElement(driver, AdminDashboardPageUI.PRODUCT_LINK_AT_SIDEBAR);
		return PageGeneratorManager.getAdminProductPage(driver);
	}
}
