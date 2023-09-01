package excelclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readf {

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\ibu95\\eclipse-workspace2\\Mvn02Pm\\ExcelFile\\NewShivin1.xlsx");
		// FileInputStream fi = new FileInputStream(f);
		// to creat work book
		Workbook w = new XSSFWorkbook();

		// to creat new Sheet
		Sheet sheet = w.createSheet("New Sheet");

		// to creat new Row
		Row row = sheet.createRow(sheet.getPhysicalNumberOfRows());

		// to creat new Cell
		Cell createCell = row.createCell(row.getPhysicalNumberOfCells());
		createCell.setCellValue("New Work book Sheet Row Cell");

		// Scenario 1 : When We know the Cell
		Row row1 = sheet.getRow(1);
		Cell cell = row1.getCell(1);

		// to send the data to the cell
		cell.setCellValue("Java");
		// =====================================================================================================
		// Scenario 2 : When we dont know the cell
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row r = sheet.getRow(i);
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				String value = "";
				Cell c = r.getCell(j);

				switch (c.getCellType()) {
				case STRING:
					value = c.getStringCellValue();
					break;
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(c)) {
						Date dateCellValue = c.getDateCellValue();
						SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
						value = sf.format(dateCellValue);
					} else {
						double num = c.getNumericCellValue();
						long l = (long) num;
						value = String.valueOf(l);
					}
					break;
				}

				if (value.equals("Shivin4")) {
					c.setCellValue("Selenium");
					break;
				}
			}
		}

		FileOutputStream o = new FileOutputStream(f);
		w.write(o);

		System.out.println("Done");

	}
}
