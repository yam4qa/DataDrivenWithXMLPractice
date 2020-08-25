package test;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.ListAccountPage;
import page.ListSalesInvoicePage;
import page.LoginPage;
import page.NewAccountPage;
import page.NewSalesInvoicePage;
import page.SideNavigation;
import util.BrowserFactory;

public class NewSalesInvoiceTest 
{
	
	WebDriver driver;
	Random rnd = new Random();
	
	@Test
	@Parameters({ "username", "password", "discount", "itemName", "qty", "price" })
	public void OpenANewAccount(String userName, String Password, String discount, String itemName, String qty, String price) throws InterruptedException {
		driver = BrowserFactory.startBrowser();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(userName, Password);

		SideNavigation sidenav = PageFactory.initElements(driver, SideNavigation.class);
		sidenav.goToNewSalesInovicePage();
		String expectedItemName = itemName + rnd.nextInt(999);
		System.out.println("Expected Item Name : " + expectedItemName);
		
		NewSalesInvoicePage newSalesInvPage = PageFactory.initElements(driver, NewSalesInvoicePage.class);
		String invoiceNum = newSalesInvPage.fillInTheNewSalesInvoiceFarm(discount, expectedItemName,  qty, price);
		System.out.println("Finally Received Generated Invoice Number is " + invoiceNum);
		
		// Get the list of column data from the page class
		sidenav.goToListSalesInvoicePage();
		ListSalesInvoicePage listSalesInvoicePage = PageFactory.initElements(driver, ListSalesInvoicePage.class);
		List<String> columnData = listSalesInvoicePage.getColumnDataFor("#");
		
		Assert.assertTrue(isDataMatching(invoiceNum, columnData), "Invoice did not post!!!!");
	}
	private boolean isDataMatching(String invoiceNum, List<String> columnData) 
	{
		for (int i=0; i<columnData.size();i++) 
		{
			if (invoiceNum.contains(columnData.get(i))) 
			{
				System.out.println("Created Invoice Exists");
				return true;
			}
		}
		return false;
	}
}
