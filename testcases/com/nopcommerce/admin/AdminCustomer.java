package com.nopcommerce.admin;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.GetElementText;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.GlobalConstants;
import pageObjects.AdminCustomerDetailPageObject;
import pageObjects.AdminCustomerPageObject;
import pageObjects.AdminDashboardPageObject;
import pageObjects.AdminLoginPageObject;
import pageObjects.PageGeneratorManager;

public class AdminCustomer extends AbstractTest {
	WebDriver driver;
	AdminLoginPageObject loginPage;
	AdminDashboardPageObject dashboardPage;
	AdminCustomerPageObject customerPage;
	AdminCustomerDetailPageObject customerDetailPage;
	
	String firstName, lastName, email, companyName, password, date, month, year, dateOfBirth, adminComment;
	String country, city, address1, address2, postalCode, phoneNumber, faxNumber;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		
		firstName = "john";
		lastName = "gacy" + getRandomNumber();
		email = "johngacy" + getRandomNumber() + "@gmail.com";
		companyName = "gacy";
		password = "johngacy";
		dateOfBirth = "8/21/1999";
		date = "21";
		month = "August";
		year = "1999";
		adminComment = "Add new Customer (Guest)";
		
		country = "Viet Nam";
		city = "TPHCM";
		address1 = "address 1";
		address2 = "address 2";
		postalCode = "700000";
		phoneNumber = "0123456789";
		faxNumber = "0987654321";
		
		log.info("Precondition - Step 01: navigate to Admin page");
		driver = getBrowserDriver(browserName, GlobalConstants.DEMO_ADMIN_PAGE);
		loginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		log.info("Precondition - Step 02: login to Admin page");
		dashboardPage = loginPage.loginToSystem("admin@yourstore.com", "admin");
		
