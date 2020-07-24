package com.qa.hubspot.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Epic("Epic -101 : design login page features")
@Feature("US -201 : design login page title, sign up link and login form modules...")
public class LoginPageTest extends BaseTest {



	// TestNG -- unit testing framework
	// PreConditions ---> Test Cases(steps) (Act vs Exp) -- Assertions ---> Tear
	// Down
	// @BeforeTest ---> @Test --Assertions --> @AfterTest
	// launchBrowser, url --- > title test --> close the browser

	
	@Description("Verify sign up link on login page ...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=1)
	public void verifySignUpLinkTest() {
		Assert.assertEquals(loginPage.SignUpLinkExist(), true);
	}
	@Description("Verify title on login page ....")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	@Description("Verify login on login page ....")
	@Severity(SeverityLevel.BLOCKER)
	@Test (priority=3)
	
	public void loginPageTest ()  {
		
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	

}