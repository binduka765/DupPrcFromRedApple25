package seldec2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTabSequence16 {
     static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		Actions act = new Actions(driver);
		
		WebElement inputStart = driver.findElement(By.name("firstname"));
		
		act.sendKeys(inputStart, "Kinjal")
		   .sendKeys(Keys.TAB)
		   .pause(200)
		   .sendKeys("Ruchi")
		   .sendKeys(Keys.TAB)
		   .pause(200)
		   .sendKeys("KinRu@appmail.com")
		   .sendKeys(Keys.TAB)
		   .pause(200)
		   .sendKeys("2346723452")
		   .sendKeys(Keys.TAB)
		   .pause(200)
		   .sendKeys("KinRu@25")
		   .sendKeys(Keys.TAB)
		   .pause(200)
		   .sendKeys("KinRu@25")
		   .sendKeys(Keys.TAB)
		   .pause(200).build().perform();
		
		
		
	}

}
