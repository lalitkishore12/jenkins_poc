package DriverAndBasicFunctions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	public static ExtentReports report = null;

	public static void report() {
		if (report == null) {
			ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "\\testreport.html");
			report = new ExtentReports();
			report.attachReporter(htmlReport);
			report.setSystemInfo("OS", "Windows 10");
			report.setSystemInfo("Browsers", "Chrome/Firefox/Opera");
			report.setSystemInfo("Test Cycle 1", "Chrome");
			report.setSystemInfo("Test Cycle 2", "Firefox");
			report.setSystemInfo("Test Cycle 3", "Opera");
			report.setSystemInfo("UI", "Make My Trip");
			htmlReport.config().setDocumentTitle("Testing Report");
		}
		System.out.println("Report Generated");
	}

}
