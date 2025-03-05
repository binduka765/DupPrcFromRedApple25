package seldec2023;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQueryGenericFn10 {
     static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google_vignette");
		
		Thread.sleep(2000);
		
		By drdownLoc = By.id("justAnInputBox");
		By allChoices = By.xpath("//span[@class='comboTreeItemTitle']");
		
		//tc_01: single selection
		selectChoice(drdownLoc, allChoices, "choice 1");
		
		

	}
	public static void doClick(By locator) {
		driver.findElement(locator).click();
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void selectChoice(By drdownlocator, By choices, String value) throws InterruptedException {
		
     //driver.findElement(By.id("justAnInputBox")).click();
		doClick(drdownlocator);
		
		Thread.sleep(2000);
		
	//List<WebElement> choicesList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
       
		List<WebElement> choicesList = getElements(choices);
		System.out.println(choicesList.size());
        
        for(WebElement e: choicesList) {
        String txt = e.getText();
        System.out.println(txt);
        
        if(txt.equals(value)) {
        	e.click();
        	break;
        }
        }
	}

}
