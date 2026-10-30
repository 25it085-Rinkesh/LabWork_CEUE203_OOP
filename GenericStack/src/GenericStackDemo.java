import java.util.Arrays;
import java.util.NoSuchElementException;

class GenericStack<T> {

    private Object[] elements;
    private int size;

    public GenericStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }

        elements = new Object[capacity];
        size = 0;
    }

    public void push(T value) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }

        elements[size++] = value;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        @SuppressWarnings("unchecked")
        T value = (T) elements[--size];

        elements[size] = null;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        @SuppressWarnings("unchecked")
        T value = (T) elements[size - 1];

        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

public class GenericStackDemo {

    public static void main(String[] args) {

        GenericStack<Integer> intStack = new GenericStack<>(2);

        intStack.push(10);
        intStack.push(20);
        intStack.push(30);

        System.out.println("Integer Stack:");
        System.out.println("Top Element: " + intStack.peek());
        System.out.println("Popped: " + intStack.pop());
        System.out.println("Popped: " + intStack.pop());
        System.out.println("Stack Size: " + intStack.size());

        GenericStack<String> strStack = new GenericStack<>(2);

        strStack.push("Java");
        strStack.push("Python");
        strStack.push("C++");

        System.out.println("\nString Stack:");
        System.out.println("Top Element: " + strStack.peek());
        System.out.println("Popped: " + strStack.pop());
        System.out.println("Popped: " + strStack.pop());

        System.out.println("\nEmpty Stack Handling:");

        try {
            strStack.pop();
            strStack.pop();
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Is String Stack Empty: " + strStack.isEmpty());
    }
}
