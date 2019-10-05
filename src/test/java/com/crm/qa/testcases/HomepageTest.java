package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.Contact;
import com.crm.qa.pages.Deals;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Login;
import com.crm.qa.util.TestUtil;

public class HomepageTest extends Testbase{
	Login login;
	HomePage homePage;
	TestUtil util;
	Contact contact;
	Deals deals;
	public HomepageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		util= new TestUtil();
		login = new Login();
		homePage=login.login(prop.getProperty("username"), prop.getProperty("password"));
		contact=new Contact();
		deals = new Deals();
	}
	
	
	@Test
	public void verifyTitleTest() {
		String titlehome=homePage.verifyTitle();
		Assert.assertEquals("CRMPRO1", titlehome,"Title not found");
	}
	
	@Test
	public void verifylabelTest() {
		util.switchFrame();
		boolean label=homePage.userlable();
		Assert.assertTrue(label);
		
	}
	
	@Test
	public void VerifyContactTest() throws InterruptedException {
		util.switchFrame();
		contact=homePage.contactLink();		
	}
	@Test
	public void verifyDealsTest() throws InterruptedException {
		util.switchFrame();
		deals=homePage.DealsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
