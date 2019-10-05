package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class Login extends Testbase {
	
	

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="(//img[@class='img-responsive'])[1]")
	WebElement logo;
	
	public Login(){
		PageFactory.initElements(driver, this);

	}
	
	public String verifyTitle() {
		return driver.getTitle();
		
	}
	
	public boolean verifylogo() {
		return logo.isDisplayed();
	}
	
	public HomePage login(String uname,String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
		
	}
}
