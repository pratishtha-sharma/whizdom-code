package WebDriver.Commands;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.TestBaseClass;

public class jobServe extends TestBaseClass {
	
	
	@BeforeTest
	public void init() throws IOException {
		launchBrowser();
	}
	
	@Test
	public void jobservmeTest() throws InterruptedException {
		
		driver.get("https://jobserve.com/in/en/Job-Search/");
		WebElement indus = driver.findElement(By.cssSelector(prop.getProperty("Industry_dropdown")));
		
		indus.click();
		
		driver.findElement(By.xpath(prop.getProperty("select_all"))).click();
		Thread.sleep(2000);
		//div[@class='ui-dropdownchecklist ui-dropdownchecklist-dropcontainer-wrapper ui-widget']/div[1]//div[@class='ui-dropdownchecklist-item ui-state-default']
		//div[@class='ui-dropdownchecklist-dropcontainer ui-widget-content']/div[@class='ui-dropdownchecklist-item ui-state-default']
		
		//WebElement indus1 = indus.findElement(By.xpath("//div[@class='ui-dropdownchecklist ui-dropdownchecklist-dropcontainer-wrapper ui-widget']//div[@class='ui-dropdownchecklist-dropcontainer ui-widget-content']"));
		
		List<WebElement> indusList = driver.findElements(By.xpath("//div[@class='ui-dropdownchecklist-dropcontainer ui-widget-content']/div[@class='ui-dropdownchecklist-item ui-state-default']"));
		
		for(int i=0; i<indusList.size(); i++) {
			
			String text = indusList.get(i).getText();
			
			if(text.equals("Defence, Military & Armed Forces")) {
				driver.findElement(By.xpath("//div[@class='ddcl-selInd-i7-fake fakeInput']")).click();
			}
			
		}
		
		
		
	}

}
