import java.util.*;

public class Leaderboard {
    public static void main(String[] args) {

        Map<String, Integer> scores = new HashMap<>();

        scores.put("Ravi", 85);
        scores.put("Amit", 95);
        scores.put("Neha", 90);
        scores.put("Priya", 95);
        scores.put("Karan", 80);

        int N = 3;

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(scores.entrySet());

        list.sort((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());
            return result != 0 ? result :
                    a.getKey().compareTo(b.getKey());
        });

        System.out.println("Top " + N + " Players:");

        for (int i = 0; i < Math.min(N, list.size()); i++) {
            System.out.println(
                    list.get(i).getKey() + " : "
                            + list.get(i).getValue());
        }
    }
}