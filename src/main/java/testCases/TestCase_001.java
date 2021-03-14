package testCases;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResults;
import utility.Constant;
import utility.DBConnect;
import utility.Log;
import utility.Utils;


public class TestCase_001 {
	
	WebDriver driver;
	HomePage objHomePage;
	SearchResults objSearchResults;
	
	/*
	 * @BeforeMethod public void getTestCaseName(Method m) { DesiredCapabilities dc
	 * = new DesiredCapabilities(); Object testName=
	 * (dc.getCapability(m.getName())); }
	 */
	
	@BeforeTest
    public void setup(){
		System.setProperty("webdriver.chrome.driver","D:\\selenium_works\\chromedriver_win32\\chromedriver.exe");  
		driver = new ChromeDriver();		
	    // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to(Constant.URL);
		// driver.get(Constant.URL);
        driver.manage().window().maximize();
    }
	
	@Test
	public void testSearchProduct()
	{
		
			objHomePage = new HomePage(driver);
			
			
			objHomePage.enterProduct("Smart Tv");			
			String getTitle = objHomePage.clickSearchBtn();
			
			//Assert.assertEquals("Amazon.com : Smart Tv",getTitle );
			
			//DBConnect.insertRecord("TC001",Utils.currentTimestamp(),"Pass");
			try {
			Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Amazon.com : Smart Tv");
			assertTrue(verifyTitle);
			
			if(verifyTitle) {
				DBConnect.insertRecord("TC001",Utils.currentTimestamp(),"Pass");
			}
			
			/*
			 * objSearchResults = new SearchResults(driver);
			 * objSearchResults.filterBrand("Sony"); objSearchResults.filterPrices("100",
			 * "200"); objSearchResults.verifySearchResults("Sony");
			 */
		}
		catch(AssertionError ae)
		{
			DBConnect.insertRecord("TC001",Utils.currentTimestamp(),"Fail");
		}
		catch(Exception e)
		{
			DBConnect.insertRecord("TC001",Utils.currentTimestamp(),"Fail");
		}
	}
	
	
	@AfterTest
	public void endTest() {
		
		driver.quit();
	}
}
