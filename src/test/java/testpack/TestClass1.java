package testpack;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestClass1 {

	@Test
	private void tc1() {
		System.out.println("Tc1 _A");
		System.out.println("Tc1 _B");
		System.out.println("Tc1 _C");
		Assert.assertTrue(false, "True Condtion Failed");
		System.out.println("Tc1 _D");
	}

	@Test
	private void tc2() {
		System.out.println("Tc2 _A");
		Assert.assertFalse(true, "False Condtion Failed");
		System.out.println("Tc2 _B");
		System.out.println("Tc2 _C");
		System.out.println("Tc2 _D");
	}

	@Test
	private void tc3() {
		System.out.println("Tc3 _A");
		System.out.println("Tc3 _B");
		Assert.assertEquals(true, false, "Equal Condtion Failed");
		System.out.println("Tc3 _C");
		System.out.println("Tc3 _D");
	}

	@Test
	private void tc4() {
		SoftAssert s = new SoftAssert();
		System.out.println("Tc4 _A");
		s.assertTrue(false, "Soft true Condtion Failed");
		System.out.println("Tc4 _B");
		s.assertFalse(true, "Soft False Condtion Failed");
		System.out.println("Tc4 _C");
		s.assertEquals(false, true, "soft Equal Condtion Failed");
		System.out.println("Tc4 _D");
		// to throw assertion Error
		s.assertAll();
	}

}
