package seldec2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMoveToElement15 {
    static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("http://mrbool.com");
		
		//creating the element: to mouse over so the dr down appears
		WebElement contentEle = driver.findElement(By.xpath("//a[text()='Content  ']"));
		
		//creating the single act to move to actual ele from dr down: 
		Actions act = new Actions(driver);
		act.moveToElement(contentEle).perform();
		//act.moveToElement(contentEle).build().perform();
		//1 - perform
		//1 - build.perform
		//n - build.perform ==> multiple actions are build and then performed
		//build() --> collecting all actions and then built and performed
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Single Videos']")).click();
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		
		

	}

}
