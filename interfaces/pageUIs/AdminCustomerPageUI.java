package pageUIs;

public class AdminCustomerPageUI {

	public static final String ADD_NEW_BUTTON = "//a[@href='/Admin/Customer/Create']";

	public static final String DYNAMIC_REMOVE_CUSTOMER_ROLE = "//span[text()='%s']/following-sibling::span[@title='delete']";
	public static final String CUSTOMER_ROLE = "//ul[@id='SelectedCustomerRoleIds_taglist']/parent::div";
	public static final String CUSTOMER_ROLE_OPTIONS = "//ul[@id='SelectedCustomerRoleIds_listbox']/li";

	public static final String DYNAMIC_CUSTOMER_TABLE_ROW = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/i[@class='fa fa-check %s-icon']";
	public static final String DYNAMIC_CUSTOMER_EDIT_BUTTON = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/a[contains(@href, 'Edit')]";

	public static final String NUMBER_OF_CUSTOMER = "//div[@id='customers-grid_info']";



}
