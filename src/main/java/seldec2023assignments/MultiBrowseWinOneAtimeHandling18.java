package seldec2023assignments;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiBrowseWinOneAtimeHandling18 {
    static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(3000);
		String pwid = driver.getWindowHandle();
		System.out.println("the parent window is:"+pwid);
		
		List<WebElement> allLinks = driver.findElements(By.cssSelector("div.orangehrm-login-footer-sm>a"));
		System.out.println(allLinks.size());
		
		for(WebElement e:allLinks) {
			e.click();
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> it = handles.iterator();
			
			while(it.hasNext()) {
				String wid = it.next();
				driver.switchTo().window(wid);
				System.out.println("child window url is:"+driver.getCurrentUrl());
				System.out.println("current page title is:"+driver.getTitle());
				
				if(!wid.equals(pwid)) {
					driver.close();
				}
				Thread.sleep(1000);
			}
			driver.switchTo().window(pwid);
			System.out.println("parent window url is:"+driver.getCurrentUrl());
			System.out.println("parent page title is:"+driver.getTitle());
			
		}
		

	}

}
