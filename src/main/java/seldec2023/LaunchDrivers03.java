package seldec2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchDrivers03 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String title1 = driver.getTitle();
		System.out.println("page title is: "+title1);
		
		driver.quit();
		

	}

}
