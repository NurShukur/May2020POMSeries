package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class InboxPage extends BasePage {
	
	private WebDriver driver; 
	ElementUtil elementutil; 
	
	//By Locator 
	
	
	By header=By.xpath("//i18n-string[text()='Say hello.']"); 
	By hideButton=By.xpath("//button[@data-button-use=\"transparent\"])[1])"); 
			
	
	
	
	// Costructor 
	
	public InboxPage (WebDriver driver ) {
		
		this.driver=driver; 
		elementutil=new ElementUtil (this.driver) ; 
		
	}
	
	
	// Page Actions
	
	public String  getInboxPageTitle () {
		
		return elementutil.doGetPageTitleWithIsTitle(10, Constants.INBOX_PAGE_TITLE);
	}
	
	public String getInboxHeader ()  {
		
		elementutil.waitForElementPresent(header, 10);
		return elementutil.doGetText(header) ; 
		
	}
	
	
	

}
