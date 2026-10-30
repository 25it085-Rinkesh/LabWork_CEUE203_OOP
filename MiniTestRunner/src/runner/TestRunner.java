package runner;

import annotation.Run;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;

public class TestRunner {

    public int runTests(Object testObject) {

        if (testObject == null) {
            throw new IllegalArgumentException(
                    "Test object cannot be null"
            );
        }

        int count = 0;

        // Get all methods of the class
        Method[] methods = testObject.getClass().getDeclaredMethods();

        // Sort methods by name for consistent output
        Arrays.sort(methods, Comparator.comparing(Method::getName));

        System.out.println("Starting Test Runner...\n");

        for (Method method : methods) {

            // Check whether method has @Run annotation
            if (method.isAnnotationPresent(Run.class)) {

                // Only execute no-argument methods
                if (method.getParameterCount() != 0) {
                    System.out.println(
                            "Skipping " + method.getName() +
                                    ": Method must have no arguments."
                    );
                    continue;
                }

                try {
                    method.setAccessible(true);

                    System.out.println(
                            "Running: " + method.getName()
                    );

                    // Invoke the annotated method
                    method.invoke(testObject);

                    count++;

                } catch (IllegalAccessException |
                         InvocationTargetException e) {

                    count++;

                    Throwable cause = e instanceof InvocationTargetException
                            ? e.getCause() : e;

                    System.out.println(
                            "Test execution error: " + cause.getMessage()
                    );
                }

                System.out.println();
            }
        }

        System.out.println("Total methods executed: " + count);

        return count;
    }
}
