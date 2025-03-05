package seldec2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
/*
 * Actions: is a class - we have to create an obj to perform various actions
 * 
 * Action : is another interface -- that stores only one action in its var
 */

public class DragNDropConcept15 {
    static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		//ele to ele on the page -- valid
		//file on the page -- NA
		
		driver.switchTo().frame(0);
		
		WebElement srcEle = driver.findElement(By.id("draggable"));
		WebElement targetEle = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
//		act.clickAndHold(srcEle)
//		    .moveToElement(targetEle)
//		        .release()
//		           .build().perform();
		
		act.dragAndDrop(srcEle, targetEle).perform();
		
		

	}

}
