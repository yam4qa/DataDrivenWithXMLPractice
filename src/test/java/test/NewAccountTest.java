package test;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.ListAccountPage;
import page.LoginPage;
import page.NewAccountPage;
import page.SideNavigation;
import util.BrowserFactory;

public class NewAccountTest {
	WebDriver driver;
	Random rnd = new Random();

//	String userName = "techfiosdemo@gmail.com";
//	String Password = "abc123";
//	String accountTitle = "Krish" + rnd.nextInt(999);
//	String descprition = "travel Expenses";
//	String balance = "20";

	@Test
	@Parameters({ "username", "password", "accountTitle", "description", "balance" })
	public void OpenANewAccount(String userName, String Password, String accountTitle, String description, String balance) throws InterruptedException {
		driver = BrowserFactory.startBrowser();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(userName, Password);

		SideNavigation sidenav = PageFactory.initElements(driver, SideNavigation.class);
		sidenav.goToNewAccountPage();

		String expectedTitle = accountTitle + rnd.nextInt(999);
		System.out.println("Expected dat: " + expectedTitle);

		NewAccountPage newAccountPage = PageFactory.initElements(driver, NewAccountPage.class);
		newAccountPage.fillInTheNewAccountForm(expectedTitle, description, balance);

		// Get the list of column data from the page class
		sidenav.goToListAccountPage();
		ListAccountPage listAccountPage = PageFactory.initElements(driver, ListAccountPage.class);
		List<String> columnData = listAccountPage.getColumnDataFor("Account");
		Assert.assertTrue(isDataPresent(expectedTitle, columnData), "New Account did not post!!!!");

	}

	private boolean isDataPresent(String expectedTitle, List<String> columnData) {
		for (String cellData : columnData) {
			if (cellData.equalsIgnoreCase(expectedTitle)) {
				System.out.println("Displayed Data: " + cellData);
				return true;
			}
		}
		return false;
	}
}