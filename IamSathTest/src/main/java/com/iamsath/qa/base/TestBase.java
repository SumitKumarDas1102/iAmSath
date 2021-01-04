package com.iamsath.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.iamsath.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new  FileInputStream("D:\\QA_Work\\selenium_iAmSath\\IamSathTest\\src\\main\\java\\com\\iamsath\\qa\\config\\config.properties");
			prop.load(ip);			
		} catch(FileNotFoundException e) {
			e.printStackTrace();	
	} catch(IOException e) {
		e.printStackTrace();
		}
	}
	
	//Setup the test environment
	public static void initialization() {
		String browserName = prop.getProperty("testBrowser");
		String chromeDriver = prop.getProperty("chromeDriverPath");
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",chromeDriver);
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		
		//launch the application
		String applicationURL = prop.getProperty("applicationUrl");
		driver.get(applicationURL);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
	}
	
	
}
