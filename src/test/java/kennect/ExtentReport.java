package kennect;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		if(extent == null) {
			createInstance();
		}
		return extent;
	}
	
	public static synchronized ExtentReports createInstance() {
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setReportName("Automation Result");
		reporter.config().setDocumentTitle("Automation Result");
		
		extent = new ExtentReports();
		extent.setSystemInfo("Organization", "Kennect");
		extent.setSystemInfo("Automation Framework", "Selenium WebDriver");
		extent.attachReporter(reporter);
		return extent;
	}
}
