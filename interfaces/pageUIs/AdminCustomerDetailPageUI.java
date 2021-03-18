package pageUIs;

public class AdminCustomerDetailPageUI {

	public static final String SAVE_AND_CONTINUE_CUSTOMER_BUTTON = "//button[@name='save-continue']";
	public static final String SAVE_CUSTOMER_BUTTON = "//button[@name='save']";

	public static final String DYNAMIC_REMOVE_CUSTOMER_ROLE = "//span[text()='%s']/following-sibling::span[@title='delete']";
	public static final String CUSTOMER_ROLE = "//ul[@id='SelectedCustomerRoleIds_taglist']/parent::div";
	public static final String CUSTOMER_ROLE_OPTIONS = "//ul[@id='SelectedCustomerRoleIds_listbox']/li";

	public static final String ACTIVE_CHECKBOX = "//input[@id='Active']";
	public static final String ADMIN_COMMENT = "//textarea[@id='AdminComment']";

	public static final String BACK_TO_CUSTOMER_LIST = "//a[text()='back to customer list']";

	public static final String ADDRESS_SECTION = "//span[text()='Addresses']";
	public static final String ADDRESS_SECTION_PLUS_SIGN = "//span[text()='Addresses']/preceding-sibling::div/following-sibling::i[contains(@class, 'plus')]";
	public static final String ADD_NEW_ADDRESS_BUTTON = "//button[contains(text(), 'Add new address')]";
	public static final String SAVE_ADDRESS_BUTTON = "//button[contains(text(), 'Save')]";

	public static final String BACK_TO_CUSTOMER_DETAIL = "//a[text()='back to customer details']";
	public static final String ADDRESS_ROW = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/div";
	public static final String ADDRESS_ROW_EDIT_BUTTON = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/a[text()='Edit']";
	public static final String ADDRESS_ROW_DELETE_BUTTON = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/a[text()='Delete']";
	public static final String SAVE_EDITED_ADDRESS_BUTTON = "//button[@name='save']";

	public static final String TABLE_EMPTY_ALERT = "//div[@id='customer-address']//tbody//td[@class='dataTables_empty']";
	
}
