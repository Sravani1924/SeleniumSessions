package ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicReport {
	WebDriver driver = null;
	ExtentReports extent;
	
	@BeforeTest
	
	public void config() {
		
		String path = System.getProperty("user.dir") +"//Reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Test Automation Result");
		reporter.config().setDocumentTitle("Extent Report Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sravani");
		
	}
	
	
	@Test
	public void intialSetUp() {
		
		ExtentTest test = extent.createTest("ExtentDemo");
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://www.google.com/");
		 driver.manage().window().maximize();
		 System.out.println(driver.getCurrentUrl());
		 System.out.println(driver.getTitle());
		 test.fail("Result do not match");
		
			
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
		 extent.flush();
	}
	

}
