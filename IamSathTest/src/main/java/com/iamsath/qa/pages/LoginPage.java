package com.iamsath.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iamsath.qa.base.TestBase;
import com.iamsath.qa.util.TestUtil;

public class LoginPage extends TestBase {
	
	//Login page object repository
	
	@FindBy(xpath="//h1[contains(text(),'Login to your account')]")
	private WebElement headerContent;
	
	@FindBy(xpath="//input[@id='kc-login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passWord;
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatePageHeader() {
		return headerContent.isDisplayed();		
	}
	
	public DashboardPage Login(String un, String pwd) {
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		userName.sendKeys(un);
		passWord.sendKeys(pwd);
		loginButton.click();
		return new DashboardPage();
	}
	

}