package testpackgroup;

import org.testng.annotations.Test;

public class C {
	@Test(groups = { "smoke" })
	private void tc1() {
		System.out.println("Smoke C");
	}

	@Test(groups = { "reg" })
	private void tc2() {
		System.out.println("Reg C");
	}

	@Test(groups = { "sanity" })
	private void tc3() {
		System.out.println("Sanity C");
	}

	@Test(groups = { "login", "smoke" })
	private void tc4() {
		System.out.println("My Login  C");
	}

}
