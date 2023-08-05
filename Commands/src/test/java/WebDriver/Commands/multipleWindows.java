package WebDriver.Commands;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.TestBaseClass;

public class multipleWindows extends TestBaseClass{
	
	@BeforeTest
	public void init() throws IOException {
		launchBrowser();
	}
	
	@Test
	public void multliWindows() {
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//a[contains(text(),'Free Access to InterviewQues/ResumeAssistance/Mate')]")).click();
		
		Set<String> s = driver.getWindowHandles();
		Iterator<String>it = s.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		
		driver.findElement(By.xpath("//a[contains(@href, '_in')]")).click();
		String actual = driver.findElement(By.xpath("//h3[contains(text(),'Log in')]")).getText();
		
		System.out.println(actual);
		
		String expected = "Log in";
		Assert.assertEquals(actual, expected);
		System.out.println("Passed");
		
	}

}
