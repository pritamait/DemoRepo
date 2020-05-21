package com.docubuilder.test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.docubuilder.base.TestBase;
import com.docubuilder.pages.HomePage;
import com.docubuilder.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homePage;
	public LoginPageTest() {
			super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		
		
	}
	
	@Test(priority=1)
	
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPageTitles();
		Assert.assertEquals(title, "Login");
		ITestResult result = Reporter.getCurrentTestResult();
        result.setAttribute("requirement", "DOC 50");   // Xray will try to create a link to this requirement issue
        result.setAttribute("test", "DOC 49");          // Xray will try to find this Test issue and report result against it
        result.setAttribute("labels", "core addition");	// Xray will add this(ese) label(s) to the associated Test issue
	}

	
	@Test(priority=2)
	public void DocubuilderLogoTest() {
		boolean flag =loginpage.validateDocubuilderLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void LoginPageTest() {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	

	
	@AfterMethod
	public void closedDown() {
		driver.quit();
	}
	
}
