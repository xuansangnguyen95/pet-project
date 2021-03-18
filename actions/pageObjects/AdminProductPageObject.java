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

	public void inputToProductNameTextbox(String productName) {
		waitToElementVisible(driver, AdminProductPageUI.PRODUCT_NAME_TEXTBOX);
		sendKeysToElement(driver, AdminProductPageUI.PRODUCT_NAME_TEXTBOX, productName);
	}

	public void clickToSearchButton() {
		waitToElementClickable(driver, AdminProductPageUI.SEARCH_PRODUCT_BUTTON);
		clickToElement(driver, AdminProductPageUI.SEARCH_PRODUCT_BUTTON);
		waitAjaxLoadingInvisible();
	}

	public void scrollToPicturePane() {
		scrollToElement(driver, AdminProductPageUI.PICTURE_PANEL);
		clickToElement(driver, AdminProductPageUI.PICTURE_PANEL);
	}

	public void inputToAltTextbox(String imageDescription) {
		waitToElementVisible(driver, AdminProductPageUI.ALT_TEXTBOX);
		sendKeysToElement(driver, AdminProductPageUI.ALT_TEXTBOX, imageDescription);
	}

	public void inputToTitleTextbox(String imageTitle) {
		waitToElementVisible(driver, AdminProductPageUI.TITLE_TEXTBOX);
		sendKeysToElement(driver, AdminProductPageUI.TITLE_TEXTBOX, imageTitle);
	}

	public void clickUpArrowInOrderTextbox(String imageOrder) {
		waitToElementClickable(driver, AdminProductPageUI.UP_ARROW_IN_ORDER_TEXTBOX);
		clickToElement(driver, AdminProductPageUI.UP_ARROW_IN_ORDER_TEXTBOX);
	}

	public void clickToAddProductPictureButton() {
		waitToElementClickable(driver, AdminProductPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		clickToElement(driver, AdminProductPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		waitAjaxLoadingInvisible();
	}

	public boolean areImageDetailsDisplayed(String productName, String pictureOrder, String pictureAlt, String pictureTitle) {
		waitToElementVisible(driver, AdminProductPageUI.UPLOADED_PICTURE_DETAIL, productName, pictureOrder, pictureAlt, pictureTitle);
		return isElementDisplayed(driver, AdminProductPageUI.UPLOADED_PICTURE_DETAIL, productName, pictureOrder, pictureAlt, pictureTitle);
	}

	public void clickToSaveButton() {
		waitToElementClickable(driver, AdminProductPageUI.SAVE_BUTTON);
		clickToElement(driver, AdminProductPageUI.SAVE_BUTTON);
		waitAjaxLoadingInvisible();
	}

	public boolean areProductDisplayed(String pictureName, String productName, String productSKU, String productPrice, String productQuantity, String productType, String productPublishStatus) {
		waitToElementVisible(driver, AdminProductPageUI.PRODUCT_DETAIL, pictureName, productName, productSKU, productPrice, productQuantity, productType, productPublishStatus);
		return isElementDisplayed(driver, AdminProductPageUI.PRODUCT_DETAIL, pictureName, productName, productSKU, productPrice, productQuantity, productType, productPublishStatus);
	}

	public void clickToDeleteButtonByPictureName(String pictureTitle) {
		waitToElementClickable(driver, AdminProductPageUI.DELETE_BUTTON_BY_PRODUCT_TITLE, pictureTitle);
		clickToElement(driver, AdminProductPageUI.DELETE_BUTTON_BY_PRODUCT_TITLE, pictureTitle);
		waitAlertPresence(driver);
		acceptAlert(driver);
		waitAjaxLoadingInvisible();
	}

	public boolean isNewPictureUploadSuccess(String fileNames) {
		waitToElementInvisible(driver, AdminProductPageUI.SPINNER_UPLOAD);
		return isElementDisplayed(driver, AdminProductPageUI.FILENAME_UPLOAD, fileNames);
	}

	public String getNumberOfProduct() {
		waitAjaxLoadingInvisible(driver);
		waitToElementVisible(driver, AdminProductPageUI.NUMBER_OF_PRODUCT);
		return getElementText(driver, AdminProductPageUI.NUMBER_OF_PRODUCT);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
