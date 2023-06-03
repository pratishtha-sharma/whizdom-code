package suiteB;

import org.testng.annotations.Test;

import dataProvider.DataProviders;
import testBase.TestBase;

public class TestBB extends TestBase{
	
	@Test(groups = {"sanity", "browserGroup1"}, dataProviderClass = DataProviders.class , dataProvider = "dataSuiteB")
	public void testBB(String username, String password) throws InterruptedException {
		log("Starting test BB");
		log(username+" and "+password);
		Thread.sleep(2000);
		log("Ending test BB");
	}

}
