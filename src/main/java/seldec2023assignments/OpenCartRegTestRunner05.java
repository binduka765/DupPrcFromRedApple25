package seldec2023assignments;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartRegTestRunner05 {
	
	public static String genRandomEmail() {
		return "BinAuto"+UUID.randomUUID()+"@appmail.com";
	}

	public static void main(String[] args) {
		
		BrowserUtility05 brUtil = new BrowserUtility05();
		WebDriver driver = brUtil.launchBrowser("chrome");
		
		By fn = By.id("input-firstname");
		By ln = By.id("input-lastname");
		By email = By.id("input-email");
		By telPh = By.id("input-telephone");
		By pwd = By.id("input-password");
		By pwdConfirm = By.id("input-confirm");
		
		By subscibeNo = By.xpath("//input[@type='radio' and @name='newsletter' and@value='1']");
		By subscribeYes = By.xpath("//input[@type='radio' and @checked='checked' and @value='0']");
		
		By privacyPolicy = By.xpath("//input[@name='agree' and@value='1']");
		By continueBtn = By.xpath("//input[@type='submit']");
		
		ElementUtility05 eleUtil = new ElementUtility05(driver);
		
		eleUtil.doSendKeys(fn, "bulbul");
		eleUtil.doSendKeys(ln, "maina");
    	eleUtil.doSendKeys(email, genRandomEmail());
    	eleUtil.doSendKeys(telPh, "9865692345");
    	eleUtil.doSendKeys(pwd, "Bulnamaina@25");
    	eleUtil.doSendKeys(pwdConfirm, "Bulnamaina@25");
    	
    	eleUtil.doClick(subscribeYes);
    	eleUtil.doClick(privacyPolicy);
    	eleUtil.doClick(continueBtn);
    	
    	String pageUrl = driver.getCurrentUrl();
    	System.out.println(driver.getTitle());
    	
    	if(pageUrl.contains("account/account")) {
    		System.out.println("ACCOUNT SUCCESSFULLY CREATED");
    	}else {
    		System.out.println("ACCT not created...create again");
    	}
    	
    
	}

}
