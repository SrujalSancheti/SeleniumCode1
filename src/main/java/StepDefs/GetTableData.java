package StepDefs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import utils.SetupNTearDown;


public class GetTableData{
	WebDriver driver;

	@BeforeTest
	void beforeTestMethod() {		
		this.driver  = SetupNTearDown.setup();
	}
	
	@AfterTest
	void afterTestMethod() {
		SetupNTearDown.driverKiller(driver);
	}
	
	
	@Test
	public void getTabData() throws IOException {
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("result");
		WebElement table = driver.findElement(By.className("ws-table-all"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		for(int i=0;i<rows.size();i++) {
			Row row = sheet.createRow(i);
			if(i==0) {
				List<WebElement> header = table.findElements(By.tagName("th"));
				for(int k = 0;k<header.size();k++) {
					String headerText = header.get(k).getText();
					Cell cell = row.createCell(k);
					cell.setCellValue(headerText);
				}
			}else {
				List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
				for(int j=0;j<cols.size();j++) {
					String cellText = cols.get(j).getText();
					Cell cell = row.createCell(j);
					cell.setCellValue(cols.get(j).getText());
				}
			}
		}
		
		FileOutputStream fis = new FileOutputStream("result.xlsx");
		workbook.write(fis);
		workbook.close();
	}
	

}
