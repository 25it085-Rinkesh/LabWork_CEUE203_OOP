public class BoundedStatsDemo {

    public static <N extends Number> double average(N[] values) {

        if (values == null || values.length == 0) {
            throw new IllegalArgumentException(
                    "Array cannot be null or empty"
            );
        }

        double sum = 0;

        for (N value : values) {
            sum += value.doubleValue();
        }

        return sum / values.length;
    }

    public static void main(String[] args) {

        Integer[] intValues = {10, 20, 30, 40, 50};

        Double[] doubleValues = {10.5, 20.5, 30.5};

        Long[] longValues = {100L, 200L, 300L};

        System.out.println("Integer Average: "
                + average(intValues));

        System.out.println("Double Average: "
                + average(doubleValues));

        System.out.println("Long Average: "
                + average(longValues));

    }
}
