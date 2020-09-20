package com.GTPLBank.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.GTPLBank.qa.base.TestBase;
import com.GTPLBank.qa.pages.HomePage;
import com.GTPLBank.qa.pages.LoginPage;

public class LoginGTPLTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginGTPLTest() {
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginPage = new LoginPage();
	}

	@Test
	public void loginPageTitleTest(){
		String title = loginPage.validatePageTitle();
		Assert.assertEquals(title, "GTPL Bank Home Page");
	}
	@Test
	public void logiLogoTest(){
		boolean logo = loginPage.validateLogo();
		Assert.assertTrue(logo);
	}
	@Test
	public void loginTest(){
		homePage = loginPage.validateLoginPage(prop.getProperty("username"),prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
