import java.util.Locale;

public class ChatFilter {

    public static String filter(String[] logs, String keyword) {

        StringBuilder report = new StringBuilder();
        int count = 0;

        for (String line : logs) {

            String[] parts = line.split(" ", 3);

            if (parts.length < 3) {
                continue;
            }

            String time = parts[0];
            String user = parts[1];
            String message = parts[2];

            if (message.toLowerCase(Locale.ROOT)
                    .contains(keyword.toLowerCase(Locale.ROOT))) {

                count++;

                report.append(time)
                        .append(" ")
                        .append(user)
                        .append(": ")
                        .append(message)
                        .append("\n");
            }
        }

        return "Matches: " + count + "\n" + report.toString();
    }
}