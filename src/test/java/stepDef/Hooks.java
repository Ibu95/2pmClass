package stepDef;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import util.FbBase;

public class Hooks extends FbBase {
	public static String reppath ="C:\\Users\\ibu95\\eclipse-workspace2\\Mvn02Pm\\src\\test\\resources\\extent.properties";
	
	@BeforeAll
	public static  void generatereport() {
		 Properties properties = new Properties();
	        try {
	            FileInputStream fileInputStream = new FileInputStream(reppath);
	            properties.load(fileInputStream);
	            fileInputStream.close();

	            // Modify the property
	            properties.setProperty("extent.reporter.spark.start", "false");
	            properties.setProperty("extent.reporter.pdf.start", "false");
	            // Save the modified properties
	            FileOutputStream fileOutputStream = new FileOutputStream(reppath);
	            properties.store(fileOutputStream, null);
	            fileOutputStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	

	@Before("@chrome")
	public static void bfrscen() {
		browserOpen("Chrome");
	}

	@Before("@edge")
	public static void bfrscened() {
		browserOpen("edge");
	}

	@After
	public static void aftScen(Scenario s) {
		if (s.isFailed()) {

		} else {
			System.out.println(s.getName() + " " + "passed");
		}

		driver.quit();

	}
}
