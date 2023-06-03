package suitea;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Date;

import baseClass.TestBaseClass;

public class TesClass extends TestBaseClass {

	@BeforeTest
	public void init() throws IOException {
		launchBrowser();
	}

	@Test
	public void testtt() throws InterruptedException {
		driver.get(prop.getProperty("url"));

		Thread.sleep(3000);

		// click on doctor name
		driver.findElement(By.linkText(prop.getProperty("doc_name"))).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);

		WebElement element = driver
				.findElement(By.xpath("//*[@id='hv-vc-appointment-pop-up23']/div/div/div[2]/div/p[2]/button[2]"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

		Date d = new Date();
		System.out.println(d.toString());
		String date_select = "25-06-2023";


		driver.findElement(By.xpath("//input[@id='video_prefdate1']")).click();

		String monthYearShown = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		System.out.println(monthYearShown);

		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date dateToSelect = sd.parse(date_select);
			System.out.println(dateToSelect.toString());
			// compare dates
			System.out.println(dateToSelect.compareTo(d));
			

			String day = new SimpleDateFormat("dd").format(dateToSelect);
			System.out.println(day);
			String month= new SimpleDateFormat("MMMM").format(dateToSelect);
			System.out.println(month);
			String year= new SimpleDateFormat("yyyy").format(dateToSelect);
			System.out.println(year);
			String monthYearToSelect = month+" "+year;
			System.out.println("Month year to be selected "+monthYearToSelect);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
