package com.source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
	WebDriver driver;
	
	By username = By.id("user_login");
	By password = By.id("user_pass");
	By login = By.id("wp-submit");
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void reLogin() {
		driver.findElement(username).sendKeys("mytest");
		driver.findElement(password).sendKeys("Qademo6!");
		driver.findElement(login).click();
	}
	
	
}
