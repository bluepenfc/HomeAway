package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import static org.testng.Assert.*;

import com.source.*;

public class EmptyCartMessageTest {
	WebDriver driver;
	ChooseBrowser cbrowser;
	IphonePage iphone;
	ConfirmPage confirm;
	CheckOutPage checkout;
	
	
	@BeforeTest
	@Parameters("browser")
	public void beforeMethod(String browser) {
		cbrowser = new ChooseBrowser();
		driver = cbrowser.loadBrowser(browser);
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    driver.get("http://store.demoqa.com/products-page/product-category/iphones/");
	}
	
	@Test
	public void emptyCartMessage() {
		iphone = new IphonePage(driver);
		confirm = new ConfirmPage(driver);
		checkout = new CheckOutPage(driver);
		
		iphone.buy();
		confirm.confirm();
		checkout.remove();
		String s = checkout.getMessage();
		assertEquals("Oops, there is nothing in your cart.", s);
		
	}

    @AfterTest
    public void afterMethod() {
    	if (driver != null)
    		driver.quit();
    }

}
