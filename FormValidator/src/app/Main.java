package app;

import model.SignupForm;
import validation.FormValidator;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        FormValidator validator = new FormValidator();

        // Valid signup form
        SignupForm validForm = new SignupForm(
                "Rinkesh",
                "rinkesh@gmail.com",
                "JavaPassword123"
        );

        System.out.println("===== VALID SIGNUP FORM =====");

        List<String> validErrors = validator.validate(validForm);

        if (validErrors.isEmpty()) {
            System.out.println("Signup successful!");
        } else {
            validErrors.forEach(System.out::println);
        }

        // Invalid signup form
        SignupForm invalidForm = new SignupForm(
                "",
                "rinkesh.long.email.address.for.validation.testing@example.com",
                "   "
        );

        System.out.println("\n===== INVALID SIGNUP FORM =====");

        List<String> invalidErrors = validator.validate(invalidForm);

        if (invalidErrors.isEmpty()) {
            System.out.println("Signup successful!");
        } else {
            for (String error : invalidErrors) {
                System.out.println("Error: " + error);
            }
        }
    }
}
