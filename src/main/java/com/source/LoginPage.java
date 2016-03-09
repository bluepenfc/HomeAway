package com.source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	By username = By.id("log");
	By password = By.id("pwd");
	By login = By.id("login");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login() {
		driver.findElement(username).sendKeys("mytest");
		driver.findElement(password).sendKeys("Qademo6!");
		driver.findElement(login).click();
	}
}
