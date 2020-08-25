package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class NewSalesInvoicePage extends BasePage
{
	WebDriver driver;
	// Every Page must have a constructor to invite the driver
	public NewSalesInvoicePage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='cid']/option[2]")
	WebElement CustomerId;
	@FindBy(how = How.XPATH, using = "//select[@id='duedate']/option[4]")
	WebElement PaymentTerms;
	@FindBy(how = How.XPATH, using = "//select[@id='tid']/option[2]")
	WebElement SalesTax;
	@FindBy(how = How.ID, using = "add_discount")
	WebElement AddDiscount;
	@FindBy(how = How.ID, using = "set_discount")
	WebElement SetDiscount;
	@FindBy(how = How.XPATH, using = "//button[text()='Save']")
	WebElement SaveDiscount;
	// //button[@data-bb-handler="success"]
	@FindBy(how = How.ID, using = "blank-add")
	WebElement AddBlankLineForProduct;
	@FindBy(how = How.NAME, using = "desc[]")
	WebElement ItemName;
	@FindBy(how = How.NAME, using = "qty[]")
	WebElement Qty;
	@FindBy(how = How.NAME, using = "amount[]")
	WebElement Price;
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Save Invoice')]")
	WebElement SaveInvoice;
	@FindBy(how = How.XPATH, using = "//h4[contains(text() , '#')]")
	WebElement InvoiceNumber;
	@FindBy(how = How.XPATH, using = "//h2[text()='INVOICE']")
	WebElement InvoiceHeader;
	
	public String fillInTheNewSalesInvoiceFarm( String setDiscount, String itemName, String qty, String price) throws InterruptedException 
	{
//		Select index = new Select(PaymentTerms);
//		index.selectByValue(paymentTermsInDays);
//		
//		Select tax = new Select(SalesTaxStatus);
//		tax.selectByValue(salesTax);
		//index.selectByIndex(1);
		CustomerId.click();
		Thread.sleep(1000);
		PaymentTerms.click();
		Thread.sleep(1000);
		SalesTax.click();
		Thread.sleep(1000);
		AddDiscount.click();
		Thread.sleep(2000);
		SetDiscount.sendKeys(setDiscount);
		Thread.sleep(1000);
		SaveDiscount.click();
		Thread.sleep(2000);
		AddBlankLineForProduct.click();
		Thread.sleep(2000);
		ItemName.sendKeys(itemName);
		Qty.sendKeys(qty);
		Price.sendKeys(price);
		SaveInvoice.click();
		System.out.println("Invoice got saved");
		
		waitForElement(InvoiceHeader, driver);
		
		String invoiceNum = InvoiceNumber.getText();
		System.out.println("Generated Invoice number is " +invoiceNum );
		if(invoiceNum.contains("# "))
		{
			return invoiceNum;
		}
		else 
			return null;
	}

	// Methods to interact with the elements
	public void waitForPage() 
	{
		System.out.println("waitForPage method");
		
	}
}
