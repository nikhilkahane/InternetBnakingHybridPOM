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
import com.ibanking.pageObjects.NewCustomerPage;
import com.ibanking.utilities.TestUtil;

public class NewCustomerPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	NewCustomerPage newCustomerPage;
	String path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\ibanking\\testData\\InernetBankingTestData.xlsx";
	
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
		driver.quit();
	}
	
	
	@Test(dataProvider="newCustData")
	public void createCustomerTest(String rowNo, String name, String gender, String date, String addr, String city, String state, String PIN, String mobile, String email, String password, String Emt) throws NumberFormatException, IOException {
		boolean result;
		result=newCustomerPage.createCustomer(rowNo, name, gender, date, addr, city, state, PIN, mobile, email, password);
		Assert.assertTrue(result);
	}
	
	@DataProvider
	public Object[][] newCustData() throws IOException{
		Object[][] newcust = TestUtil.dataProvider(path);
		return newcust;
	}

}
