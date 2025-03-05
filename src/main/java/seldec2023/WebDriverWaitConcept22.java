package seldec2023;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitConcept22 {
    static WebDriver driver;
	public static void main(String[] args) {
// Wait(I):until();-->FluentWait(C):until(){}+other methods -->WebDriverWait(C):no methods
	driver = new ChromeDriver();
	driver.get("https://www.orangehrm.com/en/30-day-free-trial");
	
	By fullName = By.id("Form_getForm_Name");
	By bussEmail = By.id("Form_getForm_Email");
	waitForElementPresence(fullName, 10).sendKeys("BinAuto");
	getElement(bussEmail).sendKeys("binauto@appmail.com");
	
	//e1:10 secs
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	WebElement fullName_ele = wait.until(ExpectedConditions.presenceOfElementLocated(fullName));
//	fullName_ele.sendKeys("testing");	
	
	//e2:0 secs
//	driver.findElement(By.id("Form_getForm_Email")).sendKeys("test@gmail.com");

	}
   public static WebElement waitForElementPresence(By locator, int timeout) {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	   return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
   }
   
   public static WebElement getElement(By locator) {
	  return driver.findElement(locator);
   }
}
