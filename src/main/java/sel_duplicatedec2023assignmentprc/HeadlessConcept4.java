package sel_duplicatedec2023assignmentprc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class HeadlessConcept4 {

	public static void main(String[] args) {
		
		EdgeOptions eo = new EdgeOptions();
//		eo.addArguments("--inprivate");
		eo.addArguments("--headless");
		
		WebDriver driver = new EdgeDriver(eo);
		driver.get("https://naveenautomationlabs.com/opencart");
		
		System.out.println(driver.getTitle());

	}

}
