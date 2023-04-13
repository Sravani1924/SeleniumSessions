package BasePage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;	

public class Listeners extends Base implements ITestListener {

	ExtentReports extent = ExtentReport.extentReportGenerator();
	ExtentTest test;

	//Threadlocal to execute parallel test cases

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed Successfully");
	}

	public void onTestFailure(ITestResult result) {

		WebDriver driver = null ;
		//screenshot to attach the report

		extentTest.get().fail(result.getThrowable());
		Object testObject = result.getInstance();
		Class cl= result.getTestClass().getRealClass();
		try {
			driver =(WebDriver)cl.getDeclaredField("driver").get(testObject);
		} catch (Exception e1) {

		}

		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}





}
