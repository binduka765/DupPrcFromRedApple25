package seldec2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GenActionsFnSpiceJetMoveToEleClick15 {
	
    static WebDriver driver;
    
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com");
		
		//creating the ele to mouse over so to find the dr down appear:
//		WebElement addOnsEle = driver.findElement(By.xpath("//div[text()='Add-ons']"));
//		
//		Actions act = new Actions(driver);
//		act.moveToElement(addOnsEle).perform();
//		
//		Thread.sleep(2000);
//		
//		//creating the dr down ele after it appeared:
//		WebElement visaServicesEle = driver.findElement(By.xpath("//a[contains(@href, 'VisaServices')]/div/div[text()='Visa Services']"));
//		visaServicesEle.click();
//		
//		String pageTitle = driver.getTitle();
//		System.out.println(pageTitle);

		By mainMenu = By.xpath("//div[text()='Add-ons']");
		By childMenu = By.xpath("//a[contains(@href, 'VisaServices')]/div/div[text()='Visa Services']");

		handleMenuSubmenu(mainMenu, childMenu);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void handleMenuSubmenu(By parentloc, By submenuloc) throws InterruptedException {
		//creating the ele to mouse over so to find the dr down appear:
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentloc)).perform();
		Thread.sleep(2000);
		
		//creating the dr down ele after it appeared: And do click action on it
		getElement(submenuloc).click();
		
		
	}

}
