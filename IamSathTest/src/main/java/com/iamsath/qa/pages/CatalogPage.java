package com.iamsath.qa.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iamsath.qa.base.TestBase;
import com.iamsath.qa.util.TestUtil;

public class CatalogPage extends TestBase {
	
	@FindBy(xpath = "//input[@id='mat-input-0']")
	WebElement searchBox;

	
	
	
	
	public boolean isSearchfiledVisible() {
		WebElement element = new WebDriverWait(driver, TestUtil.explicit_wait).until(ExpectedConditions.visibilityOf(searchBox));
		return searchBox.isDisplayed();
	}
	
	public SearchResult searchfunction() {
		WebElement element = new WebDriverWait(driver, TestUtil.explicit_wait).until(ExpectedConditions.visibilityOf(searchBox));
		 searchBox.sendKeys("7Geese");
		 return new SearchResult();
	}
	
	
	
	
	
	
	
	
}



