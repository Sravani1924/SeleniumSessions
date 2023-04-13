package ExtentReports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import BasePage.Base;


public class test2 extends Base {
	WebDriver driver ;
	
	@Test
	
	public void searchGoogleValidation() {
		driver = baseSetUp();
		driver.get("https://www.google.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Selenium Java ");
		driver.manage().window().maximize();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.close();
	}

}
