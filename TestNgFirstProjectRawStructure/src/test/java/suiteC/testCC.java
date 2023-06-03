package suiteC;

import org.testng.annotations.Test;

import dataProvider.TestDataProvider;
import testbase.testBase;

public class testCC extends testBase{
	
	@Test(dataProviderClass = TestDataProvider.class , dataProvider = "dataSuiteC")
	public void TestCC(String username, String password) throws InterruptedException {
		log("Starting CC");
		Thread.sleep(2000);
		log(username+"---"+password);
		log("Ending CC ");
	}

}
