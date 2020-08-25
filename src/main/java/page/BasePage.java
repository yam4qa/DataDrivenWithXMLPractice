package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage 
{
	public static void waitForElement(WebElement element, WebDriver driver) 
	{
		System.out.println("BasePage.java - method waitForElement");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	//
	public static void waitForElementS(List<WebElement> webElementList, WebDriver driver) 
	{
		System.out.println("BasePage.java - method waitForElementS");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElements(webElementList));
	}
}
