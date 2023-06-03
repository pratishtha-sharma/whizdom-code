package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class CustomListener implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of Failed Test is-"+ result.getName());
		ExtentTest test = (ExtentTest) result.getAttribute("reporter"); // this will have information about the testcase that is running
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
	}
	
    public void onTestSuccess(ITestResult result) {
    	System.out.println("Name of Passed Test is-"+ result.getName());
    	ExtentTest test = (ExtentTest) result.getAttribute("reporter"); // this will have information about the testcase that is running
		test.log(Status.PASS, "Testcase has been passed successfully");
	}

}
