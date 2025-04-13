package alldemos_2025;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class TotalLinksConcept1 {

	public static void main(String[] args) {
		//1. total links
		//2. print the text of each link
		//3. avoid blank text
		//4. broken link - later
		
		//the common thing/tagname for all the links -- is anchor tag-'a'
		//using the FEs strategy we can find all the links list=> collection of
		//all the links-varName -- gets stored in a List(order based collection) 
		
		//the index starts from 0
		
		WebDriver driver = new SafariDriver();
		driver.get("https://www.michaels.com/");
		
		//find out all the elements - driver.FEs
		//FEs - says give me the By. strategy
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		//List --> parent interface of ArrayList - from java.util package
		//now traverse thru the List-go to each link-And fetch the text of the link
		
		System.out.println(allLinks.size());
		
		for(int i=0;i<allLinks.size();i++) {
			String txt = allLinks.get(i).getText();
			
			//to avoid the blank text:
			if(txt.length()!=0) {
				System.out.println(txt);
			}
			
	//		System.out.println(txt);
		}
	}

}
