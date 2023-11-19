package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.driverFactory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.ResultsPage;

public class BaseTest {

	DriverFactory df;
	WebDriver driver;
	protected LoginPage loginPage;
	protected AccountPage accPage;
	protected ResultsPage resultspage;
	protected ProductInfoPage productinfo;
	protected Properties prop;
	
	
	protected SoftAssert softassert;

	@BeforeTest
	public  void setup() {
		df= new DriverFactory();

	    prop=df.initProp();
       driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		softassert=new SoftAssert();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
