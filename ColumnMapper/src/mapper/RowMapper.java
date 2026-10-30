package mapper;

import annotation.Column;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RowMapper {

    public List<String> populate(
            Object object,
            String[] headers,
            String[] data
    ) {

        if (object == null || headers == null || data == null) {
            throw new IllegalArgumentException(
                    "Object, headers and data cannot be null"
            );
        }

        if (headers.length != data.length) {
            throw new IllegalArgumentException(
                    "Header and data length must be equal"
            );
        }

        List<String> warnings = new ArrayList<>();

        // Map header names to their indexes
        Map<String, Integer> columnIndexes = new HashMap<>();

        for (int i = 0; i < headers.length; i++) {

            String header = headers[i].trim();

            if (header.isEmpty()) {
                throw new IllegalArgumentException(
                        "Header name cannot be empty"
                );
            }

            if (columnIndexes.containsKey(header)) {
                throw new IllegalArgumentException(
                        "Duplicate column: " + header
                );
            }

            columnIndexes.put(header, i);
        }

        // Get all fields of the object
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {

            Column column = field.getAnnotation(Column.class);

            // Ignore fields without @Column
            if (column == null) {
                continue;
            }

            String columnName = column.name();

            // Find matching column
            Integer index = columnIndexes.get(columnName);

            // Handle missing column
            if (index == null) {

                warnings.add(
                        "Missing column: " + columnName +
                                " for field: " + field.getName() +
                                ". Existing value left unchanged."
                );

                continue;
            }

            try {

                field.setAccessible(true);

                String value = data[index];

                Object convertedValue =
                        convertValue(value, field.getType(), field.getName());

                // Set field value using reflection
                field.set(object, convertedValue);

            } catch (IllegalAccessException e) {

                throw new IllegalStateException(
                        "Cannot access field: " + field.getName(), e
                );
            }
        }

        return warnings;
    }

    // Convert String data into the required Java type
    private Object convertValue(
            String value,
            Class<?> type,
            String fieldName
    ) {

        if (type == String.class) {
            return value;
        }

        if (value == null) {
            if (type.isPrimitive()) {
                throw new IllegalArgumentException(
                        "Null value cannot be assigned to " + fieldName
                );
            }
            return null;
        }

        try {

            String trimmed = value.trim();

            if (type == int.class || type == Integer.class) {
                return Integer.parseInt(trimmed);
            }

            if (type == double.class || type == Double.class) {
                return Double.parseDouble(trimmed);
            }

            if (type == boolean.class || type == Boolean.class) {

                if (!trimmed.equalsIgnoreCase("true") &&
                        !trimmed.equalsIgnoreCase("false")) {
                    throw new IllegalArgumentException(
                            "Invalid boolean value: " + value
                    );
                }

                return Boolean.parseBoolean(trimmed);
            }

            throw new IllegalArgumentException(
                    "Unsupported field type: " + type.getName()
            );

        } catch (NumberFormatException e) {

            throw new IllegalArgumentException(
                    "Invalid value '" + value +
                            "' for field: " + fieldName, e
            );
        }
    }
}
