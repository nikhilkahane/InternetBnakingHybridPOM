package com.ibanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ibanking.base.TestBase;
import com.ibanking.pageObjects.DepositPage;
import com.ibanking.pageObjects.HomePage;
import com.ibanking.pageObjects.LoginPage;
import com.ibanking.pageObjects.WithdrawalPage;
import com.ibanking.utilities.TestUtil;

public class WithdrawalPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	WithdrawalPage withdrawalPage;
	
	public WithdrawalPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		withdrawalPage=homePage.goToWithdrawal();
	}
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	@Test(dataProvider="withdrawData")
	public void depositAmountTest(String row, String accno, String amt, String desc, String bal) throws IOException {
		Assert.assertTrue(withdrawalPage.withdrawAmount(row, accno, amt, desc), "Amount not withdrawn");
	}
	
	@DataProvider
	public Object[][] withdrawData() throws IOException{
		Object[][] withdraw = TestUtil.dataProvider(filePath,"Withdrawal");
		return withdraw;
	}
	

}
