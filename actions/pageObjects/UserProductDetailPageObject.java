package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.UserAddressesPageUI;
import pageUIs.UserChangePasswordPageUI;
import pageUIs.UserProductDetailPageUI;
import pageUIs.UserWishListPageUI;

public class UserProductDetailPageObject extends AbstractPage {
	WebDriver driver;

	public UserProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddReviewLink() {
		waitToElementClickable(driver, UserProductDetailPageUI.ADD_REVIEW_LINK);
		clickToElement(driver, UserProductDetailPageUI.ADD_REVIEW_LINK);
	}

	public String getTopMessage() {
		waitToElementVisible(driver, UserProductDetailPageUI.TOP_MESSAGE);
		return getElementText(driver, UserProductDetailPageUI.TOP_MESSAGE);
	}

	public void clickToWishlistLink() {
		waitToElementInvisible(driver, UserWishListPageUI.TOP_MESSAGE);
		waitToElementClickable(driver, UserWishListPageUI.WISHLIST_LINK);
		clickToElement(driver, UserWishListPageUI.WISHLIST_LINK);
	}

	public void hoverMouseToShoppingCart() {
		waitToElementClickable(driver, UserProductDetailPageUI.TOP_MESSAGE_CLOSE_BUTTON);
		clickToElement(driver, UserProductDetailPageUI.TOP_MESSAGE_CLOSE_BUTTON);
		
		scrollToElement(driver, UserProductDetailPageUI.SHOPPING_CART);
		
		waitToElementVisible(driver, UserProductDetailPageUI.SHOPPING_CART);
		hoverMouseToElement(driver, UserProductDetailPageUI.SHOPPING_CART);
	}

	public String getCartQuantity() {
		waitToElementVisible(driver, UserProductDetailPageUI.SHOPPING_CART_QUANTITY);
		return getElementText(driver, UserProductDetailPageUI.SHOPPING_CART_QUANTITY);
	}

	public String getCartProductDetail(String productDetailOption) {
		waitToElementVisible(driver, UserProductDetailPageUI.DYNAMIC_CART_PRODUCT_DETAIL, productDetailOption);
		return getElementText(driver, UserProductDetailPageUI.DYNAMIC_CART_PRODUCT_DETAIL, productDetailOption);
	}

	public void clickToShoppingCart() {
		waitToElementClickable(driver, UserProductDetailPageUI.SHOPPING_CART);
		clickToElement(driver, UserProductDetailPageUI.SHOPPING_CART);
	}

	public String getProductPrice() {
		waitToElementVisible(driver, UserProductDetailPageUI.PRODUCT_PRICE);
		sleepInMilisecond(3000);
		return getElementText(driver, UserProductDetailPageUI.PRODUCT_PRICE);
	}
	
	
	


}
