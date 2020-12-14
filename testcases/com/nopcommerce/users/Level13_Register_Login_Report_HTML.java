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

public class Level13_Register_Login_Report_HTML extends AbstractTest {
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
		log.info("Register - Step 01: Open homepage");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Register - Step 02: Verify register link displayed");
		verifyFalse(homePage.isRegisterLinkDisplayed());
		
		log.info("Register - Step 03: Verify login link displayed");
		verifyFalse(homePage.isLoginLinkDisplayed());
		
		log.info("Register - Step 04: click register link at hompage");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Step 05: click to gender male radio button");
		registerPage.clickToGenderMaleRadioButton();
		
		log.info("Register - Step 06: input to Firstname textbox with value: " + firstName);
		registerPage.inputToFirstNameTextbox(firstName);
		
		log.info("Register - Step 07: input to Lastname textbox with value: " + lastName);
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Register - Step 08: select date dropdown");
		registerPage.selectDayDropdown("10");
		
		log.info("Register - Step 09: select month dropdown");
		registerPage.selectMonthDropdown("August");
		
		log.info("Register - Step 10: select year dropdown");
		registerPage.selectYearDropdown("1999");
		
		log.info("Register - Step 11: input to Email textbox with value: " + email);
		registerPage.inputToEmailTextbox(email);
		
		log.info("Register - Step 12: input to CompanyName textbox");
		registerPage.inputToCompanyTextbox(companyName);
		
		log.info("Register - Step 13: input to Password textbox with value: " + password);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Register - Step 14: click to Register button at Register page");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 15: verify success message displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("Register - Step 16: click to logout link and navigate to homepage");
		homePage = registerPage.clickToLogoutLink();
	}
	
	@Test
	public void TC02_Login() {
		log.info("Login - Step 01: open login page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: input to Email textbox with value: " + email);
		loginPage.inputToEmailTextbox(email);
		
		log.info("Login - Step 03: input to Password textbox with value: " + password);
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Login - Step 04: click to Login button at Login page");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login - Step 05: verify My Account link displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		log.info("Login - Step 06: verify Logout link  displayed");
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
		
		log.info("Login - Step 07: verify Register link undisplayed");
		Assert.assertTrue(homePage.isRegisterLinkUndisplayed());
		
		log.info("Login - Step 08: verify Login link undisplayed");
		Assert.assertTrue(homePage.isLoginLinkUndisplayed());
	}
	

	@AfterClass
	public void afterClass() {
		sleepInMilisecond(1000);
		driver.quit();
	}


}
