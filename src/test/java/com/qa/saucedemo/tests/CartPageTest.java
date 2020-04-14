package com.qa.saucedemo.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.saucedemo.base.BasePage;
import com.qa.saucedemo.page.CartPage;
import com.qa.saucedemo.page.InventoryPage;
import com.qa.saucedemo.page.LoginPage;

public class CartPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	InventoryPage  inventoryPage;
	CartPage cartPage;
	
	@BeforeTest
	public void setup(){
		basePage = new BasePage();
		prop =basePage.initalize_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.initialize_driver(browserName);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		inventoryPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		cartPage = inventoryPage.addItemsToCart();
		
	}
		
		@Test(priority=1)
		public void itemOneIsDisplayTest(){
			Assert.assertTrue(cartPage.itemOneIsDisplay(),"item one is displayed");
		}
		
		@Test(priority=2)
		public void itemTwoIsDisplayTest(){
			Assert.assertTrue(cartPage.itemTwoIsDisplay(),"item two is not displayed");
		}
	
		@Test(priority=3)
		public void addRemoveCheckoutTest(){
			cartPage.addRemoveCheckout();
		
		}
		
		
		@AfterTest
		public void tearDown(){
			driver.quit();
		}
		
	}

	
	
	
	
	
	


