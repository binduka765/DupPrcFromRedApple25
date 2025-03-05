package seldec2023;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertJsPopUpHandling17 {

	public static void main(String[] args) throws InterruptedException {
		//alert
		//prompt
		//confirm
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		//1.alert:
//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//		
//		Alert alert = driver.switchTo().alert();
//		
//	//	alert.accept();// click ok
//		
//		alert.dismiss(); //Esc btn on key board - click cancel on alert
		
		//2.confirm:
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		
//		Alert confirmAlert = driver.switchTo().alert();
//		
//		System.out.println(confirmAlert.getText());
//		Thread.sleep(5000);
//		
//		confirmAlert.accept();
		
		//3.prompt:
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		Alert promptAlert = driver.switchTo().alert();
		System.out.println(promptAlert.getText());
		Thread.sleep(5000);
		promptAlert.sendKeys("BinAuto");
		promptAlert.accept();

	}

}
