package pageUIs;

public class UserSearchPageUI {

	public static final String SEARCH_TEXTBOX = "//input[@class='search-text']";
	public static final String SEARCH_WARNING = "//div[@class='search-results']/div";
	public static final String SEARCH_BUTTON = "//input[@class='button-1 search-button']";
	public static final String ADVANCED_SEARCH_CHECKBOX = "//label[text()='Advanced search']//preceding-sibling::input";
	public static final String SEARCH_SUB_CATEGORIES_CHECKBOX = "//label[text()='Automatically search sub categories']//preceding-sibling::input";
	public static final String CATEGORY_DROPDOWN = "//label[text()='Category:']/following-sibling::select";
	
	public static final String NUMBER_OF_PRODUCT = "//h2[@class='product-title']";
	
	public static final String PRICE_RANGE_FROM_TEXTBOX = "//input[@class='price-from']";
	public static final String PRICE_RANGE_TO_TEXTBOX = "//input[@class='price-to']";
	
}
