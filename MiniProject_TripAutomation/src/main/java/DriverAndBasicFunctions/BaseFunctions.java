package DriverAndBasicFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseFunctions {
	public static WebDriver driver = null;
	public static int k = 0;

	// Invoking browser dynamically
	
	public static void setup(String browser) throws Exception {
		k = k + 1;
		// Invoking Firefox
		if (browser.equalsIgnoreCase("firefox")) {
			ExtentReport.report();
			Property.loadProperty();
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")
							+ "\\resources\\drivers\\geckodriver.exe");
			FirefoxOptions fo = new FirefoxOptions();
			// Blocking Notification Pop up
			fo.addArguments("--disable-notifications");
			fo.addArguments("--disable-infobars");
			driver = new FirefoxDriver(fo);
			driver.get("https://www.makemytrip.com/");
			System.out.println("Firefox Browser opened");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			wait(10);// Waiting for Ad pop up, if any
			Actions act = new Actions(driver);
			act.moveByOffset(5, 10).click().perform();
			wait(5);
			act.moveByOffset(5, 10).click().perform();
		}
		// Invoking Chrome
		else if (browser.equalsIgnoreCase("chrome")) {
			ExtentReport.report();
			Property.loadProperty();
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "\\resources\\drivers\\chromedriver.exe");
			ChromeOptions co = new ChromeOptions();
			// Blocking Notification Pop up
			co.addArguments("--disable-notifications");
			co.addArguments("--disable-infobars");
			driver = new ChromeDriver(co);
			driver.get("https://www.makemytrip.com/");
			System.out.println("Chrome Browser opened");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			wait(10);// Waiting for Ad pop up, if any
			Actions act = new Actions(driver);
			act.moveByOffset(5, 10).click().perform();
			wait(5);
			act.moveByOffset(5, 10).click().perform();
		}
		// Invoking Opera
		else if (browser.equalsIgnoreCase("opera")) {
			ExtentReport.report();
			Property.loadProperty();
			System.setProperty("webdriver.opera.driver",
					System.getProperty("user.dir")
							+ "\\resources\\drivers\\operadriver.exe");
			OperaOptions oo = new OperaOptions();
			oo.addArguments("--disable-notifications");
			oo.addArguments("--disable-infobars");
			driver = new OperaDriver(oo);
			driver.get("https://www.makemytrip.com/");
			System.out.println("Opera Browser opened");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			wait(15);// Waiting for Ad pop up, if any
			Actions act = new Actions(driver);
			act.moveByOffset(5, 10).click().perform();
			wait(5);
			act.moveByOffset(5, 10).click().perform();
		}
		// No browser invoked
		else {
			System.out.println("Invalid");
		}
	}

	@AfterClass
	public void closeBrowser() {
		wait(4);
		driver.quit();
		System.out.println("Browser closed");
	}

	@AfterTest
	public static void endReport() {
		ExtentReport.report.flush();
	}

	public static void wait(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
