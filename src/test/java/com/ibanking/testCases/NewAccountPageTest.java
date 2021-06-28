package com.ibanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ibanking.base.TestBase;
import com.ibanking.pageObjects.HomePage;
import com.ibanking.pageObjects.LoginPage;
import com.ibanking.pageObjects.NewAccountPage;
import com.ibanking.utilities.TestUtil;

public class NewAccountPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	NewAccountPage newAccountPage;
	
	public NewAccountPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		newAccountPage=homePage.goToNewAccount();
	}
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	@Test(dataProvider="newAccData")
	public void createAccountTest(String row, String custID, String type, String deposit, String accno) throws IOException {
		Assert.assertTrue(newAccountPage.createAccount(row, custID, type, deposit), "Account not created due to errors");
	}
	
	@DataProvider
	public Object[][] newAccData() throws IOException{
		Object[][] newcust = TestUtil.dataProvider(filePath,"NewAccount");
		return newcust;
	}
	

}
