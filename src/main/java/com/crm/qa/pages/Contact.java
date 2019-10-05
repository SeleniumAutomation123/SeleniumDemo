
//Noname111
package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.Testbase;


public class Contact extends Testbase{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactlabel;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement newContact;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement selectdrop;
	
	@FindBy(name ="first_name")
	WebElement fname;
	
	@FindBy(name="surname")
	WebElement lname;
	
	@FindBy(xpath="//input[@type='button' and @value='Load From Company']/..//input[2]")
	WebElement savebtn;
	
	@FindBy(name="client_lookup")
	WebElement comp;
	
	public Contact(){
		PageFactory.initElements(driver, this);

	}
	
	public boolean verifyContactLabel() {
		return contactlabel.isDisplayed()
;		
	}
	
	
	
	public void contactSelect(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/../..//td[1]/input")).click();;
		
		
	}
	
	
	public void creatContact(String title,String firstname,String lastname ,String company) {
		Actions action = new Actions(driver);
		newContact.click();
		Select select = new Select(selectdrop);
		select.selectByValue(title);
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
		comp.sendKeys(company);
		savebtn.click();
		
		
	}

}
