package WebDriver.Commands;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import baseClass.TestBaseClass;

public class explicitWait extends TestBaseClass{
	
	@Test
	public void waitTest() throws IOException {
		launchBrowser();
//		driver.get("https://paytm.com/");
		driver.get("https://www.awwwards.com/sites/khoa-le");
		
//		WebElement element = driver.findElement(By.xpath("//*[@id='app']/header/div/div[2]/div"));
		WebElement element = driver.findElement(By.xpath("//*[@id='header']/div/div/div[2]/div[1]/strong[1]"));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		element.click();
		
		
	}

}
