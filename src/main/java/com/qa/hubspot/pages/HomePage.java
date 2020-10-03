package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {

	private WebDriver driver; 
	ElementUtil elementUtil; 
	
	
	
	By header=((By.xpath("//i18n-string[@data-key='app.header']")));
	By accountName=(By.className("navAccount-accountName"));
	By accountMenu=By.xpath("//a[@id=\"account-menu\"]");
	By sideBarLinks=By.xpath("//a[@data-test-id='sidebar-filter']");
	
	By contactsPrimaryLink =By.id("nav-primary-contacts-branch");
	By contactsSecondaryLink =By.id("nav-secondary-contacts");
	
	
	public HomePage (WebDriver driver ) {
		
		this.driver=driver; 
		elementUtil = new ElementUtil(this.driver); 
	}
	 
	
	public String getHomePageTitle () {
		
		return elementUtil.doGetPageTitleWithIsTitle(10, Constants.HOME_PAGE_TITLE);
	} 
	
	public String getHomePageHeader() {
		
	
		if (elementUtil.doIsDisplayed(header))
		
		{
			
			return elementUtil.doGetText(header);}
		
		else {
		return null; 
		}

	}
	
	 
	public String  getLoggedInAccountName () {
		
		driver.findElement(accountMenu).click();
		
		if (elementUtil.doIsDisplayed(accountName))
		
		return elementUtil.doGetText(accountName);
		
		return null;
		
		
	}
	
	
	public ContactsPage goToContactsPage () {
		
		clickOnContacts (); 
		
		
		return new ContactsPage (driver); 
	}
	
	private void clickOnContacts () {
		
		// encapsulation  we do not want to show unnecassary information . 
		elementUtil.waitForElementPresent(contactsPrimaryLink, 10); 
		elementUtil.doClick(contactsPrimaryLink);
		elementUtil.clickWhenReady(contactsSecondaryLink, 5);
		
	}
	
	
	
	
	
}
