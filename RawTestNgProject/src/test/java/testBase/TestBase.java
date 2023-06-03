package testBase;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtentReports.ExtentManager;


public class TestBase {

	
	public ExtentReports reports;
	public ExtentTest test;
	public SoftAssert softAssert;
	public String browser;
	
	@BeforeMethod (alwaysRun = true)
	public void init(ITestContext con, ITestResult result) {
		reports = ExtentManager.getReports();
		test = reports.createTest(result.getMethod().getMethodName().toUpperCase());
		
		result.setAttribute("reporter", test);
		
		//soft assert
		softAssert = new SoftAssert(); //it will report error but not fail and stop the test while hard assert will stop the test
		
//		browser = con.getCurrentXmlTest().getParameter("browser");
//		System.out.println("Browser name is "+browser);
		
		String groupNames[] = con.getAllTestMethods()[0].getGroups();
		String browserGp = "";
		   for(String br : groupNames) {
			   if(br.startsWith("browserGroup")) {
				   browserGp = br;
				   break; 
			   }  
		   }
		
		   System.out.println("Browser is "+browserGp);
		   browser = con.getCurrentXmlTest().getParameter("browserGp");
		   
		
	}

	
	
	@AfterMethod (alwaysRun = true)
	public void afterTest() 
	{
		reports.flush(); // this is used to finalize and generate the reports
	}
	
	public void log(String msg){
		System.out.println(msg);
		test.log(Status.INFO, msg);
	}
	
	public void logFailure(String msg){
		System.out.println(msg);
		test.log(Status.FAIL, msg); // failing in extent report
	}
	
	public void failAndStop(String msg) { // this will fail in testng and report but will stop
		logFailure(msg); //report
		softAssert.fail(msg); //testng
		softAssert.assertAll(); //stop the testcase
	}
	
	public void softAssert(String msg) { // this will fail in testng and report but will continue
		logFailure(msg); //report
		softAssert.fail(msg); //testng
		
		// add code for taking screenshot of failed test in report
	}
	
}
