package pageUIs;

public class AdminProductPageUI {
	public static final String PAGING_AT_TABLE_BY_INDEX = "//li[@class='paginate_button ']/a[text()='%s']";
	public static final String PAGING_AT_TABLE_ACTIVE_BY_INDEX = "//li[@class='paginate_button active']/a[text()='%s']";
	
	public static final String SELECT_ALL_CHECKBOX = "//th/input[@id='mastercheckbox']";
	public static final String ALL_PRODUCT_CHECKBOX = "//input[@name='checkbox_products']";
	public static final String PRODUCT_CHECKBOX_BY_NAME = "//td[text()='%s']/preceding::td/input";
	public static final String PRODUCT_TABLE_ROW = "//table[@id='products-grid']/tbody/tr";
	public static final String NUMBER_ITEM_DROPDOWN = "//select[@name='products-grid_length']";
	public static final String LOADING_ICON = "//div[@id='ajaxBusy']/span";
	public static final String PRODUCT_DETAIL_IN_TABLE = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/i[contains(@class,'%s-icon')]";
	
	public static final String COLUMN_NAME_SIBLING = "//th[text()='%s']/preceding-sibling::th";
	public static final String CELL_VALUE_BY_COLUMN_AND_ROW = "//tr[%s]/td[%s]";
	public static final String PUBLISH_STATUS_BY_COLUMN_AND_ROW = "//tr[%s]/td[%s]/i";
	public static final String EDIT_ICON = "//td[text()='%s']/following-sibling::td/a";
	
	public static final String PRODUCT_NAME_TEXTBOX = "//input[@id='SearchProductName']";
	public static final String SEARCH_PRODUCT_BUTTON = "//button[@id='search-products']";
	public static final String PICTURE_PANEL = "//div[@id='product-pictures']";
	
}