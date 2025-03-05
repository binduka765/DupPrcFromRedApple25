package sel118;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait10 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/login.php/");
		
		By loginBtn = By.id("loginbutton");
		
		By createAPageLink = By.linkText("Create Page");
		
		waitToClickOn(loginBtn, driver, 20);
		waitToClickOn(createAPageLink, driver, 15);
		
	
	}
   public static void waitToClickOn(By locator, WebDriver driver, int timeout) {
	 FluentWait<WebDriver> wait =  new WebDriverWait(driver, Duration.ofSeconds(timeout)).ignoring(StaleElementReferenceException.class);
	 wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
   }
}
