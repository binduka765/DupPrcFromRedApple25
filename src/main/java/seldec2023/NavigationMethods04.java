package seldec2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods04 {

	public static void main(String[] args) {
		// back and forward
		//get vs to
		//refresh 
		
		//IQ] how many navigation methods??4 --back, forward, to, refresh
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");	
	    System.out.println(driver.getTitle());
//	    driver.navigate().to("https://naveenautomationlabs.com/opencart/");
	    driver.get("https://naveenautomationlabs.com/opencart/");//hence proved .to(); and .get() doing the same job
	    System.out.println(driver.getTitle());
	    driver.navigate().back();
	    System.out.println(driver.getTitle());
	    driver.navigate().forward();
	    System.out.println(driver.getTitle());
	    

	}

}
