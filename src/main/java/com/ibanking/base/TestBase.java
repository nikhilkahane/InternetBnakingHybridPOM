package com.ibanking.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ibanking.utilities.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eventDriver;
	public static WebEventListener eventListener;
	public static String filePath = System.getProperty("user.dir")+
			"\\src\\test\\java\\com\\ibanking\\testData\\InernetBankingTestData.xlsx";
	
	public TestBase() {
		
		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+
					"\\src\\main\\java\\com\\ibanking\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void initialization() {
		
		String browsername = prop.getProperty("browser");
		if(browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}else {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe");
			driver=new EdgeDriver();	
		}
		
		eventDriver = new EventFiringWebDriver(driver);
		eventListener= new WebEventListener();
		eventDriver.register(eventListener);
		driver=eventDriver;
		
		
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		//driver.get(prop.getProperty("url"));
		driver.navigate().to(prop.getProperty("url")); //navigate to can also be used to go to url
		
		
	}

}
