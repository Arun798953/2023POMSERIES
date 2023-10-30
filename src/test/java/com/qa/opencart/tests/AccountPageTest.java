package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Utils.AppConstants;
import com.qa.opencart.Utils.AppErrors;
import com.qa.opencart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class AccountPageTest extends BaseTest {
	@Epic("Epic - 200:Design AccountPage for OpenCart Shopping Application")
	@Story("Us - 201:create Account Page functionality for open cart Account page")

	@BeforeClass
	public void accsetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Description("Account page Test")
	@Severity(SeverityLevel.TRIVIAL)
	@Test
	public void AccpageTest() {
		String actTitle = accPage.getAccPageTitle();
		System.out.println("Account page title:   " + actTitle);
		Assert.assertEquals(actTitle, AppConstants.ACCOUNTS_PAGE_TITLE, AppErrors.NO_TITLE_MATCHED);
	}

	@Description("Accountpage url Test")
	@Severity(SeverityLevel.NORMAL)

	@Test
	public void AccpageUrlTest() {
		String actUrl = accPage.getAccPageURL();
		System.out.println("Account page url:   " + actUrl);
		Assert.assertTrue(actUrl.contains(AppConstants.ACCOUNTS_PAGE_FRACTION_URL), AppErrors.NO_URL_MATCHED);

	}

	@Description("SearchExist on Accpage Test")
	@Severity(SeverityLevel.CRITICAL)

	@Test
	public void SearchExistTest() {
		AssertJUnit.assertTrue(accPage.isSearchExist());
	}

	@Description("Logoutlnk on Accpage Test")
	@Severity(SeverityLevel.TRIVIAL)

	@Test
	public void LogoutExistTest() {
		Assert.assertTrue(accPage.isLogoutExist());
	}

	@Description(" Page SectionHeaders on Accpage Test")
	@Severity(SeverityLevel.TRIVIAL)

	@Test
	public void AccPageSectionHeadersTest() {
		List<String> actHeadersText = accPage.getAccountsPageSectionsHeaders();
		Assert.assertEquals(actHeadersText, AppConstants.EXPECTED_HEADERS_LIST);
	}

	@DataProvider
	public Object[][] getProductName() {
		return new Object[][] { { "Macbook" }, { "imac" }, { "samsung" } };

	}

	@Description(" ProductSearch Test on Accpage Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(dataProvider = "getProductName")
	public void ProductSearchTest(String productName) {
		resultspage = accPage.searchPerformance(productName);
		String actTitle = resultspage.getSearchTitle(productName);
		System.out.println("search page title:  " + actTitle);
		softassert.assertEquals(actTitle, AppConstants.SEARCH_PAGE_TITLE + " " + productName);
		Assert.assertTrue(resultspage.getproductsCount() > 0);
	}

}