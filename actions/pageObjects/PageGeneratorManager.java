package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static CustomerInforPageObject getCustomerInforPage(WebDriver driver) {
		return new CustomerInforPageObject(driver);
	}
	
	public static SearchPageObject getSearchPage(WebDriver driver) {
		return new SearchPageObject(driver);
	}
	
	public static ShippingAndReturnPageObject getShippingAndReturnPage(WebDriver driver) {
		return new ShippingAndReturnPageObject(driver);
	}
	
	public static SitemapPageObject getSitemapPage(WebDriver driver) {
		return new SitemapPageObject(driver);
	}
	
	public static WishListPageObject getWishListPage(WebDriver driver) {
		return new WishListPageObject(driver);
	}
	
	
}
