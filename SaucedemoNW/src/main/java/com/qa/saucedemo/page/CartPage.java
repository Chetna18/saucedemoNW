package com.qa.saucedemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.saucedemo.base.BasePage;
import com.qa.saucedemo.util.ElementUtil;

public class CartPage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	By sortItems = By.xpath("//select/option[@value='za']"); 
	By testTshirt = By.xpath("//button[@class='btn_primary btn_inventory'][1]");
	By removeBtn = By.xpath("//button[contains(@class,'btn_secondary')][1]");
	By conShopping = By.xpath("//div/a[@class='btn_secondary']");
	By backPack = By.xpath("//button[@class='btn_primary btn_inventory'][1]");
	By checkOut = By.id("shopping_cart_container");
	
	
	public CartPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public boolean itemOneIsDisplay(){
		return elementUtil.isElementDisplayed(testTshirt);
		}
	
	public boolean itemTwoIsDisplay(){
		return elementUtil.isElementDisplayed(sortItems);
	}
	
	public CheckoutPage addRemoveCheckout(){
		elementUtil.doClick(removeBtn);
		elementUtil.doClick(conShopping);
		elementUtil.doClick(backPack);
		elementUtil.doClick(checkOut);
		return new CheckoutPage(driver);
	}
	
}
