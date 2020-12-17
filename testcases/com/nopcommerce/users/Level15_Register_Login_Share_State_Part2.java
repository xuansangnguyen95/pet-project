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

import com.nopcommerce.common.Common_01_Register;

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

public class Level15_Register_Login_Share_State_Part2 extends AbstractTest {
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
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Login - Step 01: open login page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: input to Email textbox with value: " + Common_01_Register.email);
		loginPage.inputToEmailTextbox(Common_01_Register.email);
		
		log.info("Login - Step 03: input to Password textbox with value: " + Common_01_Register.password);
		loginPage.inputToPasswordTextbox(Common_01_Register.password);
		
		log.info("Login - Step 04: click to Login button at Login page");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login - Step 05: verify My Account link displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());		
	}

	@Test
	public void TC01_Sort_Product_With_Price() {
		
	}
	
	@Test
	public void TC02_Sort_Product_With_Name() {
	}
	

	@AfterClass
	public void afterClass() {
		sleepInMilisecond(1000);
		driver.quit();
	}


}
