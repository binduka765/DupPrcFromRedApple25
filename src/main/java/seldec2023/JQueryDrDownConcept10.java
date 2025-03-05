package seldec2023;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQueryDrDownConcept10 {
    static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google_vignette");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("justAnInputBox")).click();
		
		Thread.sleep(2000);
		
		List<WebElement> choicesList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
        System.out.println(choicesList.size());
        
        for(WebElement e: choicesList) {
        String txt = e.getText();
        System.out.println(txt);
        
        if(txt.equals("choice 1")) {
        	e.click();
        	break;
        }
        }
	}

}
