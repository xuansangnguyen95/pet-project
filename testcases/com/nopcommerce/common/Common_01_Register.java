package com.nopcommerce.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
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

public class Common_01_Register extends AbstractTest {
	WebDriver driver;
	String source_folder = System.getProperty("user.dir");
	Select select;
	String firstName, lastName, companyName;
	public static String email, password;
	
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	UserCustomerInforPageObject customerInforPage;
	UserSearchPageObject searchPage;
	UserShippingAndReturnPageObject shippingAndReturnPage;
	UserSitemapPageObject sitemapPage;
	UserWishListPageObject wishList;

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
		
		firstName = "john";
		lastName = "gacy";
		email = "johngacy" + getRandomNumber() + "@gmail.com";
		companyName = "gacy";
		password = "johngacy";
		
		log.info("PreCondition - Step 01: Open homepage");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("PreCondition - Step 02: Verify register link displayed");
		verifyFalse(homePage.isRegisterLinkDisplayed());
		
		log.info("PreCondition - Step 03: Verify login link displayed");
		verifyFalse(homePage.isLoginLinkDisplayed());
		
		log.info("PreCondition - Step 04: click register link at hompage");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("PreCondition - Step 05: click to gender male radio button");
		registerPage.clickToGenderMaleRadioButton();
		
		log.info("PreCondition - Step 06: input to Firstname textbox with value: " + firstName);
		registerPage.inputToFirstNameTextbox(firstName);
		
		log.info("PreCondition - Step 07: input to Lastname textbox with value: " + lastName);
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("PreCondition - Step 08: select date dropdown");
		registerPage.selectDayDropdown("10");
		
		log.info("PreCondition - Step 09: select month dropdown");
		registerPage.selectMonthDropdown("August");
		
		log.info("PreCondition - Step 10: select year dropdown");
		registerPage.selectYearDropdown("1999");
		
		log.info("PreCondition - Step 11: input to Email textbox with value: " + email);
		registerPage.inputToEmailTextbox(email);
		
		log.info("PreCondition - Step 12: input to CompanyName textbox");
		registerPage.inputToCompanyTextbox(companyName);
		
		log.info("PreCondition - Step 13: input to Password textbox with value: " + password);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("PreCondition - Step 14: click to Register button at Register page");
		registerPage.clickToRegisterButton();
		
		log.info("PreCondition - Step 15: verify success message displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		 
		sleepInMilisecond(1000);
		driver.quit();
	}

	@Test
	public void TC01_Search_Product_With_Name() {
		
	}
	
	@Test
	public void TC02_Search_Product_With_Category() {
	}
	

	@AfterTest
	public void afterClass() {
	
	}


}
