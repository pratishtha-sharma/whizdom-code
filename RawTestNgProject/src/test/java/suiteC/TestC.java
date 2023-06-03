package suiteC;

import org.testng.annotations.Test;

import dataProvider.DataProviders;
import testBase.TestBase;

public class TestC extends TestBase{
	
	@Test(groups = {"smoke", "browserGroup1"}, dataProviderClass = DataProviders.class , dataProvider = "dataSuiteC")
	public void testC(String username, String password) throws InterruptedException {
		log("Starting test C");
		log(username+" and "+password);
		Thread.sleep(2000);
		log("Ending test C");
	}

}
