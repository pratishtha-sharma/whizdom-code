package suiteB;

import org.testng.annotations.Test;

import dataProvider.TestDataProvider;
import testbase.testBase;

public class testB extends testBase {
	
	@Test(groups= {"sanity", "browsergroup2"}, dataProviderClass = TestDataProvider.class , dataProvider = "dataSuiteB")
	public void TestB(String username, String password) throws InterruptedException {
		log("Starting B");
		Thread.sleep(2000);
		log(username+"---"+password);
		log("Ending B ");
	}

}
