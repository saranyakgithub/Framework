package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	By searchBox = By.id("twotabsearchtextbox");
	By searchBtn = By.id("nav-search-submit-button");
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void enterProduct(String productName)
	{
		driver.findElement(searchBox).sendKeys(productName);
	}
	
	public String clickSearchBtn()
	{
		String pageTitle;
		driver.findElement(searchBtn).click();
		pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public void searchProduct(String productName)
	{
		this.enterProduct(productName);
		this.clickSearchBtn();		
	}
}
