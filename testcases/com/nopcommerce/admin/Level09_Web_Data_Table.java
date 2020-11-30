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

public class Level09_Web_Data_Table extends AbstractTest {
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
	public void TC01_Paging() {
		productPage.goToPageAtTableByIndex("2");
		Assert.assertTrue(productPage.isPageActiveAtTableByIndex("2"));
		
		productPage.goToPageAtTableByIndex("1");
		Assert.assertTrue(productPage.isPageActiveAtTableByIndex("1"));

		productPage.goToPageAtTableByIndex("3");
		Assert.assertTrue(productPage.isPageActiveAtTableByIndex("3"));

		productPage.goToPageAtTableByIndex("2");
		Assert.assertTrue(productPage.isPageActiveAtTableByIndex("2"));
		
		productPage.goToPageAtTableByIndex("1");
		Assert.assertTrue(productPage.isPageActiveAtTableByIndex("1"));

	}
	
	@Test
	public void TC02_Select_Deselect_All() {
		//productPage.waitAjaxLoadingInvisible();
		
		productPage.checkToSelectAllCheckbox();
		productPage.allProductCheckboxesChecked();
		
		productPage.checkToDeselectAllCheckbox();
		productPage.allProductCheckboxesUnchecked();
		
		productPage.checkToProductCheckboxByName("$100 Physical Gift Card");
	}
	
	@Test
	public void TC03_Displayed() {
		Assert.assertTrue(productPage.areProductDetailDisplayed("Adobe Photoshop CS4", "AD_CS4_PH", "75", "10000", "Simple", "true"));
		Assert.assertTrue(productPage.areProductDetailDisplayed("Asus N551JK-XO076H Laptop", "AS_551_LP", "1500", "10000", "Simple", "true"));
		
		productPage.selectShowItemDropdown("50");
		Assert.assertTrue(productPage.isInformationDisplayedAtColumnNameAndRowNumber("Product name", "2", "$25 Virtual Gift Card"));
		Assert.assertTrue(productPage.isInformationDisplayedAtColumnNameAndRowNumber("Stock quantity", "1", ""));
		
		
		Assert.assertTrue(productPage.isPublishStatusAtColumnNameAndRowNumber("Published", "3", "true"));
	}
	
	@Test
	public void TC04_Edit() {
		productPage.clickToEditProductDetail("$25 Virtual Gift Card");
		productPage.backToPage(driver);
		
		productPage.clickToEditProductDetail("$50 Physical Gift Card");
		productPage.backToPage(driver);
	}
	
	@AfterClass
	public void afterClass() {
		sleepInMilisecond(1000);
		driver.quit();
	}


}
