package com.nopcommerce.users;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.GetElementText;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.GlobalConstants;
import pageObjects.UserCustomerInforPageObject;
import pageObjects.UserHomePageObject;
import pageObjects.UserLoginPageObject;
import pageObjects.UserMyProductReviewPageObject;
import pageObjects.UserProductDetailPageObject;
import pageObjects.UserProductReviewPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.UserAddressesPageObject;
import pageObjects.UserChangePasswordPageObject;
import pageObjects.UserRegisterPageObject;
import pageObjects.UserSearchPageObject;
import pageObjects.UserShippingAndReturnPageObject;
import pageObjects.UserSitemapPageObject;
import pageObjects.UserWishListPageObject;
import pageUIs.UserHomePageUI;

public class MyAccount extends AbstractTest {
	WebDriver driver;
	String source_folder = System.getProperty("user.dir");
	Select select;
	String firstName, lastName, email, companyName, country, city, state, address1, address2, postalCode, phoneNumber, faxNumber, password, newPassword, date, month, year, reviewTitle, reviewText;
	String phoneNumberText;
	
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	UserCustomerInforPageObject customerInforPage;
	UserAddressesPageObject addressPage;
	UserChangePasswordPageObject changePasswordPage;
	UserProductDetailPageObject productDetailPage;
	UserProductReviewPageObject productReviewPage;
	UserMyProductReviewPageObject myProductReviewPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.DEMO_USER_PAGE);
		
		firstName = "automation";
		lastName = "FC";
		//email = "johngacy" + getRandomNumber() + "@gmail.com";
		email = "automationfc.vn01@gmail.com";
		companyName = "Automation FC";
		country = "Viet Nam";
		city = "Da Nang";
		state = "Other";
		address1 = "123/04 Le Lai";
		address2 = "234/05 Hai Phong";
		postalCode = "550000";
		phoneNumber = "0123456789";
		faxNumber = "0987654321";
		password = "johngacy";
		newPassword = "password";
		date = "1";
		month = "January";
		year = "1999";
		
		reviewTitle = "This is a review title";
		reviewText = "This is a review text";
		
		log.info("Precondition - Step 01: Open homepage");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Precondition - Step 02: click register link at hompage");
		loginPage = homePage.clickToLoginLink();

		log.info("Precondition - Step 03: input to Email textbox with value: " + Common_01_Register.email);
		loginPage.inputToTextBoxByID(driver, "Email", Common_01_Register.email);
		
		log.info("Precondition - Step 04: input to Password textbox with value: " + password);
		loginPage.inputToTextBoxByID(driver, "Password", password);
		
		log.info("Precondition - Step 05: click to 'Login' button at Login Page");
		loginPage.clickToButtonByValue(driver, "Log in");
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Precondition - Step 06: click to 'My Account' link on header");
		homePage.clickToMyAccountLink();
	}
	
	@BeforeMethod
	public void beforeMethod() {

		
	}
	
	@Test
	public void TC01_UpdateCustomerInfo() {
		
		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);
		
		log.info("Update Customer Data - Step 01: click to gender male radio button");
		customerInforPage.clickToRadioButtonByID(driver, "gender-female");
		
		log.info("Update Customer Data - Step 02: edit Firstname textbox with value: " + firstName);
		customerInforPage.inputToTextBoxByID(driver, "FirstName", firstName);
		
		log.info("Update Customer Data - Step 03: edit Lastname textbox with value: " + lastName);
		customerInforPage.inputToTextBoxByID(driver, "LastName", lastName);
		
		log.info("Update Customer Data - Step 04: select date dropdown with value: " + date);
		customerInforPage.selectDropdownByName(driver, "DateOfBirthDay", date);
		
		log.info("Update Customer Data - Step 05: select month dropdown with value: " + month);
		customerInforPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
		
		log.info("Update Customer Data - Step 06: select year dropdown with value: " + year);
		customerInforPage.selectDropdownByName(driver, "DateOfBirthYear", year);
		
		log.info("Update Customer Data - Step 07: edit Email textbox with value: " + email);
		customerInforPage.inputToTextBoxByID(driver, "Email", email);
		
		log.info("Update Customer Data - Step 08: edit CompanyName textbox");
		customerInforPage.inputToTextBoxByID(driver, "Company", companyName);
		
		log.info("Update Customer Data - Step 09: click to Save button at Customer info page");
		customerInforPage.clickToButtonByValue(driver, "Save");
		
		log.info("Update Customer Data - Step 10: verify data after editing");
		verifyEquals(customerInforPage.getAttributeByValue(driver, "gender-female", "id"), "gender-female");
		verifyEquals(customerInforPage.getAttributeByValue(driver, "FirstName", "value"), firstName);
		verifyEquals(customerInforPage.getAttributeByValue(driver, "LastName", "value"), lastName);
		verifyEquals(customerInforPage.getFirstSelectedInDropdownByName(driver, "DateOfBirthDay"), date);
		verifyEquals(customerInforPage.getFirstSelectedInDropdownByName(driver, "DateOfBirthMonth"), month);
		verifyEquals(customerInforPage.getFirstSelectedInDropdownByName(driver, "DateOfBirthYear"), year);
		verifyEquals(customerInforPage.getAttributeByValue(driver, "Email", "value"), email);
		verifyEquals(customerInforPage.getAttributeByValue(driver, "Company", "value"), companyName);
	}
	
	@Test
	public void TC02_AddAddress() {
		
		log.info("Add Addresses - Step 01: click to 'Addresses' on side menu");
		customerInforPage.openLinkByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressesPage(driver);
		
		log.info("Add Addresses - Step 02: click to 'Add New' button");
		addressPage.clickToButtonByValue(driver, "Add new");
		
		log.info("Add Addresses - Step 03: input to 'First name' textbox with value: " + firstName);
		addressPage.inputToTextBoxByID(driver, "Address_FirstName", firstName);
		
		log.info("Add Addresses - Step 04: input to 'Last name' textbox with value: " + lastName);
		addressPage.inputToTextBoxByID(driver, "Address_LastName", lastName);
		
		log.info("Add Addresses - Step 05: input to 'Email' textbox with value: " + email);
		addressPage.inputToTextBoxByID(driver, "Address_Email", email);
		
		log.info("Add Addresses - Step 06: input to 'Company' textbox with value: " + companyName);
		addressPage.inputToTextBoxByID(driver, "Address_Company", companyName);
		
		log.info("Add Addresses - Step 07: input to 'Country' textbox with value: " + country);
		addressPage.selectDropdownByName(driver, "Address.CountryId", country);
		
		log.info("Add Addresses - Step 07: input to 'Country' textbox with value: " + state);
		addressPage.selectDropdownByName(driver, "Address.StateProvinceId", state);
		
		log.info("Add Addresses - Step 08: input to 'City' textbox with value: " + city);
		addressPage.inputToTextBoxByID(driver, "Address_City", city);
		
		log.info("Add Addresses - Step 09: input to 'Address 1' textbox with value: " + address1);
		addressPage.inputToTextBoxByID(driver, "Address_Address1", address1);
		
		log.info("Add Addresses - Step 10: input to 'Address 2' textbox with value: " + address2);
		addressPage.inputToTextBoxByID(driver, "Address_Address2", address2);
		
		log.info("Add Addresses - Step 11: input to 'Zip / postal code' textbox with value: " + postalCode);
		addressPage.inputToTextBoxByID(driver, "Address_ZipPostalCode", postalCode);
		
		log.info("Add Addresses - Step 12: input to 'Phone Number' textbox with value: " + phoneNumber);
		addressPage.inputToTextBoxByID(driver, "Address_PhoneNumber", phoneNumber);
		
		log.info("Add Addresses - Step 13: input to 'Fax Number' textbox with value: " + faxNumber);
		addressPage.inputToTextBoxByID(driver, "Address_FaxNumber", faxNumber);
		
		log.info("Add Address - Step 14: click 'Save' button");
		addressPage.clickToButtonByValue(driver, "Save");

		log.info("Add Address - Step 15: verify data after saving");
		verifyEquals(addressPage.getInfoByClass(driver, "name"), firstName + " " + lastName);
		verifyEquals(addressPage.getInfoByClass(driver, "phone"), "Phone number: " + phoneNumber);
		verifyEquals(addressPage.getInfoByClass(driver, "fax"), "Fax number: " + faxNumber);
		verifyEquals(addressPage.getInfoByClass(driver, "company"), companyName);
		verifyEquals(addressPage.getInfoByClass(driver, "address1"), address1);
		verifyEquals(addressPage.getInfoByClass(driver, "address2"), address2);
		verifyEquals(addressPage.getInfoByClass(driver, "city-state-zip"), city + ", " + postalCode);
		verifyEquals(addressPage.getInfoByClass(driver, "country"), country);
		
	}

	@Test
	public void TC03_ChangePassword() {
		
		log.info("Change Password - Step 01: click to 'Change password' on side menu");
		customerInforPage.openLinkByPageName(driver, "Change password");
		changePasswordPage = PageGeneratorManager.getUserChangePasswordPage(driver);
		
		log.info("Change Password - Step 02: input to textbox 'Old Password' with value: " + password);
		changePasswordPage.inputToTextBoxByID(driver, "OldPassword", password);
		
		log.info("Change Password - Step 03: input to textbox 'New password' with value: " + newPassword);
		changePasswordPage.inputToTextBoxByID(driver, "NewPassword", newPassword);
		
		log.info("Change Password - Step 04: input to textbox 'Confirm password' with value: " + newPassword);
		changePasswordPage.inputToTextBoxByID(driver, "ConfirmNewPassword", newPassword);
		
		log.info("Change Password - Step 05: click to 'Change Password' button");
		changePasswordPage.clickToButtonByValue(driver, "Change password");
		
		log.info("Change Password - Step 06: verify password changed successfully");
		verifyEquals(changePasswordPage.getChangePasswordResult(), "Password was changed");
		
		log.info("Change Password - Step 07: click 'Log out' link on header");
		changePasswordPage.clickToLogoutLink();
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Change Password - Step 08: click 'Log in' link on header");
		homePage.clickToLoginLink();
		loginPage = PageGeneratorManager.getUserLoginPage(driver);
		
		log.info("Change Password - Step 09: input to Email textbox with value: " + email);
		loginPage.inputToTextBoxByID(driver, "Email", email);
		
		log.info("Change Password - Step 10: input to Password textbox with value: " + password);
		loginPage.inputToTextBoxByID(driver, "Password", password);
		
		log.info("Change Password - Step 11: click to 'Login' button at Login Page");
		loginPage.clickToButtonByValue(driver, "Log in");
		
		log.info("Change Password - Step 12: verify summary error message 'password' textbox");
		verifyEquals(loginPage.getSummaryErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
		log.info("Change Password - Step 13: input to Password textbox with value: " + newPassword);
		loginPage.inputToTextBoxByID(driver, "Password", newPassword);
		
		log.info("Change Password - Step 14: click to 'Login' button at Login Page");
		loginPage.clickToButtonByValue(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Change Password - Step 15: verify 'My Account' link is visible");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void TC04_AddProductReview() {
		
		log.info("Add Product Review - Step 01: click to product 'Apple MacBook Pro 13-inch'");
		homePage.clickToProductByName(driver, "Apple MacBook Pro 13-inch");
		productDetailPage = PageGeneratorManager.getUserProductDetailPage(driver);
		
		log.info("Add Product Review - Step 02: click 'Add your review' link");
		productDetailPage.clickToAddReviewLink();
		productReviewPage = PageGeneratorManager.getUserProductReviewPage(driver);
		
		log.info("Add Product Review - Step 03: input to textbox 'Review title' with value: " + reviewTitle);
		productReviewPage.inputToTextBoxByID(driver, "AddProductReview_Title", reviewTitle);
		
		log.info("Add Product Review - Step 04: input to textbox 'Review text' with value: " + reviewText);
		productReviewPage.inputToReviewTextArea(reviewText);
		
		log.info("Add Product Review - Step 05: click to radio button 4 'Rating'");
		productReviewPage.clickToRadioButtonByID(driver, "addproductrating_4");
		
		log.info("Add Product Review - Step 06: click to button 'Submit Review'");
		productReviewPage.clickToButtonByValue(driver, "Submit review");
		
		log.info("Add Product Review - Step 07: click to 'My Account' link on header");
		productReviewPage.clickToMyAccountLink();
		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);
		
		log.info("Add Product Review - Step 08: click to 'My product reviews' link on sidemenu");
		customerInforPage.openLinkByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
		
		log.info("Add Product Review - Step 09: verify review is visible in 'My Product Review' page");
		verifyTrue(myProductReviewPage.isReviewTitleVisible(reviewTitle));
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}


}
