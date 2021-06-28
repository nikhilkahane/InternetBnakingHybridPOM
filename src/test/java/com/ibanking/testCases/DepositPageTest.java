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
import com.ibanking.pageObjects.NewAccountPage;
import com.ibanking.utilities.TestUtil;

public class DepositPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	DepositPage depositPage;
	
	public DepositPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		depositPage=homePage.goToDeposit();
	}
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	@Test(dataProvider="depositData")
	public void depositAmountTest(String row, String accno, String amt, String desc, String bal) throws IOException {
		Assert.assertTrue(depositPage.depositAmount(row, accno, amt, desc), "Amount not deposited");
	}
	
	@DataProvider
	public Object[][] depositData() throws IOException{
		Object[][] newcust = TestUtil.dataProvider(filePath,"Deposit");
		return newcust;
	}
	


}
