package com.source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmPage {
	WebDriver driver;
	
	By goToCart = By.linkText("Go to Checkout");
	
	public ConfirmPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void confirm() {
		driver.findElement(goToCart).click();
	}
}
