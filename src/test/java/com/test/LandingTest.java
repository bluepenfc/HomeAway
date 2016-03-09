package com.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import com.source.*;

public class LandingTest {
	WebDriver driver;
	ChooseBrowser cbrowser;
	IphonePage iphone;
	ConfirmPage confirm;
	CheckOutPage checkout;
	PurchasePage cost;

	@BeforeTest
	@Parameters("browser")
	public void beforeMethod(String browser) {
		cbrowser = new ChooseBrowser();
		driver = cbrowser.loadBrowser(browser);
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    driver.get("http://store.demoqa.com/products-page/product-category/iphones/");
     }
	
	@Test
	public void testPrice() {	
		iphone = new IphonePage(driver);
		confirm = new ConfirmPage(driver);
		checkout = new CheckOutPage(driver);
		cost = new PurchasePage(driver);
		
		iphone.buy();
		confirm.confirm();
		checkout.checkOut();
			
		String price = cost.getCost().trim();
		Assert.assertEquals("$282.00", price);	
	}
	

    @AfterTest
    public void afterMethod() {
    	if (driver != null)
    		driver.quit();
    }

}
