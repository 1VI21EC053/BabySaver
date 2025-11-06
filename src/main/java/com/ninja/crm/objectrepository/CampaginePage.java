package com.ninja.crm.objectrepository;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class CampaginePage {
	
	WebDriver driver;
	public CampaginePage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class=\"btn btn-info\"]")
	private  WebElement createcampagineicon;
	
	
	@FindBy(xpath = "//input[@class=\"form-control\"]")
	private WebElement serachbycampagineidtextfield;
	
	public WebElement getCreatecampagineicon() {
		return createcampagineicon;
	}


	public WebElement getSerachbycampagineidtextfield() {
		return serachbycampagineidtextfield;
	}
	
	
}
	