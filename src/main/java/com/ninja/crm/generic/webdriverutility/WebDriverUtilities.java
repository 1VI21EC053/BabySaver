package com.ninja.crm.generic.webdriverutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtilities {
	public void setImplicitlyWait(WebDriver driver,int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
		
	}
	public void waitforElementToclickable(WebDriver driver,WebElement ele) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
	}
	
	public void waitforElementToBeVisible(WebDriver driver,WebElement ele) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	//Action
	public void moveToElement(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).click().perform();
	}
	//Dropdown
	public void selectOptionByValue( WebElement ele,String value) {
		Select s = new Select(ele);
		s.selectByValue(value);
	}
}
