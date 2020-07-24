package com.qa.hubspot.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ExcelUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Epic("Epic -102 : design contacts page features")
@Feature("US -202 : design contacs page title, header and new contacts ...")
public class ContactsPageTest extends BaseTest {
	
 
	
	HomePage homePage; 
	ContactsPage contactsPage;
	
	@BeforeClass
public void contactPageSetup() {
		
		homePage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		contactsPage=homePage.goToContactsPage ();
	}
	@Description("Verify ContactsPage title on contacts page ...")
	@Severity(SeverityLevel.NORMAL)
	@Test (priority = 1)
	public void verifyContactsPageTitleTest (){
		
		String title = contactsPage.getContactPageTitle(); 
		System.out.println("contacts page title is : " + title);
		
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
	
		
	}
	@Description("Verify ContactsPage header on contacts page ...")
	@Severity(SeverityLevel.MINOR)
	@Test (priority = 2)
	public void verifyContactsPageHeader  () {
		
		String header= contactsPage.getContactspageHeader(); 
		System.out.println("contacts page header is : "+header);
		Assert.assertEquals(header, Constants.CONTACTS_PAGE_HEADER);
	
	}
	@DataProvider
	public Object [][] getContactsTestData() {
		
		Object data [][]=ExcelUtil.getTestData(Constants.CONTACTS_PAGE_SHEET_NAME); 
		
		return data; 
	}
	@Description("Verify  new contacs on contacts page ...")
	@Severity(SeverityLevel.MINOR)
	@Test (priority = 3, dataProvider = "getContactsTestData")
	
	public void createNewContactTest (String emailid, String firstname, String lastname, String jobtitle) throws InterruptedException  {
		
		contactsPage.createContact(emailid, firstname, lastname, jobtitle);
		contactsPage.deleteContacts();
	}
	

	
	
	

}
