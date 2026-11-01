import java.util.regex.*;

public class TemplateFiller {

    public static String fill(String template, String[] names,
                              String[] values) {

        Pattern p = Pattern.compile("\\{(\\w+)\\}");
        Matcher m = p.matcher(template);

        StringBuilder sb = new StringBuilder();
        int lastEnd = 0;

        while (m.find()) {

            sb.append(template, lastEnd, m.start());

            String key = m.group(1);
            String replacement = "[?]";

            for (int i = 0; i < names.length; i++) {

                if (names[i].equals(key)) {
                    replacement = values[i];
                    break;
                }
            }

            sb.append(replacement);
            lastEnd = m.end();
        }

        sb.append(template.substring(lastEnd));

        return sb.toString();
    }
}