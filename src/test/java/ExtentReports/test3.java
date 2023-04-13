package ExtentReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePage.Base;

public class test3 extends Base {
	
	WebDriver driver ;
	
	@Test
	
	public void clickOnGmailValidation() {
		
		driver = baseSetUp();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
//		driver.findElement(By.cssSelector("https://mail.google.com/mail/?authuser=0&ogbl")).click();
		driver.findElement(By.xpath("//a[@class='gb_q']")).click();
		System.out.println(driver.getTitle());
		Assert.assertTrue(false);
		driver.close();
	}

	
}
