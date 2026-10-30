package app;

import runner.TestRunner;
import tests.SampleTests;

public class Main {

    public static void main(String[] args) {

        SampleTests tests = new SampleTests();

        TestRunner runner = new TestRunner();

        int total = runner.runTests(tests);

        System.out.println("\n===== TEST SUMMARY =====");
        System.out.println("Total @Run methods executed: " + total);
    }
}
