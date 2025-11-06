package com.ninja.crm.products;

import java.io.IOException;
import org.testng.annotations.Test;
import com.ninja.crm.generic.baseclassUtility.BaseClass;
import com.ninja.crm.generic.fileutility.ExcelUtilities;
import com.ninja.crm.generic.javautility.JavaUtilities;
import com.ninja.crm.generic.webdriverutility.WebDriverUtilities;
import com.ninja.crm.objectrepository.CreateProductPage;
import com.ninja.crm.objectrepository.HomePage;
import com.ninja.crm.objectrepository.productpage;

public class CreateProductTest extends BaseClass {
	@Test(groups = "smoketesting")
	public void createProductWithMandatoryfieldTest() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.getProductslink().click();
		

		ExcelUtilities e = new ExcelUtilities();
		String prodname = e.getDataFromexcelFile("Sheet1", 1, 0);
		String quan = e.getDataFromexcelFile("Sheet1", 1, 1);
		
		
		JavaUtilities ju = new JavaUtilities();
		int ab = ju.randomNumber(1000);
		//productPage
		productpage pg = new productpage(driver);
		pg.getCreateproductsicon().click();
		
	
		
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.getProductnametextfield().sendKeys(prodname+ab);
		cpp.getProductquantitytextfield().sendKeys(quan);
		cpp.getProductaddsubmitbutton().click();
		cpp.getProductcategorydropdown();
		cpp.getProductvendorIddropdown();
		
		
		WebDriverUtilities wdu= new WebDriverUtilities();
		wdu.selectOptionByValue(cpp.getProductcategorydropdown(),"Furniture");
		wdu.selectOptionByValue(cpp.getProductvendorIddropdown(), "VID_447");
		
		cpp.getProductaddsubmitbutton().click();
	
		wdu.waitforElementToclickable(driver, hp.getSuccessMsg());
		
	  
		String notif = hp.getSuccessMsg().getText();
		if (hp.getSuccessMsg().isDisplayed()) {
			System.out.println(notif);
		} else {
			System.out.println("sorry not working");
		}
		hp.getCrossButton().click();
		wdu.moveToElement(driver,hp.getProfileIcon());
		
	}
		
		
		
	}


