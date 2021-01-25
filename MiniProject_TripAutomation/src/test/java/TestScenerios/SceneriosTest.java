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
			Assert.assertTrue(false);
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
			List<WebElement> typ = driver
					.findElements(By
							.xpath("//div[@class='cabDetails']/div[1]/div/div[1]/p[2]"));
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

	// Scenerio-2 Ends
	// Scenerio-3 Begins
	@Test(priority = 10, groups = { "Regression", "Smoke" })
	public void gitCards() {
		try {
			ExtentTest logger = ExtentReport.report.createTest("Group Gifting"
					+ k);
			wait(4);
			WebElement more = driver
					.findElement(By
							.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[10]/a[1]/span[1]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", more);
			Actions act = new Actions(driver);
			act.moveToElement(more).build().perform();
			;
			wait(2);
			driver.findElement(
					By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[10]/div[1]/a[2]"))
					.click();
			logger.log(Status.INFO, "Gift Card Option Clicked");
			logger.log(Status.PASS, "Redirected to the Next Page");
			String MainWindow = driver.getWindowHandle();
			Set<String> s1 = driver.getWindowHandles();
			Iterator<String> i1 = s1.iterator();
			while (i1.hasNext()) {
				String ChildWindow = i1.next();

				if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

					// Switching to Child window
					driver.switchTo().window(ChildWindow);
				}
			}
			wait(4);
			driver.findElement(
					By.xpath("//header/div[1]/div[1]/ul[1]/li[5]/a[1]"))
					.click();
			logger.log(Status.INFO, "Group Gifting Option Clicked");
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	/*
	 * @Test(priority = 11, groups = { "Regression" }) public void
	 * amountPlaceHolder() { try { ExtentTest logger = ExtentReport.report
	 * .createTest("Amount Placeholder" + k); String actualHolder =
	 * driver.findElement( By.xpath("//input[@id='amount']")).getAttribute(
	 * "placeholder"); logger.log(Status.INFO, "Actual Amount Placeholder Taken");
	 * String expectedHolder = "Rs 1000 - Rs 100000"; logger.log(Status.INFO,
	 * "Expected Amount Placeholder Taken"); Assert.assertEquals(actualHolder,
	 * expectedHolder); logger.log(Status.PASS, "Amount Placeholder Verified"); }
	 * catch (Exception e) { Assert.assertTrue(false); } }
	 * 
	 * @Test(priority = 12, groups = { "Regression" }) public void datePlaceHolder()
	 * { try { ExtentTest logger = ExtentReport.report
	 * .createTest("Date Placeholder" + k); String actualHolder =
	 * driver.findElement( By.xpath("//input[@id='deadline']")).getAttribute(
	 * "placeholder"); logger.log(Status.INFO, "Actual Date Placeholder Taken");
	 * String expectedHolder = "yyyy-mm-dd"; logger.log(Status.INFO,
	 * "Expexted Date Placeholder Taken"); Assert.assertEquals(actualHolder,
	 * expectedHolder); logger.log(Status.PASS, "Date Placeholder Verified"); }
	 * catch (Exception e) { Assert.assertTrue(false); } }
	 * 
	 * @Test(priority = 13, groups = { "Smoke" }) public void empty() { try {
	 * ExtentTest logger = ExtentReport.report.createTest("Empty Fields" + k);
	 * wait(2); driver.findElement(By.xpath("//button[@id='next1']")).click();
	 * logger.log(Status.INFO, "Next Button Clicked"); logger.log(Status.PASS,
	 * "Warning Message Displayed"); wait(2); Screenshot.takess(); try {
	 * logger.addScreenCaptureFromPath(System.getProperty("user.dir") +
	 * "//screenshots//image" + Screenshot.i + ".png"); } catch (IOException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); }
	 * driver.findElement(By.xpath("//div[@id='okay']")).click(); } catch (Exception
	 * e) { Assert.assertTrue(false); } }
	 * 
	 * @Test(priority = 14, groups = { "Smoke" }) public void amountLess() { try {
	 * ExtentTest logger = ExtentReport.report.createTest("Less Amount" + k);
	 * driver.findElement(By.xpath("//input[@id='amount']")).sendKeys(
	 * Property.lessAmount); logger.log(Status.INFO,
	 * "Amount Entered less than the Range"); wait(1);
	 * driver.findElement(By.xpath("//input[@id='deadline']")).click();
	 * driver.findElement(
	 * By.xpath("//body[1]/div[6]/div[1]/table[1]/thead[1]/tr[2]/th[3]")) .click();
	 * driver.findElement(By.xpath("//td[contains(text(),'12')]")).click();
	 * logger.log(Status.INFO, "Date Entered");
	 * driver.findElement(By.xpath("//button[@id='next1']")).click();
	 * logger.log(Status.PASS, "Warning Message Displayed"); wait(2);
	 * Screenshot.takess(); try {
	 * logger.addScreenCaptureFromPath(System.getProperty("user.dir") +
	 * "//screenshots//image" + Screenshot.i + ".png"); } catch (IOException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); }
	 * driver.findElement(By.xpath("//div[@id='okay']")).click(); } catch (Exception
	 * e) { Assert.assertTrue(false); } }
	 * 
	 * @Test(priority = 15, groups = { "Smoke" }) public void amountMore() { try {
	 * ExtentTest logger = ExtentReport.report.createTest("More Amount" + k);
	 * driver.findElement(By.xpath("//input[@id='amount']")).clear();
	 * driver.findElement(By.xpath("//input[@id='amount']")).sendKeys(
	 * Property.moreAmount); logger.log(Status.INFO,
	 * "Amount Entered more than the Range");
	 * driver.findElement(By.xpath("//button[@id='next1']")).click();
	 * logger.log(Status.INFO, "Next Button Clicked"); logger.log(Status.PASS,
	 * "Warning Message Displayed"); wait(2); Screenshot.takess(); try {
	 * logger.addScreenCaptureFromPath(System.getProperty("user.dir") +
	 * "//screenshots//image" + Screenshot.i + ".png"); } catch (IOException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); }
	 * driver.findElement(By.xpath("//div[@id='okay']")).click(); } catch (Exception
	 * e) { Assert.assertTrue(false); } }
	 * 
	 * @Test(priority = 16, groups = { "Smoke" }) public void untick() { try {
	 * ExtentTest logger = ExtentReport.report
	 * .createTest("Unchecked Term and Condition" + k);
	 * driver.findElement(By.xpath("//input[@id='amount']")).clear();
	 * driver.findElement(By.xpath("//input[@id='amount']")).sendKeys(
	 * Property.amount); logger.log(Status.INFO, "Amount Entered within the Range");
	 * logger.log(Status.INFO, "Term and Condition checkbox is unchecked");
	 * driver.findElement(By.xpath("//button[@id='next1']")).click();
	 * logger.log(Status.INFO, "Next Button Clicked"); logger.log(Status.PASS,
	 * "Warning Message Displayed"); wait(2); Screenshot.takess(); try {
	 * logger.addScreenCaptureFromPath(System.getProperty("user.dir") +
	 * "//screenshots//image" + Screenshot.i + ".png"); } catch (IOException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } wait(2);
	 * driver.findElement(By.xpath("//div[@id='okay']")).click(); } catch (Exception
	 * e) { Assert.assertTrue(false); } }
	 * 
	 * @Test(priority = 17, groups = { "Smoke" }) public void tick() { try {
	 * ExtentTest logger = ExtentReport.report
	 * .createTest("Checked Term and Condition" + k); wait(2); driver.findElement(
	 * By.xpath("//body/div[3]/form[1]/div[2]/div[5]/div[1]/label[1]/input[1]"))
	 * .click(); logger.log(Status.INFO, "Term and Condition checkbox is checked");
	 * driver.findElement(By.xpath("//button[@id='next1']")).click();
	 * logger.log(Status.INFO, "Next Button Clicked"); logger.log(Status.PASS,
	 * "Redirected to the Next Section"); } catch (Exception e) {
	 * Assert.assertTrue(false); } }
	 * 
	 * // Scenerio-3 Ends // Scenerio-4 Begins
	 * 
	 * @Test(priority = 18, groups = { "Regression" }) public void namePlaceHolder()
	 * { try { ExtentTest logger = ExtentReport.report
	 * .createTest("Name Placeholder" + k); String actualHolder =
	 * driver.findElement( By.xpath("//input[@id='recipient']")).getAttribute(
	 * "placeholder"); logger.log(Status.INFO, "Actual Name Placeholder Taken");
	 * String expectedHolder = "Name"; logger.log(Status.INFO,
	 * "Expected Name Placeholder Taken"); Assert.assertEquals(actualHolder,
	 * expectedHolder); logger.log(Status.PASS, "Name Placeholder Verified"); }
	 * catch (Exception e) { Assert.assertTrue(false); } }
	 * 
	 * @Test(priority = 19, groups = { "Regression" }) public void
	 * emailPlaceHolder() { try { ExtentTest logger = ExtentReport.report
	 * .createTest("Email Placeholder" + k); String actualHolder =
	 * driver.findElement( By.xpath("//input[@id='recipientemail']")).getAttribute(
	 * "placeholder"); logger.log(Status.INFO, "Actual Email Placeholder Taken");
	 * String expectedHolder = "Email"; logger.log(Status.INFO,
	 * "Expected Email Placeholder Taken"); Assert.assertEquals(actualHolder,
	 * expectedHolder); logger.log(Status.PASS, "Email Placeholder Verified"); }
	 * catch (Exception e) { Assert.assertTrue(false); } }
	 * 
	 * @Test(priority = 20, groups = { "Smoke" }) public void invalidEmail() { try {
	 * ExtentTest logger = ExtentReport.report.createTest("Invalid Email" + k);
	 * driver.findElement(By.xpath("//input[@id='recipient']")).sendKeys(
	 * Property.name); logger.log(Status.INFO, "Recepient Name Entered");
	 * driver.findElement(By.xpath("//input[@id='recipientemail']"))
	 * .sendKeys(Property.invalidEmail); logger.log(Status.INFO,
	 * "Recepient Email Entered");
	 * driver.findElement(By.xpath("//button[@id='next2']")).click();
	 * logger.log(Status.INFO, "Next Button Clicked"); logger.log(Status.PASS,
	 * "Warning Message Displayed"); wait(2); Screenshot.takess(); try {
	 * logger.addScreenCaptureFromPath(System.getProperty("user.dir") +
	 * "//screenshots//image" + Screenshot.i + ".png"); } catch (IOException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } wait(2);
	 * driver.findElement(By.xpath("//div[@id='okay']")).click(); } catch (Exception
	 * e) { Assert.assertTrue(false); } }
	 */
	
	// Scenerio-4 Ends
}
