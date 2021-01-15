package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.UserAddressesPageUI;
import pageUIs.UserChangePasswordPageUI;
import pageUIs.UserProductDetailPageUI;

public class UserProductDetailPageObject extends AbstractPage {
	WebDriver driver;

	public UserProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddReviewLink() {
		waitToElementClickable(driver, UserProductDetailPageUI.ADD_REVIEW_LINK);
		clickToElement(driver, UserProductDetailPageUI.ADD_REVIEW_LINK);
	}
	
	


}
