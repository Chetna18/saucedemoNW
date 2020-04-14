package com.qa.saucedemo.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.saucedemo.base.BasePage;
import com.qa.saucedemo.page.CartPage;
import com.qa.saucedemo.page.CheckoutPage;
import com.qa.saucedemo.page.InventoryPage;
import com.qa.saucedemo.page.LoginPage;

public class CheckoutPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	InventoryPage  inventoryPage;
	CartPage cartPage;
	CheckoutPage checkOutPage;
	
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
		checkOutPage = cartPage.addRemoveCheckout();
	}
	
	@Test(priority=1)
	public void enterInformationTest(){
	checkOutPage.enterInformation(prop.getProperty("firstname"),prop.getProperty("lastname"),prop.getProperty("zipcode"));
	}
	@Test(priority=2)
	public void correctItemsInCart1Test(){
		Assert.assertEquals(checkOutPage.correctItemsInCart1(),"purchasing the incorrect items");
	}
	@Test(priority=3)
	public void correctItemsIncart2Test(){
		Assert.assertEquals(checkOutPage.correctItemsIncart2(),"purchasing the incorrect items");
	
	}
	@Test(priority=4)
	public void TotalPriceTest(){
		Assert.assertEquals("finalTotal","total");
		System.out.println("Total price is correct");
		
	}
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	

}
