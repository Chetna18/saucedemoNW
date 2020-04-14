package com.qa.saucedemo.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	By itemsInCart = By.cssSelector(".inventory_item_name");

	
	
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
	public List<String> itemsInCart(){
        List<WebElement> items = driver.findElements(itemsInCart);
        List<String> itemsTitle = new ArrayList<String>();
        for (WebElement item : items) {
            itemsTitle.add(item.getText());
        }
        return itemsTitle;
    }

}
