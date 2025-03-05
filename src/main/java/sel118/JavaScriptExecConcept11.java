package sel118;



import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class JavaScriptExecConcept11 {
    static WebDriver driver;
	public static void main(String[] args) throws IOException {
		/*
		 * JSE: is a class and we have to cast our driver into jse-once it is
		 * casted and use the ref var of casted jse along with executeScript
		 * method -- to execute the java script code
		 * 
		 */
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://classic.freecrm.com");
		driver.findElement(By.name("username")).sendKeys("test@2025");
		driver.findElement(By.name("password")).sendKeys("CauliFlower@25");
		
//		driver.findElement(By.cssSelector("input.btn.btn-small")).click();
		
		WebElement loginBtn = driver.findElement(By.cssSelector("input.btn.btn-small"));
		
		flash(loginBtn, driver); //highlight the element
		drawBorder(loginBtn, driver);//draw a border
		captureScreenShot(driver);
		

	}
	public static void flash(WebElement element, WebDriver driver) {
		
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		String bgcolor = element.getCssValue("backgroundColor");
		
		for(int i=0; i <10; i++) {
			changeColor("rgb(0,200,0", element, driver);
			changeColor(bgcolor, element, driver);
		}
	}
	
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
		
		try {
			Thread.sleep(1500);
		}catch(InterruptedException e){
			
		}
		
	}
	
	public static void drawBorder(WebElement ele, WebDriver driver) {
		
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].style.border='3px solid red'", ele);
		
	}
	public static void captureScreenShot(WebDriver driver) throws IOException {
		//Take screen shot and store as a file format
	    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //now copy the screen shot to the desired location using copyFile()
	    Files.copy(src, new File("/Users/binduk/eclipse-workspace/DuplicatePractice25JM/freeCRM.png"));
	}
	

}
