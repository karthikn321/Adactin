package org.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;
	public static File file;
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	// launch setup
	public void setup(String browser, String url) {
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser name...");
			break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.manage().window().maximize();
	}

	// excel data
	public String readExcel(String sheetName, int rowNum, int cellNum) throws IOException {
		file = new File("ExcelData\\Adactin_Data.xlsx");
		FileInputStream stream = new FileInputStream(file);
		book = new XSSFWorkbook(stream);
		sheet = book.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);

		CellType cellType = cell.getCellType();

		String value = "";
		switch (cellType) {
		case STRING:
			value = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("MM/dd/yyy");
				value = SimpleDateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				// value = valueOf.toString();
				value = valueOf.toPlainString();
			}
			break;
		default:
			System.out.println("Invalid cell Data...");
			break;
		}
		return value;
	}

	// sendkeys Method
	public void getSendKeys(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
	}

	// getttribute
	public String getAttributeValue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	// click method
	public void performClick(WebElement element) {
		element.click();
	}

	// getText method
	public String captureText(WebElement element) {
		String text = element.getText();
		return text;
	}

	// screenshot
	public void captureScreen() {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFolder = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File targetFolder = new File("C:\\Users\\karth\\eclipse-workspace\\Adactin\\Screenshot\\" + "image_"
				+ System.currentTimeMillis() + ".png");
		sourceFolder.renameTo(targetFolder);
	}

	// select method
	public void getSelectOptions(WebElement element, String selectionType, String value) {
		Select select = new Select(element);
		switch (selectionType.toLowerCase()) {
		case "visibletext":
			select.selectByVisibleText(value);
			break;
		case "values":
			select.selectByValue(value);
			break;
		case "index":
			int index = Integer.parseInt(value);
			select.selectByIndex(index);
			break;
		default:
			System.out.println("Invalid selection Type...");
			break;
		}
	}

	// handle Alert Method
	public void handleAlerts(String typeOfAlert) {
		Alert alert = driver.switchTo().alert();
		switch (typeOfAlert.toLowerCase()) {
		case "simplealert":
			alert.accept();
			break;
		case "confirmalert":
			alert.accept();
			break;
		case "promptalert":
			alert.sendKeys("accepted");
			alert.accept();
			break;
		default:
			System.out.println("Invalid alert type...");
			break;
		}
	}

	// write excel
	public void excelReport(String sheetName, int rownum, int cellnum, String data) throws IOException {
		// file = new File("\\ExcelData\\Adactin_Data.xlsx");

		FileOutputStream fileopFileOutputStream = new FileOutputStream(file);

		// XSSFWorkbook book = new XSSFWorkbook();

		sheet = book.getSheet(sheetName);

		row = sheet.getRow(rownum);

		cell = row.createCell(cellnum);

		cell.setCellValue(data);

		book.write(fileopFileOutputStream);

	}

}
