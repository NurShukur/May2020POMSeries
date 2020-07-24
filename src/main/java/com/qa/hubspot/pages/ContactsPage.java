package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;
import com.qa.hubspot.utils.ExcelUtil;

public class ContactsPage extends BasePage {

	private WebDriver driver; 
	ElementUtil elementUtil; 
	
	
	By header =By.xpath("(//*[text()=\"Contacts\"])[2]")	;
	By createContactPrimary =By.xpath("(//span[text()='Create contact'])[1]");
	By email=By.xpath("//input[@data-field='email']"); 
	By firstName=By.xpath("//input[@data-field='firstname']");
	By lastName =By.xpath("//input[@data-field='lastname']");
	By jobTitle =By.xpath("//input[@data-field='jobtitle']"); 
	By createContactSecondary=By.xpath("(//span[text()='Create contact'])[2]"); 
	By contactsBackLink =By.xpath("(//*[text()='Contacts'])[position()=1]");
	By addAnotherContact = By.xpath("(//i18n-string[text()=\"Create and add another\"])[1]");
	By userName =By.xpath("//span[@data-selenium-test='highlightTitle']");
	By deleteAllCheckBox= By.xpath("(//span[@class='private-checkbox__indicator'])[1]");
	By deletePrimary=By.xpath("(//span[text()=\"Delete\"])[1]");
	By numberOfContact=By.xpath("//textarea[@id='UIFormControl-34']");
	By deleteSecondary =By.xpath("(//span[text()='Delete'])[2]"); 
	By actions=By.xpath("//span[contains(text(),'Actions')]");
	By deleteActions=By.xpath("//i18n-string[contains(text(),'Delete')]\"))"); 
	By deleteFinal = By.xpath("//button[@data-selenium-test='delete-dialog-confirm-button']"); 
	
	public ContactsPage (WebDriver driver ) {
	
		this.driver=driver; 
		elementUtil=new ElementUtil (this.driver); 
	} 
	
	public String getContactPageTitle () {
		
	return elementUtil.doGetPageTitleWithIsTitle(10, Constants.CONTACTS_PAGE_TITLE);
	
	}
	
	public String getContactspageHeader () {
		
		elementUtil.waitForElementPresent(header, 10);  // first wait up to 10 ; 
		
		return elementUtil.doGetText(header);// once wait done get text of header  
	}
	
	public void createContact (String email , String firstName, String lastName, String jobTitle)  {
	
		
		elementUtil.clickWhenReady(createContactPrimary, 10);
		elementUtil.waitForElementToBeVisible(this.email, 10);
		elementUtil.doActionsSendKeys(this.email, email);
		elementUtil.doActionsSendKeys(this.firstName, firstName);
		elementUtil.doActionsSendKeys(this.lastName, lastName);
		
		elementUtil.waitForElementToBeVisible(this.jobTitle, 10);
		elementUtil.doActionsSendKeys(this.jobTitle, jobTitle);
		elementUtil.doClick(createContactSecondary);
		elementUtil.clickWhenReady(contactsBackLink, 10);
		
		
		
	}
	
	public  String getUserNameText() {  
		
		elementUtil.waitForElementPresent(userName, 10); 
		return elementUtil.doGetText(userName);
//		String username=contactsPage.getUserNameText();
//		System.out.println("your username is :" +username);
		
	}
	
	public void deleteContacts () {
	
		elementUtil.clickWhenReady(deleteAllCheckBox, 10);
		elementUtil.doActionsClick(deletePrimary);
		elementUtil.doActionsSendKeys(numberOfContact, "1");
		elementUtil.doActionsClick(deleteSecondary);
	
	}

	
	
}
