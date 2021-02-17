package com.nopcommerce.users;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

import commons.AbstractTest;
import commons.GlobalConstants;
import pageObjects.UserCustomerInforPageObject;
import pageObjects.UserHomePageObject;
import pageObjects.UserLoginPageObject;
import pageObjects.UserProductDetailPageObject;
import pageObjects.UserRecentlyViewedProductPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.UserCompareProductPageObject;
import pageObjects.UserComputersPageObject;
import pageObjects.UserRegisterPageObject;
import pageObjects.UserShoppingCartPageObject;
import pageObjects.UserWishListPageObject;

public class Wistlist_Compare_RecentView extends AbstractTest {
	WebDriver driver;
	String source_folder = System.getProperty("user.dir");
	Select select;
	String firstName, lastName, email, companyName, password, date, month, year, productName;
	
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	UserCustomerInforPageObject customerInforPage;
	UserWishListPageObject wishList;
	UserProductDetailPageObject productDetailPage;
	UserShoppingCartPageObject shoppingCartPage;
	UserCompareProductPageObject compareProductPage;
	UserComputersPageObject computersPage;
	UserRecentlyViewedProductPageObject recentlyViewedProductPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.DEMO_USER_PAGE);
		
		productName = "Apple MacBook Pro 13-inch";
		
		log.info("Precondition - Step 01: Open homepage");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Precondition - Step 02: click register link at hompage");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Precondition - Step 03: input to Email textbox with value: " + Common_01_Register.email);
		loginPage.inputToTextBoxByID(driver, "Email", Common_01_Register.email);
		
		log.info("Precondition - Step 04: input to Password textbox with value: " + Common_01_Register.password);
		loginPage.inputToTextBoxByID(driver, "Password", Common_01_Register.password);
		
		log.info("Precondition - Step 05: click to 'Login' button at Login Page");
		loginPage.clickToButtonByValue(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Precondition - Step 06: click to product " + productName);
		homePage.clickToProductByName(driver, productName);
		productDetailPage = PageGeneratorManager.getUserProductDetailPage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() {

	}
	
	@Test
	public void TC01_AddToWishlist() {
		
		log.info("Add To Wishlist - Step 01: click 'Add to wishlist' button");
		productDetailPage.clickToButtonByValue(driver, "Add to wishlist");
		
		log.info("Add To Wishlist - Step 02: verify message add to wishlist successfully");
		verifyEquals(productDetailPage.getTopMessage(), "The product has been added to your wishlist");
		
		log.info("Add To Wishlist - Step 03: navigate to wishlist page");
		productDetailPage.clickToWishlistLink();
		wishList = PageGeneratorManager.getUserWishListPage(driver);
		
		log.info("Add To Wishlist - Step 04: verify product added to wishlist successfully");
		verifyTrue(wishList.isProductAddedToWishlistSuccessfully(productName));
		
		log.info("Add To Wishlist - Step 05: view wishlist");
		wishList.clickToURLWishlist();
		verifyEquals(wishList.getWishlistName(), "Wishlist of john gacy");
		
	}
	
	@Test
	public void TC02_AddProductToCartFromWishlist() {
		
		log.info("Add Product To Cart From Wishlist - Step 01: click 'Add to cart' checkbox");
		wishList.clickAddToCartCheckbox();
		
		log.info("Add Product To Cart From Wishlist - Step 02: click 'Add to cart' button");
		wishList.clickToButtonByValue(driver, "Add to cart");
		shoppingCartPage = PageGeneratorManager.getUserShoppingCartPage(driver);
		
		log.info("Add Product To Cart From Wishlist - Step 03: verify product added to cart successfully");
		verifyTrue(shoppingCartPage.isProductAddedToCartSuccessfully(productName));
	}

	@Test
	public void TC03_RemoveProductInWishlist() {
		
		log.info("Remove Product In Wishlist - Step 01: click back to Homepage");
		shoppingCartPage.clickToHomepage(driver);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Remove Product In Wishlist - Step 02: click to product " + productName);
		homePage.clickToProductByName(driver, productName);
		productDetailPage = PageGeneratorManager.getUserProductDetailPage(driver);
		
		log.info("Remove Product In Wishlist - Step 03: click 'Add to wishlist' button");
		productDetailPage.clickToButtonByValue(driver, "Add to wishlist");
		
		log.info("Remove Product In Wishlist - Step 04: verify message add to wishlist successfully");
		verifyEquals(productDetailPage.getTopMessage(), "The product has been added to your wishlist");
		
		log.info("Remove Product In Wishlist - Step 05: navigate to wishlist page");
		productDetailPage.clickToWishlistLink();
		wishList = PageGeneratorManager.getUserWishListPage(driver);
		
		log.info("Remove Product In Wishlist - Step 06: click 'Remove' checkbox");
		wishList.clickRemoveCheckbox();
		
		log.info("Remove Product In Wishlist - Step 07: click 'Update wishlist' button");
		wishList.clickToButtonByValue(driver, "Update wishlist");
		
		log.info("Remove Product In Wishlist - Step 08: verify message after remove product from wishlist");
		verifyEquals(wishList.getWishlishMessage(), "The wishlist is empty!");
	}
	
	@Test
	public void TC04_AddProductToCompare() {
		
		log.info("Add Product To Compare - Step 01: click back to Homepage");
		wishList.clickToHomepage(driver);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Add Product To Compare - Step 02: add 'Build your own computer' to compare list and verify message");
		homePage.addToCompareByProductName(driver, "Build your own computer");
		verifyEquals(homePage.getTopMessage(), "The product has been added to your product comparison");
		
		log.info("Add Product To Compare - Step 03: add 'Apple MacBook Pro 13-inch' to compare list and verify message");
		homePage.addToCompareByProductName(driver, "Apple MacBook Pro 13-inch");
		verifyEquals(homePage.getTopMessage(), "The product has been added to your product comparison");
		
		log.info("Add Product To Compare - Step 04: click link 'Compare product list' footer");
		homePage.openLinkByPageName(driver, "Compare products list");		
		compareProductPage = PageGeneratorManager.getUserCompareProductPage(driver);
		
		log.info("Add Product To Compare - Step 05: verify information");
		verifyTrue(compareProductPage.isRemoveButton01Displayed());
		verifyTrue(compareProductPage.isRemoveButton02Displayed());
		verifyTrue(compareProductPage.isProductNameDisplayed("Apple MacBook Pro 13-inch"));
		verifyTrue(compareProductPage.isProductNameDisplayed("Build your own computer"));
		verifyTrue(compareProductPage.isPriceDisplayed("$1,200.00"));
		verifyTrue(compareProductPage.isPriceDisplayed("$1,800.00"));
		verifyTrue(compareProductPage.isClearListButtonDisplayed());
		
		log.info("Add Product To Compare - Step 06: click 'Clear list' button");
		compareProductPage.clickToClearListButton();
		
		log.info("Add Product To Compare - Step 07: verify message");
		verifyEquals(compareProductPage.getCompareMessage(), "You have no items to compare.");
		
		
	}

	@Test
	public void TC05_RecentlyViewedProduct() {
		
		log.info("Recently Viewed Product - Step 01: click back to Homepage");
		compareProductPage.clickToHomepage(driver);
		
		log.info("Recently Viewed Product - Step 02: click 'Computers' at Homepage");
		homePage.clickToComputersOnHeading();
		computersPage = PageGeneratorManager.getUserComputersPage(driver);
		
		log.info("Recently Viewed Product - Step 03: click sub menu 'Notebooks' at 'Computers' page");
		computersPage.clickToNotebooksSubmenu();
		
		log.info("Recently Viewed Product - Step 04: click 5 products");
		computersPage.clickToProductByName(driver, "Apple MacBook Pro 13-inch");
		computersPage.backToPage(driver);
		
		computersPage.clickToProductByName(driver, "Asus N551JK-XO076H Laptop");
		computersPage.backToPage(driver);
		
		computersPage.clickToProductByName(driver, "HP Envy 6-1180ca 15.6-Inch Sleekbook");
		computersPage.backToPage(driver);
		
		computersPage.clickToProductByName(driver, "HP Spectre XT Pro UltraBook");
		computersPage.backToPage(driver);
		
		computersPage.clickToProductByName(driver, "Lenovo Thinkpad X1 Carbon Laptop");
		computersPage.backToPage(driver);
		
		log.info("Recently Viewed Product - Step 05: click 'Recently viewed products' footer");
		computersPage.openLinkByPageName(driver, "Recently viewed products");
		recentlyViewedProductPage = PageGeneratorManager.getUserRecentlyViewedProductPage(driver);
		
		log.info("Recently Viewed Product - Step 06: verify there is only 3 nearest viewed products");
		verifyTrue(recentlyViewedProductPage.isProductNameDisplayed("Lenovo Thinkpad X1 Carbon Laptop"));
		verifyTrue(recentlyViewedProductPage.isProductNameDisplayed("HP Spectre XT Pro UltraBook"));
		verifyTrue(recentlyViewedProductPage.isProductNameDisplayed("HP Envy 6-1180ca 15.6-Inch Sleekbook"));
		verifyTrue(recentlyViewedProductPage.isProductNameUndisplayed("Asus N551JK-XO076H Laptop"));
		verifyTrue(recentlyViewedProductPage.isProductNameUndisplayed("Apple MacBook Pro 13-inch"));
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}


}
