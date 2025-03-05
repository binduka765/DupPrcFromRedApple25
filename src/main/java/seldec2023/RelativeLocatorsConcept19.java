package seldec2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;//static import

public class RelativeLocatorsConcept19 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada/saskatchewan/regina");
		Thread.sleep(4000);
		
		//creating the base element
		WebElement ele = driver.findElement(By.linkText("Regina, Canada"));
		
		//driver.findElement(Relative.with()) //---instead of thru class name-directly write with
		String leftRank = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(leftRank);

	}

}
