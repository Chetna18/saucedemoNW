package com.qa.saucedemo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;
	/**
	 * this method is used to initialize the driver on the browser name
	 * @param prop2
	 * @return WebDriver
	 */
	public WebDriver initialize_driver(String browserName){
		if(browserName.equals("Chrome")){
			WebDriverManager.chromedriver().setup();
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--headless");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE")){
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			}
		else{
			System.out.println(browserName + "browser value is wrong, please pass the correct browser name...");
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		
		return driver;	
		}
	/**
	 * This method is used to read the properties from config.properties file
	 * @return prop
	 */
	
	public Properties initalize_properties(){
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\chetn\\workspace\\SaucedemoNW\\src\\main\\java\\com\\qa\\saucedemo\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("some issue with config properties... please correct your config...");
		} catch (IOException e) {
			System.out.println("properties could not be loaded...");
			e.printStackTrace();
		}
		
		return prop;
	}
	
}
