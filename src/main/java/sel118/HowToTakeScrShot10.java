package sel118;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class HowToTakeScrShot10 {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.google.com/");
		
		//Take screen shot and store as a file format
	    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //now copy the screen shot to the desired location using copyFile()
	    Files.copy(src, new File("/Users/binduk/eclipse-workspace/DuplicatePractice25JM/google.png"));
	}

}
