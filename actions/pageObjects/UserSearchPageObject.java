package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.UserSearchPageUI;

public class UserSearchPageObject extends AbstractPage {
	WebDriver driver;

	public UserSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getSearchWarningText() {
		waitToElementVisible(driver, UserSearchPageUI.SEARCH_WARNING);
		return getElementText(driver, UserSearchPageUI.SEARCH_WARNING);
	}

	public void inputToSearchTextbox(String value) {
		waitToElementVisible(driver, UserSearchPageUI.SEARCH_TEXTBOX);
		sendKeysToElement(driver, UserSearchPageUI.SEARCH_TEXTBOX, value);
	}

	public int getNumberOfProduct() {
		waitToElementVisible(driver, UserSearchPageUI.NUMBER_OF_PRODUCT);
		return countElementSize(driver, UserSearchPageUI.NUMBER_OF_PRODUCT);
	}

	public void clickToSearchButton() {
		waitToElementClickable(driver, UserSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, UserSearchPageUI.SEARCH_BUTTON);
		
	}

	public void checkToAdvancedSearch() {
		waitToElementClickable(driver, UserSearchPageUI.ADVANCED_SEARCH_CHECKBOX);
		checkToCheckbox(driver, UserSearchPageUI.ADVANCED_SEARCH_CHECKBOX);
	}

	public void checkToSubCategoriesSearch() {
		waitToElementClickable(driver, UserSearchPageUI.SEARCH_SUB_CATEGORIES_CHECKBOX);
		checkToCheckbox(driver, UserSearchPageUI.SEARCH_SUB_CATEGORIES_CHECKBOX);
	}

	public void selectPriceRangeFrom(String price) {
		waitToElementVisible(driver, UserSearchPageUI.PRICE_RANGE_FROM_TEXTBOX);
		sendKeysToElement(driver, UserSearchPageUI.PRICE_RANGE_FROM_TEXTBOX, price);
	}

	public void selectPriceRangeTo(String price) {
		waitToElementVisible(driver, UserSearchPageUI.PRICE_RANGE_TO_TEXTBOX);
		sendKeysToElement(driver, UserSearchPageUI.PRICE_RANGE_TO_TEXTBOX, price);
	}

}
		