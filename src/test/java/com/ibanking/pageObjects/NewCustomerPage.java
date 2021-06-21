package com.ibanking.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ibanking.base.TestBase;

public class NewCustomerPage extends TestBase{
	
	//Object Repository or page factory
	@FindBy(name="name")
	WebElement nameInput;
	
	@FindBy(xpath="//input[@value='m']")
	WebElement radioMale;
	
	@FindBy(xpath="//input[@value='f']")
	WebElement radioFemale;
	
	@FindBy(name="dob")
	WebElement dateOfBirth;
	
	@FindBy(name="addr")
	WebElement addressInput;
	
	@FindBy(name="city")
	WebElement cityIput;
	
	@FindBy(name="state")
	WebElement stateInput;
	
	@FindBy(name="pinno")
	WebElement PINInput;
	
	@FindBy(name="telephoneno")
	WebElement mobileNoInput;
	
	@FindBy(name="emailid")
	WebElement emailInput;
	
	@FindBy(name="password")
	WebElement pswdInput;
	
	@FindBy(name="sub")
	WebElement submitButton;
	
	@FindBy(name="res")
	WebElement resetButton;
	
	@FindBy(linkText="Home")
	WebElement homePageLink;
	
	@FindBy(linkText="Edit Customer")
	WebElement editCustomerLink;
	
	//x[ath for customer ID-//td[contains(text(),'Customer ID')]//following-sibling::td
	
	public NewCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public boolean validateTitle(String expTitle) {
		boolean flag=false;
		String actTitle=driver.getTitle();
		System.out.println(actTitle);
		
		if(actTitle.equals(expTitle)) {
			flag=true;
		}
		
		return flag;
	}
	
	public void createCustomer(String name, String gender, String date, String addr, String city, String state, String PIN, String mobile, String email, String password) {
		nameInput.sendKeys(name);
		
		if(gender.equalsIgnoreCase("Male")) {
			radioMale.click();
		}else {
			radioFemale.click();
		}
		
		//given that date is entered in ddmmyyyy format e.g for 15 Mar 1990 use 15031990
		String chop1= date.substring(0, 3);
		String chop2= date.substring(4);
		dateOfBirth.sendKeys(chop1+Keys.TAB+chop2);
		
		addressInput.sendKeys(addr);
		cityIput.sendKeys(city);
		stateInput.sendKeys(state);
		PINInput.sendKeys(PIN);
		mobileNoInput.sendKeys(mobile);
		emailInput.sendKeys(email);
		pswdInput.sendKeys(password);
			
		submitButton.click();
		
	}
	

}
