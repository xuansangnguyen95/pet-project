package com.nopcommerce.admin;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.AdminDashboardPageObject;
import pageObjects.AdminLoginPageObject;
import pageObjects.AdminProductPageObject;
import pageObjects.PageGeneratorManager;

public class Level10_Upload_file extends AbstractTest {
	WebDriver driver;
	AdminLoginPageObject loginPage;
	AdminDashboardPageObject dashboardPage;
	AdminProductPageObject productPage;
	
	@Parameters(value = {"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		
		loginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		dashboardPage = loginPage.loginToSystem("admin@yourstore.com", "admin");
		
		productPage = dashboardPage.openProductPage();
		
	}

	@Test
	public void TC01_Upload() {

	}
	
	
	@AfterClass
	public void afterClass() {
		sleepInMilisecond(1000);
		driver.quit();
	}


}
