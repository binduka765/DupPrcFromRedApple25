package seldec2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMoveToEle15 {
       static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		
		
//		WebElement content = driver.findElement(By.xpath("//a[@class='menulink']"));//parentmenu
//		
//		WebElement coursesEle = driver.findElement(By.xpath("//ul[@class='submenu']//a[text()='Courses']"));
		
//		Actions action = new Actions(driver);
//		
//		action.moveToElement(content).perform();
//		Thread.sleep(1500);
//		
//		coursesEle.click();
		
		//tc1: app - mrbool.com
//		driver.get("http://mrbool.com");
//		By content = By.xpath("//a[@class='menulink']");
//		By coursesEle = By.xpath("//ul[@class='submenu']//a[text()='Courses']");
//		
//		handleMenuSubMenu(content,coursesEle);
		
		//tc2: app - spicejet.com
		driver.get("https://www.spicejet.com");
		//By locs bank:
		By AddOnsEle = By.xpath("//div[text()='Add-ons']");
		
		

	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void handleMenuSubMenu(By parentlocator, By childlocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(parentlocator)).perform();
		getElement(childlocator).click();
		
	}
	
}
