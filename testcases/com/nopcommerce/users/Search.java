package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
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

public class Search extends AbstractTest {
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
		
//		log.info("Precondition - Step 01: Open homepage");
//		homePage = PageGeneratorManager.getUserHomePage(driver);
//		
//		log.info("Precondition - Step 02: click register link at hompage");
//		loginPage = homePage.clickToLoginLink();
//
//		log.info("Precondition - Step 03: input to Email textbox with value: " + Common_01_Register.email);
//		loginPage.inputToTextBoxByID(driver, "Email", Common_01_Register.email);
//		
//		log.info("Precondition - Step 04: input to Password textbox with value: " + password);
//		loginPage.inputToTextBoxByID(driver, "Password", password);
//		
//		log.info("Precondition - Step 05: click to 'Login' button at Login Page");
//		loginPage.clickToButtonByValue(driver, "Log in");		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Precondition - Step 06: Open search page");
		homePage.clickToSearchLink();
		searchPage = PageGeneratorManager.getUserSearchPage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() {

	}
	
	@Test
	public void TC01_SearchWithEmptyData() {
		
		log.info("Search With Empty Data - Step 01: click Search button");
		searchPage.clickToSearchButton();
		
		log.info("Search With Empty Data - Step 02: verify Search warning");
		verifyEquals(searchPage.getSearchWarningText(), "Search term minimum length is 3 characters");
	}
	
	@Test
	public void TC02_SearchWithDataNotExist() {
		
		log.info("Search With Data Not Exist - Step 01: input to Search textbox with value: " + "Macbook Pro 2050");
		searchPage.inputToSearchTextbox("Macbook Pro 2050");
		
		log.info("Search With Data Not Exist - Step 02: click Search button");
		searchPage.clickToSearchButton();
		
		log.info("Search With Data Not Exist - Step 03: verify Search warning");
		verifyEquals(searchPage.getSearchWarningText(), "No products were found that matched your criteria.");
	}

	@Test
	public void TC03_SearchWithProductName() {
		
		log.info("Search With Product Name - Step 01: input to Search textbox with value: " + "Lenovo");
		searchPage.inputToSearchTextbox("Lenovo");
		
		log.info("Search With Product Name - Step 02: click Search button");
		searchPage.clickToSearchButton();
		
		log.info("Search With Product Name - Step 03: verify there is only 2 products");
		verifyEquals(searchPage.getNumberOfProduct(), 2);
		
		log.info("Search With Product Name - Step 04: input to Search textbox with value: " + "thinkpad x1 carbon");
		searchPage.inputToSearchTextbox("thinkpad x1 carbon");
		
		log.info("Search With Product Name - Step 05: click Search button");
		searchPage.clickToSearchButton();
		
		log.info("Search With Product Name - Step 06: verify there is only 1 products");
		verifyEquals(searchPage.getNumberOfProduct(), 1);
		
	}
	
	@Test
	public void TC04_AdvancedSearchWithParentCategories() {
		
		log.info("Advanced Search With Parent Categories - Step 01: input to Search textbox with value: " + "apple macbook pro");
		searchPage.inputToSearchTextbox("apple macbook pro");
		
		log.info("Advanced Search With Parent Categories - Step 02: check to checkbox 'Advanced Search'");
		searchPage.checkToAdvancedSearch();
		
		log.info("Advanced Search With Parent Categories - Step 03: select 'Computers' in 'Category' dropdown");
		searchPage.selectDropdownByName(driver, "cid", "Computers");
		
		log.info("Advanced Search With Parent Categories - Step 04: click Search button");
		searchPage.clickToSearchButton();
		
		log.info("Advanced Search With Parent Categories - Step 05: verify Search warning");
		verifyEquals(searchPage.getSearchWarningText(), "No products were found that matched your criteria.");
	}
	
	@Test
	public void TC05_AdvancedSearchWithSubCategories() {
		
		log.info("Advanced Search With Sub Categories - Step 01: input to Search textbox with value: " + "apple macbook pro");
		searchPage.inputToSearchTextbox("apple macbook pro");
		
		log.info("Advanced Search With Sub Categories - Step 02: check to checkbox 'Advanced Search'");
		searchPage.checkToAdvancedSearch();
		
		log.info("Advanced Search With Sub Categories - Step 03: select 'Computers' in 'Category' dropdown");
		searchPage.selectDropdownByName(driver, "cid", "Computers");
		
		log.info("Advanced Search With Sub Categories - Step 04: check to checkbox 'Advanced Search'");
		searchPage.checkToSubCategoriesSearch();
		
		log.info("Advanced Search With Sub Categories - Step 05: click Search button");
		searchPage.clickToSearchButton();
		
		log.info("Advanced Search With Sub Categories - Step 06: verify there is only 1 products");
		verifyEquals(searchPage.getNumberOfProduct(), 1);
	}
	
	
	@Test
	public void TC06_AdvancedSearchWithIncorrectManufacturer() {
		
		log.info("Advanced Search With Incorrect Manufacturer - Step 01: input to Search textbox with value: " + "apple macbook pro");
		searchPage.inputToSearchTextbox("apple macbook pro");
		
		log.info("Advanced Search With Incorrect Manufacturer - Step 02: check to checkbox 'Advanced Search'");
		searchPage.checkToAdvancedSearch();
		
		log.info("Advanced Search With Incorrect Manufacturer - Step 03: select 'Computers' in 'Category' dropdown");
		searchPage.selectDropdownByName(driver, "cid", "Computers");
		
		log.info("Advanced Search With Incorrect Manufacturer - Step 04: check to checkbox 'Advanced Search'");
		searchPage.checkToSubCategoriesSearch();
		
		log.info("Advanced Search With Incorrect Manufacturer - Step 05: select 'Computers' in 'Category' dropdown");
		searchPage.selectDropdownByName(driver, "mid", "HP");
		
		log.info("Advanced Search With Incorrect Manufacturer - Step 06: click Search button");
		searchPage.clickToSearchButton();
		
		log.info("Advanced Search With Incorrect Manufacturer - Step 07: verify Search warning"); 
		verifyEquals(searchPage.getSearchWarningText(), "No products were found that matched your criteria.");
	}
	
