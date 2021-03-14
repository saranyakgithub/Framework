package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.DBConnect;
import utility.Utils;

public class SearchResults {
	
	WebDriver driver;
	
	By srchResult = By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span");
	By brandList = By.xpath("//div[@id='brandsRefinements']/ul/li[@id='p_89/Sony']");
	By lowPriceTxt = By.id("low-price");
	By highPriceTxt = By.id("high-price");
	By goBtn = By.xpath("//input[@class='a-button-input']");
	By searchResult = By.xpath("//span[contains(text(),'No results')]");
	
	public SearchResults(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void filterBrand(String brandNme)
	{
		/*
		 * // String brandName = "Sony"; // List<WebElement> brandNames =
		 * driver.findElements(brandList); // for(WebElement brand : brandNames) // { //
		 * String txtName = brand.getText(); // if(brandNme.equals(txtName)) // {
		 * brand.click(); } }
		 */
		driver.findElement(brandList).click();
	}
	
	public void filterPrices(String lPrice, String hPrice)
	{
		driver.findElement(lowPriceTxt).sendKeys(lPrice);
		driver.findElement(highPriceTxt).sendKeys(hPrice);
		driver.findElement(goBtn).click();
	}
	
	public void verifySearchResults(String brandNme)
	{
		try
		{
		String srhResult;
		srhResult = driver.findElement(srchResult).getText();
		System.out.println("Search Products: "+ srhResult+ " "+ brandNme);
		
		boolean value;
		value = driver.findElement(searchResult).isDisplayed();
		if(!value)
		{
			// DBConnect.connectDB();
			DBConnect.insertRecord("TC001",Utils.currentTimestamp(),"Pass");
			
		}
		else
		{
			System.out.println("Testcase is failed");
		}
		}
		catch(Exception e)
		{
			System.out.println("Testcase is failed");
		}
	}
}
