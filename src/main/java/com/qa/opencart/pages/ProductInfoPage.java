package com.qa.opencart.pages;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utils.ElementUtils;
import com.qa.opencart.Utils.TimeUtils;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtils utils;
	
	private By productHeader=By.cssSelector("div#content h1");
	private By productImages=By.cssSelector("a.thumbnail");
	private By productMetaData=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=1]/li");
	private By productPrice=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=2]/li");

	private Map<String,String>ProductMap;
	
	public ProductInfoPage(WebDriver driver) {
		utils=new ElementUtils(driver);
		
	}
	public String ProductHeaders() {
		 return utils.doGetElementText(productHeader);
		
	}
	public int getProductImagesCount() {
	int imagescount= utils.waitForElementsVisible(productImages, TimeUtils.DEFAULT_TIME_OUT).size();
	System.out.println("Product images count----> "+imagescount);
	
	return imagescount;
	}
	public Map<String, String> getProductInformation() {
		//ProductMap=new HashMap<String,String>();//It Print text Randomly
		//ProductMap=new LinkedHashMap<String,String>();//It print text in an order
		ProductMap=new TreeMap<String,String>();//It Prints text on basis of alphabetical order

		getProductMetaData();
		getProductPriceData();
		System.out.println(ProductMap);
		return ProductMap;
	}

	
	private void getProductMetaData() {
		List<WebElement>metadataList=utils.getElements(productMetaData);
		System.out.println("Product metadata: "+metadataList.size());
		for(WebElement e:metadataList) {
			String meta=e.getText();
		     String metadata[]=meta.split(":");
		     String metaKey=metadata[0].trim();
		     String metaValue=metadata[1].trim();
		     ProductMap.put(metaKey,metaValue);

			
		}
	}
		
	
	
		private void getProductPriceData() {
			List<WebElement>metaPricedata=utils.getElements(productPrice);
			System.out.println("Product price data: "+metaPricedata.size());
			   String price=metaPricedata.get(0).getText().trim();
			   String EXprice=metaPricedata.get(1).getText().trim();
			   ProductMap.put("actprice", price);
			   ProductMap.put("actEXprice", EXprice);

				
			}
}

		

	
	
	


