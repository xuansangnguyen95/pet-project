package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	
	public static UserCustomerInforPageObject getUserCustomerInforPage(WebDriver driver) {
		return new UserCustomerInforPageObject(driver);
	}
	
	public static UserSearchPageObject getUserSearchPage(WebDriver driver) {
		return new UserSearchPageObject(driver);
	}
	
	public static UserShippingAndReturnPageObject getUserShippingAndReturnPage(WebDriver driver) {
		return new UserShippingAndReturnPageObject(driver);
	}
	
	public static UserSitemapPageObject getUserSitemapPage(WebDriver driver) {
		return new UserSitemapPageObject(driver);
	}
	
	public static UserWishListPageObject getUserWishListPage(WebDriver driver) {
		return new UserWishListPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
	
	public static AdminProductPageObject getAdminProductPage(WebDriver driver) {
		return new AdminProductPageObject(driver);
	}
	
}
