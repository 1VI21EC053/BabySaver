package com.ninja.crm.generic.baseclassUtility;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.ninja.crm.generic.fileutility.PropertiesUtilities;
import com.ninja.crm.generic.webdriverutility.WebDriverUtilities;
import com.ninja.crm.objectrepository.HomePage;
import com.ninja.crm.objectrepository.LoginPage;

/**
 * @author Govardhan Reddy A\
 * 
 */
public class BaseClass {

	PropertiesUtilities pu = new PropertiesUtilities();
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite(groups = { "smoketesting", "regression testing" })
	public void configBS() {

		Reporter.log("successfully connected to Db", true);
	}

	@BeforeTest(groups = { "smoketesting", "regression testing" })
	public void configBT() {

		Reporter.log("precondition ", true);
	}

//	@Parameters("browser")
	@BeforeClass(groups = { "smoketesting", "regression testing" })
	public void configBC() throws IOException {

	//	String BROWSER = pu.getDataFromProperties("Browser");
//	   String BROWSER=browser;
		String BROWSER =System.getProperty("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			ChromeOptions set = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			set.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(set);
		} else if (BROWSER.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		sdriver = driver;

		driver.manage().window().maximize();
		WebDriverUtilities wUtil = new WebDriverUtilities();
		wUtil.setImplicitlyWait(driver, 20);
		String URL = pu.getDataFromProperties("Url");
		driver.get(URL);
		Reporter.log("successfully browser open", true);
	}

	@BeforeMethod(groups = { "smoketesting", "regression testing" })
	public void configBM() throws IOException {
		String UN = pu.getDataFromProperties("Username");
		String PW = pu.getDataFromProperties("password");

		LoginPage lp = new LoginPage(driver);
		lp.getUsernametextfield().sendKeys(UN);
		lp.getPasswordtextfiled().sendKeys(PW);
		lp.getSignbutton().click();
		Reporter.log("successfully login", true);

	}

	@AfterMethod(groups = { "smoketesting", "regression testing" })
	public void configAM() {
		HomePage hp = new HomePage(driver);
//		hp.getProfileIcon().click();
		hp.getLogoutButton().click();
	}

	@AfterClass(groups = { "smoketesting", "regression testing" })

	public void configAC() {
		driver.quit();
	}

	@AfterTest(groups = { "smoketesting", "regression testing" })
	public void configAT() {
		Reporter.log("post-condition ", true);
	}

	@AfterSuite(groups = { "smoketesting", "regression testing" })
	public void configAS() {

		Reporter.log("successfully closed the Db", true);
	}
}
