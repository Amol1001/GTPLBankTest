package com.GTPLBank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GTPLBank.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = ".//img[@src='../images/1.gif']")
	WebElement image;

	@FindBy(xpath = "//a[.='Manager']")
	WebElement manager;

	@FindBy(xpath = "//a[.='New Customer']")
	WebElement newCustm;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validatePageTitle() {
		return driver.getTitle();
	}

	public boolean validatPageLogo() {
		return image.isDisplayed();
	}

	public String verifyUser() {
		return manager.getText();
	}
    
	public NewCustomerGTPL clickOnNewCustomer(){
		newCustm.click();
		return new NewCustomerGTPL();
	}
}
