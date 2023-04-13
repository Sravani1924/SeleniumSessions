package ExtentReports;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import BasePage.Base;

public class test1 extends Base {
	
	WebDriver driver ;
	
	@Test
	
	public void goToGoogleValidation() {
		driver = baseSetUp();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		 System.out.println(driver.getCurrentUrl());
		 System.out.println(driver.getTitle());
		 
		driver.close();
	}

}
