package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import pageUIs.UserComputersPageUI;

public class UserComputersPageObject extends AbstractPage {
	WebDriver driver;

	public UserComputersPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToNotebooksSubmenu() {
		waitToElementClickable(driver, UserComputersPageUI.NOTEBOOKS_LINK);
		clickToElement(driver, UserComputersPageUI.NOTEBOOKS_LINK);
	}

	public boolean isProductNameSortedAscending() {
		waitAjaxLoadingInvisible(driver);
		waitToElementVisible(driver, UserComputersPageUI.PRODUCT_TITLE);
		return isDataStringSortedAscending(driver, UserComputersPageUI.PRODUCT_TITLE);
	}

	public boolean isProductNameSortedDescending() {
		waitAjaxLoadingInvisible(driver);
		waitToElementVisible(driver, UserComputersPageUI.PRODUCT_TITLE);
		return isDataStringSortedDescending(driver, UserComputersPageUI.PRODUCT_TITLE);
	}

	public boolean isProductPriceSortedAscending() {
		waitAjaxLoadingInvisible(driver);
		waitToElementVisible(driver, UserComputersPageUI.PRODUCT_PRICE);
		return isDataFloatSortedAscending(driver, UserComputersPageUI.PRODUCT_PRICE);
	}

	public boolean isProductPriceSortedDescending() {
		waitAjaxLoadingInvisible(driver);
		waitToElementVisible(driver, UserComputersPageUI.PRODUCT_PRICE);
		return isDataFloatSortedDescending(driver, UserComputersPageUI.PRODUCT_PRICE);
	}

	public boolean areThereThreeOrLessProductsOnPage() {
		waitAjaxLoadingInvisible(driver);
		waitToElementVisible(driver, UserComputersPageUI.PRODUCT_TITLE);
		
		List<WebElement> productName = driver.findElements(By.xpath(UserComputersPageUI.PRODUCT_TITLE));
		
		if(productName.size() <= 3) {
			return true;
		}
		return false;
	}

	public boolean areThereSixOrLessProductsOnPage() {
		waitAjaxLoadingInvisible(driver);
		waitToElementVisible(driver, UserComputersPageUI.PRODUCT_TITLE);
		
		List<WebElement> productName = driver.findElements(By.xpath(UserComputersPageUI.PRODUCT_TITLE));
		
		if(productName.size() <= 6) {
			return true;
		}
		return false;
	}

	public boolean areThereNineOrLessProductsOnPage() {
		waitAjaxLoadingInvisible(driver);
		waitToElementVisible(driver, UserComputersPageUI.PRODUCT_TITLE);
		
		List<WebElement> productName = driver.findElements(By.xpath(UserComputersPageUI.PRODUCT_TITLE));
		
		if(productName.size() <= 9) {
			return true;
		}
		return false;
	}
	
	public boolean isCurrentPage1() {
		waitAjaxLoadingInvisible(driver);
		waitToElementVisible(driver, UserComputersPageUI.CURRENT_PAGE);
		
		String currentPage = getElementText(driver, UserComputersPageUI.CURRENT_PAGE);
		
		if(currentPage.equals("1")) {
			return true;
		}
		return false;
	}

	public boolean isCurrentPage2() {
		waitAjaxLoadingInvisible(driver);
		waitToElementVisible(driver, UserComputersPageUI.CURRENT_PAGE);
		
		String currentPage = getElementText(driver, UserComputersPageUI.CURRENT_PAGE);
		
		if(currentPage.equals("2")) {
			return true;
		}
		return false;
	}

	public boolean isNextIconDisplayed() {
		waitAjaxLoadingInvisible(driver);
		return isElementDisplayed(driver, UserComputersPageUI.NEXT_PAGE);
	}

	public boolean isPreviousIconDisplayed() {
		waitAjaxLoadingInvisible(driver);
		return isElementDisplayed(driver, UserComputersPageUI.PREVIOUS_PAGE);
	}

	public void clickToNextIcon() {
		waitToElementClickable(driver, UserComputersPageUI.NEXT_PAGE);
		clickToElement(driver, UserComputersPageUI.NEXT_PAGE);
	}


}
		