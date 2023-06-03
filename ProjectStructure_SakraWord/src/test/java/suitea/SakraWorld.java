package suitea;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.TestBaseClass;

public class SakraWorld extends TestBaseClass{
	
	@BeforeTest
	public void init() throws IOException {
		launchBrowser();
	}
	
	@Test
	public void appointmentTest() throws IOException, InterruptedException {
		
		
		
		driver.get(prop.getProperty("url"));
		
		Thread.sleep(3000);
		
		//click on doctor name
		driver.findElement(By.linkText(prop.getProperty("doc_name"))).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		//select consultation from the pop up
		//driver.findElement(By.xpath(prop.getProperty("consultation"))).click();
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		
		//WebElement element = driver.findElement(By.xpath("//button[@class='btn login-btn transition'][2]")); //not working with this xpath
		WebElement element = driver.findElement(By.xpath("//*[@id='hv-vc-appointment-pop-up23']/div/div/div[2]/div/p[2]/button[2]"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Consultation')]")));
		element.click();
		
//		if(!isElementPresent(prop.getProperty("name_id"))) {
//			failAndStop("Name is not visible or present");
//		}
		
		//fill the form
		driver.findElement(By.cssSelector(prop.getProperty("name"))).sendKeys(prop.getProperty("first_name"));
		
		driver.findElement(By.cssSelector(prop.getProperty("email"))).sendKeys(prop.getProperty("emailId"));
		
		driver.findElement(By.cssSelector(prop.getProperty("mobile_number"))).sendKeys(prop.getProperty("phone_number"));
		
		//Select gender
		WebElement gender = driver.findElement(By.id("video_gender"));
		Select select = new Select(gender);
		select.selectByVisibleText("Female");
		
		String allgenderOptions[] = prop.getProperty("expectedGenderoptions").split(",");
		
		List<WebElement> genderValues = select.getOptions();
		
		
		if(genderValues.size() == allgenderOptions.length) {
			
			for(int i=0; i<genderValues.size(); i++) {
				String text1 = genderValues.get(i).getText();
				String text2 = allgenderOptions[i];
				
				if(text1.equals(text2)) {
					System.out.println("Actual and expected gender values are same");
				}
			}
			
		}else
			System.out.println("Gender values are not equal");
		
		
		//select the date
		driver.findElement(By.xpath(prop.getProperty("calendar"))).click();
		Thread.sleep(3000);
		WebElement calYear = driver.findElement(By.xpath(prop.getProperty("year")));
		//wait.until(ExpectedConditions.elementToBeClickable(calYear));
		Select select1 = new Select(calYear);
		select1.selectByVisibleText(prop.getProperty("year1"));
		
		//select month
		WebElement calMonth = driver.findElement(By.xpath(prop.getProperty("month")));
		Select select2 = new Select(calMonth);
		select2.selectByVisibleText(prop.getProperty("month1"));
		
		//Select date
		List<WebElement> dates =  driver.findElements(By.cssSelector(prop.getProperty("date")));
		
		for(int i=0; i<dates.size(); i++) {
			String text = dates.get(i).getText();
			
			if(text.equalsIgnoreCase(prop.getProperty("date1")))
			{
				//Thread.sleep(2000);
				dates.get(i).click();
			}
		}
		
		
		driver.findElement(By.xpath(prop.getProperty("radio1_yes"))).click();
		
		if(driver.findElement(By.xpath(prop.getProperty("uhid"))).isDisplayed()) {
			driver.findElement(By.xpath(prop.getProperty("uhid"))).sendKeys(prop.getProperty("uhid_val"));
		}
		
		driver.findElement(By.xpath(prop.getProperty("radio2_no"))).click();
		driver.findElement(By.xpath(prop.getProperty("radio1_yes"))).click();
		
		String val = driver.findElement(By.xpath(prop.getProperty("uhid"))).getAttribute("value");
		if(val.equals(prop.getProperty("uhid_val")))
			System.out.println("UHID field is working fine");
		else
			System.out.println("Text value in UHID field is not same as entered");
		
		
		//select preferred date 1
		driver.findElement(By.xpath(prop.getProperty("preferDate1"))).click();
		selectDate(prop.getProperty("preferDate1_select"));
		
		
		//driver.quit();
		
		
		
		
	}
	
	//dynamic date selection
	public void selectDate(String dateVal) {
		
		
		Date currentDate = new Date();
		System.out.println(currentDate.toString());



		String monthYearShown = driver.findElement(By.cssSelector(prop.getProperty("month_year"))).getText();
		System.out.println(monthYearShown);

		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date dateToSelect = sd.parse(dateVal);
			System.out.println(dateToSelect.toString());
			// compare dates
			System.out.println(dateToSelect.compareTo(currentDate));
			

			String day = new SimpleDateFormat("d").format(dateToSelect);
			System.out.println(day);
			String month= new SimpleDateFormat("MMMM").format(dateToSelect);
			System.out.println(month);
			String year= new SimpleDateFormat("yyyy").format(dateToSelect);
			System.out.println(year);
			String monthYearToSelect = month+" "+year;
			System.out.println("Month year to be selected "+monthYearToSelect);
			
			while(!monthYearToSelect.equals(monthYearShown)) {
				if(dateToSelect.compareTo(currentDate)==1) {
					driver.findElement(By.xpath(prop.getProperty("cal_forwardButton"))).click();
				}
			}
			
			driver.findElement(By.xpath("//a[text()='"+day+"']")).click();

		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
	
	
//	public boolean isElementPresent(String locator) {
//		WebElement e= null;
//		
//		//element present
//		try {
//			driver.findElement(By.id(locator));
//			
//		} catch(Exception ex) {
//			return false;
//		}
//		
//		//element visible
//		if(!e.isDisplayed())
//			return false;
//		
//		//present and not hidden
//		return true;
//		
//	}

}
