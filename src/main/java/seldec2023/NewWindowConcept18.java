package seldec2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowConcept18 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		String pwid = driver.getWindowHandle();
		
	//	driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(pwid);
		
		System.out.println(driver.getTitle());

	}

}
