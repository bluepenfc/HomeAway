package com.source;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ChooseBrowser {
	  public WebDriver loadBrowser(String browser) {
		  WebDriver driver;
		  
		  if(browser.equalsIgnoreCase("firefox")){
	    	  // use firefox
	          driver = new FirefoxDriver();
	      }
	      else if(browser.equalsIgnoreCase("chrome")){
	    	  // use chrome
	          System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
	          driver = new ChromeDriver();
	      }
	      else if(browser.equalsIgnoreCase("ie")){
	    	  // use IE
	    	  System.setProperty("webdriver.ie.driver","C:\\iedriver\\IEDriverServer.exe");
	          driver = new InternetExplorerDriver();
	      }
	      else{
	          throw new RuntimeException("Browser is not correct");
	      }
	      
	      return driver;
	  }
}
