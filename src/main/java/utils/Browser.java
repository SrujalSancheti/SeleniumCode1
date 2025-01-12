package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Browser {
	public enum BROWSERLIST{
		CHROME,EDGE,FIREFOX
	}
	
	public static WebDriver callBrowser(BROWSERLIST browser) {
		WebDriver driver;
		switch (browser) {
		case CHROME:
			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			break;

		case FIREFOX:
			driver = new FirefoxDriver();
			break;
			
		case EDGE:
			driver = new EdgeDriver();
			break;
			
		default:
			throw new IllegalArgumentException("No Browser in the list");
		}
		
		return driver;
	}
	
}
