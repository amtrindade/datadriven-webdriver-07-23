package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {
	
	public MainPage open(String url) {
		getDriver().get(url);
		return this;		
	}
	
	public DetailPage search(String country) throws InterruptedException {
		WebElement tfSearch = getDriver().findElement(By.name("search"));
		tfSearch.sendKeys(country);		
		
		Thread.sleep(1000);
		WebElement btnSearch = getDriver().findElement(By.xpath("//button[.='Search']"));
		btnSearch.click();
		
		return new DetailPage();
	}
}
