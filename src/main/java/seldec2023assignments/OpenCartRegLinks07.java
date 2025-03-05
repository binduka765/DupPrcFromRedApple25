package seldec2023assignments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenCartRegLinks07 {

	public static void main(String[] args) {
		//1.launchin driver:
		BrowserUtility05 brUtil = new BrowserUtility05();
		WebDriver driver = brUtil.launchBrowser("chrome");
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//2.Locator Bank:
//		By LoginLink = By.linkText("Login");
//		By.linkText("Register");
		
		By regLinksList = By.className("list-group-item");
		
		ElementUtility05 eleUtil = new ElementUtility05(driver);
		List<WebElement> allLinks = eleUtil.getElements(regLinksList);
		ArrayList<String> elestxt = new ArrayList<String>();
		
		for(WebElement e: allLinks) {
			String text = e.getText();
			elestxt.add(text);
		}
		
		System.out.println(elestxt);
		
		

	}

}
