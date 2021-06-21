package com.ibanking.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ibanking.base.TestBase;
import com.ibanking.pageObjects.HomePage;
import com.ibanking.pageObjects.LoginPage;
import com.ibanking.pageObjects.NewCustomerPage;

public class NewCustomerPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	NewCustomerPage newCustomerPage;
	
	public NewCustomerPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		newCustomerPage=homePage.goToNewCustomer();
	}
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	
	@Test
	public void createCustomerTest() {
		newCustomerPage.createCustomer("oridgeirgio", "Male", "20121999", "ksnvie ksefhi osief", "Pune", "MP", "434321", "9094647489", "lksj@mail.com", "1q2w3e4r");
	}

}
