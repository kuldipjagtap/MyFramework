package com.learnAutomation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AmazonHomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement inputSeachItem;
	
	@FindBy(xpath="//input[@value='Go']")
	WebElement iconSearch;
	
	@FindBy(xpath="//span[text()='Hello, kuldip']")
	WebElement textHelloUser;
	
	@FindBy(xpath="//span[text()='Apple iPhone Xs (256GB) - Space Grey']")
	WebElement textDeviceName;
	
	@FindBy(xpath="//h1[@id='title']//span[normalize-space(text()='Apple iPhone Xs (256GB) - Space Grey')]")
	WebElement textSelectedDeviceName;
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	WebElement buttonAddToCart;
	
	@FindBy(xpath="//a[@id='hlb-view-cart-announce']")
	WebElement buttonCart;
	
	@FindBy(xpath="//div[@id='sc-active-cart'] //h2[normalize-space(text()='Shopping Cart')]")
	WebElement labelShoppingCart;
	
	@FindBy(xpath="//select[@name='quantity']")
	WebElement quantity;
	
	@FindBy(xpath="//input[@name='proceedToCheckout']")
	WebElement buttonProceedToBuy;
	
	@FindBy(xpath="//a[@id='nav-link-accountList']")
	WebElement labelAccountAndList;
	
	@FindBy(xpath="//a[@id='nav-item-signout']//span[text()='Sign Out']")
	WebElement labelSignOut;
	

}