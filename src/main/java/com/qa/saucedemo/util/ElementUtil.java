package com.qa.saucedemo.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.saucedemo.base.BasePage;

public class ElementUtil extends BasePage{
	
	WebDriver driver;
	
	public ElementUtil(WebDriver driver){
		this.driver = driver;
	}
	/**
	 * this method is used to create the webelement on the basis of By locator
	 * @param locator
	 * @return element
	 */
	public WebElement getElement(By locator){
		WebElement element = null;
		try{
		element = driver.findElement(locator);
		}catch(Exception e) {
			System.out.println("Some exception occurred while creating webElement..."  );
			System.out.println(e.getMessage());
		}
		return element;
	}
	

	public void selectValueFromTheDropDown(By element, String option){
		try{
		Select s= new Select((WebElement) element);
		s.selectByVisibleText(option);
		}catch(Exception e){
		
		}
	}
	
	public String getSelectedOption(WebElement element){
		Select s= new Select(element);			
		return s.getFirstSelectedOption().getText();
	}
	
	public void doClick(By locator){
		try{
			getElement(locator).click();
			}catch(Exception e) {
				System.out.println("Some exception occurred while clicking on webelement...");
				System.out.println(e.getMessage());
			}
	}
	public void doSendKey(By locator, String value){
		try{
		WebElement ele = getElement(locator);
		ele.clear();
		ele.sendKeys(value);
		}catch(Exception e){
			System.out.println("Some exception occurred while passing value to Webelement..." );
		}
	}
	public String doGetText(By locator){
		try{
		 return getElement(locator).getText();
		}catch(Exception e) {
			System.out.println("Some excption occurred while getting the text of the webelement....");
			System.out.println(e.getMessage());
			return null;
		}
	
	}
	public void waitElementPresent(By locator, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	public boolean isElementDisplayed(By locator){
		try{
		 return getElement(locator).isDisplayed();
		 	}catch(Exception e) {
				System.out.println("Some exception occurred while checking webelement displayed" + locator);
				System.out.println(e.getMessage());
				return false;
			}
		}
	
	public boolean TotalPriceEqual(String total){
		if(total.equals(total)){
			System.out.println("Total price is correct;"+ total);
		}else{
			System.out.println("please check the items total");
		}
	return true;
	}
	}


