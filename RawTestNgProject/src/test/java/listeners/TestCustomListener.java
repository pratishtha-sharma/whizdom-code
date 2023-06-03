package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestCustomListener implements ITestListener{

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("----Test Passed----");
		System.out.println("--Passed test name is- "+result.getName());
		ExtentTest test = (ExtentTest) result.getAttribute("reporter"); // this will have information about the testcase that is running
		test.log(Status.PASS, "Testcase has been passed successfully "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("----Test Failed----");
		System.out.println("--Failed test name is- "+result.getName());
		ExtentTest test = (ExtentTest) result.getAttribute("reporter"); // this will have information about the testcase that is running.
		// since the reporter is setting extent test object from testbase class here we are returning the test object and have to cast it as result return the Object type
		
		test.log(Status.FAIL, result.getThrowable().getMessage()); // the msg from this is shown in last in report
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTest test = (ExtentTest) result.getAttribute("reporter"); // this will have information about the testcase that is running
		test.log(Status.SKIP, "Testcase has been skipped "+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	
	
	
}
