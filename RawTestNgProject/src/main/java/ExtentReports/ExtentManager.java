package ExtentReports;



import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	
	static ExtentReports reports;
	
	public static ExtentReports getReports() {
		
		if (reports == null) {
			
			reports = new ExtentReports();
			Date d = new Date();
			String ssfolder = d.toString().replaceAll(":", "-")+"//screenshots";
			
			String reportsFolderPath = System.getProperty("user.dir")+"\\reports\\"+ d.toString().replaceAll(":", "-");
			String screenshotFolderPath = System.getProperty("user.dir")+"\\reports\\"+ ssfolder;
			
			System.out.println(reportsFolderPath);
			System.out.println(screenshotFolderPath);
			
			ExtentSparkReporter sparkR = new ExtentSparkReporter(reportsFolderPath);
			
			sparkR.config().setReportName("Regression Testing");
			sparkR.config().setDocumentTitle("Automation Test Report");
			
			reports.attachReporter(sparkR);
			
			}
		return reports;
		
	}
	
	
}
