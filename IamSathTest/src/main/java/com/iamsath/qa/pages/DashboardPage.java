package com.iamsath.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iamsath.qa.base.TestBase;
import com.iamsath.qa.util.TestUtil;

public class DashboardPage extends TestBase {
	
	@FindBy(xpath="//img[@class='logo']")
	WebElement dashboardLogo;
	
	@FindBy(xpath="//div[contains(text(),'Request New Access')]")
	WebElement requestNewAccess;
	
	@FindBy(xpath="//span[contains(text(),'Request Access')]")
	WebElement requestNewAccessButton;
	
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isLogoVisible() {
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		return dashboardLogo.isDisplayed();
		
	}
	
	public String validateNewReqAccess() {
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		requestNewAccess.isDisplayed();
		return requestNewAccess.getText();
	}
	
	public CatalogPage clickNewAccessButton() {
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		requestNewAccessButton.click();
		return new CatalogPage();
	}
	
	
	
	
	
	
	
	

}
