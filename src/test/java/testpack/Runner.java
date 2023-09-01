package testpack;

import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestRun.class, TestRunEdge.class, TestRunIng.class })
public class Runner {

	@Test
	public void report() {
		Result r = JUnitCore.runClasses(TestRun.class, TestRunEdge.class, TestRunIng.class);

		int runCount = r.getRunCount();
		System.out.println("Total TC =" + runCount);

		long runTime = r.getRunTime();
		System.out.println("Total Time =" + runTime);

		int ignoreCount = r.getIgnoreCount();
		System.out.println("Skipped TC =" + ignoreCount);

		int failureCount = r.getFailureCount();
		System.out.println("Failed TC =" + failureCount);

		List<Failure> failures = r.getFailures();
		for (Failure f : failures) {
			Throwable exception = f.getException();
			exception.printStackTrace();
		}

		boolean wasSuccessful = r.wasSuccessful();
		System.out.println("Suite Run = " + wasSuccessful);
	}

}
