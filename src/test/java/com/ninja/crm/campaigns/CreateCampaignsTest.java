package com.ninja.crm.campaigns;

/**
 * 
 * @author Govardhan Reddy A
 * 
 * verifing that user is able to create a campaigns with mandatory field
 * 
 */

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ninja.crm.generic.baseclassUtility.BaseClass;
import com.ninja.crm.generic.fileutility.ExcelUtilities;
import com.ninja.crm.generic.javautility.JavaUtilities;
import com.ninja.crm.generic.webdriverutility.WebDriverUtilities;
import com.ninja.crm.objectrepository.CampaginePage;
import com.ninja.crm.objectrepository.CreateCampaignePage;
import com.ninja.crm.objectrepository.HomePage;

@Listeners(com.ninja.crm.listeners.ListenersImplementation.class)
public class CreateCampaignsTest extends BaseClass{

	@Test(groups = "smoketesting")
	public void createCampaignsWithMandatoryFieldsTest() throws EncryptedDocumentException, IOException {
/*navigating ==========> home page */
		
		HomePage hp = new HomePage(driver);
		hp.getCampaignslink().click();
/* navigating ==========> campaginepage*/
		CampaginePage cp = new CampaginePage(driver);
		cp.getCreatecampagineicon().click();
		/* fetching the data from excelutility in genric utlity */
		
		ExcelUtilities eu = new ExcelUtilities();
		String campName = eu.getDataFromexcelFile("Sheet1", 1, 0);
		String targetSize = eu.getDataFromexcelFile("Sheet1", 1, 1);
		CreateCampaignePage ccp = new CreateCampaignePage(driver);
		ccp.getCampaginenametextfield().sendKeys(campName);
		ccp.getCampaginetargetsizetextfield().sendKeys(targetSize);
		ccp.getCreatecampaginesubmitbutton().click();
		
		
		
		
		/* using webdriver utlity*/
		WebDriverUtilities wu = new WebDriverUtilities();
		wu.waitforElementToclickable(driver, hp.getSuccessMsg());
		 hp.getSuccessMsg();
/* using soft assert */
		SoftAssert s = new SoftAssert();
		hp.getCrossButton().click();
		wu.moveToElement(driver, hp.getProfileIcon());
		s.assertAll();
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*verifing that user is able to create a campaigns with expected date */
	@Test(groups = "regression testing")
	public void createCampaignsWithExpectedDateTest() throws EncryptedDocumentException, IOException {
		
		/*navigating ==========> home page */
		HomePage hp = new HomePage(driver);
		hp.getCampaignslink().click();
		/* navigating ==========> campaginepage*/
		CampaginePage cp1 = new CampaginePage(driver);
		cp1.getCreatecampagineicon().click();
		/* fetching the data from excelutility in genric utlity */
		ExcelUtilities e = new ExcelUtilities();
		String campName = e.getDataFromexcelFile("Sheet1", 1, 0);
		String targetsize = e.getDataFromexcelFile("Sheet1", 1, 1);

		CreateCampaignePage ccp = new CreateCampaignePage(driver);
		ccp.getCampaginenametextfield().sendKeys(campName);
		ccp.getCampaginetargetsizetextfield().sendKeys(targetsize);
		/* using javautlity for date*/
		JavaUtilities se = new JavaUtilities();
		String ab = se.getFutureDate(7); // java utility
		ccp.getCampagineexpectedclosedate().sendKeys(ab);
		ccp.getCreatecampaginesubmitbutton().click();
		/* using webdriver utlity*/
		WebDriverUtilities wu = new WebDriverUtilities();
		wu.waitforElementToclickable(driver, hp.getSuccessMsg());
		/* using soft assert */
		SoftAssert s = new SoftAssert();
		s.assertTrue(hp.getSuccessMsg().isDisplayed());
		hp.getCrossButton().click();
		wu.moveToElement(driver, hp.getProfileIcon());
		s.assertAll();
		
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test(groups = "regression testing")
	public void createCampaignsWithStatusTest() throws EncryptedDocumentException, IOException {
	
		/*navigating ==========> home page */
		HomePage hp = new HomePage(driver);
		hp.getCampaignslink().click();
		/* navigating ==========> campaginepage*/
		CampaginePage cp1 = new CampaginePage(driver);
		cp1.getCreatecampagineicon().click();
		/* fetching the data from excelutility in genric utlity */
		ExcelUtilities e = new ExcelUtilities();
		String campName = e.getDataFromexcelFile("Sheet1", 1, 0);
		String targetsize = e.getDataFromexcelFile("Sheet1", 1, 1);
		String status = e.getDataFromexcelFile("Sheet1", 1, 2);
		CreateCampaignePage ccp = new CreateCampaignePage(driver);
		ccp.getCampaginenametextfield().sendKeys(campName);
		ccp.getCampaginetargetsizetextfield().sendKeys(targetsize);
		ccp.getCampaginestatustextfield().sendKeys(status);
		ccp.getCreatecampaginesubmitbutton().click();
		/* using webdriver utlity*/
		WebDriverUtilities wu = new WebDriverUtilities();
		wu.waitforElementToclickable(driver, hp.getSuccessMsg());
		/* using soft assert */
		SoftAssert s = new SoftAssert();
		s.assertTrue(hp.getSuccessMsg().isDisplayed());
		hp.getCrossButton().click();
		wu.moveToElement(driver, hp.getProfileIcon());
		s.assertAll();
		
	}
}
