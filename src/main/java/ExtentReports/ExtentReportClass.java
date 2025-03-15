package ExtentReports;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportClass {
	static ExtentReports extent;
	@BeforeTest
	public static ExtentReports reportGenerator() {
		System.out.println("report Generate");
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Orange Website Demo");
		reporter.config().setDocumentTitle("Orange HRM Page");
		
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "DeAtHGuN4509");
		return extent;
		}
}
