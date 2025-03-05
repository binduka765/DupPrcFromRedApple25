package seldec2023;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.oc.exceptions.BrowserException;

public class BrowserUtility04 {
	
	 WebDriver driver;
	/**
	 * this method is used to the browser on the basis of given browsername
	 * @author binduk
	 * @param
	 * @return 
	 * 
	 */
	public WebDriver launchBrowser(String browserName) {
		System.out.println("the browser supplied is "+browserName);
		
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
		case "ie":
			driver = new InternetExplorerDriver();
			break;

		default:
			System.out.println("plz pass the right browser "+browserName);
			throw new BrowserException("BROWSER NOT FOUND....");
		}
		
		return driver;
		
	}
	//http://google.com
	//https://google.com
	//overloading the launchURL() to take URL type of param
	public void launchURL(String url) {
		
		if(url== null) {
			throw new BrowserException("URL IS NULL");
		}
		if(url.indexOf("http")==0) {
			driver.get(url);
		}
		else {
			throw new BrowserException("HTTP IS MISSING...");
		}
		
	}
	
	public void launchURL(URL url) {
      
		if (url == null) {
			throw new BrowserException("URL IS NULL");
		}
		String appUrl = String.valueOf(url);
		if (appUrl.indexOf("http") == 0) {
			driver.navigate().to(appUrl);
		} else {
			throw new BrowserException("HTTP IS MISSING...");
		}

	}
	
	public String getPageTitle(){
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
