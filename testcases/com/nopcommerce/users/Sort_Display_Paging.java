package com.nopcommerce.users;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.AbstractTest;
import commons.GlobalConstants;
import pageObjects.PageGeneratorManager;
import pageObjects.UserComputersPageObject;
import pageObjects.UserHomePageObject;

public class Sort_Display_Paging extends AbstractTest {
	WebDriver driver;
	String source_folder = System.getProperty("user.dir");

	UserHomePageObject homePage; 
	UserComputersPageObject computersPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.DEMO_USER_PAGE);
		
		log.info("Precondition - Step 01: click 'Computers' at homepage");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		homePage.clickToComputersOnHeading();
		computersPage = PageGeneratorManager.getUserComputersPage(driver);
		
		log.info("Precondition - Step 02: click sub menu 'Notebooks' at 'Computers' page");
		computersPage.clickToNotebooksSubmenu();
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
			
	}
	
	@Test
	public void TC01_VerifyProductNameSortAtoZ() {
		
		log.info("Verify Product Name Sort A to Z - Step 01: choose Sort by 'Name: A to Z'");
		computersPage.selectDropdownByName(driver, "products-orderby", "Name: A to Z");
		
		log.info("Verify Product Name Sort A to Z - Step 02: verify the order of product name");
		verifyTrue(computersPage.isProductNameSortedAscending());
	}
	
	@Test
	public void TC02_VerifyProductNameSortZtoA() {
		
		log.info("Verify Product Name Sort Z to A - Step 01: choose Sort by 'Name: Z to A'");
		computersPage.selectDropdownByName(driver, "products-orderby", "Name: Z to A");
		
		log.info("Verify Product Name Sort Z to A - Step 02: verify the order of product name");
		verifyTrue(computersPage.isProductNameSortedDescending());
	}
	
	@Test
	public void TC03_VerifyProductPriceSortLowToHigh() {
		
		log.info("Verify Product Price Sort Low To High - Step 01: choose Sort by 'Price: Low to High");
		computersPage.selectDropdownByName(driver, "products-orderby", "Price: Low to High");
		
		log.info("Verify Product Price Sort Low To High - Step 02: verify the order of product price");
		verifyTrue(computersPage.isProductPriceSortedAscending());
	}
	
	@Test
	public void TC04_VerifyProductPriceSortHighToLow() {
		
		log.info("Verify Product Price Sort High To Low - Step 01: choose Sort by 'Price: High To Low");
		computersPage.selectDropdownByName(driver, "products-orderby", "Price: High to Low");
		
		log.info("Verify Product Price Sort High To Low - Step 02: verify the order of product price");
		verifyTrue(computersPage.isProductPriceSortedDescending());
	}

	@Test
	public void TC05_Display3ProductsPerPage() {
		
		log.info("Display 3 Products Per Page - Step 01: choose Display 3 per page");
		computersPage.selectDropdownByName(driver, "products-pagesize", "3");
		
		log.info("Display 3 Products Per Page - Step 02: verify there are only 3 or less products on page");
		computersPage.areThereThreeOrLessProductsOnPage();
		
		log.info("Display 3 Products Per Page - Step 03: verify Next Icon is displayed when on page 1");
		verifyTrue(computersPage.isCurrentPage1());
		verifyTrue(computersPage.isNextIconDisplayed());
		
		log.info("Display 3 Products Per Page - Step 04: verify Previous Icon is displayed when on page 2");
		computersPage.clickToNextIcon();
		verifyTrue(computersPage.isCurrentPage2());
		verifyTrue(computersPage.isPreviousIconDisplayed());
		
	}
	
	@Test
	public void TC06_Display6ProductsPerPage() {
		
		log.info("Display 6 Products Per Page - Step 01: choose Display 6 per page");
		computersPage.selectDropdownByName(driver, "products-pagesize", "6");
		
		log.info("Display 6 Products Per Page - Step 02: verify there are only 6 or less products on page");
		verifyTrue(computersPage.areThereSixOrLessProductsOnPage());
		
	}
	
	@Test
	public void TC07_Display9ProductsPerPage() {
		
		log.info("Display 9 Products Per Page - Step 01: choose Display 9 per page");
		computersPage.selectDropdownByName(driver, "products-pagesize", "9");
		
		log.info("Display 9 Products Per Page - Step 02: verify there are only 9 or less products on page");
		verifyTrue(computersPage.areThereNineOrLessProductsOnPage());
		
	}
	
	
	
	
	
	
	@AfterClass
	public void afterClass() {
		//closeBrowserAndDriver(driver);
	}


}
