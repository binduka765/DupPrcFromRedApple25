package seldec2023assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class HeadlessWithEdge04 {

	public static void main(String[] args) throws InterruptedException {
		
		EdgeOptions eo = new EdgeOptions();
//		eo.addArguments("--inprivate");
		eo.addArguments("--headless");
		
		WebDriver driver = new EdgeDriver(eo);
		driver.get("ttps://naveenautomationlabs.com/opencart/");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);


	}

}
