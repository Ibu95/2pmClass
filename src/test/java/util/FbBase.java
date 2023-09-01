package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FbBase {
	public static  WebDriver driver;

	public static void browserOpen(String browser) {

		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ibu95\\eclipse-workspace2\\Mvn02Pm\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			break;
		case "incognito":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ibu95\\eclipse-workspace2\\Mvn02Pm\\Driver\\chromedriver.exe");
			ChromeOptions c = new ChromeOptions();
			c.addArguments("--incognito");
			driver = new ChromeDriver(c);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			break;
		}
	}

	public static void sendData(WebElement ele, String data) {
		ele.sendKeys(data);
	}

	public static void clcikElement(WebElement ele) {
		ele.click();
	}

	public static void browserClose() throws InterruptedException {
		Thread.sleep(500);
		driver.quit();
	}

	public static void loadUrl(String url) {
		driver.get(url);
	}

	public static Sheet getMySheet(String pathname, String sheetName) throws IOException {
		File file = new File(pathname);
		FileInputStream fi = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fi);
		Sheet sheet = w.getSheet(sheetName);
		return sheet;
	}

	public static String readCell(Sheet sheet, int rownum, int cellnum) {
		String value = "";
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);

		switch (cell.getCellType()) {
		case STRING:
			value = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				value = new SimpleDateFormat("dd-MM-yyyy").format(cell.getDateCellValue());
			} else {
				value = String.valueOf((long) cell.getNumericCellValue());
			}
			break;
		}
		return value;

	}
	
	

}
