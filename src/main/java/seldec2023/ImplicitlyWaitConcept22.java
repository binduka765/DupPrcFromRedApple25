package seldec2023;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitlyWaitConcept22 {
     static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
//strikeddriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//sel 3.x
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//sel4.x
		//implicitly wait: Global wait: applied to all eles by default whenever
		//ele created by FE, FEs
		
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		
		driver.findElement(By.id("Form_getForm_Name")).sendKeys("test");//e1
		//e2
		//e3
		//e4...en
		
		
		
		

	}

}
