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
	
	String fileName = "1.JPG";
	String productName = "Apple iCam";
	String productSKU = "APPLE_CAM";
	String productPrice = "1300";
	String productQuantity = "10000";
	String productType = "Simple";
	String productPublishStatus = "true";
	
	String pictureName = productName.toLowerCase().replace(" ", "-");
	String pictureAlt = "Alt";
	String pictureTitle = "Title";
	String pictureOrder = "1";
	
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
		productPage.inputToProductNameTextbox(productName);
		
		productPage.clickToSearchButton();
		
		productPage.clickToEditProductDetail(productName);
		
		productPage.scrollToPicturePane();
		
		productPage.uploadFileByPanelID(driver, "product-pictures", fileName);
		
		Assert.assertTrue(productPage.isNewPictureUploadSuccess(fileName));
		productPage.inputToAltTextbox(pictureAlt);
		productPage.inputToTitleTextbox(pictureTitle);
		productPage.clickUpArrowInOrderTextbox(pictureOrder);
		
	    productPage.clickToAddProductPictureButton();
	    
	    Assert.assertTrue(productPage.areImageDetailsDisplayed(pictureName, pictureOrder, pictureAlt, pictureTitle));
	    
	    productPage.clickToSaveButton();
	    
		productPage.inputToProductNameTextbox(productName);
		
		productPage.clickToSearchButton();
		
		Assert.assertTrue(productPage.areProductDisplayed(pictureName, productName, productSKU, productPrice, productQuantity, productType, productPublishStatus));
		
		productPage.clickToEditProductDetail(productName);
		
		productPage.scrollToPicturePane();
		
		productPage.clickToDeleteButtonByPictureName(pictureTitle);
		
		productPage.clickToSaveButton();
		
		productPage.inputToProductNameTextbox(productName);
		
		productPage.clickToSearchButton();
		
		Assert.assertTrue(productPage.areProductDisplayed(pictureName, productName, productSKU, productPrice, productQuantity, productType, productPublishStatus));
		
	}
	
	
	@AfterClass
	public void afterClass() {
		sleepInMilisecond(1000);
		driver.quit();
	}


}
