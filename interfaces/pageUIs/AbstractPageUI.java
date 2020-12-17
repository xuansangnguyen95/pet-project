package pageUIs;

public class AbstractPageUI {
	public static final String SEARCH_LINK = "//ul[@class='list']//a[text()='Search']";
	public static final String SHIPPING_AND_RETURN_LINK = "//ul[@class='list']//a[text()='Shipping & returns']";
	public static final String SITEMAP_LINK = "//ul[@class='list']//a[text()='Sitemap']";
	public static final String MY_ACCOUNT_LINK = "//ul[@class='list']//a[text()='My account']";
	public static final String WISH_LIST_LINK = "//div[@class='header-links']//span[text()='Wishlist']";
	public static final String HOMEPAGE_LINK = "//img[@alt='nopCommerce demo store']";
	
	public static final String DYNAMIC_LINK = "//ul[@class='list']//a[text()='%s']";
	public static final String UPLOAD_FILE_TYPE_BY_PANEL = "//div[@id='%s']//input[@type='file']";
	
	public static final String DYNAMIC_RADIO_BUTTON_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_VALUE = "//input[@value='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "//select[@name='%s']";
}
