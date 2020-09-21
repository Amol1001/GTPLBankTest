package com.GTPLBank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.GTPLBank.qa.base.TestBase;

public class LoginPage extends TestBase {

	// PageFactory(Object Repository)
	@FindBy(name = "uid")
	WebElement UserID;

	@FindBy(name = "password")
	WebElement Password;

	@FindBy(name = "btnLogin")
	WebElement LOGIN;

	@FindBy(xpath = ".//div[@class='logo']")
	WebElement logo;
	@FindBy(name = "btnReset")
	WebElement resetbtn;

	// Initializing page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validatePageTitle() {
		return driver.getTitle();

	}

	public boolean validateLogo() {
		return logo.isDisplayed();
	}

	public HomePage validateLoginPage(String uid, String pswrd, String reset) {
		if (reset.equalsIgnoreCase("no")) {
			UserID.sendKeys(uid);
			Password.sendKeys(pswrd);
			LOGIN.click();
			String title = driver.getTitle();
			Assert.assertEquals(title, "GTPL Bank Manager HomePage");
			

		} else {
			UserID.sendKeys(uid);
			Password.sendKeys(pswrd);
			resetbtn.click();
			System.out.println("Reset");
		}
		return new HomePage();

	}

}
