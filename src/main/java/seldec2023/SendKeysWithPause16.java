package seldec2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SendKeysWithPause16 {
    static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		Actions act = new Actions(driver);
		
		WebElement searchBox = driver.findElement(By.name("search"));
		
		String value = "macbook";
		
		char val[] = value.toCharArray();
		
		for(char c: val) {
			act.sendKeys(searchBox, String.valueOf(c)).pause(500).build().perform();
		}
		
		

	}

}
