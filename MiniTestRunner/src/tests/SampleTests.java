package tests;

import annotation.Run;

public class SampleTests {

    @Run
    public void testAddition() {
        int result = 10 + 20;

        System.out.println("Addition Test: " +
                (result == 30 ? "PASSED" : "FAILED"));
    }

    @Run
    public void testSubtraction() {
        int result = 50 - 20;

        System.out.println("Subtraction Test: " +
                (result == 30 ? "PASSED" : "FAILED"));
    }

    public void normalMethod() {
        System.out.println("This method should not execute.");
    }

    @Run
    public void testString() {
        String name = "Java";

        System.out.println("String Test: " +
                (name.equals("Java") ? "PASSED" : "FAILED"));
    }

    public void anotherNormalMethod() {
        System.out.println("This method is not a test.");
    }
}
