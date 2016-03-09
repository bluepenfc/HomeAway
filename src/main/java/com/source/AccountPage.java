package com.source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
	WebDriver driver;
	WebElement pc;
	
	By menu = By.cssSelector("li#wp-admin-bar-my-account a[class='ab-item']");
	By myProfile = By.xpath(".//*[@id='wp-admin-bar-edit-profile']/a");
	By myFirstName = By.id("first_name");
	By saveProfile = By.name("submit");
	By logOut = By.xpath(".//*[@id='wp-admin-bar-logout']/a");
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private void getMenu() {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(menu);
		action.moveToElement(we).build().perform();		
	}
	
	public void getProfile() {
		getMenu();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		driver.findElement(myProfile).click();
		pc = wait.until(ExpectedConditions.presenceOfElementLocated(myFirstName));
		pc.click();
		
	}
	
	public void save() {
		driver.findElement(saveProfile).submit();
	}
	
	public void logout() {
		getMenu();

		driver.findElement(logOut).click();
	}
	
	public void setFirstname() {
		getProfile();
		pc.clear();
		pc.sendKeys("myfinaldemo");
	}
	
	public String getFirstname() {
		getProfile();
		String name = driver.findElement(myFirstName).getAttribute("value");
		return name;
	}
}
