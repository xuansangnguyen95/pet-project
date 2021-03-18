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
	
	public static UserAddressesPageObject getUserAddressesPage(WebDriver driver) {
		return new UserAddressesPageObject(driver);
	}
	
	public static UserChangePasswordPageObject getUserChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordPageObject(driver);
	}
	
	public static UserProductDetailPageObject getUserProductDetailPage(WebDriver driver) {
		return new UserProductDetailPageObject(driver);
	}
	
	public static UserProductReviewPageObject getUserProductReviewPage(WebDriver driver) {
		return new UserProductReviewPageObject(driver);
	}
	
	public static UserMyProductReviewPageObject getUserMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
	}
	
	public static UserComputersPageObject getUserComputersPage(WebDriver driver) {
		return new UserComputersPageObject(driver);
	}
	
	public static UserCompareProductPageObject getUserCompareProductPage(WebDriver driver) {
		return new UserCompareProductPageObject(driver);
	}
	
	public static UserRecentlyViewedProductPageObject getUserRecentlyViewedProductPage(WebDriver driver) {
		return new UserRecentlyViewedProductPageObject(driver);
	}
	
	public static UserShoppingCartPageObject getUserShoppingCartPage(WebDriver driver) {
		return new UserShoppingCartPageObject(driver);
	}
	
	public static UserCheckoutPageObject getUserCheckoutPage(WebDriver driver) {
		return new UserCheckoutPageObject(driver);
	}
	
	public static UserOrderDetailPageObject getUserOrderDetailPage(WebDriver driver) {
		return new UserOrderDetailPageObject(driver);
	}
	
	public static UserOrderListPageObject getUserOrderListPage(WebDriver driver) {
		return new UserOrderListPageObject(driver);
	}
	
	public static AdminProductDetailPageObject getAdminProductDetailPage(WebDriver driver) {
		return new AdminProductDetailPageObject(driver);
	}
	
	public static AdminCustomerPageObject getAdminCustomerPage(WebDriver driver) {
		return new AdminCustomerPageObject(driver);
	}
	
	public static AdminCustomerDetailPageObject getAdminCustomerDetailPage(WebDriver driver) {
		return new AdminCustomerDetailPageObject(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
