package com.nopcommerce.users;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
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
import pageObjects.UserOrderDetailPageObject;
import pageObjects.UserOrderListPageObject;
import pageObjects.UserProductDetailPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.UserCheckoutPageObject;
import pageObjects.UserRegisterPageObject;
import pageObjects.UserSearchPageObject;
import pageObjects.UserShippingAndReturnPageObject;
import pageObjects.UserShoppingCartPageObject;
import pageObjects.UserSitemapPageObject;
import pageObjects.UserWishListPageObject;
import pageUIs.UserHomePageUI;

public class Order extends AbstractTest {
	WebDriver driver;
	String source_folder = System.getProperty("user.dir");
	Select select;
	String orderNumber;
	
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserCustomerInforPageObject customerInforPage;
	UserProductDetailPageObject productDetailPage;
	UserShoppingCartPageObject shoppingCartPage;
	UserSearchPageObject searchPage;
	UserCheckoutPageObject checkoutPage;
	UserOrderDetailPageObject orderDetailPage;
	UserOrderListPageObject orderListPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.DEMO_USER_PAGE);
		
		log.info("Precondition - Step 01: Open homepage");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Precondition - Step 02: click register link at hompage");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Precondition - Step 03: input to Email textbox with value: " + Common_01_Register.email);
		loginPage.inputToTextBoxByID(driver, "Email", Common_01_Register.email);
		
		log.info("Precondition - Step 04: input to Password textbox with value: " + Common_01_Register.password);
		loginPage.inputToTextBoxByID(driver, "Password", Common_01_Register.password);
		
		log.info("Precondition - Step 05: click to 'Login' button at Login Page");
		loginPage.clickToButtonByValue(driver, "Log in");
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() {

	}
	
	@Test
	public void TC01_AddProductToCart() {
		
		log.info("Add Product To Cart - Step 01: Open product 'Build your own computer'");
		homePage.clickToProductByName(driver, "Build your own computer");
		productDetailPage = PageGeneratorManager.getUserProductDetailPage(driver);
		
		log.info("Add Product To Cart - Step 02: choose 'Processor' 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
		productDetailPage.selectDropdownByName(driver, "product_attribute_1", "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
		
		log.info("Add Product To Cart - Step 03: choose 'RAM' 8GB [+$60.00]");
		productDetailPage.selectDropdownByName(driver, "product_attribute_2", "8GB [+$60.00]");
		
		log.info("Add Product To Cart - Step 04: choose 'HDD' 400 GB [+$100.00]");
		productDetailPage.clickToRadioButtonByID(driver, "product_attribute_3_7");
		
		log.info("Add Product To Cart - Step 05: choose 'OS' Vista Premium [+$60.00]");
		productDetailPage.clickToRadioButtonByID(driver, "product_attribute_4_9");
		
		log.info("Add Product To Cart - Step 06: choose 'Software' Microsoft Office [+$50.00], Acrobat Reader [+$10.00], Total Commander [+$5.00]");
		productDetailPage.clickToCheckboxByID(driver, "product_attribute_5_10");
		productDetailPage.clickToCheckboxByID(driver, "product_attribute_5_11");
		productDetailPage.clickToCheckboxByID(driver, "product_attribute_5_12");
		
		log.info("Add Product To Cart - Step 07: click button 'Add to cart'");
		productDetailPage.clickToButtonByValue(driver, "Add to cart");
		
		log.info("Add Product To Cart - Step 08: verify top message 'The product has been added to your shopping cart'");
		verifyEquals(productDetailPage.getTopMessage(), "The product has been added to your shopping cart");
		
		log.info("Add Product To Cart - Step 09: hover mouse to shopping cart");
		productDetailPage.hoverMouseToShoppingCart();
		
		log.info("Add Product To Cart - Step 10: verify product added successfully");
		verifyEquals(productDetailPage.getCartQuantity(), "(1)");
		verifyEquals(productDetailPage.getCartProductDetail("count"), "There are 1 item(s) in your cart.");
		verifyEquals(productDetailPage.getCartProductDetail("attributes"), "Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]\nRAM: 8GB [+$60.00]\nHDD: 400 GB [+$100.00]\nOS: Vista Premium [+$60.00]\nSoftware: Microsoft Office [+$50.00]\nSoftware: Acrobat Reader [+$10.00]\nSoftware: Total Commander [+$5.00]");
		verifyEquals(productDetailPage.getCartProductDetail("price"), "Unit price: $1,500.00");
		verifyEquals(productDetailPage.getCartProductDetail("quantity"), "Quantity: 1");
		verifyEquals(productDetailPage.getCartProductDetail("totals"), "Sub-Total: $1,500.00");
		
	}
	
	@Test
	public void TC02_EditProductInCart() {
		
		log.info("Edit Product In Cart - Step 01: click 'Shopping Cart'");
		productDetailPage.clickToShoppingCart();
		shoppingCartPage = PageGeneratorManager.getUserShoppingCartPage(driver);
		
		log.info("Edit Product In Cart - Step 02: click 'Edit'");
		shoppingCartPage.clickToEditProduct();
		productDetailPage = PageGeneratorManager.getUserProductDetailPage(driver);
		
		log.info("Edit Product In Cart - Step 03: choose 'Processor' 2.2 GHz Intel Pentium Dual-Core E2200");
		productDetailPage.selectDropdownByName(driver, "product_attribute_1", "2.2 GHz Intel Pentium Dual-Core E2200");
		
		log.info("Edit Product In Cart - Step 04: choose 'RAM' 4GB [+$20.00]");
		productDetailPage.selectDropdownByName(driver, "product_attribute_2", "4GB [+$20.00]");
		
		log.info("Edit Product In Cart - Step 05: choose 'HDD' 320 GB");
		productDetailPage.clickToRadioButtonByID(driver, "product_attribute_3_6");
		
		log.info("Edit Product In Cart - Step 06: choose 'OS' Vista Home [+$50.00]");
		productDetailPage.clickToRadioButtonByID(driver, "product_attribute_4_8");
		
		log.info("Edit Product In Cart - Step 07: choose 'Software' Microsoft Office [+$50.00]");
		productDetailPage.clickToUncheckboxByID(driver, "product_attribute_5_11");
		productDetailPage.clickToUncheckboxByID(driver, "product_attribute_5_12");
		
		log.info("Edit Product In Cart - Step 08: verify price is $1,320.00");
		verifyEquals(productDetailPage.getProductPrice(), "$1,320.00");
		
		log.info("Edit Product In Cart - Step 09: change amount to '2'");
		productDetailPage.inputToTextBoxByID(driver, "product_enteredQuantity_1", "2");
		
		log.info("Edit Product In Cart - Step 10: click button 'Update'");
		productDetailPage.clickToButtonByValue(driver, "Update");
		
		log.info("Edit Product In Cart - Step 11: verify top message 'The product has been added to your shopping cart'");
		verifyEquals(productDetailPage.getTopMessage(), "The product has been added to your shopping cart");
		
		log.info("Edit Product In Cart - Step 12: hover mouse to shopping cart");
		productDetailPage.hoverMouseToShoppingCart();
		
		log.info("Edit Product In Cart - Step 13: verify product added successfully");
		verifyEquals(productDetailPage.getCartQuantity(), "(2)");
		verifyEquals(productDetailPage.getCartProductDetail("count"), "There are 2 item(s) in your cart.");
		verifyEquals(productDetailPage.getCartProductDetail("attributes"), "Processor: 2.2 GHz Intel Pentium Dual-Core E2200\nRAM: 4GB [+$20.00]\nHDD: 320 GB\nOS: Vista Home [+$50.00]\nSoftware: Microsoft Office [+$50.00]");
		verifyEquals(productDetailPage.getCartProductDetail("price"), "Unit price: $1,320.00");
		verifyEquals(productDetailPage.getCartProductDetail("quantity"), "Quantity: 2");
		verifyEquals(productDetailPage.getCartProductDetail("totals"), "Sub-Total: $2,640.00");
	}
	
	@Test
	public void TC03_RemoveFromCart() {
		
		log.info("Remove From Cart - Step 01: click 'Shopping Cart'");
		productDetailPage.clickToShoppingCart();
		shoppingCartPage = PageGeneratorManager.getUserShoppingCartPage(driver);
		
		log.info("Remove From Cart - Step 02: click checkbox remove product");
		shoppingCartPage.clickToRemoveProductCheckbox("Build your own computer");
		
		log.info("Remove From Cart - Step 03: click button 'Update'");
		shoppingCartPage.clickToUpdateShoppingCartButton();
		
		log.info("Remove From Cart - Step 04: verify message 'Your Shopping Cart is empty!'");
		verifyEquals(shoppingCartPage.getSummaryMessage(), "Your Shopping Cart is empty!");
	
	}
	
	@Test
	public void TC04_UpdateShoppingCart() {
		
		log.info("Update Shopping Cart - Step 01: click 'Search' link footer");
		shoppingCartPage.openLinkByPageName(driver, "Search");
		searchPage = PageGeneratorManager.getUserSearchPage(driver);
		
		log.info("Update Shopping Cart - Step 02: search product 'Lenovo'");
		searchPage.inputToSearchTextbox("Lenovo");
		searchPage.clickToSearchButton();
		
		log.info("Update Shopping Cart - Step 03: click product 'Lenovo IdeaCentre 600 All-in-One PC'");
		searchPage.clickToProductByName(driver, "Lenovo IdeaCentre 600 All-in-One PC");
		productDetailPage = PageGeneratorManager.getUserProductDetailPage(driver);
		
		log.info("Update Shopping Cart - Step 04: click button 'Add to cart'");
		productDetailPage.clickToButtonByValue(driver, "Add to cart");
		
		log.info("Update Shopping Cart - Step 05: click link 'Shopping Cart'");
		productDetailPage.clickToShoppingCart();
		shoppingCartPage = PageGeneratorManager.getUserShoppingCartPage(driver);
		
		log.info("Update Shopping Cart - Step 06: edit Quantity '5'");		
		shoppingCartPage.editProductQuantity("Lenovo IdeaCentre 600 All-in-One PC", "5");
		
		log.info("Update Shopping Cart - Step 07: click button 'Update'");
		shoppingCartPage.clickToUpdateShoppingCartButton();
		
		log.info("Update Shopping Cart - Step 08: verify total price is $2,500.00'");
		verifyEquals(shoppingCartPage.getProductTotalPrice("Lenovo IdeaCentre 600 All-in-One PC"), "$2,500.00");
		
	}
	
	@Test
	public void TC05_CheckoutOrder() {
		
//		log.info("Checkout Order - Step 01: click button ' Estimate shipping'");
//		shoppingCartPage.clickToEstimateShippingButton();
//		
//		log.info("Checkout Order - Step 02: select country 'Viet Nam'");
//		shoppingCartPage.selectDropdownByName(driver, "CountryId", "Viet Nam");
//		
//		log.info("Checkout Order - Step 03: select state/province 'Other'");
//		shoppingCartPage.selectDropdownByName(driver, "StateProvinceId", "Other");
//		
//		log.info("Checkout Order - Step 04: input zip/postal code '550000'");
//		shoppingCartPage.inputToTextBoxByID(driver, "ZipPostalCode", "550000");
//		
//		log.info("Checkout Order - Step 05: click button 'Apply'");
//		shoppingCartPage.waitShippingOptionsLoadingInivisible();
//		shoppingCartPage.clickToButtonByValue(driver, "Apply");
//		shoppingCartPage.waitAjaxLoadingInvisible(driver);
//		
		log.info("Checkout Order - Step 06: click checkbox 'Term of service'");
		shoppingCartPage.clickToCheckboxByID(driver, "termsofservice");
		
		log.info("Checkout Order - Step 07: click button 'Checkout'");
		shoppingCartPage.clickToButtonByCheckout();
		checkoutPage = PageGeneratorManager.getUserCheckoutPage(driver);
		
		log.info("Checkout Order - Step 08: click to uncheck 'Ship to the same address'");
		checkoutPage.clickToUncheckboxByID(driver, "ShipToSameAddress");
		
		log.info("Checkout Order - Step 09: input billing address information");
		checkoutPage.selectDropdownByName(driver, "BillingNewAddress.CountryId", "Viet Nam");
		checkoutPage.inputToTextBoxByID(driver, "BillingNewAddress_City", "TPHCM");
		checkoutPage.inputToTextBoxByID(driver, "BillingNewAddress_Address1", "123 nguyen trai");
		checkoutPage.inputToTextBoxByID(driver, "BillingNewAddress_ZipPostalCode", "550000");
		checkoutPage.inputToTextBoxByID(driver, "BillingNewAddress_PhoneNumber", "1234567890");
		
		log.info("Checkout Order - Step 10: click button 'Continue'");
		checkoutPage.clickToBillingAddressContinueButton();

		log.info("Checkout Order - Step 11: select dropdown 'New Address'");
		checkoutPage.selectDropdownByName(driver, "shipping_address_id", "New Address");
		
		log.info("Checkout Order - Step 12: input shipping address information");
		checkoutPage.selectDropdownByName(driver, "ShippingNewAddress.CountryId", "Viet Nam");
		checkoutPage.inputToTextBoxByID(driver, "ShippingNewAddress_City", "Ha Noi");
		checkoutPage.inputToTextBoxByID(driver, "ShippingNewAddress_Address1", "456 Hai Ba Trung");
		checkoutPage.inputToTextBoxByID(driver, "ShippingNewAddress_ZipPostalCode", "700000");
		checkoutPage.inputToTextBoxByID(driver, "ShippingNewAddress_PhoneNumber", "0987654321");
		
		log.info("Checkout Order - Step 13: click button 'Continue'");
		checkoutPage.clickToShippingAddressContinueButton();
		
		log.info("Checkout Order - Step 14: click button 'Continue'");
		checkoutPage.clickToShippingMethodContinueButton();
		
		log.info("Checkout Order - Step 15: click button 'Continue'");
		checkoutPage.clickToPaymentMethodContinueButton();
		
		log.info("Checkout Order - Step 16: verify payment info");
		verifyEquals(checkoutPage.getPaymentInfo(), "Mail Personal or Business Check, Cashier's Check or money order to:\n\nNOP SOLUTIONS\nyour address here,\nNew York, NY 10001\nUSA\nNotice that if you pay by Personal or Business Check, your order may be held for up to 10 days after we receive your check to allow enough time for the check to clear. If you want us to ship faster upon receipt of your payment, then we recommend your send a money order or Cashier's check.\nP.S. You can edit this text from admin panel.");
		
		log.info("Checkout Order - Step 17: click button 'Continue'");
		checkoutPage.clickToPaymentInformationContinueButton();
		
		log.info("Checkout Order - Step 18: verify Confirm Order");
		
		verifyEquals(checkoutPage.getBillingAddress(), 
				"john gacy" 
				+ "\nEmail: " + Common_01_Register.email 
				+ "\nPhone: 1234567890"
				+ "\nFax:\n"
				+ Common_01_Register.companyName
				+ "\n123 nguyen trai"
				+ "\nTPHCM,550000"
				+ "\nViet Nam");
		
		verifyEquals(checkoutPage.getShippingAddress(), 
				"john gacy" 
				+ "\nEmail: " + Common_01_Register.email 
				+ "\nPhone: 0987654321"
				+ "\nFax:\n"
				+ Common_01_Register.companyName
				+ "\n456 Hai Ba Trung"
				+ "\nHa Noi,700000"
				+ "\nViet Nam");
		
		verifyEquals(checkoutPage.getPaymentMethod(), "Check / Money Order");
		verifyEquals(checkoutPage.getShippingMethod(), "Ground");
		
		verifyEquals(checkoutPage.getGiftWrappingStatus(), "Gift wrapping: No");
		
		verifyEquals(checkoutPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "sku"), "LE_IC_600");
		verifyEquals(checkoutPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "unit-price"), "$500.00");
		verifyEquals(checkoutPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "quantity"), "5");
		verifyEquals(checkoutPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "subtotal"), "$2,500.00");

		log.info("Checkout Order - Step 19: click button 'Confirm'");
		checkoutPage.clickToButtonByValue(driver, "Confirm");
		
		log.info("Checkout Order - Step 20: verify order complete");
		verifyTrue(checkoutPage.isOrderCompleteMessageDisplayed());
		verifyTrue(checkoutPage.isOrderNumberDisplayed());
		orderNumber = checkoutPage.getOrderNumber();
		System.out.println(orderNumber);
		
		log.info("Checkout Order - Step 21: navigate to My Account");
		checkoutPage.openLinkByPageName(driver, "My account");
		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);
		
		log.info("Checkout Order - Step 22: navigate to Orders");
		customerInforPage.openLinkByPageName(driver, "Orders");
		orderListPage = PageGeneratorManager.getUserOrderListPage(driver);
		
		log.info("Checkout Order - Step 22: verify Order " + orderNumber + " is displayed");
		verifyTrue(orderListPage.isOrderNumberDisplayedInOrderList(orderNumber));
		
		log.info("Checkout Order - Step 22: click Order " + orderNumber + " 'Details'");
		orderListPage.clickToDetailButtonByOrderNumber(orderNumber);
		orderDetailPage = PageGeneratorManager.getUserOrderDetailPage(driver);
		
		log.info("Checkout Order - Step 23: verify Order " + orderNumber + " information is displayed");
		verifyTrue(orderDetailPage.isOrderNumberIsDisplayed(orderNumber));
		//verifyEquals(orderDetailPage.getOrderDateSummary(), "Order Date: Tuesday, February 16, 2021");
		verifyEquals(orderDetailPage.getOrderStatusSummary(), "Order Status: Pending");
		verifyEquals(orderDetailPage.getOrderTotalSummary(), "Order Total: $2,500.00");
		
		verifyEquals(orderDetailPage.getBillingAddress(), 
				"john gacy" 
				+ "\nEmail: " + Common_01_Register.email 
				+ "\nPhone: 1234567890"
				+ "\nFax:\n"
				+ Common_01_Register.companyName
				+ "\n123 nguyen trai"
				+ "\nTPHCM,550000"
				+ "\nViet Nam");
		
		verifyEquals(orderDetailPage.getShippingAddress(), 
				"john gacy" 
				+ "\nEmail: " + Common_01_Register.email 
				+ "\nPhone: 0987654321"
				+ "\nFax:\n"
				+ Common_01_Register.companyName
				+ "\n456 Hai Ba Trung"
				+ "\nHa Noi,700000"
				+ "\nViet Nam");
		
		verifyEquals(orderDetailPage.getPaymentMethod(), "Check / Money Order");
		verifyEquals(orderDetailPage.getShippingMethod(), "Ground");
		
		verifyEquals(orderDetailPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "sku"), "LE_IC_600");
		verifyEquals(orderDetailPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "unit-price"), "$500.00");
		verifyEquals(orderDetailPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "quantity"), "5");
		verifyEquals(orderDetailPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "total"), "$2,500.00");
		
		verifyEquals(orderDetailPage.getGiftWrappingStatus(), "Gift wrapping: No");
		
		verifyEquals(orderDetailPage.getOrderSubtotal(), "$2,500.00");
		verifyEquals(orderDetailPage.getOrderShippingCost(), "$0.00");
		verifyEquals(orderDetailPage.getOrderTaxValue(), "$0.00");
		verifyEquals(orderDetailPage.getOrderTotal(), "$2,500.00");
	}
	
	@Test
	public void TC06_CheckoutOrderWithCreditCard() {
		
		log.info("Checkout Order With Credit Card - Step 01: click 'Search' link footer");
		orderDetailPage.openLinkByPageName(driver, "Search");
		searchPage = PageGeneratorManager.getUserSearchPage(driver);
		
		log.info("Checkout Order With Credit Card - Step 02: search product 'Lenovo'");
		searchPage.inputToSearchTextbox("Lenovo");
		searchPage.clickToSearchButton();
		
		log.info("Checkout Order With Credit Card - Step 03: click product 'Lenovo IdeaCentre 600 All-in-One PC'");
		searchPage.clickToProductByName(driver, "Lenovo IdeaCentre 600 All-in-One PC");
		productDetailPage = PageGeneratorManager.getUserProductDetailPage(driver);
		
		log.info("Checkout Order With Credit Card - Step 04: click button 'Add to cart'");
		productDetailPage.clickToButtonByValue(driver, "Add to cart");
		
		log.info("Checkout Order With Credit Card - Step 05: verify top message 'The product has been added to your shopping cart'");
		verifyEquals(productDetailPage.getTopMessage(), "The product has been added to your shopping cart");
		
		log.info("Checkout Order With Credit Card - Step 06: hover mouse to shopping cart");
		productDetailPage.hoverMouseToShoppingCart();
		
		log.info("Checkout Order With Credit Card - Step 07: verify product added successfully");
		verifyEquals(productDetailPage.getCartQuantity(), "(1)");
		verifyEquals(productDetailPage.getCartProductDetail("count"), "There are 1 item(s) in your cart.");
		verifyEquals(productDetailPage.getCartProductDetail("name"), "Lenovo IdeaCentre 600 All-in-One PC");
		verifyEquals(productDetailPage.getCartProductDetail("price"), "Unit price: $500.00");
		verifyEquals(productDetailPage.getCartProductDetail("quantity"), "Quantity: 1");
		verifyEquals(productDetailPage.getCartProductDetail("totals"), "Sub-Total: $500.00");
		
		log.info("Checkout Order With Credit Card - Step 08: click link 'Shopping Cart'");
		productDetailPage.clickToShoppingCart();
		shoppingCartPage = PageGeneratorManager.getUserShoppingCartPage(driver);
		
		log.info("Checkout Order With Credit Card - Step 09: click checkbox 'Term of service'");
		shoppingCartPage.clickToCheckboxByID(driver, "termsofservice");
		
		log.info("Checkout Order With Credit Card - Step 10: click button 'Checkout'");
		shoppingCartPage.clickToButtonByCheckout();
		checkoutPage = PageGeneratorManager.getUserCheckoutPage(driver);
		
		log.info("Checkout Order With Credit Card - Step 11: click to uncheck 'Ship to the same address'");
		checkoutPage.clickToUncheckboxByID(driver, "ShipToSameAddress");
		
		log.info("Checkout Order With Credit Card - Step 12: select dropdown 'New Address'");
		checkoutPage.selectDropdownByName(driver, "billing_address_id", "New Address");
		
		log.info("Checkout Order With Credit Card - Step 13: input billing address information");
		checkoutPage.selectDropdownByName(driver, "BillingNewAddress.CountryId", "Viet Nam");
		checkoutPage.inputToTextBoxByID(driver, "BillingNewAddress_City", "TPHCM");
		checkoutPage.inputToTextBoxByID(driver, "BillingNewAddress_Address1", "123 nguyen trai");
		checkoutPage.inputToTextBoxByID(driver, "BillingNewAddress_ZipPostalCode", "550000");
		checkoutPage.inputToTextBoxByID(driver, "BillingNewAddress_PhoneNumber", "1234567890");
		
		log.info("Checkout Order With Credit Card - Step 14: click button 'Continue'");
		checkoutPage.clickToBillingAddressContinueButton();

		log.info("Checkout Order With Credit Card - Step 15: select dropdown 'New Address'");
		checkoutPage.selectDropdownByName(driver, "shipping_address_id", "New Address");
		
		log.info("Checkout Order With Credit Card - Step 16: input shipping address information");
		checkoutPage.selectDropdownByName(driver, "ShippingNewAddress.CountryId", "Viet Nam");
		checkoutPage.inputToTextBoxByID(driver, "ShippingNewAddress_City", "Ha Noi");
		checkoutPage.inputToTextBoxByID(driver, "ShippingNewAddress_Address1", "456 Hai Ba Trung");
		checkoutPage.inputToTextBoxByID(driver, "ShippingNewAddress_ZipPostalCode", "700000");
		checkoutPage.inputToTextBoxByID(driver, "ShippingNewAddress_PhoneNumber", "0987654321");
		
		log.info("Checkout Order With Credit Card - Step 17: click button 'Continue'");
		checkoutPage.clickToShippingAddressContinueButton();
		
		log.info("Checkout Order With Credit Card - Step 18: click button 'Continue'");
		checkoutPage.clickToShippingMethodContinueButton();
		
		log.info("Checkout Order With Credit Card - Step 19: choose 'Credit Card' and click button 'Continue'");
		checkoutPage.clickToRadioButtonByID(driver, "paymentmethod_1");
		checkoutPage.clickToPaymentMethodContinueButton();
		
		log.info("Checkout Order With Credit Card - Step 20: input payment information");
		checkoutPage.inputToTextBoxByID(driver, "CardholderName", "John Gacy");
		checkoutPage.inputToTextBoxByID(driver, "CardNumber", "5555555555");
		checkoutPage.selectDropdownByName(driver, "ExpireMonth", "02");
		checkoutPage.selectDropdownByName(driver, "ExpireYear", "2022");
		checkoutPage.inputToTextBoxByID(driver, "CardCode", "1111");
		
		log.info("Checkout Order With Credit Card - Step 21: click button 'Continue'");
		checkoutPage.clickToPaymentInformationContinueButton();
		
		log.info("Checkout Order With Credit Card - Step 22: verify Confirm Order");
		
		verifyEquals(checkoutPage.getBillingAddress(), 
				"john gacy" 
				+ "\nEmail: " + Common_01_Register.email 
				+ "\nPhone: 1234567890"
				+ "\nFax:\n"
				+ Common_01_Register.companyName
				+ "\n123 nguyen trai"
				+ "\nTPHCM,550000"
				+ "\nViet Nam");
		
		verifyEquals(checkoutPage.getShippingAddress(), 
				"john gacy" 
				+ "\nEmail: " + Common_01_Register.email 
				+ "\nPhone: 0987654321"
				+ "\nFax:\n"
				+ Common_01_Register.companyName
				+ "\n456 Hai Ba Trung"
				+ "\nHa Noi,700000"
				+ "\nViet Nam");
		
		verifyEquals(checkoutPage.getPaymentMethod(), "Credit Card");
		verifyEquals(checkoutPage.getShippingMethod(), "Ground");
		
		verifyEquals(checkoutPage.getGiftWrappingStatus(), "Gift wrapping: No");
		
		verifyEquals(checkoutPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "sku"), "LE_IC_600");
		verifyEquals(checkoutPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "unit-price"), "$500.00");
		verifyEquals(checkoutPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "quantity"), "1");
		verifyEquals(checkoutPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "subtotal"), "$500.00");

		log.info("Checkout Order With Credit Card - Step 23: click button 'Confirm'");
		sleepInMilisecond(10000);
		checkoutPage.clickToButtonByValue(driver, "Confirm");
		
		log.info("Checkout Order With Credit Card - Step 24: verify order complete");
		verifyTrue(checkoutPage.isOrderCompleteMessageDisplayed());
		verifyTrue(checkoutPage.isOrderNumberDisplayed());
		orderNumber = checkoutPage.getOrderNumber();
		System.out.println(orderNumber);
		
		log.info("Checkout Order With Credit Card - Step 25: navigate to My Account");
		checkoutPage.openLinkByPageName(driver, "My account");
		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);
		
		log.info("Checkout Order With Credit Card - Step 26: navigate to Orders");
		customerInforPage.openLinkByPageName(driver, "Orders");
		orderListPage = PageGeneratorManager.getUserOrderListPage(driver);
		
		log.info("Checkout Order With Credit Card - Step 27: verify Order " + orderNumber + " is displayed");
		verifyTrue(orderListPage.isOrderNumberDisplayedInOrderList(orderNumber));
		
		log.info("Checkout Order With Credit Card - Step 28: click Order " + orderNumber + " 'Details'");
		orderListPage.clickToDetailButtonByOrderNumber(orderNumber);
		orderDetailPage = PageGeneratorManager.getUserOrderDetailPage(driver);
		
		log.info("Checkout Order With Credit Card - Step 29: verify Order " + orderNumber + " information is displayed");
		verifyTrue(orderDetailPage.isOrderNumberIsDisplayed(orderNumber));
		//verifyEquals(orderDetailPage.getOrderDateSummary(), "Order Date: Tuesday, February 16, 2021");
		verifyEquals(orderDetailPage.getOrderStatusSummary(), "Order Status: Pending");
		verifyEquals(orderDetailPage.getOrderTotalSummary(), "Order Total: $500.00");
		
		verifyEquals(orderDetailPage.getBillingAddress(), 
				"john gacy" 
				+ "\nEmail: " + Common_01_Register.email 
				+ "\nPhone: 1234567890"
				+ "\nFax:\n"
				+ Common_01_Register.companyName
				+ "\n123 nguyen trai"
				+ "\nTPHCM,550000"
				+ "\nViet Nam");
		
		verifyEquals(orderDetailPage.getShippingAddress(), 
				"john gacy" 
				+ "\nEmail: " + Common_01_Register.email 
				+ "\nPhone: 0987654321"
				+ "\nFax:\n"
				+ Common_01_Register.companyName
				+ "\n456 Hai Ba Trung"
				+ "\nHa Noi,700000"
				+ "\nViet Nam");
		
		verifyEquals(orderDetailPage.getPaymentMethod(), "Credit Card");
		verifyEquals(orderDetailPage.getShippingMethod(), "Ground");
		
		verifyEquals(orderDetailPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "sku"), "LE_IC_600");
		verifyEquals(orderDetailPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "unit-price"), "$500.00");
		verifyEquals(orderDetailPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "quantity"), "1");
		verifyEquals(orderDetailPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "total"), "$500.00");
		
		verifyEquals(orderDetailPage.getGiftWrappingStatus(), "Gift wrapping: No");
		
		verifyEquals(orderDetailPage.getOrderSubtotal(), "$500.00");
		verifyEquals(orderDetailPage.getOrderShippingCost(), "$0.00");
		verifyEquals(orderDetailPage.getOrderTaxValue(), "$0.00");
		verifyEquals(orderDetailPage.getOrderTotal(), "$500.00");
		
	}
	
	@Test
	public void TC07_ReOrder() {
		
		log.info("Re Order - Step 25: navigate to My Account");
		orderDetailPage.openLinkByPageName(driver, "My account");
		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);
		
		log.info("Checkout Order With Credit Card - Step 26: navigate to Orders");
		customerInforPage.openLinkByPageName(driver, "Orders");
		orderListPage = PageGeneratorManager.getUserOrderListPage(driver);
		
		log.info("Checkout Order With Credit Card - Step 28: click Order " + orderNumber + " 'Details'");
		orderListPage.clickToDetailButtonByOrderNumber(orderNumber);
		orderDetailPage = PageGeneratorManager.getUserOrderDetailPage(driver);
		
		log.info("Re Order - Step 04: click button 'Re-order'");
		orderDetailPage.clickToButtonByValue(driver, "Re-order");
		shoppingCartPage = PageGeneratorManager.getUserShoppingCartPage(driver);
		
		log.info("Update Shopping Cart - Step 06: edit Quantity '10'");		
		shoppingCartPage.editProductQuantity("Lenovo IdeaCentre 600 All-in-One PC", "10");
		
		log.info("Update Shopping Cart - Step 07: click button 'Update'");
		shoppingCartPage.clickToUpdateShoppingCartButton();
		
		log.info("Update Shopping Cart - Step 08: verify total price is $5,000.00'");
		verifyEquals(shoppingCartPage.getProductTotalPrice("Lenovo IdeaCentre 600 All-in-One PC"), "$5,000.00");
		
		log.info("Checkout Order - Step 06: click checkbox 'Term of service'");
		shoppingCartPage.clickToCheckboxByID(driver, "termsofservice");
		
		log.info("Checkout Order - Step 07: click button 'Checkout'");
		shoppingCartPage.clickToButtonByCheckout();
		checkoutPage = PageGeneratorManager.getUserCheckoutPage(driver);
		
		log.info("Checkout Order - Step 08: click to uncheck 'Ship to the same address'");
		checkoutPage.clickToUncheckboxByID(driver, "ShipToSameAddress");
		
		log.info("Checkout Order With Credit Card - Step 12: select dropdown 'New Address'");
		checkoutPage.selectDropdownByName(driver, "billing_address_id", "New Address");
		
		log.info("Checkout Order - Step 09: input billing address information");
		checkoutPage.selectDropdownByName(driver, "BillingNewAddress.CountryId", "Viet Nam");
		checkoutPage.inputToTextBoxByID(driver, "BillingNewAddress_City", "TPHCM");
		checkoutPage.inputToTextBoxByID(driver, "BillingNewAddress_Address1", "123123 nguyen trai");
		checkoutPage.inputToTextBoxByID(driver, "BillingNewAddress_ZipPostalCode", "550000");
		checkoutPage.inputToTextBoxByID(driver, "BillingNewAddress_PhoneNumber", "1234567890");
		
		log.info("Checkout Order - Step 10: click button 'Continue'");
		checkoutPage.clickToBillingAddressContinueButton();

		log.info("Checkout Order - Step 11: select dropdown 'New Address'");
		checkoutPage.selectDropdownByName(driver, "shipping_address_id", "New Address");
		
		log.info("Checkout Order - Step 12: input shipping address information");
		checkoutPage.selectDropdownByName(driver, "ShippingNewAddress.CountryId", "Viet Nam");
		checkoutPage.inputToTextBoxByID(driver, "ShippingNewAddress_City", "Ha Noi");
		checkoutPage.inputToTextBoxByID(driver, "ShippingNewAddress_Address1", "456456 Hai Ba Trung");
		checkoutPage.inputToTextBoxByID(driver, "ShippingNewAddress_ZipPostalCode", "700000");
		checkoutPage.inputToTextBoxByID(driver, "ShippingNewAddress_PhoneNumber", "0987654321");
		
		log.info("Checkout Order - Step 13: click button 'Continue'");
		checkoutPage.clickToShippingAddressContinueButton();
		
		log.info("Checkout Order - Step 14: choose 'Next Air Day' and click button 'Continue'");
		checkoutPage.clickToRadioButtonByID(driver, "shippingoption_1");
		checkoutPage.clickToShippingMethodContinueButton();
		
		log.info("Checkout Order - Step 15: click button 'Continue'");
		checkoutPage.clickToPaymentMethodContinueButton();
		
		log.info("Checkout Order - Step 16: verify payment info");
		verifyEquals(checkoutPage.getPaymentInfo(), "Mail Personal or Business Check, Cashier's Check or money order to:\n\nNOP SOLUTIONS\nyour address here,\nNew York, NY 10001\nUSA\nNotice that if you pay by Personal or Business Check, your order may be held for up to 10 days after we receive your check to allow enough time for the check to clear. If you want us to ship faster upon receipt of your payment, then we recommend your send a money order or Cashier's check.\nP.S. You can edit this text from admin panel.");
		
		log.info("Checkout Order - Step 17: click button 'Continue'");
		checkoutPage.clickToPaymentInformationContinueButton();
		
		log.info("Checkout Order - Step 18: verify Confirm Order");
		
		verifyEquals(checkoutPage.getBillingAddress(), 
				"john gacy" 
				+ "\nEmail: " + Common_01_Register.email 
				+ "\nPhone: 1234567890"
				+ "\nFax:\n"
				+ Common_01_Register.companyName
				+ "\n123123 nguyen trai"
				+ "\nTPHCM,550000"
				+ "\nViet Nam");
		
		verifyEquals(checkoutPage.getShippingAddress(), 
				"john gacy" 
				+ "\nEmail: " + Common_01_Register.email 
				+ "\nPhone: 0987654321"
				+ "\nFax:\n"
				+ Common_01_Register.companyName
				+ "\n456456 Hai Ba Trung"
				+ "\nHa Noi,700000"
				+ "\nViet Nam");
		
		verifyEquals(checkoutPage.getPaymentMethod(), "Check / Money Order");
		verifyEquals(checkoutPage.getShippingMethod(), "Next Day Air");
		
		verifyEquals(checkoutPage.getGiftWrappingStatus(), "Gift wrapping: No");
		
		verifyEquals(checkoutPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "sku"), "LE_IC_600");
		verifyEquals(checkoutPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "unit-price"), "$500.00");
		verifyEquals(checkoutPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "quantity"), "10");
		verifyEquals(checkoutPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "subtotal"), "$5,000.00");

		log.info("Checkout Order - Step 19: wait 15s then click button 'Confirm'");
		sleepInMilisecond(15000);
		checkoutPage.clickToButtonByValue(driver, "Confirm");
		
		log.info("Checkout Order - Step 20: verify order complete");
		verifyTrue(checkoutPage.isOrderCompleteMessageDisplayed());
		verifyTrue(checkoutPage.isOrderNumberDisplayed());
		orderNumber = checkoutPage.getOrderNumber();
		System.out.println(orderNumber);
		
		log.info("Checkout Order - Step 21: navigate to My Account");
		checkoutPage.openLinkByPageName(driver, "My account");
		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);
		
		log.info("Checkout Order - Step 22: navigate to Orders");
		customerInforPage.openLinkByPageName(driver, "Orders");
		orderListPage = PageGeneratorManager.getUserOrderListPage(driver);
		
		log.info("Checkout Order - Step 22: verify Order " + orderNumber + " is displayed");
		verifyTrue(orderListPage.isOrderNumberDisplayedInOrderList(orderNumber));
		
		log.info("Checkout Order - Step 22: click Order " + orderNumber + " 'Details'");
		orderListPage.clickToDetailButtonByOrderNumber(orderNumber);
		orderDetailPage = PageGeneratorManager.getUserOrderDetailPage(driver);
		
		log.info("Checkout Order - Step 23: verify Order " + orderNumber + " information is displayed");
		verifyTrue(orderDetailPage.isOrderNumberIsDisplayed(orderNumber));
		//verifyEquals(orderDetailPage.getOrderDateSummary(), "Order Date: Tuesday, February 16, 2021");
		verifyEquals(orderDetailPage.getOrderStatusSummary(), "Order Status: Pending");
		verifyEquals(orderDetailPage.getOrderTotalSummary(), "Order Total: $5,000.00");
		
		verifyEquals(orderDetailPage.getBillingAddress(), 
				"john gacy" 
				+ "\nEmail: " + Common_01_Register.email 
				+ "\nPhone: 1234567890"
				+ "\nFax:\n"
				+ Common_01_Register.companyName
				+ "\n123123 nguyen trai"
				+ "\nTPHCM,550000"
				+ "\nViet Nam");
		
		verifyEquals(orderDetailPage.getShippingAddress(), 
				"john gacy" 
				+ "\nEmail: " + Common_01_Register.email 
				+ "\nPhone: 0987654321"
				+ "\nFax:\n"
				+ Common_01_Register.companyName
				+ "\n456456 Hai Ba Trung"
				+ "\nHa Noi,700000"
				+ "\nViet Nam");
		
		verifyEquals(orderDetailPage.getPaymentMethod(), "Check / Money Order");
		verifyEquals(orderDetailPage.getShippingMethod(), "Next Day Air");
		
		verifyEquals(orderDetailPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "sku"), "LE_IC_600");
		verifyEquals(orderDetailPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "unit-price"), "$500.00");
		verifyEquals(orderDetailPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "quantity"), "10");
		verifyEquals(orderDetailPage.getProductInfoByNameAndAttribute("Lenovo IdeaCentre 600 All-in-One PC", "total"), "$5,000.00");
		
		verifyEquals(orderDetailPage.getGiftWrappingStatus(), "Gift wrapping: No");
		
		verifyEquals(orderDetailPage.getOrderSubtotal(), "$5,000.00");
		verifyEquals(orderDetailPage.getOrderShippingCost(), "$0.00");
		verifyEquals(orderDetailPage.getOrderTaxValue(), "$0.00");
		verifyEquals(orderDetailPage.getOrderTotal(), "$5,000.00");
		
		
		
	}
	
	
	
	@AfterClass
	public void afterClass() {
		//closeBrowserAndDriver(driver);
	}


}
