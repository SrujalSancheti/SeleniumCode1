package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelUtility {
	WebDriver driver;
	
	public static Object[][] getExcelData(String fileName, String sheetName) throws IOException{
		FileInputStream fis = new FileInputStream(new File(fileName));
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] data = new Object[rowCount-1][colCount];
		for(int i=1;i<rowCount;i++) {
			Row row = sheet.getRow(i);
			for(int j=0;j<colCount;j++) {
				Cell cell = row.getCell(j);
				data[i-1][j] = getCellValue(cell);
			}
		}
		
		fis.close();
		workbook.close();
		return data;
	}
	
	
	private static Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return cell.getNumericCellValue();
            default:
                return null;
        }
    }
}
