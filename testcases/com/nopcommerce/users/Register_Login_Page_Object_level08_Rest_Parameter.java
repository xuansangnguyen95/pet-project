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
import pageObjects.CustomerInforPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import pageObjects.SearchPageObject;
import pageObjects.ShippingAndReturnPageObject;
import pageObjects.SitemapPageObject;
import pageObjects.WishListPageObject;

public class Register_Login_Page_Object_level08_Rest_Parameter extends AbstractTest {
	WebDriver driver;
	String source_folder = System.getProperty("user.dir");
	Select select;
	String firstName, lastName, email, companyName, password;
	
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	CustomerInforPageObject customerInforPage;
	SearchPageObject searchPage;
	ShippingAndReturnPageObject shippingAndReturnPage;
	SitemapPageObject sitemapPage;
	WishListPageObject wishList;

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
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
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
	
	@Test
	public void TC05_Switch_Page_02() {
		//hompage -> search
		searchPage = (SearchPageObject) homePage.openLinkByPageName(driver, "Search");
		
		//search -> shipping and return
		shippingAndReturnPage = (ShippingAndReturnPageObject) searchPage.openLinkByPageName(driver, "Shipping & returns");
		
		//shipping and return -> sitemap
		sitemapPage = (SitemapPageObject) shippingAndReturnPage.openLinkByPageName(driver, "Sitemap");
		
		//sitemap -> footer my account
		customerInforPage = (CustomerInforPageObject) sitemapPage.openLinkByPageName(driver, "My account");
		
	}
	
	@Test
	public void TC05_Switch_Page_03() {
		//hompage -> search
		homePage.openLinkWithPageName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		
		//search -> shipping and return
		searchPage.openLinkWithPageName(driver, "Shipping & returns");
		shippingAndReturnPage = PageGeneratorManager.getShippingAndReturnPage(driver);
		
		//shipping and return -> sitemap
		shippingAndReturnPage.openLinkWithPageName(driver, "Sitemap");
		sitemapPage = PageGeneratorManager.getSitemapPage(driver);
		
		//sitemap -> footer my account
		sitemapPage.openLinkWithPageName(driver, "My account");
		customerInforPage = PageGeneratorManager.getCustomerInforPage(driver);
	}

	
	@AfterClass
	public void afterClass() {
		sleepInMilisecond(1000);
		driver.quit();
	}


}
