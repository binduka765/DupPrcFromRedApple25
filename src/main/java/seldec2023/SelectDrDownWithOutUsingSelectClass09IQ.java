package seldec2023;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDrDownWithOutUsingSelectClass09IQ {
     static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		
		//not allowed to use select class-so reach till u get all options
		//by writing an xpath
		
		By allOptions = By.xpath("//select[@id='Form_getForm_Country']/option");
		
		DoSelectDrDownWithoutSelectClass(allOptions, "India");
		DoSelectDrDownWithoutSelectClass(allOptions, "Australia");
		
//		List<WebElement> allOptionsList = driver.findElements(allOptions);
//		
//		System.out.println(allOptionsList.size());
//		
//		for(WebElement e: allOptionsList) {
//			String text = e.getText();
//			
//			if(text.equals("India")) {
//				e.click();
//				break;
//			}
//		}
//		

	}
   public static void DoSelectDrDownWithoutSelectClass(By locator, String value) {
	   
	   List<WebElement> allOptionsList = driver.findElements(locator);
		
		System.out.println(allOptionsList.size());
		
		for(WebElement e: allOptionsList) {
			String text = e.getText();
			
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
		
   }
}
