package WebDriver.Commands;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.TestBaseClass;

public class takesScreenshot extends TestBaseClass {

	@Test
	public void screenshot() throws IOException {

		launchBrowser();
		driver.get("https://www.google.com");

		takescreenshots("F:\\sample.png");

		// screenshot of particular thing
		WebElement e = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img"));

		getElementScreenshot(e, "F:\\cropImg.png");

	}

	public void takescreenshots(String filePath) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {

			FileUtils.copyFile(src, new File(filePath));

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void getElementScreenshot(WebElement ele, String filePath) {
		// Get entire page screenshot
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg;
		try {
			fullImg = ImageIO.read(screenshot);
			// Get the location of element on the page , 100,150
			Point point = ele.getLocation();

			// Get width and height of the element -50,100
			int eleWidth = ele.getSize().getWidth();
			int eleHeight = ele.getSize().getHeight();

			// Crop the entire page screenshot to get only element screenshot
			BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
			ImageIO.write(eleScreenshot, "png", screenshot);

			// Copy the element screenshot to disk
			File screenshotLocation = new File(filePath);
			FileUtils.copyFile(screenshot, screenshotLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
