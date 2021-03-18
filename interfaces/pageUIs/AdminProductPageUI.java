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
	
	public static final String SPINNER_UPLOAD = "//span[contains(@class, 'qq-upload-spinner')]";
	public static final String FILENAME_UPLOAD = "//span[contains(@class, 'qq-upload-file') and @title='%s']";
	
	public static final String ALT_TEXTBOX = "//input[@id='AddPictureModel_OverrideAltAttribute']";
	public static final String TITLE_TEXTBOX = "//input[@id='AddPictureModel_OverrideTitleAttribute']";
	public static final String UP_ARROW_IN_ORDER_TEXTBOX = "//input[@id='AddPictureModel_DisplayOrder']/following-sibling::span/span[@title='Increase value']";	
	
	public static final String ADD_PRODUCT_PICTURE_BUTTON = "//button[@id='addProductPicture']";	
	public static final String UPLOADED_PICTURE_DETAIL = "//a[contains(@href, '%s')]/parent::td[@data-columnname='PictureUrl']/following-sibling::td[@data-columnname='DisplayOrder' and text()='%s']/following-sibling::td[@data-columnname='OverrideAltAttribute' and text()='%s']/following-sibling::td[@data-columnname='OverrideTitleAttribute' and text()='%s']";	
	public static final String SAVE_BUTTON = "//button[@name='save']";	
	public static final String DELETE_BUTTON_BY_PRODUCT_TITLE = "//td[@data-columnname='OverrideTitleAttribute' and text()='%s']/following-sibling::td[@data-columnname='Id']//i[@class='fa fa-remove']";	
	public static final String PRODUCT_DETAIL = "//img[contains(@src, '%s')]/parent::td/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/i[contains(@class, '%s-icon')]";
	
	public static final String NUMBER_OF_PRODUCT = "//div[@id='products-grid_info']";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}