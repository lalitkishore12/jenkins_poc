package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import DriverAndBasicFunctions.BaseFunctions;

public class CabLocator {
	public static String fare = "";
	public static String car = "";
	public static void cabType() {
		int i = -1;
		List<WebElement> type = BaseFunctions.driver.findElements(By
				.xpath("//div[@class='cabDetails']/div[1]/div/div[1]/p[2]"));
		List<WebElement> price = BaseFunctions.driver
				.findElements(By
						.xpath("//div[@class='makeFlex column spaceBetween priceDetailsPadding flexGrow1']/div/div/p[1]"));
		for (WebElement ct : type) {
			i = i + 1;
			if (ct.getText().equalsIgnoreCase("SUV")) {
				car = ct.getText();
				String str = price.get(i).getText();
				fare = "Rs." + str.substring(1);
				break;
			}
		}
		System.out.println("Cab details fetched");
	}
}
