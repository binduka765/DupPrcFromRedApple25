package seldec2023;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsRtClick15 {
    static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement rtClickEle = driver.findElement(By.xpath("//span[text()='right click me']"));
		
		Actions act = new Actions(driver);
		act.contextClick(rtClickEle).perform();
		
		List<WebElement> rightclickeles 
		= driver.findElements(By.cssSelector("ul.context-menu-list>li:not(.context-menu-separator)"));
		
		for(WebElement e: rightclickeles) {
			String text = e.getText();
			System.out.println(e.getText());
			if(text.equals("Copy")) {
				e.click();
				break;
			}
		}

	}

}
