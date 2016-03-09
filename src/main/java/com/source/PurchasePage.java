package com.source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchasePage {
	WebDriver driver;
	
	By country = By.cssSelector("option[value='US']");
	By calculate = By.name("wpsc_submit_zipcode");
	By totalPrice = By.cssSelector("span[id='checkout_total'] span.pricedisplay");
	
	public PurchasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getCost() {
		String price = "";
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		driver.findElement(country).click();
		driver.findElement(calculate).click();
		WebElement pc = wait.until(ExpectedConditions.visibilityOf(driver.findElement(totalPrice)));

		if (pc.isDisplayed())
			price = pc.getText();
		
		return price;
	}
}
