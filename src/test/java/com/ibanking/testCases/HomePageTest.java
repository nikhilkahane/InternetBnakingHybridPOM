package com.ibanking.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ibanking.base.TestBase;
import com.ibanking.pageObjects.HomePage;
import com.ibanking.pageObjects.LoginPage;
import com.ibanking.pageObjects.NewCustomerPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	NewCustomerPage newCustomerPage;
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	
	@Test
	public void linkTest() {
		Assert.assertTrue(homePage.newCutomerLinkTest());
	}
	
	@Test
	public void validateManagerIDTest() {
		Assert.assertTrue(homePage.validateManagerID(prop.getProperty("username")));
		//Assert.assertTrue(homePage.validateManagerID("mngr"));
	}
	
	@Test
	public void goToNewCustomerTest() {
		newCustomerPage=homePage.goToNewCustomer();
	}

}
