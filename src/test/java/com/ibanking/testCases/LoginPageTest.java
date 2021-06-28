package com.ibanking.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ibanking.base.TestBase;
import com.ibanking.pageObjects.HomePage;
import com.ibanking.pageObjects.LoginPage;
import com.ibanking.utilities.TestUtil;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	String loginTitle = "Guru99 Bank Home Page";
	String homeTitle = "Guru99 Bank Manager HomePage";
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testTitle() {
		Assert.assertTrue(TestUtil.validateTitle(loginTitle),"Title did not match");
	}
	
	@Test(priority=10)
	public void loginTest() {
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(TestUtil.validateTitle(homeTitle),"Title did not match");
	}
	

}
