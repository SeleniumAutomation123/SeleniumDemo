package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Login;

public class LoginPageTest extends Testbase {
	
	Login login;
	HomePage homePage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		login = new Login();
	}
	
	
	@Test(priority=1)
	public void VerifyTitle() {
		String title=login.verifyTitle();
		Assert.assertEquals("CRMPRO1 - CRM software for customer relationship management, sales, and support.",title);
	}
	
	@Test(priority=2)
	public void verifyLogo() {
		boolean logo=login.verifylogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority=3)
	public void LoginTest() {
		homePage=login.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
