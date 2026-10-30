class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

class Pair<A, B> {
    private A first;
    private B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
}

public class GenericContainersDemo {

    public static <T> T first(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        return array[0];
    }

    public static void main(String[] args) {

        // Using Box with different data types
        Box<Integer> intBox = new Box<>();
        intBox.set(100);

        Box<String> strBox = new Box<>();
        strBox.set("Hello Java");

        System.out.println("Integer Box: " + intBox.get());
        System.out.println("String Box: " + strBox.get());

        Pair<String, Integer> student = new Pair<>("Rinkesh", 85);

        Pair<Double, Boolean> result = new Pair<>(89.5, true);

        System.out.println("\nStudent Name: " + student.getFirst());
        System.out.println("Student Marks: " + student.getSecond());

        System.out.println("\nPercentage: " + result.getFirst());
        System.out.println("Passed: " + result.getSecond());

        String[] names = {"Rinkesh", "Prince", "Rahul"};
        Integer[] numbers = {10, 20, 30};
        Double[] prices = {45.5, 60.5, 75.5};

        System.out.println("\nFirst Name: " + first(names));
        System.out.println("First Number: " + first(numbers));
        System.out.println("First Price: " + first(prices));
    }
}
