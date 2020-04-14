package com.qa.saucedemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.saucedemo.base.BasePage;
import com.qa.saucedemo.util.ElementUtil;

public class CheckoutPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	
	By firstName = By.id("first-name");
	By LastName = By.id("last-name");
	By zipCode = By.id("postal-code");
	By continueBtn = By.xpath("//div/input[@type='submit' and @value='CONTINUE']");
	By onesie = By.xpath("//button[@class='btn_primary btn_inventory'][last()]");
	By backPack = By.xpath("//button[@class='btn_primary btn_inventory'][1]");
	By totalPrice = By.cssSelector(".summary_total_label");
	By finishBtn = By.linkText("FINISH");
	
	
	
	
	
	public CheckoutPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	public void enterInformation(String fristName, String lastName, String zipC){
		elementUtil.doSendKey(firstName, fristName);
		elementUtil.doSendKey(LastName, lastName);
		elementUtil.doSendKey(zipCode, zipC);
		elementUtil.doClick(continueBtn);
	}
	
	public boolean correctItemsInCart1(){
		return elementUtil.isElementDisplayed(onesie);
		
	}
	public boolean correctItemsIncart2(){
		return elementUtil.isElementDisplayed(backPack);
	}
	
	public void TotalPrice(String total){
		elementUtil.TotalPriceEqual(total);
		elementUtil.doClick(finishBtn);
		
	
}
	

}
