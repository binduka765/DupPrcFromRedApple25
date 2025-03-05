package seldec2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorStrategy05 {
     
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//create a webelement + perform an action on it(click, sendkeys, gettext,
		//isDisplayed)
		
		//1.id: unique attribute: can not be duplicate
		driver.findElement(By.id("input-email"));
		
		//2.name: can be duplicate:
		
		
		//3.classname:it is not a unique attribute, can be duplicate
		
		//4.xpath: is the complete address of the webelement on the html dom page
		//also known as xml path
		
		//*[@id="input-password"]
		
		//5.css: cascaded style sheet: it is not an attribute:

	}

}
