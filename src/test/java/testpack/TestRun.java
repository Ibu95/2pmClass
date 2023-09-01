package testpack;

import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import fbpom.FbHome;
import testDatas.TestData;
import util.FbBase;

public class TestRun extends FbBase {
	public static Sheet mySheet;
	public static FbHome f;

	@Parameters({ "browser" })
	@BeforeClass
	public static void bfrClas(@Optional("chrome") String arg) throws IOException {
		browserOpen(arg);
		loadUrl("https://www.facebook.com/");
		mySheet = getMySheet("C:\\Users\\ibu95\\eclipse-workspace2\\Mvn02Pm\\ExcelFile\\Shivin1.xlsx", "Sheet1");
	}

	@BeforeMethod
	public void bfr() {
		f = new FbHome();
		System.out.println("Start Time " + new Date());
	}

	@AfterMethod
	public void aft() throws InterruptedException {
		System.out.println("End Time " + new Date());
	}

	@Test(priority = 3, timeOut = 3000, expectedExceptions = { AssertionError.class })
	public void userName() throws InterruptedException {
		String readCell = readCell(mySheet, 0, 0);
		sendData(f.getuName(), readCell);
		Assert.fail();
	}

	@Test(dependsOnMethods = { "userName" }, priority = 1, alwaysRun = true)
	public void pass() throws InterruptedException {
		sendData(f.getPword(), readCell(mySheet, 0, 1));
	}

	@Test(priority = 6)
	public void lgBtn() throws InterruptedException {
		clcikElement(f.getLg());
	}

	@Test(dataProvider = "lgData", dataProviderClass = TestData.class)
	public static void seqLogin(String arg1, String arg2) throws InterruptedException {
		loadUrl("https://www.facebook.com/");
		sendData(f.getuName(), arg1);
		sendData(f.getPword(), arg2);
		clcikElement(f.getLg());
		Thread.sleep(2000);
	}

	@AfterClass
	public static void closebrowser() throws InterruptedException {
		browserClose();
	}

}