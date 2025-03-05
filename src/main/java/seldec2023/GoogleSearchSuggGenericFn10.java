package seldec2023;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchSuggGenericFn10 {
     static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		By searchField = By.name("q");
		By searchSuggs = By.xpath("//ul[@class='G43f7e']//div[@class='wM6W7d']/span");
		
		doSearch(searchField, "selenium", searchSuggs, "python");
		
//		ElementUtility05 eleUtil = new ElementUtility05(driver);
//		eleUtil.

	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void doSearch(By searchlocator, String searchKey, By suggsList, String value) throws InterruptedException {
		getElement(searchlocator).sendKeys(searchKey);
		
		Thread.sleep(3000);
		
		List<WebElement> suggestions = getElements(suggsList);
		
		for(WebElement e: suggestions) {
			String txt = e.getText();
			System.out.println(txt);
			
			if(txt.contains(value)) {
				e.click();
				break;
			}
		}
	}

}
