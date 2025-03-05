package seldec2023;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandling18 {
    static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//parent
		Thread.sleep(3000);
		//property: target = _blank ==> link opens in a new tab
		
		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click();//child
		
		//Set: doesnot have duplicates and is non-order based collection
		//iterator: is an interface used to iterate non-order based collection
		
		//1st: fetch the window ids
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();
		
		String parentwindowid = it.next();
		System.out.println("parent window handle:"+parentwindowid);
		
		String childwindowid = it.next();
		System.out.println("child window handle: "+childwindowid);
		
		//2nd: switching work:
		driver.switchTo().window(childwindowid);
		System.out.println("child window url: "+driver.getCurrentUrl());
		
		driver.close();
		
		driver.switchTo().window(parentwindowid);
		System.out.println("parent window url: "+driver.getCurrentUrl());
		
		driver.quit();

	}

}
