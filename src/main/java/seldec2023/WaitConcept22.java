package seldec2023;

public class WaitConcept22 {

	public static void main(String[] args) {
		//script --- synch -->app(slow, server slowness, network)
		
		//synch: wait
		//1.static wait: Thread.sleep(10000): 10 secs: 2 secs
		//2.dynamic wait:10 secs: 2 secs: 8 secs will be cancelled
		
		//2.a: Implicitly wait:
		//2.b: Explicitly Wait: is just a concept: to apply this kind of wait
		//       have to use the below two classes
		         //i: WebDriverWait(C)
		         //ii:FluentWait(C)
		
		//Wait(I):until();-->FluentWait(C):(@overriden)until(){}+other methods -->WebDriverWait(C):no methods
		
		//Fluent wait has a child class WebDriverWait
		
		/*
		 * Implicitly Wait: is dynamic and Global
		 * casei) cannot apply for any one specific element-gets applied to all and slows
		 *     down the applications performance
		 *    ii) cannot be applied for non-webEles(alert, title, urls, browser windows)
		 *   iii) have to override the previous value each time you want to provide new 
		 *   value
		 *   
		 * 
		 * EXPLICIT Wait: is dynamic, can be applied explicitly for one single element
		 * Wait(I):until();-->FluentWait(C):until(){}+other methods -->WebDriverWait(C):no methods
		 * 
		 * 
		 * 
		 * WAYS OF THE CREATION OF WE/WEs:
		 * ----->>>
		 * 1.driver.FE/FEs
		 * 2.using jse--gives shadow dom webelement -- converting it into WE
		 * 3.wait.until()==>without driver.FE() ---just supply the By locator--it will wait until the given
		 * seconds waiting to chk if the ele is seen/present on dom
		 * finding using the wait:
		 * ============>>>>
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10);
		 * WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(ele);
		 * ele.sendKeys("xyz");
		 * 
		 * IQ:Difference between visibility of element located and presence of element located??
		 * 
		 * presence: means seen on the dom
		 * 
		 * visibility: means always checking if seen on page - present on the page+visibility on dom
		 * also means it has height and width > 0
		 * 
		 * 
		 * 
		 * document.readyState
		 * i)complete ii) in progress iii)loading
		 * 
		 * JimEvans: a contributor to selenium said
		 * DO NOT MIX IMPLICIT AND EXPLICIT WAITS TO GETHER
		 */

	}

}
