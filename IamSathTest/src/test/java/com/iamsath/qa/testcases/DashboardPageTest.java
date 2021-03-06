package com.iamsath.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iamsath.qa.base.TestBase;
import com.iamsath.qa.pages.CatalogPage;
import com.iamsath.qa.pages.DashboardPage;
import com.iamsath.qa.pages.LoginPage;
import com.iamsath.qa.util.TestUtil;

public class DashboardPageTest extends TestBase {
	LoginPage lp;
	DashboardPage dp;
	CatalogPage cp;
	
	
	public DashboardPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		lp = new LoginPage();
		dp = lp.Login(prop.getProperty("userName"), prop.getProperty("passWord"));
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
	}
	
	
	@Test(priority=1)
	public void checkDashBoardLogo() {
		boolean flag = dp.isLogoVisible();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority=2)
	public void checkNewReqAccess() {
		String newReqAccess = dp.validateNewReqAccess();
		Assert.assertEquals(newReqAccess, "Request New Access");
	}
	
	@Test(priority=3)
	public void NewRequestAccessTest() {
		cp = dp.clickNewAccessButton();
	}
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
	      driver.quit();
	  }
}
