package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.UserAddressesPageUI;
import pageUIs.UserChangePasswordPageUI;
import pageUIs.UserMyProductReviewPageUI;

public class UserMyProductReviewPageObject extends AbstractPage {
	WebDriver driver;

	public UserMyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isReviewTitleVisible(String reviewTitle) {
		return isElementDisplayed(driver, UserMyProductReviewPageUI.DYMAMIC_PRODUCT_REVIEW_TITLE, reviewTitle);
	}
	
	


}
