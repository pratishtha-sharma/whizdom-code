package suiteA;

import org.testng.annotations.Test;

import dataProvider.TestDataProvider;
import testbase.testBase;

public class testAA extends testBase {
	
	@Test(dataProviderClass = TestDataProvider.class , dataProvider = "dataSuiteA")
	public void TestAA(String username, String password) throws InterruptedException {
		log("Starting AA");
		Thread.sleep(2000);
		log(username+"---"+password);
		log("Ending AA ");
	}

}
