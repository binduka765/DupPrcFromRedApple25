package seldec2023;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForTitleUrl23 {
    static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com");
		
//		String title = waitForTitleContains("Free CRM software for customer relationship management",5);
	String title = waitForTitleIs("Free CRM software for customer relationship management, sales, and support.",5);
		System.out.println(title);

	}
	//WAIT 5
    public static String waitForTitleContains(String titlefraction, int timeout) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    	
    	try {
    	if(wait.until(ExpectedConditions.titleContains(titlefraction))) {
    		return driver.getTitle();
    	}
    	}
    	catch(Exception e) {
    		System.out.println("title is not found within: "+timeout);
    	}
    	return null;
    }
    //WAIT 6
    public static String waitForTitleIs(String title, int timeout) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    	
    	try {
    	if(wait.until(ExpectedConditions.titleIs(title))) {
    		return driver.getTitle();
    	}
    	}catch(Exception e) {
    		System.out.println("title is not found within : "+timeout);
    	}
    	return title;
    }
    //WAIT 7
    public static String waitForUrlContains(String urlfraction, int timeout) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    	try {
    	if(wait.until(ExpectedConditions.urlContains(urlfraction))) {
    		return driver.getCurrentUrl();
    	}
    	}catch(Exception e) {
    		System.out.println("url is not found within : "+timeout);
    	}
    	return null;
    }
    
    //WAIT 8
    public static String waitForUrlIs(String url, int timeout) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    try {	
    if(wait.until(ExpectedConditions.urlToBe(url))) {
    	return driver.getCurrentUrl();
    }
    }catch(Exception e) {
    	System.out.println("url is not found within : "+timeout);
    }
	return null;
    }
}
