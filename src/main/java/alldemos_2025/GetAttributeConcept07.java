package alldemos_2025;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class GetAttributeConcept07 {

	public static void main(String[] args) {
		// text --> getText()
		//attribute --> getAttribute()
		
		//get all the links
		//get the href attribute value
		WebDriver driver = new SafariDriver();
		driver.get("https://www.michaels.com");
		
		List<WebElement> allEles = driver.findElements(By.className("css-ljjwvb"));
		
		for(WebElement ele: allEles) {
			System.out.println(ele.getText());
		}

	}

}
