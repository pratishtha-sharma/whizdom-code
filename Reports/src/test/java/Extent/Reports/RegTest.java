package Extent.Reports;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class RegTest {
	
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeMethod
	public void init() {
		reports = ExtentManager.getReports();
		test = reports.createTest("Reg Test");	
		
	}

	
	@Test
	public void login() {
		
		test.log(Status.INFO, "Reg case started");
		test.log(Status.INFO, "Logged in");
		test.log(Status.INFO, "Test Passed");
	
		
	}
	
	@AfterMethod
	public void afterTest() {
		reports.flush(); // this is used to finalize and generate the reports
	}
	
	
}
