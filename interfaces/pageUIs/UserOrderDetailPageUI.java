package pageUIs;

public class UserOrderDetailPageUI {

	public static final String DYNAMIC_ORDER_NUMBER = "//div[@class='order-number']/strong[contains(text(),'%s')]";
	public static final String ORDER_DATE_SUMMARY = "//li[@class='order-date']";
	public static final String ORDER_STATUS_SUMMARY = "//li[@class='order-status']";
	public static final String ORDER_TOTAL_SUMMARY = "//li[@class='order-total']";
	
	public static final String ORDER_SUBTOTAL = "//label[text()='Sub-Total:']/ancestor::tr/td[@class='cart-total-right']/span";
	public static final String SHIPPING_COST = "//label[text()='Shipping:']/ancestor::tr/td[@class='cart-total-right']/span";
	public static final String TAX_VALUE = "//label[text()='Tax:']/ancestor::tr/td[@class='cart-total-right']/span";
	public static final String ORDER_TOTAL = "//label[text()='Order Total:']/ancestor::tr/td[@class='cart-total-right']/span";
	
	public static final String PAYMENT_METHOD = "//li[@class='payment-method']/span[@class='value']";
	public static final String SHIPPING_METHOD = "//li[@class='shipping-method']/span[@class='value']";
	
	public static final String BILLING_ADDRESS = "//div[@class='billing-info']/ul";
	public static final String SHIPPING_ADDRESS = "//div[@class='shipping-info']/ul";
	
	public static final String DYNAMIC_PRODUCT_CHECKOUT_INFO = "//a[text()='%s']/ancestor::td/parent::tr/td[@class='%s']/span";
	public static final String PRODUCT_NAME = "//td[@class='product']/a";
	
	public static final String GIFT_WRAPPING_STATUS = "//div[@class='section options']/div";
	
	
	
	
	
}
