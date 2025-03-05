package seldec2023;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PollingORintervaltimeConcept23 {

	public static void main(String[] args) {
		/**
		 * POLLING TIME: same as interval time/sleep time as well=>time interval between
		 * two trials--supplied again as -- Duration.ofSeconds(sleeptime)
		 * WebDriverWait -- has two constructors 
		 * one -- asks for just Duration.ofSeconds(timeout) alongwith driver
		 * second -- asks for Duration.ofSeconds(timeout) + sleep/interval time along with driver
		 * ==> WebDriverWait(driver, timeout, sleep);
		 * 
		 * if no polling time is provided explicitly -- still sel internally applies a
		 * default polling time which is by default -- 500 milli seconds
		 * 500 milli secs == half second
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//parent
		
		By twitter = By.xpath("//a[contains(@href, 'twitter')]");
		
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//By default interval time 500 ms
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(twitter)).click();

	}

}
