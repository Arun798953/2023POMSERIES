package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utils.AppConstants;
import com.qa.opencart.Utils.ElementUtils;
import com.qa.opencart.Utils.TimeUtils;

import io.qameta.allure.Step;

public class LoginPage {
	private WebDriver driver;
	private ElementUtils eleUtil;

	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	private By LogoutLnk = By.linkText("Logout");

	// 2. page constructor:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtils(driver);
	}

	// 3. page actions:
	@Step("get login page title")
	public String getLoginPageTitle() {
		return eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, TimeUtils.DEFAULT_TIME_OUT);
	}

	@Step("get login page url")
	public String getLoginPageUrl() {
		return eleUtil.waitForUrlContains(AppConstants.LOGIN_PAGE_FRACTION_URL, TimeUtils.DEFAULT_TIME_OUT);
	}

	@Step("checking forgot pwd lnk Exist")
	public boolean isforgotPWdLinkExist() {
		return eleUtil.doIsDisplayed(forgotPwdLink);
	}

	@Step("login with username:{0} and password{1}")
	public AccountPage doLogin(String un, String pwd) {
		System.out.println("Creds are : " + un + " : " + pwd);
		eleUtil.waitForElementVisible(emailId, TimeUtils.DEFAULT_TIME_OUT).sendKeys(un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);

		return new AccountPage(driver);

	}

}
