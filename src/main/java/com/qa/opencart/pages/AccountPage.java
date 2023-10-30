package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utils.AppConstants;
import com.qa.opencart.Utils.ElementUtils;
import com.qa.opencart.Utils.TimeUtils;

import io.qameta.allure.Step;

	public class AccountPage {
		
		private WebDriver driver;
        private ElementUtils eleUtil;
		
		private By search = By.name("search");
		private By searchIcon = By.cssSelector("div#search button");
		private By logoutLink = By.linkText("Logout");
		private By accSecHeaders = By.cssSelector("div#content h2");
		
		public AccountPage(WebDriver driver) {
			this.driver=driver;
			eleUtil = new ElementUtils(driver);
		}
		
		public String getAccPageTitle() {
			return eleUtil.waitForTitleIs(AppConstants.ACCOUNTS_PAGE_TITLE, TimeUtils.DEFAULT_TIME_OUT);
		}
		
		public String getAccPageURL() {
			return eleUtil.waitForUrlContains(AppConstants.ACCOUNTS_PAGE_FRACTION_URL, TimeUtils.DEFAULT_TIME_OUT);
		}
		
		public boolean isSearchExist() {
			return eleUtil.waitForElementVisible(search,TimeUtils.DEFAULT_TIME_OUT).isDisplayed();
		}
		
		
		public boolean isLogoutExist() {
			return eleUtil.waitForElementVisible(logoutLink, TimeUtils.DEFAULT_TIME_OUT).isDisplayed();
		}
		@Step("Get Page section Headers")
		public List<String> getAccountsPageSectionsHeaders() {
			List<WebElement> secHeadersList = eleUtil.waitForElementsVisible(accSecHeaders, TimeUtils.DEFAULT_TIME_OUT);
			List<String> secHeadersValList = new ArrayList<String>();
			for(WebElement e : secHeadersList) {
				String text = e.getText();
				secHeadersValList.add(text);
			}
			return secHeadersValList;
		}

		public ResultsPage searchPerformance(String productName) {
			
	System.out.println("product search for:  "+productName);
	if(isSearchExist()) {
		eleUtil.doSendKeys(search, productName);
		eleUtil.doClick(searchIcon);
		return new ResultsPage(driver);
		
	}
	return null;			
		}

		
		}
		
		


