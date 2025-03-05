package sel_duplicatedec2023practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods4 {

	public static void main(String[] args) throws MalformedURLException {
		//back vs forward
		//get vs to
		//refresh
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to(new URL("https://www.google.com/"));
		
		driver.navigate().refresh();
		
		
//		driver.get("https://naveenautomationlabs.com/opencart");
//		System.out.println(driver.getTitle());
////		driver.navigate().to("https://www.google.com/");
//		driver.get("https://www.google.com/");
//		System.out.println(driver.getTitle());
//		driver.navigate().back();
//		System.out.println(driver.getTitle());
//		driver.navigate().forward();
//		System.out.println(driver.getTitle());
//		driver.navigate().back();
//		System.out.println(driver.getTitle());
	}

}
