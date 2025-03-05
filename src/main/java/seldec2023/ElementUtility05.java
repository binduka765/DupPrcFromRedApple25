package seldec2023;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import allexceptions.ElementException;

//SRP
public class ElementUtility05 {
	
	private WebDriver driver;
	
	public ElementUtility05(WebDriver driver) {
		this.driver = driver;
	}

	private void nullBlankCheck(String value) {

		if (value == null || value.length() == 0) {
			throw new ElementException(value + "--- visible text cannot be null or blank");
		}

	}

	// method to convert the string locators to By locators:
	// how to create a By locator using the String locators:
	public By getBy(String locatorType, String locatorValue) {
		By locator = null;

		switch (locatorType.toLowerCase().trim()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;

		case "classname":
			locator = By.className(locatorValue);
			break;

		case "linktext":
			locator = By.linkText(locatorValue);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
			break;

		case "xpath":
			locator = By.xpath(locatorValue);
			break;

		case "css":
			locator = By.cssSelector(locatorValue);
			break;
		case "tagname":
			locator = By.tagName(locatorValue);
			break;


		default:
			break;
		}
		return locator;
		
	}
	//overloading the below method to take String locator:
	public WebElement getElement(By locator) {//session - 08 FE error
		WebElement element = null;
		
		try {
		element = driver.findElement(locator);
		}catch(NoSuchElementException e) {
			e.printStackTrace();
			return null;
			
		}
		return element;
	}
	public WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue));
	}
	//overloading the below method to take String type locator:
	public void doSendKeys(By locator, String value) {
		nullBlankCheck(value);
		getElement(locator).sendKeys(value);
	}
	//overloading the doSendKeys method: with wait applied-WAIT 3
	public void doSendKeys(By locator, String value, int timeout) {
		nullBlankCheck(value);
		waitForElementVisible(locator, timeout).sendKeys(value);
	}
	
	
	public void doSendKeys(String locatorType, String locatorValue) {
		nullBlankCheck(locatorValue);
		getElement(getBy(locatorType, locatorValue)).sendKeys(locatorValue);
	}
	public void doClick(By locator) {
		getElement(locator).click();
	}
	//overloading the doClick method: with explicit wait applied-WAIT 4
	public void doClick(By locator, int timeout) {
		waitForElementVisible(locator, timeout).click();
	}
	
	public String doGetElementText(By locator) {
		return getElement(locator).getText();
		
	}
	
	public boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public boolean isElementExist(By locator) {

		if (getElements(locator).size() == 1) {
			return true;
		}
		return false;
	}

	// *****************FEsUtilities************************

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
    
	public  int getElementsCount(By locator) {
		return getElements(locator).size();
	}
	
	public  ArrayList<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
	 ArrayList<String> eleTextList = new ArrayList<String>();
	 
	 for(WebElement e: eleList) {
		String text = e.getText();
		
		if(text.length()!=0) {
			eleTextList.add(text);
		}
		
	 }
	 return eleTextList;
	}
	
	public  ArrayList<String> getElementsAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		ArrayList<String> eleAttrList = new ArrayList<String>();
		
		for(WebElement e: eleList) {
			String attrValue = e.getAttribute(attrName);
			
			if(attrValue.length()!=0) {
				eleAttrList.add(attrValue);
				
			}
		}
		return eleAttrList;
	}
	//**************Select based Drop Down Utils*******************//
	
	public void doSelectByIndex(By locator, int index) {
		 
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
		
	}
	
	public void doSelectByVisibleText(By locator, String visibleText) {
		
//		if(visibleText == null || visibleText.length() == 0) {
//			throw new ElementException("visible text cannot be null");
//		}
		nullBlankCheck(visibleText);
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}
	
	public void doSelectByValue(By locator, String value) {
		
//		if(value == null || value.length() == 0) {
//			throw new ElementException("visible text cannot be null");
//		}
		
		nullBlankCheck(value);
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
		
	}
	
	 //select - using alloptions() ---->>>generic utilities
    public List<String> getDropDownOptionsTextList(By locator) {
    	List<WebElement> optionsList = getDropDownOptionsList(locator);
    	List<String> optionsTxtList = new ArrayList<String>();
    	
    	for(WebElement e: optionsList) {
    		String text = e.getText();
    		optionsTxtList.add(text);
    	}
    	return optionsTxtList;
    }
    public List<WebElement> getDropDownOptionsList(By locator) {
    	
    	Select select = new Select(getElement(locator));
    	return select.getOptions();
    }
    
    public int getDropDownValuesCount(By locator) {
    	
    	WebElement element = driver.findElement(locator);
    	Select select = new Select(element);
    	return select.getOptions().size();
    	
    }
	
    public void doSelectDropDownValue(By locator, String value) {
    	nullBlankCheck(value);
    	Select select = new Select(getElement(locator));
    	
    	List<WebElement> elementOptions = select.getOptions();
    	System.out.println(elementOptions.size());
    	
		for (WebElement e : elementOptions) {
			String text = e.getText();
			System.out.println(text);

			if (text.equals(value)) {
				e.click();
				break;
			}
		}

	}

	public void printSelectDropDownValue(By locator) {

		List<WebElement> optionsList = getDropDownOptionsList(locator);

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
		}

    }
	//without select class select the drop down:
	 public void DoSelectDrDownWithoutSelectClass(By locator, String value) {
		   
		   List<WebElement> allOptionsList = driver.findElements(locator);
			
			System.out.println(allOptionsList.size());
			
			for(WebElement e: allOptionsList) {
				String text = e.getText();
				
				if(text.equals(value)) {
					e.click();
					break;
				}
			}
			
	   }
	 
	 //**********************ACTIONS class utilities**********************//
	 
	 public void handleMenuSubmenu(By parentloc, By submenuloc) throws InterruptedException {
			//creating the ele to mouse over so to find the dr down appear:
			Actions act = new Actions(driver);
			act.moveToElement(getElement(parentloc)).perform();
			Thread.sleep(2000);
			
			//creating the dr down ele after it appeared: And do click action on it
	//		getElement(submenuloc).click();
			
			doClick(submenuloc);
		
		}
	
	 public void handleMenuSubmenuLevels4(By level1Menu, By level2Menu, By level3Menu, By level4Menu) throws InterruptedException {
		   
	//	   getElement(level1Menu).click();
		   doClick(level1Menu);
		   
		   Actions act = new Actions(driver);
		   
		   act.moveToElement(getElement(level2Menu)).perform();
		   Thread.sleep(1500);
		   
		   act.moveToElement(getElement(level3Menu)).perform();
		   Thread.sleep(1500);
		   
	//	   getElement(level4Menu).click();
		   doClick(level4Menu);
		   
	   }
	 
		public void doActionsClick(By locator) {
			Actions act = new Actions(driver);
			act.click(getElement(locator)).perform();
		}

		public void doActionsSendKeys(By locator, String value) {
			Actions act = new Actions(driver);
			act.sendKeys(getElement(locator), value).perform();
		}
		
		//****************Search Utils*************//
		
		public void doSearch(By searchlocator, String searchKey, By suggsList, String value) throws InterruptedException {
	//		getElement(searchlocator).sendKeys(searchKey);
		
			doSendKeys(searchlocator, searchKey);		
			Thread.sleep(3000);
			
			List<WebElement> suggestions = getElements(suggsList);
			
			for(WebElement e: suggestions) {
				String txt = e.getText();
				System.out.println(txt);
				
				if(txt.contains(value)) {
					e.click();
					break;
				}
			}

}
		
		//*************** Wait Utils **********************************//
		//WAIT 15:chks for ele to be visible+enabled as well-so can be clicked
		public void clickWhenReady(By locator, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		}
		//WAIT 16: wait for ele's presence-chks for atleast one ele present on page
		public List<WebElement> waitForElementsPresence(By locator, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		}
		/**
		 * //WAIT 17: wait for ele's visible-
		 * An expectation for checking that all elements present on the web page that 
		 * match the locator are visible. Visibility means that the elements are not only
		 *  displayed but also have a height and width that is greater than 0.
		 * @param locator
		 * @param timeout
		 * can be used for checking the list of footer links
		 * @return 
		 */
		
		public List<WebElement> waitForElementsVisible(By locator, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}
		
		//WAIT-1
		public  WebElement waitForElementPresence(By locator, int timeout) {
			   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			   return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		   }
		//WAIT-2 : By DEFAULT half second POLLING TIMe applied
		public WebElement waitForElementVisible(By locator, int timeout) {
			   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			   return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		   }
		//WAIT 18: with EXPLICIT POLLING TIME INTERVAL
		//overloading to override the default polling time of half sec--to take provided explicitly
		public WebElement waitForElementVisible(By locator, int timeout, int intervaltime) {
			   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofSeconds(intervaltime));
			   return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		   }
		//WAIT 5
	    public String waitForTitleContains(String titlefraction, int timeout) {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    	
	    	try {
	    	if(wait.until(ExpectedConditions.titleContains(titlefraction))) {
	    		return driver.getTitle();
	    	}
	    	}
	    	catch(Exception e) {
	    		System.out.println("title is not found within: "+timeout);
	    	}
	    	return null;
	    }
	    //WAIT 6
	    public  String waitForTitleIs(String title, int timeout) {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    	
	    	try {
	    	if(wait.until(ExpectedConditions.titleIs(title))) {
	    		return driver.getTitle();
	    	}
	    	}catch(Exception e) {
	    		System.out.println("title is not found within : "+timeout);
	    	}
	    	return title;
	    }
	    //WAIT 7
	    public String waitForUrlContains(String urlfraction, int timeout) {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    	try {
	    	if(wait.until(ExpectedConditions.urlContains(urlfraction))) {
	    		return driver.getCurrentUrl();
	    	}
	    	}catch(Exception e) {
	    		System.out.println("url is not found within : "+timeout);
	    	}
	    	return null;
	    }
	    
	    //WAIT 8
	    public String waitForUrlIs(String url, int timeout) {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    try {	
	    if(wait.until(ExpectedConditions.urlToBe(url))) {
	    	return driver.getCurrentUrl();
	    }
	    }catch(Exception e) {
	    	System.out.println("url is not found within : "+timeout);
	    }
		return null;
	    }
	    //WAIT FOR ALERTS: 9,10,11,12,13
	  //alert -- switchToAlert, accept, dismiss, getText, sendpromptmessage, 
		public  Alert waitForJSAlertAndSwitchToIt(int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			return wait.until(ExpectedConditions.alertIsPresent());
		}
	    public String getAlertText(int timeout) {
	    	return waitForJSAlertAndSwitchToIt(timeout).getText();
	    }
	    public void acceptAlert(int timeout) {
	    	waitForJSAlertAndSwitchToIt(timeout).accept();
	    }
	    public void dismissAlert(int timeout) {
	    	waitForJSAlertAndSwitchToIt(timeout).dismiss();
	    }
	    public void alertSendKeys(int timeout, String value) {
	    	waitForJSAlertAndSwitchToIt(timeout).sendKeys(value);
	    }
	    //WAIT FOR WINDOWS-BROWSER:14
	    public void waitForWindow(int totalnumofwindowstobe, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.numberOfWindowsToBe(totalnumofwindowstobe));

		}
}
