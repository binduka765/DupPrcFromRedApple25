package seldec2023;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSuggestions10 {
    static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		
		Thread.sleep(3000);
		
		List<WebElement> suggList = driver.findElements(By.xpath("//ul[@class='G43f7e']//div[@class='wM6W7d']/span"));
		System.out.println(suggList.size());
		
		for(WebElement e: suggList) {
			String txt = e.getText();
			System.out.println(txt);
			if(txt.contains("python")) {
				e.click();
				break;
			}
		}
		
		

	}

}
