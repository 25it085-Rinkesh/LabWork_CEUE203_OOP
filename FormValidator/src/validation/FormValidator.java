package validation;

import annotation.NotBlank;
import annotation.MaxLength;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class FormValidator {

    public List<String> validate(Object object) {

        if (object == null) {
            throw new IllegalArgumentException("Object cannot be null");
        }

        List<String> errors = new ArrayList<>();

        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {

            // Ignore static fields
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }

            NotBlank notBlank = field.getAnnotation(NotBlank.class);
            MaxLength maxLength = field.getAnnotation(MaxLength.class);

            // Skip fields without annotations
            if (notBlank == null && maxLength == null) {
                continue;
            }

            try {

                // Access private fields
                field.setAccessible(true);

                Object rawValue = field.get(object);

                if (rawValue != null && !(rawValue instanceof String)) {
                    errors.add(field.getName() + " must be a String");
                    continue;
                }

                String value = (String) rawValue;

                // Check NotBlank annotation
                if (notBlank != null &&
                        (value == null || value.trim().isEmpty())) {

                    errors.add(
                            field.getName() + " must not be blank"
                    );
                }

                // Check MaxLength annotation
                if (maxLength != null) {

                    int maximum = maxLength.value();

                    if (maximum < 0) {
                        throw new IllegalArgumentException(
                                "Maximum length cannot be negative"
                        );
                    }

                    if (value != null && value.length() > maximum) {

                        errors.add(
                                field.getName() +
                                        " must be at most " +
                                        maximum + " characters"
                        );
                    }
                }

            } catch (IllegalAccessException e) {

                errors.add(
                        "Cannot access field: " + field.getName()
                );
            }
        }

        return errors;
    }
}
