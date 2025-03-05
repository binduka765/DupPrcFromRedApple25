package sel_duplicatedec2023practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessConcept4 {

	public static void main(String[] args) {
		// headless vs headed
		//headless: no browser visibility
		//faster: since doesnot waste to open the browser and visualize
		//run tcs on CI CD/Jenkins/Linux: headless
		//recommended: because doesnot simulate users actions
		//local:
		//complex apps/HTML DOM:
		//alerts/popups: could be a problem
		
		//1.create chromeOPtions class obj ref before webDriver initialization
		//2. using the ChromeOptions obj ref, pass the argument --headless using
		//addarguments()
		//3. pass this ChromeOptions obj ref webDriver initialization
		
		//for chrome:
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--headless");
//		co.addArguments("--incognito");
		
//		WebDriver driver = new ChromeDriver(co);
//		driver.get("https://naveenautomationlabs.com/opencart");
//		
//		System.out.println(driver.getTitle());
		
		//for firefox:
		FirefoxOptions fo = new FirefoxOptions();
		fo.addArguments("--headless");
		
		WebDriver driver = new FirefoxDriver(fo);
		driver.get("https://naveenautomationlabs.com/opencart");
		
		System.out.println(driver.getTitle());
		
		

	}

}
