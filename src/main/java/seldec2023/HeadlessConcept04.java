package seldec2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessConcept04 {

	public static void main(String[] args) throws InterruptedException {
		// headless vs headed
		//headless: no browser visibility
		//faster
		//run tcs on CI CD/Jenkins/Linux: headless
		//recommended: not recommended
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(co);
		driver.get("ttps://naveenautomationlabs.com/opencart/");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

	}

}
