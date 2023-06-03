package suiteB;

import org.testng.annotations.Test;

import dataProvider.TestDataProvider;
import testbase.testBase;

public class testBB extends testBase {
	
	@Test(dataProviderClass = TestDataProvider.class , dataProvider = "dataSuiteB")
	public void TestBB(String username, String password) throws InterruptedException {
		log("Starting BB");
		Thread.sleep(2000);
		log(username+"---"+password);
		log("Ending BB ");
	}

}
