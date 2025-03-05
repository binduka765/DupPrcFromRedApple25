package seldec2023;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForAlerts23 {
    static WebDriver driver;
	public static void main(String[] args) {
		//alert
		//prompt
		//confirm
		//ExpectedConditions-automatically switches to the Alert, once it is present
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
		

	}
	//alert -- switchToAlert, accept, dismiss, getText, sendpromptmessage, 
	public static Alert waitForJSAlertAndSwitchToIt(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
    public static String getAlertText(int timeout) {
    	return waitForJSAlertAndSwitchToIt(timeout).getText();
    }
    public static void acceptAlert(int timeout) {
    	waitForJSAlertAndSwitchToIt(timeout).accept();
    }
    public static void dismissAlert(int timeout) {
    	waitForJSAlertAndSwitchToIt(timeout).dismiss();
    }
    public static void alertSendKeys(int timeout, String value) {
    	waitForJSAlertAndSwitchToIt(timeout).sendKeys(value);
    }
}
