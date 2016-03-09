package com.source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
	WebDriver driver;
	By login = By.className("account_icon");
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login() {
		driver.findElement(login).click();
	}
}
