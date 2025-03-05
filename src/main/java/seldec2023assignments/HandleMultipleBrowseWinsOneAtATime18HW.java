package seldec2023assignments;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleMultipleBrowseWinsOneAtATime18HW {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String pwid = driver.getWindowHandle();
		System.out.println(pwid);
		
		Thread.sleep(3000);
		
		List<WebElement> allsociallinks = driver.findElements(By.xpath("//div[@class='orangehrm-login-footer-sm']/a"));
		System.out.println(allsociallinks.size());
		
		for(WebElement e:allsociallinks) {
			
			e.click();
			Thread.sleep(2000);
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> it = handles.iterator();
			
			while(it.hasNext()) {
				String currwid = it.next();
				if(!currwid.equals(pwid)) {
					driver.switchTo().window(currwid);
					System.out.println(driver.getCurrentUrl());
					
				}
			}
		
		}
		driver.close();
		driver.switchTo().window(pwid);
	}

}
