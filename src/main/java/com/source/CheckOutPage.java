package com.source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	WebDriver driver;
	
	By conBtn = By.cssSelector("a.step2 > span");
	By rmvBtn = By.cssSelector("form.adjustform.remove > input[name='submit']");
	By message = By.xpath(".//*[@id='post-29']/div");
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkOut() {
		driver.findElement(conBtn).click();
	}
	
	public void remove() {
		driver.findElement(rmvBtn).click();
	}
	
	public String getMessage() {
		String s = driver.findElement(message).getText();
		return s;
	}
}
