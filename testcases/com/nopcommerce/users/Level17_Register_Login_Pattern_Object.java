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

public class Level17_Register_Login_Pattern_Object extends AbstractTest {
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
		driver = getBrowserDriver(browserName);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
		
		firstName = "john";
		lastName = "gacy";
		email = "johngacy" + getRandomNumber() + "@gmail.com";
		companyName = "gacy";
		password = "johngacy";
		date = "21";
		month = "August";
		year = "1999";
		
	
		 
	}

	@Test
	public void TC01_Register() {
		log.info("Register - Step 01: Open homepage");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Register - Step 04: click register link at hompage");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Step 05: click to gender male radio button");
		registerPage.clickToRadioButtonByID(driver, "gender-male");
		
		log.info("Register - Step 06: input to Firstname textbox with value: " + firstName);
		registerPage.inputToTextBoxByID(driver, "FirstName", firstName);
		
		log.info("Register - Step 07: input to Lastname textbox with value: " + lastName);
		registerPage.inputToTextBoxByID(driver, "LastName", lastName);
		
		log.info("Register - Step 08: select date dropdown with value: " + date);
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", date);
		
		log.info("Register - Step 09: select month dropdown with value: " + month);
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
		
		log.info("Register - Step 10: select year dropdown with value: " + year);
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);
		
		log.info("Register - Step 11: input to Email textbox with value: " + email);
		registerPage.inputToTextBoxByID(driver, "Email", email);
		
		log.info("Register - Step 12: input to CompanyName textbox");
		registerPage.inputToTextBoxByID(driver, "Company", companyName);
		
		log.info("Register - Step 13: input to Password textbox with value: " + password);
		registerPage.inputToTextBoxByID(driver, "Password", password);
		registerPage.inputToTextBoxByID(driver, "ConfirmPassword", password);
		
		log.info("Register - Step 14: click to Register button at Register page");
		registerPage.clickToButtonByValue(driver, "Register");
		
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
		loginPage.inputToTextBoxByID(driver, "Email", email);
		
		log.info("Login - Step 03: input to Password textbox with value: " + password);
		loginPage.inputToTextBoxByID(driver, "Password", password);
		
		log.info("Login - Step 04: click to Login button at Login page");
		loginPage.clickToButtonByValue(driver, "Log in");
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
	}
	

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}


}
