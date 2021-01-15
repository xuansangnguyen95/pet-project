package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.UserAddressesPageUI;
import pageUIs.UserChangePasswordPageUI;
import pageUIs.UserProductDetailPageUI;
import pageUIs.UserProductReviewPageUI;

public class UserProductReviewPageObject extends AbstractPage {
	WebDriver driver;

	public UserProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToMyAccountLink() {
		waitToElementClickable(driver, UserProductReviewPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserProductReviewPageUI.MY_ACCOUNT_LINK);
	}

	public void inputToReviewTextArea(String reviewText) {
		waitToElementVisible(driver, UserProductReviewPageUI.REVIEW_TEXT_AREA);
		sendKeysToElement(driver, UserProductReviewPageUI.REVIEW_TEXT_AREA, reviewText);
	}
	
	


}
