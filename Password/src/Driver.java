import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter no. of Passwords:");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] pas = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Password " + (i + 1) + ":");
            pas[i] = scanner.nextLine();
        }

        System.out.println("\n--- Password Strength Results ---");

        for (String pw : pas) {
            System.out.println("Password: " + pw);

            System.out.println("Length >= 8: "
                    + PasswordChecker.checkLength(pw));

            System.out.println("Contains uppercase: "
                    + PasswordChecker.checkUppercase(pw));

            System.out.println("Contains digit: "
                    + PasswordChecker.checkDigit(pw));

            System.out.println("Contains special char: "
                    + PasswordChecker.checkSpecial(pw));

            System.out.println("Strength: "
                    + PasswordChecker.strength(pw));

            System.out.println("---------------------------");
        }

        scanner.close();
    }
}