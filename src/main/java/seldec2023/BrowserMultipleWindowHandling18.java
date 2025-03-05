package seldec2023;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMultipleWindowHandling18 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String pwid = driver.getWindowHandle();
		System.out.println(pwid);
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(@href, 'linkedin')]")).click();
		driver.findElement(By.xpath("//a[contains(@href, 'facebook')]")).click();
		driver.findElement(By.xpath("//a[contains(@href, 'twitter')]")).click();
		driver.findElement(By.xpath("//a[contains(@href, 'youtube')]")).click();
		
		//fetch window ids:
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		while(it.hasNext()) {
			
			String windowid = it.next();
			driver.switchTo().window(windowid);
			System.out.println("window url: "+driver.getCurrentUrl());
			
			if(!windowid.equals(pwid)) {
				driver.close();
			}
			
			Thread.sleep(2000);
		}
		driver.switchTo().window(pwid);
		System.out.println(driver.getCurrentUrl()+""+driver.getTitle());

	}

}
