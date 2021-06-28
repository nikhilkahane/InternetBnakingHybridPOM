package com.ibanking.pageObjects;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ibanking.base.TestBase;
import com.ibanking.utilities.TestUtil;

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
	
	//xpath for customer ID-//td[contains(text(),'Customer ID')]//following-sibling::td
	
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
	
	public boolean createCustomer(String row, String name, String gender, String date, String addr, String city, String state, String PIN, String mobile, String email, String password) throws IOException {
		boolean custCreated;
		
		nameInput.sendKeys(name);
		
		if(gender.equalsIgnoreCase("Male")) {
			radioMale.click();
		}else {
			radioFemale.click();
		}
		
		//given that date is entered in ddmmyyyy format e.g for 15 Mar 1990 use 15031990
		String chop1= date.substring(0, 4);
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
		
		try {
			Alert a = driver.switchTo().alert();
			System.out.println("Failed to create customer "+name+" with error: "+a.getText());
			a.accept();
			custCreated=false;
		
		}catch(NoAlertPresentException e) {
			String val=driver.findElement(By.xpath("//td[contains(text(),'Customer ID')]//following-sibling::td")).getText();
			TestUtil.writeToExcel(row, filePath, val, "NewCustomer");
			custCreated=true;
		}
		
		return custCreated;
		
		
	}
	
	
	

}
