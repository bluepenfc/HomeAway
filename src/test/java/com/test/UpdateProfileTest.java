package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import com.source.*;

public class UpdateProfileTest {
	WebDriver driver;
	ChooseBrowser cbrowser;
	Homepage home;
	AccountPage account;
	LoginPage login;
	LogoutPage logout;
	
	@BeforeTest
	@Parameters("browser")
	public void beforeMethod(String browser) {
		cbrowser = new ChooseBrowser();
		driver = cbrowser.loadBrowser(browser);
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    driver.get("http://store.demoqa.com/");
   }
	
	@Test
	public void checkName() {
		home = new Homepage(driver);
		account = new AccountPage(driver);
		login = new LoginPage(driver);
		logout = new LogoutPage(driver);
		
		home.login();
		login.login();
		account.setFirstname();
		account.save();
		account.logout();
		
		// re-login
		logout.reLogin();
		String name = account.getFirstname();
		
		assertEquals("myfinaldemo", name);
		
	}

    @AfterTest
    public void afterMethod() {
    	if (driver != null)
    		driver.quit();
    }

}
