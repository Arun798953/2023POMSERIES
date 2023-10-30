package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {
	@BeforeClass
	public void prodInfosetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@DataProvider
	public Object[][]getProductHeadersTestData() {
		return new Object[][] { 
			    {"MacBook","MacBook Pro"},
			    {"MacBook","MacBook Air"},
				{"Samsung","Samsung SyncMaster 941BW"},
				{"Samsung","Samsung Galaxy Tab 10.1"},
				};
				
	}

	@Test(dataProvider="getProductHeadersTestData")
	public void ProductHeadersTest(String SearchKey, String mainProductName) {
		resultspage = accPage.searchPerformance(SearchKey);
		productinfo = resultspage.selectProduct(mainProductName);
		String actHeader = productinfo.ProductHeaders();
		Assert.assertEquals(actHeader, mainProductName);

	}
	@DataProvider
	public Object[][]getProductImagesTestData() {
		return new Object[][] { 
			    {"MacBook","MacBook Pro"},
			    {"MacBook","MacBook Air"},
				{"Samsung","Samsung SyncMaster 941BW"},
				{"Samsung","Samsung Galaxy Tab 10.1"},
				};
				
	}

	@Test(dataProvider="getProductImagesTestData")
	public void ProductImagesTest(String searchKey,String mainProductName) {
		resultspage = accPage.searchPerformance(searchKey);
		productinfo = resultspage.selectProduct(mainProductName);
		int actImagesCount= productinfo.getProductImagesCount();
		Assert.assertTrue(actImagesCount>0);
	

	}
	@Test
	public void ProductMetadataTest() {
		resultspage = accPage.searchPerformance("Macbook");
		productinfo = resultspage.selectProduct("MacBook");
	Map<String,String>actproductinfoMap=productinfo.getProductInformation();
	softassert.assertEquals(actproductinfoMap.get("Brand"),"Apple");
	softassert.assertEquals(actproductinfoMap.get("Product Code"),"Product 16");
	softassert.assertEquals(actproductinfoMap.get("Reward Points"),"600");
	softassert.assertEquals(actproductinfoMap.get("Availability"),"In Stock");
	softassert.assertAll();

	
	
	
	


}
	}
