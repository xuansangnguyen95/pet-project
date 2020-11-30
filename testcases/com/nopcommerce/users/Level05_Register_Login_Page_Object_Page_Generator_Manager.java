package com.nopcommerce.users;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
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

public class Level05_Register_Login_Page_Object_Page_Generator_Manager extends AbstractTest {
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
	UserSitemapPageObject sitemap;
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
	public void TC04_Switch_Page() {
		//hompage -> search
		searchPage = homePage.openSearch(driver);
		
		//search -> shipping and return
		shippingAndReturnPage = searchPage.openShippingAndReturn(driver);
		
		//shipping and return -> sitemap
		sitemap = shippingAndReturnPage.openSitemap(driver);
		
		//sitemap -> footer my account
		customerInforPage = sitemap.openMyAccount(driver);
		
		//footer my account -> homepage
		homePage = customerInforPage.openHomePage(driver);
		
		//homepage -> header wishlist
		wishList = homePage.openWishList(driver);
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

}
