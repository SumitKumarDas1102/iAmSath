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
import com.iamsath.qa.pages.SearchResult;
import com.iamsath.qa.util.TestUtil;

public class CatalogPageTest extends TestBase {
	LoginPage lp;
	DashboardPage dp;
	CatalogPage cp;
	SearchResult sp;

	
	public CatalogPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		lp = new LoginPage();
		dp = lp.Login(prop.getProperty("userName"), prop.getProperty("passWord"));
		cp = dp.clickNewAccessButton();
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void checkSearchField() {
		boolean flag = cp.isSearchfiledVisible();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void checkSearchResult() {
		sp = cp.searchfunction();
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
	      driver.quit();
	  }

}
