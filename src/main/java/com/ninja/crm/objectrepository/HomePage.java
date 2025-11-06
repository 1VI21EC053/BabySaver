package com.ninja.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Campaigns")
	private WebElement campaignslink;

	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productslink;

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement successMsg;
	
	@FindBy(xpath = "//button[@aria-label='close']")
	private WebElement crossButton;

	@FindBy(xpath = "//div[@class='user-icon']")
	private WebElement profileIcon;

	@FindBy(xpath = "//div[@class='dropdown-item logout']")
	private WebElement logoutButton;

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getCrossButton() {
		return crossButton;
	}

	public WebElement getSuccessMsg() {
		return successMsg;
	}

	public WebElement getCampaignslink() {
		return campaignslink;
	}

	public WebElement getProductslink() {
		return productslink;
	}

}
