package com.nopcommerce.users;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.UserCustomerInforPageObject;
import pageObjects.UserHomePageObject;
import pageObjects.UserLoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.UserRegisterPageObject;
import pageObjects.UserSearchPageObject;
import pageObjects.UserShippingAndReturnPageObject;
import pageObjects.UserSitemapPageObject;
import pageObjects.UserWishListPageObject;

public class Level08_Register_Login_Page_Object_Rest_Parameter extends AbstractTest {
	WebDriver driver;
	String source_folder = System.getProperty("user.dir");
	Select select;
	String firstName, lastName, email, companyName, password;
	
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	UserCustomerInforPageObject customerInforPage;
	UserSearchPageObject searchPage;
	UserShippingAndReturnPageObject shippingAndReturnPage;
	UserSitemapPageObject sitemapPage;
	UserWishListPageObject wishList;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
		
		firstName = "john";
		lastName = "gacy";
		email = "johngacy" + getRandomNumber() + "@gmail.com";
		companyName = "gacy";
		password = "johngacy";
		
	
		 
	}

	@Test
	public void TC01_Register() {
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToGenderMaleRadioButton();
		
		registerPage.inputToFirstNameTextbox(firstName);
		
		registerPage.inputToLastNameTextbox(lastName);
		
		registerPage.selectDayDropdown("10");
		
		registerPage.selectMonthDropdown("August");
		
		registerPage.selectYearDropdown("1999");
		
		registerPage.inputToEmailTextbox(email);
		
		registerPage.inputToCompanyTextbox(companyName);
		
		registerPage.inputToPasswordTextbox(password);
		
		registerPage.inputToConfirmPasswordTextbox(password);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		homePage = registerPage.clickToLogoutLink();
	}
	
	@Test
	public void TC02_Login() {
		
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		
		
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
		
	}
	
	@Test
	public void TC03_View_My_Account() {
		
		customerInforPage = homePage.clickToMyAccountLink();
		
		Assert.assertTrue(customerInforPage.isGenderMaleRadioButtonSelected());
		
		Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(), firstName);
		Assert.assertEquals(customerInforPage.getLastNameTextboxValue(), lastName);
		
		Assert.assertEquals(customerInforPage.getSelectedTextInDayDropdown(), "10");
		Assert.assertEquals(customerInforPage.getSelectedTextInMonthDropdown(), "August");
		Assert.assertEquals(customerInforPage.getSelectedTextInYearDropdown(), "1999");
		
		Assert.assertEquals(customerInforPage.getEmailTextboxValue(), email);
		Assert.assertEquals(customerInforPage.getCompanyTextboxValue(), companyName);
	}
	
	@Test
	public void TC04_Switch_Page_01() {
		//hompage -> search
		searchPage = homePage.openSearch(driver);
		
		//search -> shipping and return
		shippingAndReturnPage = searchPage.openShippingAndReturn(driver);
		
		//shipping and return -> sitemap
		sitemapPage = shippingAndReturnPage.openSitemap(driver);
		
		//sitemap -> footer my account
		customerInforPage = sitemapPage.openMyAccount(driver);
		
		//footer my account -> homepage
		homePage = customerInforPage.openHomePage(driver);
		
		//homepage -> header wishlist
		wishList = homePage.openWishList(driver);
		
	}
	
//	@Test
//	public void TC05_Switch_Page_02() {
//		//hompage -> search
//		searchPage = (UserSearchPageObject) homePage.openLinkByPageName(driver, "Search");
//		
//		//search -> shipping and return
//		shippingAndReturnPage = (UserShippingAndReturnPageObject) searchPage.openLinkByPageName(driver, "Shipping & returns");
//		
//		//shipping and return -> sitemap
//		sitemapPage = (UserSitemapPageObject) shippingAndReturnPage.openLinkByPageName(driver, "Sitemap");
//		
//		//sitemap -> footer my account
//		customerInforPage = (UserCustomerInforPageObject) sitemapPage.openLinkByPageName(driver, "My account");
//		
//	}
	
	@Test
	public void TC05_Switch_Page_03() {
		//hompage -> search
		homePage.openLinkByPageName(driver, "Search");
		searchPage = PageGeneratorManager.getUserSearchPage(driver);
		
		//search -> shipping and return
		searchPage.openLinkByPageName(driver, "Shipping & returns");
		shippingAndReturnPage = PageGeneratorManager.getUserShippingAndReturnPage(driver);
		
		//shipping and return -> sitemap
		shippingAndReturnPage.openLinkByPageName(driver, "Sitemap");
		sitemapPage = PageGeneratorManager.getUserSitemapPage(driver);
		
		//sitemap -> footer my account
		sitemapPage.openLinkByPageName(driver, "My account");
		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);
	}

	
	@AfterClass
	public void afterClass() {
		sleepInMilisecond(1000);
		driver.quit();
	}


}
