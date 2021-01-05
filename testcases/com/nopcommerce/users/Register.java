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

public class Register extends AbstractTest {
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
		email = "johngacy" + getRandomNumber() + "@gmail.com";
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
		registerPage = homePage.clickToRegisterLink();
	}
	
	@Test
	public void TC01_RegisterWithValidData() {

		log.info("With valid data - Step 01: click to gender male radio button");
		registerPage.clickToRadioButtonByID(driver, "gender-male");
		
		log.info("With valid data - Step 02: input to Firstname textbox with value: " + firstName);
		registerPage.inputToTextBoxByID(driver, "FirstName", firstName);
		
		log.info("With valid data - Step 03: input to Lastname textbox with value: " + lastName);
		registerPage.inputToTextBoxByID(driver, "LastName", lastName);
		
		log.info("With valid data - Step 04: select date dropdown with value: " + date);
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", date);
		
		log.info("With valid data - Step 05: select month dropdown with value: " + month);
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
		
		log.info("With valid data - Step 06: select year dropdown with value: " + year);
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);
		
		log.info("With valid data - Step 07: input to Email textbox with value: " + email);
		registerPage.inputToTextBoxByID(driver, "Email", email);
		
		log.info("With valid data - Step 08: input to CompanyName textbox");
		registerPage.inputToTextBoxByID(driver, "Company", companyName);
		
		log.info("With valid data - Step 09: input to Password textbox with value: " + password);
		registerPage.inputToTextBoxByID(driver, "Password", password);
		registerPage.inputToTextBoxByID(driver, "ConfirmPassword", password);
		
		log.info("With valid data - Step 10: click to Register button at Register page");
		registerPage.clickToButtonByValue(driver, "Register");
		
		log.info("With valid data - Step 11: verify success message displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("With valid data - Step 12: click to logout link and navigate to homepage");
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void TC02_RegisterWithEmptyData() {
		
		log.info("With empty data - Step 01: click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("With empty data - Step 02: verify error message 'Firstname' textbox");
		verifyEquals(registerPage.getTextErrorMessageByValue(driver, "FirstName"), "First name is required.");
		
		log.info("With empty data - Step 03: verify error message 'Lastname' textbox");
		verifyEquals(registerPage.getTextErrorMessageByValue(driver, "LastName"), "Last name is required.");
		
		log.info("With empty data - Step 04: verify error message 'Email' textbox");
		verifyEquals(registerPage.getTextErrorMessageByValue(driver, "Email"), "Email is required.");
		
		log.info("With empty data - Step 05: verify error message 'Password' textbox");
		verifyEquals(registerPage.getTextErrorMessageByValue(driver, "Password"), "Password is required.");
		
		log.info("With empty data - Step 06: verify error message 'Confirm Password' textbox");
		verifyEquals(registerPage.getTextErrorMessageByValue(driver, "ConfirmPassword"), "Password is required.");
	}
	
	@Test
	public void TC03_RegisterWithInvalidEmail() {
		
		log.info("With invalid email - Step 01: click to gender male radio button");
		registerPage.clickToRadioButtonByID(driver, "gender-male");
		
		log.info("With invalid email - Step 02: input to Firstname textbox with value: " + firstName);
		registerPage.inputToTextBoxByID(driver, "FirstName", firstName);
		
		log.info("With invalid email - Step 03: input to Lastname textbox with value: " + lastName);
		registerPage.inputToTextBoxByID(driver, "LastName", lastName);
		
		log.info("With invalid email - Step 04: select date dropdown with value: " + date);
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", date);
		
		log.info("With invalid email - Step 05: select month dropdown with value: " + month);
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
		
		log.info("With invalid email - Step 06: select year dropdown with value: " + year);
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);
		
		log.info("With invalid email - Step 07: input to Email textbox with value: johngacy123ru.com");
		registerPage.inputToTextBoxByID(driver, "Email", "johngacy123ru.com");
		
		log.info("With invalid email - Step 08: input to CompanyName textbox");
		registerPage.inputToTextBoxByID(driver, "Company", companyName);
		
		log.info("With invalid email - Step 09: input to Password textbox with value: " + password);
		registerPage.inputToTextBoxByID(driver, "Password", password);
		registerPage.inputToTextBoxByID(driver, "ConfirmPassword", password);
		
		log.info("With invalid email - Step 10: click to Register button at Register page");
		registerPage.clickToButtonByValue(driver, "Register");
		
		log.info("With invalid email - Step 11: verify error message 'Email' textbox");
		verifyEquals(registerPage.getTextErrorMessageByValue(driver, "Email"), "Wrong email");
	}
	
	@Test
	public void TC04_RegisterWithExistedEmail() {
		
		log.info("With existed email - Step 01: click to gender male radio button");
		registerPage.clickToRadioButtonByID(driver, "gender-male");
		
		log.info("With existed email - Step 02: input to Firstname textbox with value: " + firstName);
		registerPage.inputToTextBoxByID(driver, "FirstName", firstName);
		
		log.info("With existed email - Step 03: input to Lastname textbox with value: " + lastName);
		registerPage.inputToTextBoxByID(driver, "LastName", lastName);
		
		log.info("With existed email - Step 04: select date dropdown with value: " + date);
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", date);
		
		log.info("With existed email - Step 05: select month dropdown with value: " + month);
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
		
		log.info("With existed email - Step 06: select year dropdown with value: " + year);
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);
		
		log.info("With existed email - Step 07: input to Email textbox with value: " + email);
		registerPage.inputToTextBoxByID(driver, "Email", email);
		
		log.info("With existed email - Step 08: input to CompanyName textbox");
		registerPage.inputToTextBoxByID(driver, "Company", companyName);
		
		log.info("With existed email - Step 09: input to Password textbox with value: " + password);
		registerPage.inputToTextBoxByID(driver, "Password", password);
		registerPage.inputToTextBoxByID(driver, "ConfirmPassword", password);
		
		log.info("With existed email - Step 10: click to Register button at Register page");
		registerPage.clickToButtonByValue(driver, "Register");
		
		log.info("With existed email - Step 11: verify error message 'Email' textbox");
		verifyEquals(registerPage.getSummaryErrorMessage(), "The specified email already exists");
	}

	@Test
	public void TC05_RegisterWithInvalidPassword() {
		
		log.info("With invalid Password - Step 01: click to gender male radio button");
		registerPage.clickToRadioButtonByID(driver, "gender-male");
		
		log.info("With invalid Password - Step 02: input to Firstname textbox with value: " + firstName);
		registerPage.inputToTextBoxByID(driver, "FirstName", firstName);
		
		log.info("With invalid Password - Step 03: input to Lastname textbox with value: " + lastName);
		registerPage.inputToTextBoxByID(driver, "LastName", lastName);
		
		log.info("With invalid Password - Step 04: select date dropdown with value: " + date);
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", date);
		
		log.info("With invalid Password - Step 05: select month dropdown with value: " + month);
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
		
		log.info("With invalid Password - Step 06: select year dropdown with value: " + year);
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);
		
		log.info("With invalid Password - Step 07: input to Email textbox with value: " + email);
		registerPage.inputToTextBoxByID(driver, "Email", email);
		
		log.info("With invalid Password - Step 08: input to CompanyName textbox");
		registerPage.inputToTextBoxByID(driver, "Company", companyName);
		
		log.info("With invalid Password - Step 09: input to Password textbox with value: 123" );
		registerPage.inputToTextBoxByID(driver, "Password", "123");
		registerPage.inputToTextBoxByID(driver, "ConfirmPassword", "123");
		
		log.info("With invalid Password - Step 10: click to Register button at Register page");
		registerPage.clickToButtonByValue(driver, "Register");
		
		log.info("With invalid Password - Step 11: verify error message 'Password' textbox");
		verifyEquals(registerPage.getTextErrorMessageByValue(driver, "Password"), "Password must meet the following rules:\nmust have at least 6 characters");
	}
	
	@Test
	public void TC06_RegisterWithIncorrectConfirmPassword() {
		
		log.info("With incorrect Confirm Password - Step 01: click to gender male radio button");
		registerPage.clickToRadioButtonByID(driver, "gender-male");
		
		log.info("With incorrect Confirm Password - Step 02: input to Firstname textbox with value: " + firstName);
		registerPage.inputToTextBoxByID(driver, "FirstName", firstName);
		
		log.info("With incorrect Confirm Password - Step 03: input to Lastname textbox with value: " + lastName);
		registerPage.inputToTextBoxByID(driver, "LastName", lastName);
		
		log.info("With incorrect Confirm Password - Step 04: select date dropdown with value: " + date);
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", date);
		
		log.info("With incorrect Confirm Password - Step 05: select month dropdown with value: " + month);
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
		
		log.info("With incorrect Confirm Password - Step 06: select year dropdown with value: " + year);
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);
		
		log.info("With incorrect Confirm Password - Step 07: input to Email textbox with value: " + email);
		registerPage.inputToTextBoxByID(driver, "Email", email);
		
		log.info("With incorrect Confirm Password - Step 08: input to CompanyName textbox");
		registerPage.inputToTextBoxByID(driver, "Company", companyName);
		
		log.info("With incorrect Confirm Password - Step 09: input to Password textbox with value: " + password);
		registerPage.inputToTextBoxByID(driver, "Password", password);
		registerPage.inputToTextBoxByID(driver, "ConfirmPassword", "123");
		
		log.info("With incorrect Confirm Password - Step 10: click to Register button at Register page");
		registerPage.clickToButtonByValue(driver, "Register");
		
		log.info("With incorrect Confirm Password - Step 11: verify error message 'Confirm Password' textbox");
		verifyEquals(registerPage.getTextErrorMessageByValue(driver, "ConfirmPassword"), "The password and confirmation password do not match.");
	}
	
	

	

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}


}
