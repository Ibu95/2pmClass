package testpackgroup;

import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.Test;

public class A {

	@Test
	private void tc1() {
		System.out.println("Smoke A");
	}

	@Test(retryAnalyzer = ReRun.class)
	private void tc2() {
		System.out.println("Reg A");
		Assert.fail();
	}

	@Test
	private void tc3() {
		System.out.println("Sanity A");
		Assert.fail();
	}

	@Test
	private void tc4() {
		System.out.println("My Login  A");
	}

}
