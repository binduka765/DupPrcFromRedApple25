package sel118;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class ObjRepo9 {
      static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		
			FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
		
			prop.load(fis);
			
			System.out.println(prop.getProperty("name"));
			System.out.println(prop.getProperty("age"));
			
			String url = prop.getProperty("URL");
			System.out.println(url);
			
			String browserName = prop.getProperty("browser");
			System.out.println(browserName);
			
			if(browserName.equals("chrome")) {
				driver = new ChromeDriver();
			}
			else if(browserName.equals("firefox")) {
				driver = new FirefoxDriver();
			}
			else if(browserName.equals("ie")) {
				driver = new InternetExplorerDriver();
			}
			else if(browserName.equals("safari")) {
				driver = new SafariDriver();
			}
			
			driver.get(url);
			System.out.println(driver.getTitle());
			
			driver.close();

	}

}
