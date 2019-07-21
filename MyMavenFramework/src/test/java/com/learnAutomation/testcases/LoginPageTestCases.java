package com.learnAutomation.testcases;

import java.util.Set;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.learnAutomation.pages.BaseClass;
import com.learnAutomation.pages.AmazonLoginPage;
import com.learnAutomation.utility.Listner;

public class LoginPageTestCases extends BaseClass{
	
	
	@Test
	public void loginApp() {
		//This is first commit from Kuldip
		logger = report.createTest("Login to Amazon");
		AmazonLoginPage amazonLoginPage = PageFactory.initElements(driver, AmazonLoginPage.class);
		logger.info("Strating application");
		amazonLoginPage.loginToFK(excel.getStringData("Login", 1, 0), excel.getStringData("Login", 1, 1));
		Listner.captureScreenShot(driver);
		logger.pass("Login Success");
		AmazonHomePage amazonHomePage = PageFactory.initElements(driver, AmazonHomePage.class);
		String handle= driver.getWindowHandle();
		amazonHomePage.inputSeachItem.sendKeys("Apple iPhone X (256GB) - Space Grey");
		amazonHomePage.iconSearch.click();
		amazonHomePage.textDeviceName.click();
		for(String handle1 : driver.getWindowHandles()) {
			if(!handle.equals(handle1)) {
		    driver.switchTo().window(handle1);}}
		amazonHomePage.textSelectedDeviceName.getText().equals("Apple iPhone X (256GB) - Space Grey");
		amazonHomePage.buttonAddToCart.click();
		amazonHomePage.buttonCart.click();
		amazonHomePage.labelShoppingCart.getText().equalsIgnoreCase("Shopping Cart");
		Select select = new Select(driver.findElement(By.xpath("//select[@name='quantity']")));
		select.selectByValue("2");
		amazonHomePage.buttonProceedToBuy.click();
		
		DeliveryAddressPage deliveryAddressPage = PageFactory.initElements(driver, DeliveryAddressPage.class);
		deliveryAddressPage.inputPinCode.sendKeys("411044");
		deliveryAddressPage.inputCompany.sendKeys("AgroStar");
		deliveryAddressPage.inputCity.sendKeys("Pune");
		deliveryAddressPage.inputState.sendKeys("Maharashtra");
		deliveryAddressPage.buttonContinue.click();
		driver.close();
		driver.switchTo().window(handle);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(amazonHomePage.labelAccountAndList);
		actions.moveToElement(amazonHomePage.labelSignOut).click();
	}
	

	
	
}
