package com.nopcommerce.users;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
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
import pageObjects.PageGeneratorManager;
import pageObjects.UserRegisterPageObject;
import pageObjects.UserSearchPageObject;
import pageObjects.UserShippingAndReturnPageObject;
import pageObjects.UserSitemapPageObject;
import pageObjects.UserWishListPageObject;
import pageUIs.UserHomePageUI;

public class Login extends AbstractTest {
	WebDriver driver;
	String source_folder = System.getProperty("user.dir");
	Select select;
	String firstName, lastName, email, companyName, password, date, month, year;
	
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
		driver = getBrowserDriver(browserName, GlobalConstants.DEMO_USER_PAGE);
		
		firstName = "john";
		lastName = "gacy";
		//email = "johngacy" + getRandomNumber() + "@gmail.com";
		email = "johngacy395@gmail.com";
		companyName = "gacy";
		password = "johngacy";
		date = "21";
		month = "August";
		year = "1999";
	}
	
	@BeforeMethod
	public void beforeMethod() {
		log.info("Precondition - Step 01: Open homepage");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Precondition - Step 02: click register link at hompage");
		loginPage = homePage.clickToLoginLink();
	}
	
	@Test
	public void TC01_LoginWithValidData() {

		log.info("With valid data - Step 01: input to Email textbox with value: " + Common_01_Register.email);
		loginPage.inputToTextBoxByID(driver, "Email", Common_01_Register.email);
		
		log.info("With valid data - Step 02: input to Password textbox with value: " + password);
		loginPage.inputToTextBoxByID(driver, "Password", password);
		
		log.info("With valid data - Step 03: click to 'Login' button at Login Page");
		loginPage.clickToButtonByValue(driver, "Log in");
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("With valid data - Step 04: verify 'Log out' on header visible");
		verifyTrue(homePage.isLogoutLinkDisplayed());
		
		log.info("With valid data - Step 05: click to logout link and navigate to homepage");
		homePage.clickToLogoutLink();

	}

	@Test
	public void TC02_LoginWithEmptyData() {
		
		log.info("With empty data - Step 01: click to 'Log in' button at Login Page");
		loginPage.clickToButtonByValue(driver, "Log in");
		
		log.info("With empty data - Step 02: verify error message 'Email' textbox");
		verifyEquals(loginPage.getTextErrorMessageByValue(driver, "Email"), "Please enter your email");
		
	}
	
	@Test
	public void TC03_LoginWithInvalidEmail() {
		
		log.info("With invalid email - Step 01: input to Email textbox with value: johngacy123ru.com");
		loginPage.inputToTextBoxByID(driver, "Email", "johngacy123ru.com");
		
		log.info("With invalid email - Step 02: click to 'Log in' button at Login Page");
		loginPage.clickToButtonByValue(driver, "Log in");
		
		log.info("With invalid email - Step 03: verify error message 'Email' textbox");
		verifyEquals(loginPage.getTextErrorMessageByValue(driver, "Email"), "Wrong email");
	}
	
	@Test
	public void TC04_LoginWithUnregisteredEmail() {
		
		log.info("With unregistered email - Step 01: input to Email textbox with value: ada@coce.com");
		loginPage.inputToTextBoxByID(driver, "Email", "ada@coce.com");
		
		log.info("With unregistered email - Step 02: input to Password textbox with value: " + password);
		loginPage.inputToTextBoxByID(driver, "Password", password);
		
		log.info("With unregistered email - Step 03: click to 'Log in' button at Login Page");
		loginPage.clickToButtonByValue(driver, "Log in");
		
		log.info("With unregistered email - Step 14: verify summary error message 'Email' textbox");
		verifyEquals(loginPage.getSummaryErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void TC05_LoginWithEmptyPassword() {
		
		log.info("With unregistered email - Step 01: input to Email textbox with value: " + Common_01_Register.email);
		loginPage.inputToTextBoxByID(driver, "Email", Common_01_Register.email);
		
		log.info("With unregistered email - Step 02: input to Password textbox with value: " + "");
		loginPage.inputToTextBoxByID(driver, "Password", "");
		
		log.info("With unregistered email - Step 03: click to 'Log in' button at Login Page");
		loginPage.clickToButtonByValue(driver, "Log in");
		
		log.info("With unregistered email - Step 04: verify summary error message 'password' textbox");
		verifyEquals(loginPage.getSummaryErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void TC06_RegisterWithIncorrectPassword() {
		
		log.info("With unregistered email - Step 01: input to Email textbox with value: " + Common_01_Register.email);
		loginPage.inputToTextBoxByID(driver, "Email", Common_01_Register.email);
		
		log.info("With unregistered email - Step 02: input to Password textbox with value: " + "123");
		loginPage.inputToTextBoxByID(driver, "Password", "123");
		
		log.info("With unregistered email - Step 03: click to 'Log in' button at Login Page");
		loginPage.clickToButtonByValue(driver, "Log in");
		
		log.info("With unregistered email - Step 04: verify summary error message 'password' textbox");
		verifyEquals(loginPage.getSummaryErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}


}
