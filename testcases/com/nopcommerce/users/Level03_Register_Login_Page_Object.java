package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;
import pageObjects.UserCustomerInforPageObject;
import pageObjects.UserHomePageObject;
import pageObjects.UserLoginPageObject;
import pageObjects.UserRegisterPageObject;

public class Level03_Register_Login_Page_Object extends AbstractPage {
	WebDriver driver;
	String source_folder = System.getProperty("user.dir");
	Select select;
	String firstName, lastName, email, companyName, password;
	
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	UserCustomerInforPageObject customerInforPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
		
		firstName = "john";
		lastName = "gacy";
		email = "johngacy" + getRandomNumber() + "@gmail.com";
		companyName = "gacy";
		password = "johngacy";
		
		homePage = new UserHomePageObject(driver);
		 
	}
	

	@Test
	public void TC01_Register() {
		homePage.clickToRegisterLink();
		
		registerPage = new UserRegisterPageObject(driver);
		sleepInMilisecond(1);
		
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
		
		registerPage.clickToLogoutLink();
		
		//homePage = new HomePageObject(driver);
	}
	
	@Test
	public void TC02_Login() {
		sleepInMilisecond(1);
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
		
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		
		homePage = new UserHomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
		
	}
	
	@Test
	public void TC03_View_My_Account() {
		sleepInMilisecond(1);
		homePage.clickToMyAccountLink();
		customerInforPage = new UserCustomerInforPageObject(driver);
		
		Assert.assertTrue(customerInforPage.isGenderMaleRadioButtonSelected());
		
		Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(), firstName);
		Assert.assertEquals(customerInforPage.getLastNameTextboxValue(), lastName);
		
		Assert.assertEquals(customerInforPage.getSelectedTextInDayDropdown(), "10");
		Assert.assertEquals(customerInforPage.getSelectedTextInMonthDropdown(), "August");
		Assert.assertEquals(customerInforPage.getSelectedTextInYearDropdown(), "1999");
		
		Assert.assertEquals(customerInforPage.getEmailTextboxValue(), email);
		Assert.assertEquals(customerInforPage.getCompanyTextboxValue(), companyName);
		
		
	}
		
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public int getRandomNumber() {
		Random temp = new Random();
		return temp.nextInt(999);
	}
	
}
