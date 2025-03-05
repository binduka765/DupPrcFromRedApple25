package seldec2023;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleChoicesJQuerySpreadParamTOUGH10 {
    static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google_vignette");

		Thread.sleep(2000);

		By drdownLoc = By.id("justAnInputBox");
		By allChoices = By.xpath("//span[@class='comboTreeItemTitle']");
		
		//tc_01: single selection
//		selectChoice(drdownLoc, allChoices, "choice 1");//array length will be 1
		
		//tc_02: multiple selection: 3 Dot Spread Parameter
//		selectChoice(drdownLoc, allChoices, "choice 1", "choice 3");//array length will be 2
		
		//tc_o3: all selection
		selectChoice(drdownLoc, allChoices, "all");//all is given to value array =>length 1
	}
	
	public static void doClick(By locator) {
		driver.findElement(locator).click();
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	/**
	 * @author binduk
	 * this method supports 3 tc's: for single selection, multiple selection, all selection
	 * for all selection, plz pass all in case of all selection
	 * @param drdownlocator
	 * @param choices
	 * @param value
	 * @throws InterruptedException
	 * 3 Dot param  -- also called var args params
	 */
	
	public static void selectChoice(By drdownlocator, By choices, String... value) throws InterruptedException {
		
     //driver.findElement(By.id("justAnInputBox")).click();
		doClick(drdownlocator);
		
		Thread.sleep(2000);
		
//		if(value[0].equals("all")) {
//			//write logic for do all selection
//			
//		}
		
		List<WebElement> choicesList = getElements(choices);
		if(!value[0].equals("all")) {
			//write logic NOT FOR for do all selection
			
			//List<WebElement> choicesList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		       
//			List<WebElement> choicesList = getElements(choices);
			System.out.println(choicesList.size());
	        
	        for(WebElement e: choicesList) {
	        String txt = e.getText();
	        System.out.println(txt);
	        
	        for(String val:value) {
	        	if(txt.equals(val)) {
	            	e.click();
	          //  	break;
	            }
	        }
	        }	       
			
		}
		else {
			//all selection logic
			for(WebElement e: choicesList) {
				try {
					e.click();
				} catch (ElementNotInteractableException exc) {
					break;
				}
				
			}
		}
		
	
	}


}
