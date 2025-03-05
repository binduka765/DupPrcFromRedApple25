package seldec2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import allexceptions.ElementException;

public class SelectDrDownConcept09 {
    
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		
		WebElement country = driver.findElement(By.id("Form_getForm_Country"));
		
		Select select = new Select(country);
		
//		select.selectByIndex(5);
//		select.selectByIndex(500);//NSE
//		select.selectByVisibleText("India");
//		select.selectByVisibleText(null);//NPE - so needs null check for gen fn
//		select.selectByValue("Australia");
		select.selectByValue(null);//NPE - so needs null check for generic fn
		
//		driver.quit();
		
//		By countryEle = By.id("Form_getForm_Country");
//		
//		doSelectByIndex(countryEle, 5);
//		doSelectByVisibleText(countryEle, "India");
//		doSelectByValue(countryEle, "Australia");

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectByIndex(By locator, int index) {
		 
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
		
	}
	
	public static void doSelectByVisibleText(By locator, String visibleText) {
		
		if(visibleText == null || visibleText.length() == 0) {
			throw new ElementException("visible text cannot be null");
		}
		
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}
	
	public static void doSelectByValue(By locator, String value) {
		
		if(value == null || value.length() == 0) {
			throw new ElementException("visible text cannot be null");
		}
		
		
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
		
	}

}
