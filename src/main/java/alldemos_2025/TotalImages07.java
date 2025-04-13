package alldemos_2025;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class TotalImages07 {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new SafariDriver();
		driver.get("https://www.michaels.com/");
		
		List<WebElement> imagesList = driver.findElements(By.tagName("img"));
		
		System.out.println("total images = "+imagesList.size());
		
		for(WebElement image : imagesList) {
			String altValue = image.getAttribute("alt");
			String srcValue = image.getAttribute("src");
			
			System.out.println(altValue +"-----"+srcValue);
			
		}

	}

}
