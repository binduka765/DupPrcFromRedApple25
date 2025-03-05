package seldec2023;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthORBasicPopUp17NOTJsPOpup {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		String username = "admin";
		String password = "admin";
		
		//supply in the url itself=>after https://username:password@=>
//		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
//		driver.get("https://the-internet.herokuapp.com/basic_auth");
		
		
//		driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		
		//sel 4.x:
		((HasAuthentication)driver).register(() -> new UsernameAndPassword(username, password));
		
		driver.get("https://the-internet.herokuapp.com/basic_auth");

	}

}