		log.info("Precondition - Step 03: navigate to Customers/Customers");
		customerPage = dashboardPage.openCustomerPage();
	}

	@Test
	public void TC01_CreateNewCustomer() {
		
		log.info("Create New Customer - Step 01: click button 'Add New'");
		customerPage.clickToAddNewButton();
		customerDetailPage = PageGeneratorManager.getAdminCustomerDetailPage(driver);
		
		log.info("Create New Customer - Step 02: add customer information");
		customerDetailPage.inputToTextBoxByID(driver, "Email", email);
		customerDetailPage.inputToTextBoxByID(driver, "Password", password);
		customerDetailPage.inputToTextBoxByID(driver, "FirstName", firstName);
		customerDetailPage.inputToTextBoxByID(driver, "LastName", lastName);
		customerDetailPage.clickToRadioButtonByID(driver, "Gender_Male");
		customerDetailPage.inputToTextBoxByID(driver, "DateOfBirth", dateOfBirth);
		customerDetailPage.inputToTextBoxByID(driver, "Company", companyName);
		customerDetailPage.removeCustomerRoleByValue("Registered");
		customerDetailPage.addCustomerRoleByValue("Guests");
		customerDetailPage.clickToCheckboxByID(driver, "Active");
		customerDetailPage.inputToAdminCommment(adminComment);
		
		log.info("Create New Customer - Step 03: click button 'Save and Continue Edit'");
		customerDetailPage.clickToSaveAndContinueCustomerButton();
		
		log.info("Create New Customer - Step 04: verify success message");
		verifyEquals(customerDetailPage.getTopAlert(driver), "×\nThe new customer has been added successfully.");
		
		log.info("Create New Customer - Step 05: verify customer information");
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Email", "value"), email);
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "FirstName", "value"), firstName);
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "LastName", "value"), lastName);
		verifyTrue(customerDetailPage.isRadioButtonCheckedByID(driver, "Gender_Male"));
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "DateOfBirth", "value"), dateOfBirth);
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Company", "value"), companyName);
		verifyTrue(customerDetailPage.isCustomerRoleDisplayedByValue("Guests"));
		verifyTrue(customerDetailPage.isActiveCheckboxChecked());
		verifyEquals(customerDetailPage.getAdminCommment(), adminComment);
		
		log.info("Create New Customer - Step 06: click link 'back to customer list'");
		customerDetailPage.clickToBackToCustomerList();
		customerPage = PageGeneratorManager.getAdminCustomerPage(driver);
		
		log.info("Create New Customer - Step 07: remove 'Registered' and add 'Guests'");
		customerPage.removeCustomerRoleByValue("Registered");
		customerPage.addCustomerRoleByValue("Guests");
		
		log.info("Create New Customer - Step 08: click button 'Search''");
		customerPage.clickToButtonByID(driver, "search-customers");
		
		log.info("Create New Customer - Step 09: verify customer is displayed");
		verifyTrue(customerPage.isCustomerDisplayed(firstName + " " + lastName, "Guests", companyName, "true"));
	}
	
	@Test
	public void TC02_SearchCustomerWithEmail() {
		
		log.info("Search Customer With Email - Step 01: input to textbox Email with value: " + email);
		customerPage.inputToTextBoxByID(driver, "SearchEmail", email);
		
		log.info("Search Customer With Email - Step 02: click button 'Search''");
		customerPage.clickToButtonByID(driver, "search-customers");
		
		log.info("Search Customer With Email - Step 03: verify customer is displayed");
		verifyTrue(customerPage.isCustomerDisplayed(firstName + " " + lastName, "Guests", companyName, "true"));
		
		log.info("Search Customer With Email - Step 04: verify number of customer is 1");
		verifyEquals(customerPage.getNumberOfCustomer(), "1-1 of 1 items");
	}
	
	@Test
	public void TC03_SearchCustomerWithName() {
		
		log.info("Search Customer With Name - Step 01: input to textbox FirstName and LastName with value: " + firstName + " " + lastName);
		customerPage.inputToTextBoxByID(driver, "SearchFirstName", firstName);
		customerPage.inputToTextBoxByID(driver, "SearchLastName", lastName);
		
		log.info("Search Customer With Name - Step 02: click button 'Search''");
		customerPage.clickToButtonByID(driver, "search-customers");
		
		log.info("Search Customer With Name - Step 03: verify customer is displayed");
		verifyTrue(customerPage.isCustomerDisplayed(firstName + " " + lastName, "Guests", companyName, "true"));

		log.info("Search Customer With Name - Step 04: verify number of customer is 1");
		verifyEquals(customerPage.getNumberOfCustomer(), "1-1 of 1 items");
	}
	
	@Test
	public void TC04_SearchCustomerWithCompany() {
		
		log.info("Search Customer With Company - Step 01: input to textbox Company with value: " + companyName);
		customerPage.inputToTextBoxByID(driver, "SearchCompany", companyName);
		
		log.info("Search Customer With Company - Step 02: click button 'Search''");
		customerPage.clickToButtonByID(driver, "search-customers");
		
		log.info("Search Customer With Company - Step 03: verify customer is displayed");
		verifyTrue(customerPage.isCustomerDisplayed(firstName + " " + lastName, "Guests", companyName, "true"));
		
		log.info("Search Customer With Company - Step 04: verify number of customer is 1");
		verifyEquals(customerPage.getNumberOfCustomer(), "1-1 of 1 items");
	}
	
	@Test
	public void TC05_SearchCustomerWithFullData() {
		
		log.info("Search Customer With Full Data - Step 01: input to textbox Email with value: " + email);
		customerPage.inputToTextBoxByID(driver, "SearchEmail", email);
		
		log.info("Search Customer With Full Data - Step 02: input to textbox FirstName and LastName with value: " + firstName + " " + lastName);
		customerPage.inputToTextBoxByID(driver, "SearchFirstName", firstName);
		customerPage.inputToTextBoxByID(driver, "SearchLastName", lastName);
		
		log.info("Search Customer With Full Data - Step 03: input to textbox Company with value: " + companyName);
		customerPage.inputToTextBoxByID(driver, "SearchCompany", companyName);
		
		log.info("Search Customer With Full Data - Step 04: input to dropdown Date of Birth with month: " + month + "and date: " + date);
		customerPage.selectDropdownByName(driver, "SearchMonthOfBirth", "8");
		customerPage.selectDropdownByName(driver, "SearchDayOfBirth", "21");
		
		log.info("Search Customer With Full Data - Step 05: click button 'Search''");
		customerPage.clickToButtonByID(driver, "search-customers");
		
		log.info("Search Customer With Full Data - Step 06: verify customer is displayed");
		verifyTrue(customerPage.isCustomerDisplayed(firstName + " " + lastName, "Guests", companyName, "true"));
		
		log.info("Search Customer With Full Data - Step 07: verify number of customer is 1");
		verifyEquals(customerPage.getNumberOfCustomer(), "1-1 of 1 items");
	}
	
	@Test
	public void TC06_EditCustomer() {
		
		log.info("Edit Customer - Step 01: click button 'Edit'");
		customerPage.clickToEditButton(firstName + " " + lastName, "Guests", companyName);
		customerDetailPage = PageGeneratorManager.getAdminCustomerDetailPage(driver);
		
		log.info("Edit Customer - Step 02: edit customer information");
		customerDetailPage.inputToTextBoxByID(driver, "Email", "edit_" + email);
		customerDetailPage.inputToTextBoxByID(driver, "FirstName", "edit " + firstName);
		customerDetailPage.inputToTextBoxByID(driver, "LastName", "edit " + lastName);
		customerDetailPage.inputToTextBoxByID(driver, "DateOfBirth", "10/21/1999");
		customerDetailPage.inputToTextBoxByID(driver, "Company", "edit " + companyName);
		customerDetailPage.inputToAdminCommment("edit " + adminComment);
		
		log.info("Edit Customer - Step 03: click button 'Save'");
		customerDetailPage.clickToSaveCustomerButton();
		customerPage = PageGeneratorManager.getAdminCustomerPage(driver);
		
		log.info("Edit Customer - Step 04: verify top alert");
		verifyEquals(customerPage.getTopAlert(driver), "×\nThe customer has been updated successfully.");

		log.info("Edit Customer - Step 05: input to textbox Email with value: edit_" + email);
		customerPage.inputToTextBoxByID(driver, "SearchEmail", "edit_" + email);
		
		log.info("Edit Customer - Step 06: input to textbox FirstName and LastName with value: edit " + firstName + " edit " + lastName);
		customerPage.inputToTextBoxByID(driver, "SearchFirstName", "edit " + firstName);
		customerPage.inputToTextBoxByID(driver, "SearchLastName", "edit " + lastName);
		
		log.info("Edit Customer - Step 07: input to textbox Company with value: edit " + companyName);
		customerPage.inputToTextBoxByID(driver, "SearchCompany", "edit " + companyName);
		
		log.info("Edit Customer - Step 08: input to dropdown Date of Birth with month: 10 and date: 21");
		customerPage.selectDropdownByName(driver, "SearchMonthOfBirth", "10");
		customerPage.selectDropdownByName(driver, "SearchDayOfBirth", "21");
		
		log.info("Edit Customer - Step 09: remove 'Registered' and add 'Guests'");
		customerPage.removeCustomerRoleByValue("Registered");
		customerPage.addCustomerRoleByValue("Guests");
		
		log.info("Edit Customer - Step 10: click button 'Search''");
		customerPage.clickToButtonByID(driver, "search-customers");
		
		log.info("Edit Customer - Step 11: verify customer is displayed");
		verifyTrue(customerPage.isCustomerDisplayed("edit " + firstName + " " + "edit " + lastName, "Guests", "edit " + companyName, "true"));
		
		log.info("Edit Customer - Step 12: verify number of customer is 1");
		verifyEquals(customerPage.getNumberOfCustomer(), "1-1 of 1 items");
		
	}
	
	@Test
	public void TC07_AddNewCustomerAddress() {
		
		log.info("Add New Customer Address - Step 01: click button 'Edit'");
		customerPage.clickToEditButton("edit " + firstName + " " + "edit " + lastName, "Guests", "edit " + companyName);
		customerDetailPage = PageGeneratorManager.getAdminCustomerDetailPage(driver);
		
		log.info("Add New Customer Address - Step 02: click section 'Addresses'");
		customerDetailPage.clickToAddressesSection();
		
		log.info("Add New Customer Address - Step 03: click button 'Add new address'");
		customerDetailPage.clickToAddNewAddressButton();
		
		log.info("Add New Customer Address - Step 04: add new address information");
		customerDetailPage.inputToTextBoxByID(driver, "Address_FirstName", firstName);
		customerDetailPage.inputToTextBoxByID(driver, "Address_LastName", lastName);
		customerDetailPage.inputToTextBoxByID(driver, "Address_Email", email);
		customerDetailPage.inputToTextBoxByID(driver, "Address_Company", companyName);
		customerDetailPage.selectDropdownByName(driver, "Address.CountryId", country);
		customerDetailPage.inputToTextBoxByID(driver, "Address_City", city);
		customerDetailPage.inputToTextBoxByID(driver, "Address_Address1", address1);
		customerDetailPage.inputToTextBoxByID(driver, "Address_Address2", address2);
		customerDetailPage.inputToTextBoxByID(driver, "Address_ZipPostalCode", postalCode);
		customerDetailPage.inputToTextBoxByID(driver, "Address_PhoneNumber", phoneNumber);
		customerDetailPage.inputToTextBoxByID(driver, "Address_FaxNumber", faxNumber);
		
		log.info("Add New Customer Address - Step 05: click button 'Save'");
		customerDetailPage.clickToSaveAddressButton();
		
		log.info("Add New Customer Address - Step 06: verify top alert");
		verifyEquals(customerDetailPage.getTopAlert(driver), "×\nThe new address has been added successfully.");
		
		log.info("Add New Customer Address - Step 07: verify new address added successfully");
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Address_FirstName", "value"), firstName);
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Address_LastName", "value"), lastName);
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Address_Email", "value"), email);
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Address_Company", "value"), companyName);
		verifyEquals(customerDetailPage.getFirstSelectedInDropdownByName(driver, "Address.CountryId"), "Viet Nam");
		verifyEquals(customerDetailPage.getFirstSelectedInDropdownByName(driver, "Address.StateProvinceId"), "Other");
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Address_City", "value"), city);
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Address_Address1", "value"), address1);
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Address_Address2", "value"), address2);
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Address_ZipPostalCode", "value"), postalCode);
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Address_PhoneNumber", "value"), phoneNumber);
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Address_FaxNumber", "value"), faxNumber);
		
		log.info("Add New Customer Address - Step 08: click link 'back to customer detail'");
		customerDetailPage.clickToBackToCustomerDetail();
		
		log.info("Add New Customer Address - Step 09: verify new address added successfully");
		verifyEquals(customerDetailPage.getAddressRow(firstName, lastName, email, phoneNumber, faxNumber), companyName + "\n" + address1 + "\n" + address2 + "\n" + city + "," + postalCode + "\n" + country);
		
	}
	
	@Test
	public void TC08_EditCustomerAddress() {
		
		log.info("Edit Customer Address - Step 01: click button 'Edit' address");
		customerDetailPage.clickToEditButton(firstName, lastName, email, phoneNumber, faxNumber);
		
		log.info("Edit Customer Address - Step 02: edit address information");
		customerDetailPage.inputToTextBoxByID(driver, "Address_FirstName", "edit " + firstName);
		customerDetailPage.inputToTextBoxByID(driver, "Address_LastName", "edit " + lastName);
		customerDetailPage.inputToTextBoxByID(driver, "Address_Email", email);
		customerDetailPage.inputToTextBoxByID(driver, "Address_Company", "edit " + companyName);
		customerDetailPage.selectDropdownByName(driver, "Address.CountryId", "United States");
		customerDetailPage.selectDropdownByName(driver, "Address.StateProvinceId", "California");
		customerDetailPage.inputToTextBoxByID(driver, "Address_City", "edit " + city);
		customerDetailPage.inputToTextBoxByID(driver, "Address_Address1", "edit " + address1);
		customerDetailPage.inputToTextBoxByID(driver, "Address_Address2", "edit " + address2);
		customerDetailPage.inputToTextBoxByID(driver, "Address_ZipPostalCode", "600000");
		customerDetailPage.inputToTextBoxByID(driver, "Address_PhoneNumber", "1111111111");
		customerDetailPage.inputToTextBoxByID(driver, "Address_FaxNumber", "2222222222");
		
		log.info("Edit Customer Address - Step 03: click button 'Save'");
		customerDetailPage.clickToSaveEditedAddressButton();
		
		log.info("Edit Customer Address - Step 04: verify top alert");
		verifyEquals(customerDetailPage.getTopAlert(driver), "×\nThe address has been updated successfully.");

		log.info("Edit Customer Address - Step 05: verify new address added successfully");
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Address_FirstName", "value"), "edit " + firstName);
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Address_LastName", "value"), "edit " + lastName);
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Address_Email", "value"), email);
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Address_Company", "value"), "edit " + companyName);
		verifyEquals(customerDetailPage.getFirstSelectedInDropdownByName(driver, "Address.CountryId"), "United States");
		verifyEquals(customerDetailPage.getFirstSelectedInDropdownByName(driver, "Address.StateProvinceId"), "California");
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Address_City", "value"), "edit " + city);
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Address_Address1", "value"), "edit " + address1);
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Address_Address2", "value"), "edit " + address2);
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Address_ZipPostalCode", "value"), "600000");
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Address_PhoneNumber", "value"), "1111111111");
		verifyEquals(customerDetailPage.getElementAttributeByID(driver, "Address_FaxNumber", "value"), "2222222222");
	
		log.info("Edit Customer Address - Step 06: click link 'back to customer detail'");
		customerDetailPage.clickToBackToCustomerDetail();
		
		log.info("Edit Customer Address - Step 07:sssssssssssssssssswqwqwqwqwqqweqweqweqweqweqwrrrterterterttyuyuiuiiopiopiop verify new address added successfully");
		verifyEquals(customerDetailPage.getAddressRow("edit " + firstName, "edit " + lastName, email, "1111111111", "2222222222"), "edit " + companyName + "\n" + "edit " + address1 + "\n" + "edit " + address2 + "\n" + "edit " + city + "," + "California" + "," + "600000" + "\n" + "United States");
		
	}
	
	@Test
	public void TC09_DeleteAddress() {
		
		log.info("Delete Customer Address - Step 01: click button 'Delete'");
		customerDetailPage.clickToDeleteButton("edit " + firstName, "edit " + lastName, email, "1111111111", "2222222222");
		
		log.info("Delete Customer Address - Step 02: verify no row in address table");
		verifyEquals(customerDetailPage.getAddressTableAlert(), "No data available in table");
		
	}
	

	
	@AfterClass
	public void afterClass() {
		//closeBrowserAndDriver(driver);
	}


}
