package BasePage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Base {
	
	WebDriver driver;
	
	

	public WebDriver baseSetUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}
	
	
	public String getScreenShotPath(String TestCaseName,WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver; 
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir")+"//Reports//"+TestCaseName+".png" ;
		File file = new File(destPath);
		FileUtils.copyFile(source,file);
		return destPath;
		
		
	}
}


