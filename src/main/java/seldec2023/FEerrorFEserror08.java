package seldec2023;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FEerrorFEserror08 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
//		driver.findElement(By.name("search111"));//org.openqa.selenium.NoSuchElementException
		
		List<WebElement> eleList = driver.findElements(By.className("BinAuto"));
		System.out.println(eleList.size());
		
		driver.close();

	}

}
