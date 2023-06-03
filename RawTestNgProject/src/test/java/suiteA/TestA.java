package suiteA;

import org.testng.annotations.Test;

import dataProvider.DataProviders;
import testBase.TestBase;

public class TestA extends TestBase {
	
	
	@Test(groups = {"smoke", "browserGroup1"}, dataProviderClass = DataProviders.class , dataProvider = "dataSuiteA")
	public void testA(String browserName, String username, String password) throws InterruptedException {
		log("Starting test A");
//		softAssert.assertEquals("Title1", "Title");
//		softAssert.assertEquals("Text1", "Text");
		
		if(! "Title1".equals("Title"))
			softAssert("The titles did not match"); // this will fail in testng and report but will continue
		
		log("Assert started");
		log("Application started");
		log("Booking tickets");
		
		if(! "Text1".equals("Text"))
			softAssert("The Text did not match"); // this will fail in testng and report but will continue
		
		if(! "Text1".equals("Text"))
			failAndStop("Invalid data"); // this will fail in testng and report and will stop
		
		
		log("After Hard Assert"); // this will not get printed as above is the hard assert
		
		
		
		softAssert.assertAll();
		log(username+" and "+password);
		Thread.sleep(2000);
		log("Ending test A");
	}

}
