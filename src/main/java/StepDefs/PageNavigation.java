package StepDefs;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Listeners.MyTestListener;
import utils.Screenshot;
import utils.SetupNTearDown;
import utils.TimeString;

public class PageNavigation extends MyTestListener{
	WebDriver driver;
	String kurramKurram = "mytest"+ new TimeString().currentTimeString();
	
	@BeforeTest
	void beforeTestMethod() {		
		this.driver = SetupNTearDown.setup();
	}
	
	@AfterTest
	void afterTestMethod() {
		SetupNTearDown.driverKiller(driver);
	}
	
	public void tpNav() throws IOException {
		Screenshot.takeWindowScreenShot(driver, kurramKurram);
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.navigate().to("https://www.w3schools.com/mysql/default.asp");
	}
}
