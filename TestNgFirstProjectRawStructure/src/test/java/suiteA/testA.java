package suiteA;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import dataProvider.TestDataProvider;
import testbase.testBase;

public class testA extends testBase{

	@Test(groups= {"smoke", "browsergroup1"}, dataProviderClass = TestDataProvider.class , dataProvider = "dataSuiteA")
	public void TestA(String username, String password) throws InterruptedException {
		log("Starting A");
		Thread.sleep(2000);
		log(username+"---"+password);
		log("Ending A ");
		//log("Case executed in browser: "+ browser);
		//test.log(Status.FAIL, "Failed forcefully");
		//Assert.fail("Failed deliberately");
	}
	
}
