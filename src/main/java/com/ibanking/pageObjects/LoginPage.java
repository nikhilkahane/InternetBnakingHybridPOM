package com.ibanking.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ibanking.base.TestBase;

public class LoginPage extends TestBase{
	
	//object repository or page factory
	@FindBy(xpath="//*[@name='uid']")
	WebElement uname;
	
	@FindBy(xpath="//*[@name='password']")
	WebElement pswd;
	
	@FindBy(name="btnLogin")
	WebElement loginButton;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String username, String password) {
		uname.sendKeys(username);
		pswd.sendKeys(password);
		loginButton.click();
		
		return new HomePage();
	}
	
	

}
