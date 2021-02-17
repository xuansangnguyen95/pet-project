package pageUIs;

public class UserShoppingCartPageUI {

	public static final String EDIT_LINK = "//div[@class='edit-item']/a";
	
	public static final String DYNAMIC_PRODUCT = "//td[@class='product']/a[text()='%s']";
	
	public static final String DYNAMIC_PRODUCT_QUANTITY = "//a[text()='%s']/parent::td[@class='product']/following-sibling::td[@class='quantity']/input";
	public static final String DYNAMIC_REMOVE_CHECKBOX = "//a[text()='%s']/parent::td[@class='product']/preceding-sibling::td[@class='remove-from-cart']/input";
	public static final String DYNAMIC_PRODUCT_TOTAL_PRICE = "//a[text()='%s']/parent::td[@class='product']/following-sibling::td[@class='subtotal']/span";
	
	public static final String SHIPPING_OPTIONS_LOADING = "";
	
	public static final String UPDATE_SHOPPING_CART_BUTTON = "//input[@value='Update shopping cart']";
	public static final String ESTIMATE_SHIPPING_BUTTON = "//a[@id='open-estimate-shipping-popup']";
	public static final String CHECKOUT_BUTTON = "//button[@value='checkout']";
	
	
	public static final String ORDER_SUMMARY_MESSAGE = "//div[@class='order-summary-content']/div";
}
