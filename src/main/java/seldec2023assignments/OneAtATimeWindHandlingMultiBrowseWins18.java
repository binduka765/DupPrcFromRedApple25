package seldec2023assignments;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OneAtATimeWindHandlingMultiBrowseWins18 {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(4000);
	
	String parentWid = driver.getWindowHandle();
	System.out.println(parentWid);
	
	List<WebElement> AllExtLinks = driver.findElements(By.cssSelector("div.orangehrm-login-footer-sm a"));
	System.out.println(AllExtLinks.size());
	
	for(WebElement e: AllExtLinks) {	
		e.click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		while(it.hasNext()) {
			String wid = it.next();
			System.out.println("current wid :"+wid);
			driver.switchTo().window(wid);
			
			if(!wid.equals(parentWid)) {
				driver.close();
			}
			Thread.sleep(1000);
		}
		driver.switchTo().window(parentWid);
		System.out.println(parentWid);
		
	}
	


	}

}
