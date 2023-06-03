package WebDriver.Commands;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.TestBaseClass;

public class radioButtons extends TestBaseClass {
	
	//select radio button
	//check which one is selected
	
	//public WebDriver driver;
	
	@Test
	public void radio() throws IOException {
		
		driver  = launchBrowser();
		driver.get("https://www.chabadpotomac.com/templates/articlecco_cdo/aid/1094542/jewish/HS-Registration-Form-New-Student.htm");
		
		List<WebElement> radio = driver.findElements(By.name("reading_proficiency"));
		//radio.get(0).click();
		
		for(int i=0; i<radio.size(); i++) {
			String text = radio.get(i).getText();
			
			if(text.equals("Somewhat    ")) {
				radio.get(i).click();
				break;
			}
		}
		
	}
	
	
	

}
