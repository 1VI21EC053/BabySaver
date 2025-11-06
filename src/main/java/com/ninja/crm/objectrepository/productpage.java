package com.ninja.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productpage {
	
	WebDriver driver;
	public productpage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//button[@class=\"btn btn-info\"]")
	private  WebElement createproductsicon;
	
	
	public WebElement getCreateproductsicon() {
		return createproductsicon;
	}
	
	
	
	

}
