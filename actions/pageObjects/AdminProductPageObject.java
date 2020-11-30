package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.AbstractPage;
import pageUIs.AdminProductPageUI;

public class AdminProductPageObject extends AbstractPage {
	WebDriver driver;

	public AdminProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void goToPageAtTableByIndex(String indexPage) {
		waitToElementClickable(driver, AdminProductPageUI.PAGING_AT_TABLE_BY_INDEX, indexPage);
		clickToElement(driver, AdminProductPageUI.PAGING_AT_TABLE_BY_INDEX, indexPage);
	}

	public boolean isPageActiveAtTableByIndex(String indexPage) {
		waitToElementVisible(driver, AdminProductPageUI.PAGING_AT_TABLE_ACTIVE_BY_INDEX, indexPage);
		return isElementDisplayed(driver, AdminProductPageUI.PAGING_AT_TABLE_ACTIVE_BY_INDEX, indexPage);
	}

	public void checkToSelectAllCheckbox() {
		waitToElementClickable(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		checkToCheckbox(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
	}

	public void checkToDeselectAllCheckbox() {
		waitToElementClickable(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		uncheckToCheckbox(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
	}
	
	public void allProductCheckboxesChecked() {
		List<WebElement> allProductCheckboxes = getElements(driver, AdminProductPageUI.ALL_PRODUCT_CHECKBOX);
		for(WebElement productCheckbox : allProductCheckboxes) {
			Assert.assertTrue(productCheckbox.isSelected());
		}
	}

	public void allProductCheckboxesUnchecked() {
		List<WebElement> allProductCheckboxes = getElements(driver, AdminProductPageUI.ALL_PRODUCT_CHECKBOX);
		for(WebElement productCheckbox : allProductCheckboxes) {
			Assert.assertFalse(productCheckbox.isSelected());
		}
	}

	public void checkToProductCheckboxByName(String productName) {
		waitToElementClickable(driver, AdminProductPageUI.PRODUCT_CHECKBOX_BY_NAME, productName);
		checkToCheckbox(driver, AdminProductPageUI.PRODUCT_CHECKBOX_BY_NAME, productName);
	}

	public void waitAjaxLoadingInvisible() {
		waitToElementInvisible(driver, AdminProductPageUI.LOADING_ICON);
	}

	public boolean areProductDetailDisplayed(String productName, String skuID, String price, String quantity,
			String productType, String publishStatus) {
		waitToElementVisible(driver, AdminProductPageUI.PRODUCT_DETAIL_IN_TABLE, productName, skuID, price, quantity, productType, publishStatus);
		return isElementDisplayed(driver, AdminProductPageUI.PRODUCT_DETAIL_IN_TABLE, productName, skuID, price, quantity, productType, publishStatus);
	}

	public void selectShowItemDropdown(String itemNumber) {
		waitToElementClickable(driver, AdminProductPageUI.NUMBER_ITEM_DROPDOWN);
		selectItemInDropdown(driver, AdminProductPageUI.NUMBER_ITEM_DROPDOWN, itemNumber);
	}

	public boolean isInformationDisplayedAtColumnNameAndRowNumber(String columnName, String rowIndex, String expectedValue) {
		int columnNameIndex = countElementSize(driver, AdminProductPageUI.COLUMN_NAME_SIBLING, columnName) + 1;
		String actualValue = getElementText(driver, AdminProductPageUI.CELL_VALUE_BY_COLUMN_AND_ROW, rowIndex, String.valueOf(columnNameIndex));
		return actualValue.equals(expectedValue);
	}

	public boolean isPublishStatusAtColumnNameAndRowNumber(String columnName, String rowIndex, String publishStatus) {
		int columnNameIndex = countElementSize(driver, AdminProductPageUI.COLUMN_NAME_SIBLING, columnName) + 1;
		return isElementDisplayed(driver, AdminProductPageUI.PUBLISH_STATUS_BY_COLUMN_AND_ROW, rowIndex, String.valueOf(columnNameIndex), publishStatus);
	}

	public void clickToEditProductDetail(String productName) {
		waitToElementClickable(driver, AdminProductPageUI.EDIT_ICON, productName);
		clickToElement(driver, AdminProductPageUI.EDIT_ICON, productName);
		waitAjaxLoadingInvisible();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
