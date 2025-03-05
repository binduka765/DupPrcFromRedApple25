package seldec2023;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleMultipleBrowseWinsOneAtaTime18 {
    static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(4000);
		
		String pwid = driver.getWindowHandle();
		System.out.println(pwid);
		
		
		List<WebElement> allLinks = driver.findElements(By.cssSelector("div.orangehrm-login-footer-sm a"));
		System.out.println(allLinks.size());
		
		//clicking on each social link/browser window
		for(WebElement e: allLinks) {
			
			e.click();
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> it = handles.iterator();
			
			//grabbing the window ids:
			while(it.hasNext()) {
				String wid = it.next();
				driver.switchTo().window(wid);
				System.out.println(wid);
				
				if(!wid.equals(pwid)) {
					driver.close();
				}
				Thread.sleep(1000);
			}
			
			driver.switchTo().window(pwid);
			System.out.println(driver.getWindowHandle());
			
		}
		

	}

}
