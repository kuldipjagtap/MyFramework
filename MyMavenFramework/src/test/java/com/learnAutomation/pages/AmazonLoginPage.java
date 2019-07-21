package com.learnAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonLoginPage {
		
	public AmazonLoginPage() {
	}
	
	@FindBy(xpath="//span[text()='Hello, Sign in']") 
	WebElement buttonSignIn;
	
	@FindBy(xpath="//input[@name='email']") 
	WebElement inputEmailOrMobile;
	
	@FindBy(xpath="//input[@id='continue']") 
	WebElement buttonContinue;
	
	@FindBy(xpath="//input[@id='ap_password']") 
	public WebElement inputPassword;
	
	@FindBy(xpath="//input[@id='signInSubmit']") 
	public WebElement buttonLogin;
	
	public void loginToFK(String userName, String password) {
		
		buttonSignIn.click();
		inputEmailOrMobile.sendKeys(userName);
		buttonContinue.click();
		inputPassword.sendKeys(password);
		buttonLogin.click();
	}

}
