package seldec2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * getOptions() -- will give all options there under select tag
 * getAllSelectedOptions() -- will give only the selected options thru script/manual
 * getFirstSelectedOption() -- if there is a default selection there for dr down
 * e.g: for month dr down - the current year is by default selected
 * 
 * dr down : NOT SELECT BASED
 */

public class SelectMultipleTag10 {
    static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");
		
		WebElement drDownEle = driver.findElement(By.xpath("//select[@multiple]"));
		
		Select select = new Select(drDownEle);
		
		boolean flag = select.isMultiple();
		System.out.println(flag);
		
		if(select.isMultiple()) {
			System.out.println("multi select is possible");
			
			select.selectByVisibleText("American flamingo");
			select.selectByVisibleText("Andean flamingo");
			select.selectByVisibleText("Lesser flamingo");
			select.selectByVisibleText("James's flamingo");
//			select.selectByVisibleText("American flamingo");
		}
		select.deselectByVisibleText("Lesser flamingo");
		Thread.sleep(3000);
	
		select.deselectAll();
		
		driver.quit();

	}

}
