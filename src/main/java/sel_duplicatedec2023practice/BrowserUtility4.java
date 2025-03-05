package sel_duplicatedec2023practice;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtility4 {
	WebDriver driver;
	/**
	 * this method is used to initialize the browser on the basis of given browser name
	 * @author binduk
	 * @param browserName
	 * @return
	 */
	public WebDriver launchBrowser(String browserName) {
		System.out.println("browser supplied: "+browserName);
		
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
			System.out.println("plz pass the correct browser "+browserName);
			throw new BrowserException("BROWSER NOT FOUND..."+browserName);
		}
		return driver;
	}
	//null chk + http check
	public void launchUrl(String url) {
		if(url == null) {
			throw new BrowserException("URL IS NULL");
		}
		
		if(url.indexOf("http")==0) {
			driver.get(url);
				}else {
			throw new BrowserException("HTTP IS MISSING IN URL");
		}
	}
	//overloading the launch url method to take URL type url param:
	public void launchUrl(URL url) {
		if(url == null) {
			throw new BrowserException("URL IS NULL");
		}
		String appUrl = String.valueOf(url);
		if(appUrl.indexOf("http")==0) {
			driver.navigate().to(appUrl);
				}else {
			throw new BrowserException("HTTP IS MISSING IN URL");
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
