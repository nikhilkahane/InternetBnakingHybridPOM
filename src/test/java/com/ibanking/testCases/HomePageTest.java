package com.ibanking.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ibanking.base.TestBase;
import com.ibanking.pageObjects.HomePage;
import com.ibanking.pageObjects.LoginPage;
import com.ibanking.pageObjects.NewCustomerPage;
import com.ibanking.utilities.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	NewCustomerPage newCustomerPage;
	
	String homeTitle = "Guru99 Bank Manager HomePage";
	
	
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
		driver.quit();
	}
	
	
	@Test
	public void titleTest() {
		Assert.assertTrue(TestUtil.validateTitle(homeTitle), "Home page tile does not match");
	}
	
	@Test
	public void validateManagerIDTest() {
		Assert.assertTrue(homePage.validateManagerID(prop.getProperty("username")));
	}
	
	@Test(priority=10)
	public void goToNewCustomerTest() {
		newCustomerPage=homePage.goToNewCustomer();
	}

}
