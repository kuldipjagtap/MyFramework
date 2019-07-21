package com.learnAutomation.testcases;

import java.sql.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryAddressPage {
	
	@FindBy(xpath="//div[@class='enter-address-form ']//input[@name='enterAddressPostalCode']")
	WebElement inputPinCode;
	
	@FindBy(xpath="//div[@class='enter-address-form ']//input[@name='enterAddressAddressLine1']")
	WebElement inputCompany;
	
	
	@FindBy(xpath="//div[@class='enter-address-form ']//input[@name='enterAddressCity']")
	WebElement inputCity;
	
	@FindBy(xpath="//div[@class='enter-address-form ']//input[@name='enterAddressStateOrRegion']")
	WebElement inputState;
	
	@FindBy(xpath="//div[@class='enter-address-form ']//input[@name='shipToThisAddress']")
	WebElement buttonContinue;
	
	@FindBy(xpath="//div[@class='a-row a-spacing-medium']//input[@class='a-button-text']")
	WebElement buttonContinueToDelivery;
	
	
	
	
}
