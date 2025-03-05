package seldec2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClickSendKeys15 {
    static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By usermail = By.id("input-email");
		By pwd = By.id("input-password");
		By loginBtn = By.xpath("//input[@type='submit']");
		
		Actions act = new Actions(driver);
		
//		act.sendKeys(driver.findElement(usermail),"simsim@appmail.com").perform();
//		act.sendKeys(driver.findElement(pwd), "jujube@25").perform();
//		act.click(driver.findElement(loginBtn)).perform();
		
		doActionsSendKeys(usermail, "simsim@appmail.com");
		doActionsSendKeys(pwd, "jujube@25");
		doActionsClick(loginBtn);
		

	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
    public static void doActionsClick(By locator) {
    	Actions act = new Actions(driver);
    	act.click(getElement(locator)).perform();
    }
    public static void doActionsSendKeys(By locator, String value) {
    	Actions act = new Actions(driver);
    	act.sendKeys(getElement(locator), value).perform();
    }
};
