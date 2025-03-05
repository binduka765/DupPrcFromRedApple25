package seldec2023assignments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegPageLinksUsingGenFn07 {
     static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		By regLinksList = By.className("list-group-item");
		
		doGetElementsText(regLinksList, "class");

	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static ArrayList<String> doGetElementsText(By locator, String attrName) {
		List<WebElement> allLinks = getElements(locator);
		ArrayList<String> elestxt = new ArrayList<String>();
		
		for(WebElement e: allLinks) {
			String text = e.getText();
			elestxt.add(text);
		}
		
		System.out.println(elestxt);
		return elestxt;
		
	}

}