	@Test
	public void TC07_AdvancedSearchWithCorrectManufacturer() {
		
		log.info("Advanced Search With Correct Manufacturer - Step 01: input to Search textbox with value: " + "apple macbook pro");
		searchPage.inputToSearchTextbox("apple macbook pro");
		
		log.info("Advanced Search With Correct Manufacturer - Step 02: check to checkbox 'Advanced Search'");
		searchPage.checkToAdvancedSearch();
		
		log.info("Advanced Search With Correct Manufacturer - Step 03: select 'Computers' in 'Category' dropdown");
		searchPage.selectDropdownByName(driver, "cid", "Computers");
		
		log.info("Advanced Search With Correct Manufacturer - Step 04: check to checkbox 'Advanced Search'");
		searchPage.checkToSubCategoriesSearch();
		
		log.info("Advanced Search With Correct Manufacturer - Step 05: select 'Computers' in 'Category' dropdown");
		searchPage.selectDropdownByName(driver, "mid", "Apple");
		
		log.info("Advanced Search With Correct Manufacturer - Step 06: click Search button");
		searchPage.clickToSearchButton();
		
		log.info("Advanced Search With Correct Manufacturer - Step 07: verify there is only 1 products"); 
		verifyEquals(searchPage.getNumberOfProduct(), 1);
	}
	
	@Test
	public void TC08_AdvancedSearchInPriceRange() {
		
		log.info("Advanced Search In Price Range - Step 01: input to Search textbox with value: " + "apple macbook pro");
		searchPage.inputToSearchTextbox("apple macbook pro");
		
		log.info("Advanced Search In Price Range - Step 02: check to checkbox 'Advanced Search'");
		searchPage.checkToAdvancedSearch();
		
		log.info("Advanced Search In Price Range - Step 03: select 'Computers' in 'Category' dropdown");
		searchPage.selectDropdownByName(driver, "cid", "Computers");
		
		log.info("Advanced Search In Price Range - Step 04: check to checkbox 'Advanced Search'");
		searchPage.checkToSubCategoriesSearch();
		
		log.info("Advanced Search In Price Range - Step 05: select 'Computers' in 'Category' dropdown");
		searchPage.selectDropdownByName(driver, "mid", "Apple");
		
		log.info("Advanced Search In Price Range - Step 06: select price range 1000-2000");
		searchPage.selectPriceRangeFrom("1000");
		searchPage.selectPriceRangeTo("2000");
		
		log.info("Advanced Search In Price Range - Step 07: click Search button");
		searchPage.clickToSearchButton();
		
		log.info("Advanced Search In Price Range - Step 08: verify there is only 1 products"); 
		verifyEquals(searchPage.getNumberOfProduct(), 1);
	}
	
	@Test
	public void TC09_AdvancedSearchNotInPriceRange() {
		
		log.info("Advanced Search Not In Price Range - Step 01: input to Search textbox with value: " + "apple macbook pro");
		searchPage.inputToSearchTextbox("apple macbook pro");
		
		log.info("Advanced Search Not In Price Range - Step 02: check to checkbox 'Advanced Search'");
		searchPage.checkToAdvancedSearch();
		
		log.info("Advanced Search Not In Price Range - Step 03: select 'Computers' in 'Category' dropdown");
		searchPage.selectDropdownByName(driver, "cid", "Computers");
		
		log.info("Advanced Search Not In Price Range - Step 04: check to checkbox 'Advanced Search'");
		searchPage.checkToSubCategoriesSearch();
		
		log.info("Advanced Search Not In Price Range - Step 05: select 'Computers' in 'Category' dropdown");
		searchPage.selectDropdownByName(driver, "mid", "Apple");
		
		log.info("Advanced Search Not In Price Range - Step 06: select price range 1000-1700");
		searchPage.selectPriceRangeFrom("1000");
		searchPage.selectPriceRangeTo("1700");
		
		log.info("Advanced Search Not In Price Range - Step 07: click Search button");
		searchPage.clickToSearchButton();
		
		log.info("Advanced Search Not In Price Range - Step 08: verify search warning"); 
		verifyEquals(searchPage.getSearchWarningText(), "No products were found that matched your criteria.");
		
		log.info("Advanced Search Not In Price Range - Step 09: select price range 1900-5000");
		searchPage.selectPriceRangeFrom("1900");
		searchPage.selectPriceRangeTo("5000");
		
		log.info("Advanced Search Not In Price Range - Step 10: click Search button");
		searchPage.clickToSearchButton();
		
		log.info("Advanced Search Not In Price Range - Step 11: verify search warning"); 
		verifyEquals(searchPage.getSearchWarningText(), "No products were found that matched your criteria.");
		
		
	}
	
	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}


}
