package com.qa.saucedemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.saucedemo.base.BasePage;
import com.qa.saucedemo.util.ElementUtil;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	By username = By.id("user-name");
	By Password = By.id("password");
	By loginBtn = By.cssSelector(".btn_action");
	
	
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public InventoryPage doLogin(String id, String pwd){
		elementUtil.doSendKey(username, id);
		elementUtil.doSendKey(Password, pwd);
		elementUtil.doClick(loginBtn);
	
		return new InventoryPage(driver);
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
