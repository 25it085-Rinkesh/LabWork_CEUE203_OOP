import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of log lines: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] logs = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter log line " + (i + 1) + ": ");
            logs[i] = scanner.nextLine();
        }

        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine();

        String result = ChatFilter.filter(logs, keyword);

        System.out.println(result);

        scanner.close();
    }
}