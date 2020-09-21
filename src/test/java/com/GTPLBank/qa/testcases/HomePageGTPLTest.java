package com.GTPLBank.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.GTPLBank.qa.base.TestBase;
import com.GTPLBank.qa.pages.HomePage;
import com.GTPLBank.qa.pages.LoginPage;
import com.GTPLBank.qa.pages.NewCustomerGTPL;

public class HomePageGTPLTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	NewCustomerGTPL newCustomerGtpl;
	
	public HomePageGTPLTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.validateLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("reset"));
	}
	
	@Test
	public void pageTiteTest(){
		String tite = homePage.validatePageTitle();
		Assert.assertEquals(tite, "GTPL Bank Manager HomePage");
	}
	@Test
	public void PageloTest(){
		boolean flag = homePage.validatPageLogo();
		Assert.assertTrue(flag);
	}
	@Test
	public void UserRoleTest(){
		String userRole = homePage.verifyUser();
		Assert.assertEquals(userRole, "Manager");
	}
	@Test
	public void newCustmLinkTest(){
		newCustomerGtpl = homePage.clickOnNewCustomer();
	}
}
