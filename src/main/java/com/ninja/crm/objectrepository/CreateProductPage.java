package com.ninja.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CreateProductPage {


		WebDriver driver;
		public CreateProductPage(WebDriver driver) {
			this.driver=driver;
		PageFactory.initElements(driver, this);
		
		}

		@FindBy(name = "productName")
		private  WebElement productnametextfield;
		
		
		@FindBy(name = "productCategory")
		private WebElement productcategorydropdown;
		
		
		@FindBy(name = "quantity")
		private WebElement productquantitytextfield;
		
		@FindBy(name = "price")
		private WebElement productperunittextfiled;
		
		@FindBy(name = "vendorId")
		private WebElement productvendorIddropdown;
		
		@FindBy(xpath =  "//button[@type=\"submit\"]")
		private WebElement productaddsubmitbutton;
		
		
		public WebElement getProductaddsubmitbutton() {
			return productaddsubmitbutton;
		}

		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getProductnametextfield() {
			return productnametextfield;
		}

		public WebElement getProductcategorydropdown() {
			return productcategorydropdown;
		}

		public WebElement getProductquantitytextfield() {
			return productquantitytextfield;
		}

		public WebElement getProductperunittextfiled() {
			return productperunittextfiled;
		}

		public WebElement getProductvendorIddropdown() {
			return productvendorIddropdown;
		}
		
		
	
	}


