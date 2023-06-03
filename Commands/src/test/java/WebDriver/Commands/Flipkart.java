package WebDriver.Commands;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Flipkart {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");

		// to solve the websocket problem
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/mens-tshirts/pr?sid=clo,ash,ank,edy&fm=neo%2Fmerchandising&iid=M_0f48f0f0-3efd-4cfc-be2d-b42d4bbf3f33_1_372UD5BXDFYS_MC.IF56C41VGEYS&otracker=hp_rich_navigation_2_1.navigationCard.RICH_NAVIGATION_Fashion~Men%2527s%2BTop%2BWear~Men%2527s%2BT-Shirts_IF56C41VGEYS&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_2_L2_view-all&cid=IF56C41VGEYS");

		//List<WebElement> allTShirts = driver.findElements(By.xpath("//a[@class='_2UzuFa']")); //this is getting only number of tshirt only images
		List<WebElement> allTShirts = driver.findElements(By.xpath("//a[@class='IRpwTa']")); //This gives the name of tshirts
		System.out.println("Number of Tshirts- "+allTShirts.size());
		
		for(WebElement e : allTShirts) {
			System.out.println(e.getText());
		}
		
		List<WebElement> allTShirtPrices = driver.findElements(By.xpath("//div[@class='_30jeq3']")); //This gives the name of tshirts
		System.out.println("Number of Tshirts- "+allTShirtPrices.size());
		
		for(WebElement e : allTShirtPrices) {
			System.out.println(e.getText());
		}
		
		for(int i=0; i<allTShirts.size();i++) {
			System.out.println(allTShirts.get(i).getText()+"----"+allTShirtPrices.get(i).getText());
		}
		
		driver.quit();
		
	}

}
