package com.ninja.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignePage {
	WebDriver driver;
	public CreateCampaignePage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	
	}

	@FindBy(name = "campaignName")
	private  WebElement campaginenametextfield;
	
	
	@FindBy(name = "campaignStatus")
	private WebElement campaginestatustextfield;
	
	
	@FindBy(name = "targetSize")
	private WebElement campaginetargetsizetextfield;
	
	@FindBy(name = "expectedCloseDate")
	private WebElement campagineexpectedclosedate;
	
	@FindBy(name = "targetAudience")
	private WebElement campaginetargetaduiencetextfield;
	
	
	@FindBy(xpath = "//button[text()='Create Campaign']")
	private WebElement createcampaginesubmitbutton;
	
	@FindBy(name = "description")
	private WebElement campaginedescriptiontextfield;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCampaginenametextfield() {
		return campaginenametextfield;
	}

	public WebElement getCampaginestatustextfield() {
		return campaginestatustextfield;
	}

	public WebElement getCampaginetargetsizetextfield() {
		return campaginetargetsizetextfield;
	}

	public WebElement getCampagineexpectedclosedate() {
		return campagineexpectedclosedate;
	}

	public WebElement getCampaginetargetaduiencetextfield() {
		return campaginetargetaduiencetextfield;
	}

	public WebElement getCampaginedescriptiontextfield() {
		return campaginedescriptiontextfield;
	}

	public WebElement getCreatecampaginesubmitbutton() {
		return createcampaginesubmitbutton;
	}
	
	
}
