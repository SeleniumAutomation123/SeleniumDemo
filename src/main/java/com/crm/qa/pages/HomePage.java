package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class HomePage extends Testbase {
	
	@FindBy(xpath ="//td[contains(text(),'User: testuser7879 testuser7879')]")
	WebElement userLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//a[text()='Deals']")
	WebElement DealsLink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);

	}
	
	public String verifyTitle() {
		return driver.getTitle();
		
	}
	
	public boolean userlable() {
		return userLabel.isDisplayed();
	}
	
	public Contact contactLink() {
		contactLink.click();
		return  new Contact();
	}
	
	public Deals DealsLink() {
		DealsLink.click();
		return  new Deals();
	}
	
}
