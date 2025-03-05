package seldec2023;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonTabSeqInputTest16 {
     static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		Actions act = new Actions(driver);
		
		act.sendKeys(Keys.TAB)
		   .sendKeys(Keys.TAB)
		   .sendKeys(Keys.TAB)
		   .sendKeys(Keys.TAB)
		   .sendKeys(Keys.TAB)
		   .sendKeys("macbook Air")
		   .sendKeys(Keys.ENTER)
		   .build().perform();

	}

}
