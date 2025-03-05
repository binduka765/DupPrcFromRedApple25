package seldec2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeConcept07 {
	static WebDriver driver;
	public static void main(String[] args) {
		//text --> getText()
		//attribute --> getAttribute()
		
		//get all links
		//capture href value
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
//		String fn_placeholder = driver.findElement(By.id("input-firstname")).getAttribute("placeholder");
//        String fn_type = driver.findElement(By.id("input-firstname")).getAttribute("type");
//        String fn_name = driver.findElement(By.id("input-firstname")).getAttribute("name");
//        
//        System.out.println(fn_placeholder);
//        System.out.println(fn_type);
//        System.out.println(fn_name);
		
		By firstname = By.id("input-firstname");
		By regLink = By.linkText("Register");
		
		String fn_placeholder = doElementGetAttribute(firstname, "placeholder");
		System.out.println(fn_placeholder);
		String register_href = doElementGetAttribute(regLink, "href");
		System.out.println(register_href);
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static String doElementGetAttribute(By locator, String attriName) {
		return getElement(locator).getAttribute(attriName);
	}

}
