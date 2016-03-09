package com.source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IphonePage {
	WebDriver driver;
	By price = By.className("currentprice pricedisplay product_price_96");
	By addToCart = By.cssSelector("form[name='product_96'] > div.wpsc_buy_button_container.group > div.input-button-buy > span > input[name='Buy']");
	

	public IphonePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void buy() {
		driver.findElement(addToCart).click();
	}
	
	public double findPrice() {
		String iphonePrice = driver.findElement(price).getText().substring(1);
		double price = Double.parseDouble(iphonePrice);
		return price;
	}
	
	
}
