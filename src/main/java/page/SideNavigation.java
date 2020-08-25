package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SideNavigation {
	
	WebDriver driver;

	// Every Page must have a constructor to invite the driver
	public SideNavigation(WebDriver driver) {
		this.driver = driver;
	}

//	Bank&Cash    //span[text()='Bank & Cash']
//	New Account  linkText    New Account
//	List Account LinkText  List Accounts
	
	// Element Library
	@FindBy(how = How.XPATH, using = "//span[text()='Bank & Cash']")
	WebElement BankCashModule;
	@FindBy(how = How.LINK_TEXT, using = "New Account")
	WebElement NewAccountPage;
	@FindBy(how = How.LINK_TEXT, using = "List Accounts")
	WebElement ListAccountPage;
	
	
	@FindBy(how = How.XPATH, using="//ul[@id='side-menu']/descendant::span[contains(text() ,'Sales' )]")
	WebElement SalesInvoiceModuleLink;
	@FindBy(how = How.XPATH, using="//ul[@id='side-menu']/descendant::a[contains(text() ,'New Invoice' )]")
	WebElement NewSalesInvoiceLink;
	@FindBy(how = How.XPATH, using="//ul[@id='side-menu']/descendant::a[text()='Invoices']")
	WebElement ListSalesInvoiceLink;
	
	public void goToNewAccountPage() throws InterruptedException 
	{
		BankCashModule.click();
		Thread.sleep(2000);
		NewAccountPage.click();
	}
	public void goToListAccountPage() throws InterruptedException 
	{
		BankCashModule.click();
		Thread.sleep(2000);
		ListAccountPage.click();
	}
	public void goToNewSalesInovicePage() throws InterruptedException 
	{
		SalesInvoiceModuleLink.click();
		Thread.sleep(2000);
		NewSalesInvoiceLink.click();
	}
	public void goToListSalesInvoicePage() throws InterruptedException 
	{
		System.out.println("Landed into goToListSalesInvoicePage method in SideNavigation page");
		ListSalesInvoiceLink.click();
		Thread.sleep(5000);
	}
	
}
