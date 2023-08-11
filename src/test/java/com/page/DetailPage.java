package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DetailPage {

	public String getTitleCountry() {		
		WebElement spanTitle = getDriver().findElement(By.xpath("//span[@class='mw-page-title-main']"));
		return spanTitle.getText();		
	}

}
