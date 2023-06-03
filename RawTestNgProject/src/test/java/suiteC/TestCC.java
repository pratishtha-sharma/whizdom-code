package suiteC;

import org.testng.annotations.Test;

import dataProvider.DataProviders;
import testBase.TestBase;

public class TestCC extends TestBase{
	
	@Test(groups = {"smoke", "sanity", "browserGroup2"}, dataProviderClass = DataProviders.class , dataProvider = "dataSuiteC")
	public void testCC(String username, String password) throws InterruptedException {
		log("Starting test CC");
		log(username+" and "+password);
		Thread.sleep(2000);
		log("Ending test CC");
	}

}
