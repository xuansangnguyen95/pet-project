package com.nopcommerce.admin;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.GlobalConstants;
import pageObjects.AdminDashboardPageObject;
import pageObjects.AdminLoginPageObject;
import pageObjects.AdminProductDetailPageObject;
import pageObjects.AdminProductPageObject;
import pageObjects.PageGeneratorManager;

public class AdminSearchProduct extends AbstractTest {
	WebDriver driver;
	AdminLoginPageObject loginPage;
	AdminDashboardPageObject dashboardPage;
	AdminProductPageObject productPage;
	AdminProductDetailPageObject productDetailPage;
	
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
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("Precondition - Step 01: navigate to Admin page");
		driver = getBrowserDriver(browserName, GlobalConstants.DEMO_ADMIN_PAGE);
		loginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		log.info("Precondition - Step 02: login to Admin page");
		dashboardPage = loginPage.loginToSystem("admin@yourstore.com", "admin");
		
		log.info("Precondition - Step 03: navigate to Catalog/Products");
		productPage = dashboardPage.openProductPage();
	}

	@Test
	public void TC01_SearchWithProductName01() {
		
		log.info("Search With Product Name 01 - Step 01: input to 'Product Name' textbox with value: Lenovo IdeaCentre 600 All-in-One PC" );
		productPage.inputToTextBoxByID(driver, "SearchProductName", "Lenovo IdeaCentre 600 All-in-One PC");
		
		log.info("Search With Product Name 01 - Step 02: click Search button" );
		productPage.clickToButtonByID(driver, "search-products");
		
		log.info("Search With Product Name 01 - Step 03: verify only 1 product displayed");
		verifyEquals(productPage.getNumberOfProduct(), "1-1 of 1 items");
		verifyTrue(productPage.areProductDetailDisplayed("Lenovo IdeaCentre 600 All-in-One PC", "LE_IC_600", "500", "10000", "Simple", "true"));
	}
	
	@Test
	public void TC02_SearchWithProductName02() {
		
		log.info("Search With Product Name 02 - Step 01: input to 'Product Name' textbox with value: Lenovo IdeaCentre 600 All-in-One PC" );
		productPage.inputToTextBoxByID(driver, "SearchProductName", "Lenovo IdeaCentre 600 All-in-One PC");
		
		log.info("Search With Product Name 02 - Step 02: click 'Category' and choose 'Computers'");
		productPage.selectDropdownByName(driver, "SearchCategoryId", "Computers");
		
		log.info("Search With Product Name 02 - Step 03: check to checkbox 'Search subcategories'");
		productPage.clickToUncheckboxByID(driver, "SearchIncludeSubCategories");
		
		log.info("Search With Product Name 02 - Step 04: click Search button" );
		productPage.clickToButtonByID(driver, "search-products");
		
		log.info("Search With Product Name 02 - Step 05: verify 0 product displayed");
		verifyEquals(productPage.getNumberOfProduct(), "No records");
	}
	
	@Test
	public void TC03_SearchWithProductName03() {
		
		log.info("Search With Product Name 03 - Step 01: input to 'Product Name' textbox with value: Lenovo IdeaCentre 600 All-in-One PC" );
		productPage.inputToTextBoxByID(driver, "SearchProductName", "Lenovo IdeaCentre 600 All-in-One PC");
		
		log.info("Search With Product Name 03 - Step 02: click 'Category' and choose 'Computers'");
		productPage.selectDropdownByName(driver, "SearchCategoryId", "Computers");
		
		log.info("Search With Product Name 03 - Step 03: check to checkbox 'Search subcategories'");
		productPage.clickToCheckboxByID(driver, "SearchIncludeSubCategories");
		
		log.info("Search With Product Name 03 - Step 04: click Search button" );
		productPage.clickToButtonByID(driver, "search-products");
		
		log.info("Search With Product Name 03 - Step 03: verify only 1 product displayed");
		verifyEquals(productPage.getNumberOfProduct(), "1-1 of 1 items");
		verifyTrue(productPage.areProductDetailDisplayed("Lenovo IdeaCentre 600 All-in-One PC", "LE_IC_600", "500", "10000", "Simple", "true"));
	}
	
	
	@Test
	public void TC04_SearchWithProductName04() {
		
		log.info("Search With Product Name 04 - Step 01: input to 'Product Name' textbox with value: Lenovo IdeaCentre 600 All-in-One PC" );
		productPage.inputToTextBoxByID(driver, "SearchProductName", "Lenovo IdeaCentre 600 All-in-One PC");
		
		log.info("Search With Product Name 04 - Step 02: click 'Category' and choose 'Computers >> Desktops'");
		productPage.selectDropdownByName(driver, "SearchCategoryId", "Computers >> Desktops");
		
		log.info("Search With Product Name 04 - Step 03: check to checkbox 'Search subcategories'");
		productPage.clickToUncheckboxByID(driver, "SearchIncludeSubCategories");
		
		log.info("Search With Product Name 04 - Step 04: click Search button" );
		productPage.clickToButtonByID(driver, "search-products");
		
		log.info("Search With Product Name 04 - Step 03: verify only 1 product displayed");
		verifyEquals(productPage.getNumberOfProduct(), "1-1 of 1 items");
		verifyTrue(productPage.areProductDetailDisplayed("Lenovo IdeaCentre 600 All-in-One PC", "LE_IC_600", "500", "10000", "Simple", "true"));
	}
	
	@Test
	public void TC05_SearchWithProductName05() {
		
		log.info("Search With Product Name 05 - Step 01: input to 'Product Name' textbox with value: Lenovo IdeaCentre 600 All-in-One PC" );
		productPage.inputToTextBoxByID(driver, "SearchProductName", "Lenovo IdeaCentre 600 All-in-One PC");
		
		log.info("Search With Product Name 05 - Step 02: click 'Category' and choose 'All'");
		productPage.selectDropdownByName(driver, "SearchCategoryId", "All");
		
		log.info("Search With Product Name 05 - Step 03: check to checkbox 'Search subcategories'");
		productPage.clickToUncheckboxByID(driver, "SearchIncludeSubCategories");
		
		log.info("Search With Product Name 05 - Step 04: click 'Manufacturer' and choose 'Apple'");
		productPage.selectDropdownByName(driver, "SearchManufacturerId", "Apple");
		
		log.info("Search With Product Name 05 - Step 05: click Search button" );
		productPage.clickToButtonByID(driver, "search-products");
		
		log.info("Search With Product Name 05 - Step 06: verify 0 product displayed");
		verifyEquals(productPage.getNumberOfProduct(), "No records");
	}
	
	@Test
	public void TC06_GoDirectlyToProductSKU() {
		
		log.info("Go Directly To Product SKU - Step 01: input to 'Go directly to product SKU' textbox with value: LE_IC_600" );
		productPage.inputToTextBoxByID(driver, "GoDirectlyToSku", "LE_IC_600");
		
		log.info("Go Directly To Product SKU - Step 02: click button 'Go'" );
		productPage.clickToButtonByID(driver, "go-to-product-by-sku");
		productDetailPage = PageGeneratorManager.getAdminProductDetailPage(driver);
		
		log.info("Go Directly To Product SKU - Step 03: verify this is a product detail page" );
		verifyTrue(productDetailPage.doesPageTitleContainEditProductDetail());
	}
	
	
	
	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}


}
