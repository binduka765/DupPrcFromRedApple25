package seldec2023assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.oc.exceptions.BrowserException;

public class BrowserUtility05 {
	
	WebDriver driver;
	
	public WebDriver launchBrowser(String browserName) {
		System.out.println("browser supplied is: "+browserName);
		
		
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;

		default:
			System.out.println("plz pass the right browser "+browserName);
			throw new BrowserException("BROWSER NOT FOUND "+browserName);
		}
		return driver;
	}
    public void launchURL(String url) {
    	if(url == null) {
    		throw new BrowserException("URL IS NULL...");
    	}
    	if(url.indexOf("http")==0) {
    		driver.get(url);
    	}
    }
    
    public String getPageTitle() {
    	return driver.getTitle();
    }
    public String getPageUrl() {
    	return driver.getCurrentUrl();
    }
    public void closeBrowser() {
    	driver.close();
    }
    public void quitBrowser() {
    	driver.quit();
    }
}
