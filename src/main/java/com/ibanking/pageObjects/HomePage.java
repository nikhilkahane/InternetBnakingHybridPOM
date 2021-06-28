package com.ibanking.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ibanking.base.TestBase;

public class HomePage extends TestBase{
	
	//object repository or page factory
	@FindBy(xpath="//tr[@class='heading3']")
	WebElement managerIDLabel;
	
	@FindBy(linkText="New Customer")
	WebElement newCustomerLink;
	
	@FindBy(linkText="New Account")
	WebElement newAccountLink;
	
	@FindBy(linkText="Deposit")
	WebElement depositLink;
	
	@FindBy(linkText="Withdrawal")
	WebElement withdrawalLink;
	
	@FindBy(linkText="Fund Transfer")
	WebElement fundTransferLink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean newCutomerLinkTest() {
		return newCustomerLink.isDisplayed();
	}
	
	public boolean validateManagerID(String mID) {//to validate the user displayed and user logged in are same
		boolean flag;
		String actualID=managerIDLabel.getText();
		if(actualID.contains(mID)) {
			flag=true;
		}else {
			flag=false;
		}
		
		return flag;
	}
	
	public NewCustomerPage goToNewCustomer() {
		newCustomerLink.click();
		
		return new NewCustomerPage();
	}
	
	public NewAccountPage goToNewAccount() {
		newAccountLink.click();
		
		return new NewAccountPage();
	}
	
	public DepositPage goToDeposit() {
		depositLink.click();
		
		return new DepositPage();
	}
	
	public WithdrawalPage goToWithdrawal() {
		withdrawalLink.click();
		
		return new WithdrawalPage();	
	}
	
	public FundTransferPage goToFundTransfer() {
		fundTransferLink.click();
		
		return new FundTransferPage();	
	}
	

}
