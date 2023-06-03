package suiteB;

import org.testng.annotations.Test;

import dataProvider.DataProviders;
import testBase.TestBase;

public class TestB extends TestBase{
	
	@Test(groups = {"smoke", "browserGroup2"}, dataProviderClass = DataProviders.class , dataProvider = "dataSuiteB")
	public void testB(String username, String password) throws InterruptedException {
		log("Starting test B");
		log(username+" and "+password);
		Thread.sleep(2000);
		log("Ending test B");
	}


}
