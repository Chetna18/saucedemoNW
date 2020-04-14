package com.qa.saucedemo.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.saucedemo.base.BasePage;
import com.qa.saucedemo.page.InventoryPage;
import com.qa.saucedemo.page.LoginPage;

public class InventoryPageTest {
	
	public class LoginPageTest {
		WebDriver driver;
		BasePage basePage;
		Properties prop;
		LoginPage loginPage;
		InventoryPage  inventoryPage;
		
		@BeforeTest
		public void setup(){
			basePage = new BasePage();
			prop =basePage.initalize_properties();
			String browserName = prop.getProperty("browser");
			driver = basePage.initialize_driver(browserName);
			driver.get(prop.getProperty("url"));
			loginPage = new LoginPage(driver);
			inventoryPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		}
		
		/*@Test
		public void sortItemsTest(){
			inventoryPage.sortItems("shoppingCart" , prop.getProperty("value"));
		}*/
		
		@Test
		public void addItemsToCartTest(){
			inventoryPage.addItemsToCart();
			
		}
	
		@AfterTest
		public void tearDown(){
			driver.quit();
		}
		
		
	
	
	
	
	}
	
}
	


