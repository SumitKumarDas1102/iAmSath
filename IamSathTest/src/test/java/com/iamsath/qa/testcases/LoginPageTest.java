package com.iamsath.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iamsath.qa.base.TestBase;
import com.iamsath.qa.pages.DashboardPage;
import com.iamsath.qa.pages.LoginPage;
import com.iamsath.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	LoginPage lp;
	DashboardPage dp;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		lp = new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		String pageTitle = lp.validatePageTitle();
		Assert.assertEquals(pageTitle, "IDHub Application");
	}
	
	@Test(priority=2)
	public void LoginPageHeaderTest() {
		boolean flag = lp.validatePageHeader();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void LoginFunctionTest() {
		dp = lp.Login(prop.getProperty("userName"), prop.getProperty("passWord"));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	 public void tearDown() {
	      driver.quit();
	  }
}
