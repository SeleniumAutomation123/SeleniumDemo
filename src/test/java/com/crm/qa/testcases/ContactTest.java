package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.Contact;
import com.crm.qa.pages.Deals;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Login;
import com.crm.qa.util.TestUtil;

public class ContactTest extends Testbase{
	Login login;
	HomePage homePage;
	TestUtil util;
	Contact contact;
	Deals deals;
	
	public ContactTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		util= new TestUtil();
		login = new Login();
		homePage=login.login(prop.getProperty("username"), prop.getProperty("password"));
		util.switchFrame();
		contact=homePage.contactLink();
	}
	
	@Test
	public void verifyContactlabelTest() {
		boolean contactlabel=contact.verifyContactLabel();
		Assert.assertTrue(contactlabel);
	}
	
	@Test
	public void verifyContactSelectTest() throws InterruptedException {
		contact.contactSelect("ab cd");
		
	}
	
	@DataProvider
	public Object[][] getCrmdata() throws InvalidFormatException {
		Object[][] data =TestUtil.getTestData("Contacts");
		return data;
	}
	
	@Test(dataProvider="getCrmdata")
	public void createContacttest(String title,String firstname,String lastname,String company) {
		
		homePage.contactLink();
		//contact.creatContact("Dr.","Tom", "Peter","Google");
		contact.creatContact(title, firstname, lastname, company);
		
}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
