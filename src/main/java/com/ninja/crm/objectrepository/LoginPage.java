package com.ninja.crm.objectrepository;
/**
 * @author Govardhan Reddy A
 * Login to application
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	private  WebElement usernametextfield;
	@FindBy(id = "inputPassword")
	private WebElement passwordtextfiled;
	@FindBy(xpath = "//button[@class=\"btn btn-primary btn-lg btn-block\"]")
	private WebElement signbutton;
	public WebElement getUsernametextfield() {
		return usernametextfield;
	}
	public WebElement getPasswordtextfiled() {
		return passwordtextfiled;
	}
	public WebElement getSignbutton() {
		return signbutton;
	}



}

