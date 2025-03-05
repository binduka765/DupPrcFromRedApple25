package seldec2023;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDrDownAllOptions09 {
     static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		
//		WebElement country = driver.findElement(By.id("Form_getForm_Country"));
//		
//		Select select = new Select(country);
//
//		List<WebElement> countryOptions = select.getOptions();
//		System.out.println(countryOptions.size());
//		
//		for(WebElement e: countryOptions) {
//			String text = e.getText();
//			System.out.println(text);
//			
//			if(text.equals("India")) {
//				e.click();
//				break;
//			}
//		}
	
		By drDownEle = By.id("Form_getForm_Country");
		doSelectDropDownValue(drDownEle, "India");
		
	}
    public static WebElement getElement(By locator) {
    	return driver.findElement(locator);
    }
    
    public static List<String> getDropDownOptionsTextList(By locator) {
    	List<WebElement> optionsList = getDropDownOptionsList(locator);
    	List<String> optionsTxtList = new ArrayList<String>();
    	
    	for(WebElement e: optionsList) {
    		String text = e.getText();
    		optionsTxtList.add(text);
    	}
    	return optionsTxtList;
    }
    public static List<WebElement> getDropDownOptionsList(By locator) {
    	
    	Select select = new Select(getElement(locator));
    	return select.getOptions();
    }
    
    public static int getDropDownValuesCount(By locator) {
    	
    	WebElement element = driver.findElement(locator);
    	Select select = new Select(element);
    	return select.getOptions().size();
    	
    }
	
    public static void doSelectDropDownValue(By locator, String value) {
    	
    	Select select = new Select(getElement(locator));
    	
    	List<WebElement> elementOptions = select.getOptions();
    	System.out.println(elementOptions.size());
    	
    	for(WebElement e: elementOptions) {
    		String text = e.getText();
    		System.out.println(text);
    		
    		if(text.equals(value)) {
    			e.click();
    			break;
    		}
    	}
    	
    }
    
    public static void printSelectDropDownValue(By locator) {
    	
    	List<WebElement> optionsList = getDropDownOptionsList(locator);
    	
    	for(WebElement e: optionsList) {
    		String text = e.getText();
    		System.out.println(text);
    	}
    
    }
	
}
