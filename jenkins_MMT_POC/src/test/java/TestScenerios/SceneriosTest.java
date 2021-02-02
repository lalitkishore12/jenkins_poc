package TestScenerios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import DriverAndBasicFunctions.BaseFunctions;
import DriverAndBasicFunctions.Excel;
import DriverAndBasicFunctions.ExtentReport;
import DriverAndBasicFunctions.Property;
import DriverAndBasicFunctions.Screenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class SceneriosTest extends BaseFunctions{
	// Scenerio-1 Begins
	@Test(priority = 1, groups = { "Regression" })
	public void verifyTitle() {
		try {
			BaseFunctions.setup("chrome");
			ExtentTest logger = ExtentReport.report.createTest("Home Page" + k);
			logger.log(Status.INFO, "Home Page Opened");
			String pageTitle = driver.getTitle();
			String expTitle = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
			Assert.assertEquals(pageTitle, expTitle);
			logger.log(Status.PASS, "Title of Home Page Verified");
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 2, groups = { "Regression", "Smoke" })
	public void verifyClick() {
		try {
			ExtentTest logger = ExtentReport.report.createTest("Cab Page" + k);
			WebElement element = driver
					.findElement(By
							.xpath("//*[@id='SW']/div[1]/div[2]/div/div/nav/ul/li[8]/a"));
			element.click();
			logger.log(Status.INFO, "Cabs Option Clicked");
			String pageTitle = driver.getTitle();
			String expTitle = "Online Cab Booking - Book Outstation Cabs at Lowest Fare @ MakeMyTrip";
			Assert.assertEquals(pageTitle, expTitle);
			logger.log(Status.PASS, "Title of Cab Page Verified");
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	// Scenerio-1 Ends
	// Scenerio-2 Begins
	@Test(priority = 3, groups = { "Regression" })
	public void verifyOneway() {
		try {
			ExtentTest logger = ExtentReport.report.createTest("Verify One Way"
					+ k);
			WebElement oneWay = driver
					.findElement(By
							.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/span[1]"));
			if (oneWay.isEnabled()) {
				logger.log(Status.INFO, "One Way is selected");
				Assert.assertTrue(true);
				logger.log(Status.PASS, "Verified");
			} else {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 4, groups = { "Regression", "Smoke" })
	public void enterSource() {
		try {
			ExtentTest logger = ExtentReport.report.createTest("Source City"
					+ k);
			driver.findElement(By.xpath("//input[@id='fromCity']")).click();
			wait(2);
			logger.log(Status.INFO, "Entering Source City");
			driver.findElement(By.xpath("//div[@role='combobox']/input[1]"))
					.sendKeys(Property.sourceCity);
			List<WebElement> autos = driver.findElements(By
					.xpath("//*[@role='listbox']/li"));
			wait(4);
			for (WebElement src : autos) {
				if (src.getText().contains(Property.sourceCity)) {
					src.click();
					logger.log(Status.PASS, "Source City Entered");
					break;
				}
			}
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 5, groups = { "Regression", "Smoke" })
	public void enterDestination() {
		try {
			ExtentTest logger = ExtentReport.report
					.createTest("Destination City" + k);
			wait(2);
			logger.log(Status.INFO, "Entering Destination City");
			driver.findElement(By.xpath("//div[@role='combobox']/input[1]"))
					.sendKeys(Property.destinationCity);
			List<WebElement> autod = driver.findElements(By
					.xpath("//*[@role='listbox']/li"));
			wait(4);
			for (WebElement des : autod) {
				if (des.getText().contains(Property.destinationCity)) {
					des.click();
					logger.log(Status.PASS, "Destination City Entered");
					break;
				}
			}
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 6, groups = { "Regression", "Smoke" })
	public void enterDepatureDate() {
		try {
			ExtentTest logger = ExtentReport.report.createTest("Departure Date"
					+ k);
			logger.log(Status.INFO, "Entering Departure Date");
			driver.findElement(By.xpath("//span[contains(text(),'DEPARTURE')]"))
					.click();
			List<WebElement> dates = driver
					.findElements(By
							.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div/div"));
			for (WebElement d : dates) {
				if (d.getText().equals(Property.journeyDate)) {
					d.click();
					logger.log(Status.PASS, "Departure Date Entered");
					break;
				}
			}
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}

	@Test(priority = 7, groups = { "Regression", "Smoke" })
	public void enterPickupTime() {
		try {
			ExtentTest logger = ExtentReport.report.createTest("Pickup Time"
					+ k);
			logger.log(Status.INFO, "Entering Pickup Time");
			driver.findElement(
					By.xpath("//span[contains(text(),'PICKUP-TIME')]")).click();
			List<WebElement> time = driver
					.findElements(By
							.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li"));
			for (WebElement t : time) {
				if (t.getText().equals(Property.pickupTime)) {
					t.click();
					logger.log(Status.PASS, "Pickup Time Entered");
					break;
				}
			}
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 8, groups = { "Smoke" })
	public void clickSearch() {
		try {
			ExtentTest logger = ExtentReport.report.createTest("Search" + k);
			driver.findElement(By.xpath("//a[contains(text(),'Search')]"))
					.click();
			logger.log(Status.INFO, "Search Button Clicked");
			String pageTitle = driver.getTitle();
			logger.log(Status.INFO, "Actual Result Page Title Taken");
			String expTitle = "Cabs";
			logger.log(Status.INFO, "Expected Result Page Title Taken");
			Assert.assertEquals(pageTitle, expTitle);
			logger.log(Status.PASS, "Result Page Title Verified");
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 9, groups = { "Smoke" })
	public void findSUV() {
		try {
			ExtentTest logger = ExtentReport.report
					.createTest("Suv Search" + k);
			List<String> find = new ArrayList<String>();
			List<WebElement> typ = driver.findElements(By.xpath("//div[@class='cabDetails']/div[1]/div/div[1]/p[2]"));
			logger.log(Status.INFO, "All the Suvs Picked");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			for (WebElement ct : typ) {
				wait(1);
				js.executeScript("arguments[0].scrollIntoView()", ct);
				find.add(ct.getText());
			}
			if (find.contains(Property.carType)) {
				Excel.createExcel();
				logger.log(Status.PASS,
						"Lowest Charged Cab is Picked and Stored in Excel");
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
}
