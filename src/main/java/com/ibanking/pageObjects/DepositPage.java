package com.ibanking.pageObjects;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ibanking.base.TestBase;
import com.ibanking.utilities.TestUtil;

public class DepositPage extends TestBase{
	
	//object repository or page factory
	@FindBy(name="accountno")
	WebElement 	accnoInput;
	
	@FindBy(name="ammount")
	WebElement 	amountInput;
	
	@FindBy(name="desc")
	WebElement descriptionInput;
	
	@FindBy(name="AccSubmit")
	WebElement submitBtn;
	
	
	public DepositPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Methods or actions
	public boolean depositAmount(String row, String accno, String amt, String desc) throws IOException {
		
		boolean deposited;
		accnoInput.sendKeys(accno);
		amountInput.sendKeys(amt);
		descriptionInput.sendKeys(desc);
		
		submitBtn.click();
		
		try {
			Alert a = driver.switchTo().alert();
			System.out.println("Failed to deposit amount into "+ accno +" with error: "+a.getText());
			a.accept();
			deposited=false;
		
		}catch(NoAlertPresentException e) {
			String val=driver.findElement(By.xpath("//td[contains(text(),'Current Balance')]//following-sibling::td")).getText();
			System.out.println("Updated balance: "+val);
			TestUtil.writeToExcel(row, filePath, val,"Deposit");
			deposited=true;
		}
		
		return deposited;
	}
	

}
