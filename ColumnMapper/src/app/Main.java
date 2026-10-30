package app;

import model.Student;
import mapper.RowMapper;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // CSV header row
        String[] headers = {
                "student_name",
                "age",
                "email"
        };

        // CSV data row
        String[] data = {
                "Rinkesh",
                "20",
                "rinkesh@gmail.com"
        };

        Student student = new Student();

        RowMapper mapper = new RowMapper();

        List<String> warnings =
                mapper.populate(student, headers, data);

        System.out.println("===== STUDENT DETAILS =====");

        System.out.println(student);

        System.out.println("\n===== MAPPING WARNINGS =====");

        if (warnings.isEmpty()) {
            System.out.println("All columns mapped successfully!");
        } else {
            for (String warning : warnings) {
                System.out.println(warning);
            }
        }
    }
}
