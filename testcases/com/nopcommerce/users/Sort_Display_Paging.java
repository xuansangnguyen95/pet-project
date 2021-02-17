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
		verifyTrue(computersPage.isProductNameSortAtoZ());
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}


}
