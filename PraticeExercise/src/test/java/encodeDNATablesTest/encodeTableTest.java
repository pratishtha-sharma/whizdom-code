package encodeDNATablesTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.TestBaseClass;

public class encodeTableTest extends TestBaseClass {
	
	@BeforeTest
	public void openBrowser() throws IOException {
		
		launchBrowser();
		
	}
	
	@Test
	public void encodeTable() {
		
		driver.get("https://www.encodedna.com/javascript/demo/dynamically-add-or-remove-table-rows-using-javascript-and-save-data.htm");
		
		driver.findElement(By.xpath("//input[contains(@value, 'Create a Table')]")).click();
		driver.findElement(By.xpath("//input[contains(@value, 'Click to add a new row')]")).click();
		
	}

}
