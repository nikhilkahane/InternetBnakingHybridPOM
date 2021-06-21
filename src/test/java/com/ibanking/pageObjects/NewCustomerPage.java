package com.ibanking.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ibanking.base.TestBase;

public class NewCustomerPage extends TestBase{
	
	//Object Repository or page factory
	@FindBy(name="name")
	WebElement name;
	
	@FindBy(xpath="//input[@value='m']")
	WebElement radioMale;
	
	@FindBy(xpath="//input[@value='f']")
	WebElement radioFemale;
	
	@FindBy(name="dob")
	WebElement dateOfBirth;
	
	@FindBy(name="addr")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement PIN;
	
	@FindBy(name="telephoneno")
	WebElement mobileNo;
	
	@FindBy(name="emailid")
	WebElement email;
	
	@FindBy(name="password")
	WebElement pswd;
	
	@FindBy(name="sub")
	WebElement submitButton;
	
	@FindBy(name="res")
	WebElement resetButton;
	
	@FindBy(linkText="Home")
	WebElement homePageLink;
	
	@FindBy(linkText="Edit Customer")
	WebElement editCustomerLink;
	
	//x[ath for customer ID-//td[contains(text(),'Customer ID')]//following-sibling::td
	
	public boolean validateTitle(String expTitle) {
		boolean flag=false;
		String actTitle=driver.getTitle();
		System.out.println(actTitle);
		
		if(actTitle.equals(expTitle)) {
			flag=true;
		}
		
		return flag;
	}
	
	public void createCustomer() {
		
		
	}
	

}
