package com.ExtentReport_Generation;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import reports.ExtentManager;

public class RegTest {
	
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void initialize() {
		reports = ExtentManager.getReports();
		
		test = reports.createTest("Reg_Test");
	}
	
	
	@Test
	public void login() {
		
		test.log(Status.INFO, "Reg testcase execution");
		test.log(Status.FAIL, "Testcase Failed");
		
	}
	
	@AfterTest
	public void quit() {
		reports.flush();	
	}

}
