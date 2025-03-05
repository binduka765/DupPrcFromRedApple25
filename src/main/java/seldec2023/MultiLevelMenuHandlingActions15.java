package seldec2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultiLevelMenuHandlingActions15 {
    static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com");
		Thread.sleep(2000);
		
		By lvl1Menu = By.xpath("(//span[contains(text(),'Shop by')])[2]");
		
		By lvl2Menu = By.linkText("Beverages");
		
		By lvl3Menu = By.linkText("Tea");
		
		By lvl4Menu = By.linkText("Green Tea");
		
		handleMenuSubmenuLevels4(lvl1Menu, lvl2Menu, lvl3Menu, lvl4Menu);
		
		

	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
   public static void handleMenuSubmenuLevels4(By level1Menu, By level2Menu, By level3Menu, By level4Menu) throws InterruptedException {
	   
	   getElement(level1Menu).click();
	   
	   Actions act = new Actions(driver);
	   
	   act.moveToElement(getElement(level2Menu)).perform();
	   Thread.sleep(1500);
	   
	   act.moveToElement(getElement(level3Menu)).perform();
	   Thread.sleep(1500);
	   
	   getElement(level4Menu).click();
	   
   }

}
