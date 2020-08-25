package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ListSalesInvoicePage 
{
	WebDriver driver;

	// Every Page must have a constructor to invite the driver
	public ListSalesInvoicePage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	
	public List<String> getColumnDataFor(String columnHeader) 
	{
		List<String> columnData = new ArrayList<String>();
		System.out.println("Landed in 'getColumnDataFor' Method");
		int index = getColumnHeaderIndexFor(columnHeader);
		
		String xpath = "//table/descendant::tr/td["+index+"]";
		List<WebElement> columnDataElements = driver.findElements(By.xpath(xpath));
		System.out.println("Column data size is : "+ columnDataElements.size());
		for(int i=0; i<columnDataElements.size(); i++) {
			columnData.add(columnDataElements.get(i).getText());
		}
		return columnData;
	}

	private int getColumnHeaderIndexFor(String columnHeader) 
	{	System.out.println("Landed in 'getColumnHeaderIndexFor' Method");
		String xpath = "//table/descendant::th";
		List<WebElement> columnHeaderElements = driver.findElements(By.xpath(xpath));
		System.out.println(" Header elements array length is "+columnHeaderElements.size() +" and first header element is "+columnHeaderElements.get(0).getText());
		System.out.println("To be match with header: "+columnHeader);
		int index = 1;
		for (int i =0; i<columnHeaderElements.size(); i++) 
		{System.out.println(columnHeaderElements.get(i).getText());
			if (columnHeader.equals(columnHeaderElements.get(i).getText())) //.equalsIgnoreCase(columnHeader)
			{
				System.out.println("Returning index of header as : " +index);
				return index;
			}
			index++;
		}
		return 0;
	}
	
}
