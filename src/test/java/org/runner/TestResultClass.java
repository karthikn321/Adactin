
package org.runner;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestResultClass {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestRunnerClass.class);

		System.out.println("=====================================================================================");
		System.out.println("==== TEST CASE RESULTS ====");

		int runCount = result.getRunCount();
		int ignoreCount = result.getIgnoreCount();
		int failureCount = result.getFailureCount();

		System.out.println("Run Count: " + runCount);
		System.out.println("Ignored Count: " + ignoreCount);
		System.out.println("Failure Count: " + failureCount);

		List<Failure> failures = result.getFailures();
		for (Failure failure : failures) {
			System.out.println("Test Failed: " + failure.getTestHeader());
			System.out.println("Failure Message: " + failure.getMessage());
			System.out.println("Stack Trace: " + failure.getTrace());
		}

		boolean wasSuccessful = result.wasSuccessful();
		if (wasSuccessful) {
			System.out.println("All Test Classes Executed Successfully");
		} else {
			System.out.println("Not All Test Classes Executed Successfully");
		}
	}
}
