package com.docubuilder.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.docubuilder.base.TestBase;

public class LoginPage extends TestBase{

	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='button']")
	WebElement login;
	
	@FindBy(xpath = "//div[@class='topHeaderDCILogoIMAGE']")
	WebElement DocubilderLogo;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateLoginPageTitles() {
		return driver.getTitle();
		
	}
	
	public boolean validateDocubuilderLogo() {
		return DocubilderLogo.isDisplayed();
	}
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		
		return new HomePage();
		
		
	}
	
	
	
	
	
}
