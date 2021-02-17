package pageUIs;

public class UserCheckoutPageUI {

	public static final String BILLING_ADDRESS_CONTINUE_BUTTON = "//input[@onclick='Billing.save()']";
	public static final String SHIPPING_ADDRESS_CONTINUE_BUTTON = "//input[@onclick='Shipping.save()']";
	public static final String SHIPPING_METHOD_CONTINUE_BUTTON = "//input[@onclick='ShippingMethod.save()']";
	public static final String PAYMENT_METHOD_CONTINUE_BUTTON = "//input[@onclick='PaymentMethod.save()']";
	public static final String PAYMENT_INFO_CONTINUE_BUTTON = "//input[@onclick='PaymentInfo.save()']";
	
	public static final String PAYMENT_INFO = "//div[@class='section payment-info']//td";
	
	public static final String PAYMENT_METHOD = "//li[@class='payment-method']/span[@class='value']";
	public static final String SHIPPING_METHOD = "//li[@class='shipping-method']/span[@class='value']";
	
	public static final String BILLING_ADDRESS = "//div[@class='billing-info']/ul";
	public static final String SHIPPING_ADDRESS = "//div[@class='shipping-info']/ul";
	
	public static final String DYNAMIC_PRODUCT_CHECKOUT_INFO = "//a[text()='%s']/parent::td/parent::tr/td[@class='%s']/span";
	public static final String PRODUCT_NAME = "//td[@class='product']/a";
	
	public static final String GIFT_WRAPPING_STATUS = "//div[@class='cart-options']/div";
	
	public static final String ORDER_SUBTOTAL = "//tr[@class='order-subtotal']/td[@class='cart-total-right']/span";
	public static final String SHIPPING_COST = "//tr[@class='shipping-cost']/td[@class='cart-total-right']/span";
	public static final String TAX_VALUE = "//tr[@class='tax-value']/td[@class='cart-total-right']/span";
	public static final String ORDER_TOTAL = "//tr[@class='order-total']/td[@class='cart-total-right']/span";

	public static final String ORDER_COMPLETE_MESSAGE = "//div[@class='section order-completed']//strong";
	public static final String ORDER_NUMBER = "//div[@class='order-number']//strong";








}
