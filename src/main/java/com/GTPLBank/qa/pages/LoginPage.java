package com.GTPLBank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.GTPLBank.qa.base.TestBase;

public class LoginPage extends TestBase {

	//PageFactory(Object Repository)
	@FindBy(name="uid")
	WebElement UserID;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(name="btnLogin")
	WebElement LOGIN;
	
	@FindBy(xpath=".//div[@class='logo']")   
	WebElement logo;
	
	//Initializing page object
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validatePageTitle(){
		return driver.getTitle();
		 
	}
	
	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	public HomePage validateLoginPage(String uid, String pswrd){
		UserID.sendKeys(uid);
		Password.sendKeys(pswrd);
		LOGIN.click();
		return new HomePage();
	}
}
