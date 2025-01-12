package StepDefs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageFactory.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ExcelUtility;
import utils.SetupNTearDown;

public class Login {
	WebDriver driver;
	LoginPage lpg = new LoginPage(driver);	
	
	@Given("I am on login page")
//	@Test
	public void onloginPage() {
		driver = SetupNTearDown.setup();
		driver.get("https://www.saucedemo.com/");
	}
	
	@When("I take input of creds from {string}")
	public void enterCreds(String excelName) throws IOException{
		LoginPage lpg = new LoginPage(driver);
		Object[][] creds = ExcelUtility.getExcelData(excelName, "Sheet1");
		for(Object[] cred:creds) {
			String username = cred[0].toString();
			String password = cred[1].toString();
			lpg.enterUsernameAndPassword(username,password);
		}
	}
	
	@Then("I perform login with data from the Excel file")
	public void checkResults() {
		lpg.assertData();
	}
}















