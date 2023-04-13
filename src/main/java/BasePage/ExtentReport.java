package BasePage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	static ExtentReports extent;
	
	public static ExtentReports extentReportGenerator() {
		
		String path = System.getProperty("user.dir") +"//Reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Test Automation Result");
		reporter.config().setDocumentTitle("Extent Report Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sravani");
		return extent;
		
	}
	

}
