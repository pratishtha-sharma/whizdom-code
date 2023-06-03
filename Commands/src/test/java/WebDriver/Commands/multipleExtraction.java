package WebDriver.Commands;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.fluent.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class multipleExtraction {
	
	
	public static boolean validateResponseCode(String url) {
		
		int resp_code= 0;
		try {
			resp_code = Request.Get(url).execute().returnResponse().getStatusLine().getStatusCode();
			System.out.println("Response code for url--- "+url+"is-> "+resp_code);
			if(resp_code == 200) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");

		// to solve the websocket problem
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://edition.cnn.com/");

		SoftAssert sa = new SoftAssert(); 
		List<WebElement> allLinks = driver.findElements(By.xpath("//div[@class='header__nav-item']//a"));

		System.out.println("Total Links " + allLinks.size());

		for (int i = 0; i < allLinks.size(); i++) {

			if (i == 5) {
				String text1 = allLinks.get(i).getText();
				System.out.println(text1);

				String text2 = allLinks.get(i).getAttribute("href");
				System.out.println(text2);

				break;
			}
		}

		// List<WebElement> moreHeader = driver.findElements(By.xpath(
		// "//div[@class='container__title container_lead-plus-headlines__title
		// ']/following-sibling::div[1]"));

		List<WebElement> moreHeader = driver.findElements(By.xpath(
				"//div[@class='container_lead-plus-headlines__cards-wrapper']//div//div[@class='container__field-links container_lead-plus-headlines__field-links']"));

		System.out.println("Total Links " + moreHeader.size());

		for (int i = 0; i < moreHeader.size(); i++) {

			if (i == 1) {
				String text1 = moreHeader.get(i).getText();
				System.out.println(text1);

//				String text2 = moreHeader.get(i).getAttribute("href");
//				System.out.println(text2);
			}

		}

		List<WebElement> topLinks = driver
				.findElements(By.xpath("//*[@id='pageHeader']/div/div/div[1]/div[1]/nav/div/div/a"));

		for (int i = 0; i < topLinks.size(); i++) {
			System.out.println(topLinks.get(i).getText());
			String url = topLinks.get(i).getAttribute("href");
			System.out.println(url);

			boolean result = validateResponseCode(url);
			sa.assertTrue(result, "Invalid response code");
			topLinks.get(i).click(); //this throws stale element exception as it moves to next page and the value of i is lost as we moved to the next page
			// and coming back to same page from below line would not get the value of i which we have already used.
			// so we will extract the value of toplinks again.
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			driver.get("https://edition.cnn.com/"); 
			System.out.println("-------------------------------------------------------------------------");
			
			topLinks = driver.findElements(By.xpath("//*[@id='pageHeader']/div/div/div[1]/div[1]/nav/div/div/a"));

		}
		
		sa.assertAll();

		driver.quit();

	}

}


