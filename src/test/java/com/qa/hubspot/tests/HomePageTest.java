package com.qa.hubspot.tests;




import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic -102 : design home page features")
@Feature("US -202 : design home page title, header and account names ...")
public class HomePageTest  extends BaseTest {
 
	HomePage homePage; 
	
	@BeforeClass
public void homePageSetup() {
		
	homePage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}

	@Description("verify HomePage title on home page ")
	@Severity(SeverityLevel.NORMAL)
	@Test (priority = 2)
	public void verifyHomePageTitleTest() {
		String title=homePage.getHomePageTitle(); 
		System.out.println("Home page title is : " +title);
		Assert.assertEquals(title,Constants.HOME_PAGE_TITLE);

	}
	
	
	
	
	@Description("verify HomePage header on home page ")
	@Severity(SeverityLevel.MINOR)
	@Test (priority = 1)
	public void verifyHomePageHeaderTest () {
	String header=homePage.getHomePageHeader();
	System.out.println("Home Page header is " + header);
	Assert.assertEquals(header,Constants.HOME_PAGE_HEADER);

		}
	@Description("verify HomePage logged in account on home page ")
	@Severity(SeverityLevel.CRITICAL)
	@Test (priority = 3)
	public void verifyLoggedinUserTest() {
		String accountName=homePage.getLoggedInAccountName();
		System.out.println("Logged in user account name is : " + accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
		
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

