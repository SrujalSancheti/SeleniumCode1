package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utils.Browser.BROWSERLIST;

public class SetupNTearDown {
	 static WebDriver driver;

	public static WebDriver setup() {
		return Browser.callBrowser(BROWSERLIST.CHROME);
	}
	
	public static void driverKiller(WebDriver driver) {
		if(driver!=null) {
			driver.quit();
		}
	}
}
