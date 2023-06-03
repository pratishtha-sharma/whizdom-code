package com.ExtentReport_Generation;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reports.ExtentManager;

public class LoginTest {
	
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void initialize() {
		reports = ExtentManager.getReports();
		
		test = reports.createTest("Login_Test");
	}
	
	
	@Test
	public void login() {
		
		test.log(Status.INFO, "Login testcase execution");
		test.log(Status.PASS, "Testcase Passed");
		
	}
	
	@AfterTest
	public void quit() {
		reports.flush();	
	}

}
