package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utils.ElementUtils;
import com.qa.opencart.Utils.TimeUtils;

public class ResultsPage {
	private WebDriver driver;
	private ElementUtils util;
	
	private By searchproducts=By.cssSelector("div.product-layout");

	public ResultsPage(WebDriver driver) {
		this.driver=driver;
		util=new ElementUtils(driver);
		
	}
	public String getSearchTitle(String productName) {
		return util.waitForTitleContains(productName, TimeUtils.DEFAULT_TIME_OUT);
		
	}
	public int getproductsCount() {
		int productCount =util.waitForElementsVisible(searchproducts, TimeUtils.DEFAULT_TIME_OUT).size();
		System.out.println("products count is: "+productCount);
		return productCount;
		
		
	}
	public ProductInfoPage selectProduct(String mainProductName) {
		System.out.println("select product: "+mainProductName);
		util.doClick(By.linkText(mainProductName));
		return new ProductInfoPage(driver);
		
	}
	

	

}
