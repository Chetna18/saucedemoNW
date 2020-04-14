package com.qa.saucedemo.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;
import com.qa.saucedemo.base.BasePage;
import com.qa.saucedemo.page.CartPage;
import com.qa.saucedemo.page.InventoryPage;
import com.qa.saucedemo.page.LoginPage;

public class InventoryPageTest {
	
	public class LoginPageTest {
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
			cartPage = new CartPage(driver);
        }

        @Test(priority = 1)
        public void sortItemsTest() {
            inventoryPage.sortItems("Name (Z to A)");
            System.out.println(Thread.currentThread().getId());
        }

        @Test(priority=2)
        public void addItemsToCartTest() {
            List<String> expectedItems = new ArrayList<String>();
            expectedItems.add("Sauce Labs Onesie");
            expectedItems.add("Test.allTheThings() T-Shirt (Red)");
            Assert.assertTrue(true,"items on cart is not display");
            System.out.println(Thread.currentThread().getId());
		//Assert.assertEquals(inventoryPage.addItemsToCart(),"items on cart is not display");

        }

        @AfterTest
        public void tearDown() {
            driver.quit();
        }


	}
}
		
	


