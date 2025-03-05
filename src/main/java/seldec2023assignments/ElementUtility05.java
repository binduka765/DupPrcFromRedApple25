package seldec2023assignments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtility05 {
	
private WebDriver driver;
	
	public ElementUtility05(WebDriver driver) {
		this.driver = driver;
	}
	//method to convert the string locators to By locators:
	//how to create a By locator using the String locators:
	public By getBy(String locatorType, String locatorValue) {
		By locator = null;
		
		switch (locatorType.toLowerCase().trim()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;

		case "classname":
			locator = By.className(locatorValue);
			break;

		case "linktext":
			locator = By.linkText(locatorValue);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
			break;

		case "xpath":
			locator = By.xpath(locatorValue);
			break;

		case "css":
			locator = By.cssSelector(locatorValue);
			break;
		case "tagname":
			locator = By.tagName(locatorValue);
			break;


		default:
			break;
		}
		return locator;
		
	}
	//overloading the below method to take String locator:
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue));
	}
	//overloading the below method to take String type locator:
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	public void doSendKeys(String locatorType, String locatorValue) {
		getElement(getBy(locatorType, locatorValue)).sendKeys(locatorValue);
	}
	public void doClick(By locator) {
		getElement(locator).click();
	}
	public String doGetElementText(By locator) {
		return getElement(locator).getText();
		
	}
	
	//*****************FEsUtilities************************
	
	public  List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
    
	public  int getElementsCount(By locator) {
		return getElements(locator).size();
	}
	
	public  ArrayList<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
	 ArrayList<String> eleTextList = new ArrayList<String>();
	 
	 for(WebElement e: eleList) {
		String text = e.getText();
		
		if(text.length()!=0) {
			eleTextList.add(text);
		}
		
	 }
	 return eleTextList;
	}
	
	public  ArrayList<String> getElementsAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		ArrayList<String> eleAttrList = new ArrayList<String>();
		
		for(WebElement e: eleList) {
			String attrValue = e.getAttribute(attrName);
			
			if(attrValue.length()!=0) {
				eleAttrList.add(attrValue);
				
			}
		}
		return eleAttrList;
	}
	
	

}
