package com.ibanking.pageObjects;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ibanking.base.TestBase;
import com.ibanking.utilities.TestUtil;

public class NewAccountPage extends TestBase{
	
	//object repository or page factory
	@FindBy(name="cusid")
	WebElement customerIDInput;
	
	@FindBy(name="inideposit")
	WebElement initialDepositInput;
	
	@FindBy(name="selaccount")
	WebElement accType;
	
	@FindBy(name="button2")
	WebElement submitBtn;
	
	public NewAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Methods or  actions
	public boolean createAccount(String row, String custID, String type, String deposit) throws IOException {
		
		boolean accCreated;
		
		customerIDInput.sendKeys(custID);
		Select selectType = new Select(accType); //initialize select with dropdown web element
		selectType.selectByVisibleText(type);
		initialDepositInput.sendKeys(deposit);
		
		submitBtn.click();
		
		try {
			Alert a = driver.switchTo().alert();
			System.out.println("Failed to create acoount "+ custID +" with error: "+a.getText());
			a.accept();
			accCreated=false;
		
		}catch(NoAlertPresentException e) {
			String val=driver.findElement(By.xpath("//td[contains(text(),'Account ID')]//following-sibling::td")).getText();
			System.out.println("New account no.: "+val);
			TestUtil.writeToExcel(row, filePath, val,"NewAccount");
			accCreated=true;
		}
		
		return accCreated;
		
	}
	
	
	
	
	
	
	
	
	

}
