package testpackgroup;

import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class B {
	@Test
	private void tc1() {
		System.out.println("Smoke B");
		Assert.fail();
	}

	@Test
	private void tc2() {
		System.out.println("Reg B");
	}

	@Test
	private void tc3() {
		System.out.println("Sanity B");
	}

	@Test
	private void tc4() {
		System.out.println("My Login  B");
	}

	

}
