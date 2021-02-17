package pageUIs;

public class UserWishListPageUI {

	public static final String TOP_MESSAGE = "//div[@class='bar-notification success']/p";
	
	public static final String WISHLIST_LINK = "//span[text()='Wishlist']";
	public static final String DYNAMIC_PRODUCT = "//td[@class='product']/a[text()='%s']";
	
	public static final String URL_WISHLIST = "//a[@class='share-link']";
	public static final String NAME_WISHLIST = "//div[@class='page-title']/h1";
	
	public static final String ADD_TO_CART_CHECKBOX = "//label[text()='Add to cart:']//following-sibling::input";
	public static final String REMOVE_CHECKBOX = "//label[text()='Remove:']//following-sibling::input";
	
	public static final String WISHLIST_MESSAGE = "//div[@class='page-body']/div";
}
