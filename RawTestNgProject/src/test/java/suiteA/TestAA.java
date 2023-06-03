package suiteA;

import org.testng.annotations.Test;

import dataProvider.DataProviders;
import testBase.TestBase;

public class TestAA extends TestBase{
	
	@Test(groups = {"sanity", "browserGroup2"}, dataProviderClass = DataProviders.class , dataProvider = "dataSuiteA")
	public void testAA(String browserName, String username, String password) throws InterruptedException {
		log("Starting test AA");
		log(username+" and "+password);
		Thread.sleep(2000);
		log("Ending test AA");
	}


}
