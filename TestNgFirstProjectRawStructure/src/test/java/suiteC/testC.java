package suiteC;

import org.testng.annotations.Test;

import dataProvider.TestDataProvider;
import testbase.testBase;

public class testC extends testBase {
	
	@Test(dataProviderClass = TestDataProvider.class , dataProvider = "dataSuiteC")
	public void TestC(String username, String password) throws InterruptedException {
		log("Starting C");
		Thread.sleep(2000);
		log(username+"---"+password);
		log("Ending C ");
	}

}
