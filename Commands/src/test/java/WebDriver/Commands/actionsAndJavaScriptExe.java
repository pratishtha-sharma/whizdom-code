package WebDriver.Commands;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.TestBaseClass;

public class actionsAndJavaScriptExe extends TestBaseClass{
	
	public JavascriptExecutor js;
	
	@BeforeTest
	public void launchWeb() throws IOException {
		launchBrowser();
		//driver.get("https://www.americangolf.co.uk/golf-clubs");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location='https://www.americangolf.co.uk/golf-clubs'");
		
	}
		
		@Test
		public void testAmericanGolf() throws InterruptedException {
			
			//xpath of accept button
			WebElement e = driver.findElement(By.xpath("//*[@id='termly-code-snippet-support']/div/div/div/div/div/div[2]/button[2]"));
			e.click();
			Thread.sleep(2000);
			Actions act = new Actions(driver);
			//WebElement golfClubs = driver.findElement(By.linkText("Golf Clubs"));
			WebElement golfClubs = driver.findElement(By.xpath("//*[@id='header-navigation']/div/ul/li[3]/a"));
			act.moveToElement(golfClubs).build().perform();
	
			
	//part 1		
//			driver.findElement(By.xpath("//*[@id='CLUBS_1']/ul/li[3]/ul/li[2]/a/span")).click();
//			
//			//price toggle
//			WebElement priceToggle = driver.findElement(By.xpath("//*[@id='secondary']/div[1]/div[8]/div/div/div[1]/div/div/div[1]/div"));
//			
//			//scroll page 
//			js.executeScript("window.scrollBy(0,1500)"); 
//			act.clickAndHold(priceToggle).moveByOffset(150, 0).build().perform();
			
			
	//part 2		
			List<WebElement> links = driver.findElements(By.xpath("//div[@id='CLUBS_1']/descendant::a"));
			Random r = new Random();
			int i = r.nextInt(links.size());
			Thread.sleep(2000);
			String text = links.get(i).getText();
			System.out.println(text);
			links.get(i).click();
			
			
		}
			
}
