package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage  extends BasePage {
	
	private WebDriver driver; 
	ElementUtil elementUtil; 

	
	
	
	//1.ByLocators -Object Repository 
	
		By emailId =By.id("username");
		By password =By.id("password");
		By loginbtn =By.id("loginBtn");
		By signUpLink = By.xpath("//i18n-string[text()='Sign up']");
		
		 
		
	//2.constructor of the page class;
	public LoginPage (WebDriver driver) {
		this.driver=driver;  
		elementUtil =new ElementUtil(this.driver) ; 
	}
	
	//3. page ctions.
	
	@Step("getting login page title")
	 public String getLoginPageTitle () {	 
		return elementUtil.doGetPageTitleWithIsTitle(10, Constants.LOGIN_PAGE_TITLE); 
	 }
	@Step("getting sign up link presents")
	 public boolean SignUpLinkExist () {
	
		//return elementUtil.doIsDisplayed(signUpLink); 
		 return elementUtil.doIsDisplayed(signUpLink);
	 }
	@Step("login with username: {0} and password : {1}")
	 public HomePage doLogin (String username, String pswd) {

		 elementUtil.waitForElementToBeVisible(emailId, 10); // before filling the form wait up to 10 second to find element;
		 elementUtil.doSendKeys(emailId, username);
		 elementUtil.doSendKeys(password, pswd);
		 elementUtil.doActionsClick(loginbtn);
		 return new HomePage(driver); 
		 
	 }
	 
	 
	 
	
}
