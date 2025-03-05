package seldec2023;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import allexceptions.ElementException;

public class IssueWithThisApproach22 {
     static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/en/30-day-free-trial");

	}
	public static void nullBlankCheck(String value) {
		
		if (value == null || value.length() == 0) {
			throw new ElementException(value + "--- visible text cannot be null or blank");
		}
	}
	
	public static WebElement waitForElementVisible(By locator, int timeout) {
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		   return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	   }
	
	//issue with this approach: is becoming GLOBAL wait again: getting applied to all eles
	//DO NOT DO THIS : SINCE IT IS LIKE IMPLICITLY WAIT AGAIN
	//instead overload the same method:
//	public static void doSendKeys(By locator, String value) {
//		nullBlankCheck(value);
//	//	getElement(locator).sendKeys(value);
//		waitForElementVisible(locator, 10).sendKeys(value);
//		
//	}
	
	public static void doSendKeys(By locator, String value, int timeout) {
		nullBlankCheck(value);
		waitForElementVisible(locator, 10).sendKeys(value);
		
		
	}

}
