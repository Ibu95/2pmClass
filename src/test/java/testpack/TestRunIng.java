package testpack;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.*;
import org.openqa.selenium.By;

import fbpom.FbHome;
import util.FbBase;

public class TestRunIng extends FbBase {
	public static Sheet mySheet;
	public static FbHome f;

	@BeforeClass
	public static void bfrClas() throws IOException {
		browserOpen("incognito");
		mySheet = getMySheet("C:\\Users\\ibu95\\eclipse-workspace2\\Mvn02Pm\\ExcelFile\\Shivin1.xlsx", "Sheet1");
	}

	@BeforeMethod
	public void bfr() {
		loadUrl("https://www.facebook.com/");
		f = new FbHome();

	}

	@AfterMethod
	public void aft() throws InterruptedException {
		Thread.sleep(2000);
	}

	@Test
	public void tc1() throws InterruptedException {
		String readCell = readCell(mySheet, 0, 0);
		sendData(f.getuName(), readCell);
		sendData(f.getPword(), readCell(mySheet, 0, 1));
		clcikElement(f.getLg());
	}

	@Test
	public void tc2() throws InterruptedException {
		driver.findElement(By.id("mail")).sendKeys(readCell(mySheet, 1, 0));
		sendData(f.getPword(), readCell(mySheet, 1, 1));
		clcikElement(f.getLg());

	}

	@Test
	public void tc3() throws InterruptedException {
		sendData(f.getuName(), readCell(mySheet, 2, 0));
		sendData(f.getPword(), readCell(mySheet, 2, 1));
		clcikElement(f.getLg());
	}

	@AfterClass
	public static void closebrowser() throws InterruptedException {
		browserClose();
	}
}
