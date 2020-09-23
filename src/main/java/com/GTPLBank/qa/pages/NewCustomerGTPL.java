package com.GTPLBank.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GTPLBank.qa.base.TestBase;

public class NewCustomerGTPL extends TestBase {

	@FindBy(xpath = "//input[@name='name']")
	WebElement customerName;
	
	@FindBy(xpath = "//td[contains(text(),'Gender')]/../td/input[1]")
	WebElement male;
	
	@FindBy(xpath = "//td[contains(text(),'Gender')]/../td/input[2]")
	WebElement female;
	
	@FindBy(xpath = "//input[@id='dob']")
	WebElement dob;
	
	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement address;
	
	@FindBy(xpath = "//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath = "//input[@name='state']")
	WebElement state;
	
	@FindBy(xpath = "//input[@name='pinno']")
	WebElement pinno;
	
	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement cellno;
	
	@FindBy(xpath = "//input[@name='emailid']")
	WebElement email;
	
	@FindBy(xpath = "//input[@name='sub']")
	WebElement submit;
	
	public NewCustomerGTPL(){
		PageFactory.initElements(driver, this);
	}
	
	public String vaidatePageTite(){
		return driver.getTitle();
	}
	
	public void vaidateNewCust_Entry(String cstName, String gender, String date,String month,String year, String addrs, String City, String State, 
			String pin, String mobileno, String emailid){
		
		customerName.sendKeys(cstName);
		if(gender.equalsIgnoreCase("male")){
			male.click();
		}else{
			female.click();
		}
		dob.sendKeys(date);
		dob.sendKeys(month);
		dob.sendKeys(Keys.TAB);
		dob.sendKeys(year);
		address.sendKeys(addrs);
		city.sendKeys(City);
		state.sendKeys(State);
		pinno.sendKeys(pin);
		cellno.sendKeys(mobileno);
		email.sendKeys(emailid);
		//submit.click();
	}
}
