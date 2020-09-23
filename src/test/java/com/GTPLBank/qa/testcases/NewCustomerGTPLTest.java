package com.GTPLBank.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GTPLBank.qa.base.TestBase;
import com.GTPLBank.qa.pages.HomePage;
import com.GTPLBank.qa.pages.LoginPage;
import com.GTPLBank.qa.pages.NewCustomerGTPL;
import com.GTPLBank.qa.util.TestUtil;

public class NewCustomerGTPLTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	NewCustomerGTPL newCustomerGtpl;
	String sheetName = "NewCustomerEntry";
	
	public NewCustomerGTPLTest(){
		super();
	}
	@BeforeMethod
	public void setup(){
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.validateLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("reset"));
		newCustomerGtpl = homePage.clickOnNewCustomer();
	}
	/*@Test(priority=1)
	public void validatePageTest(){
		String title = newCustomerGtpl.vaidatePageTite();
		Assert.assertEquals(title, "Gtpl Bank New Customer Entry Page");
	}*/
	@DataProvider
	public Object[][] getNewCustTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=2, dataProvider = "getNewCustTestData")
	public void newCust_entryTest(String name, String gendr, String day, String month, String year, String addrs, String city, String state,
			String pin, String mobno, String email){
		
		/*newCustomerGtpl.vaidateNewCust_Entry(prop.getProperty("Customer Name"), prop.getProperty("Gender"), prop.getProperty("day"), 
				prop.getProperty("month"), prop.getProperty("year"), prop.getProperty("Address"), prop.getProperty("City"), prop.getProperty("State"), 
				prop.getProperty("PIN"), prop.getProperty("Mobile Number"), prop.getProperty("E-mail"));*/
		newCustomerGtpl.vaidateNewCust_Entry(name, gendr, day, month, year, addrs, city, state, pin, mobno, email);
	}
}
