package service;

import model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    private TaskService service;

    @BeforeEach
    void setUp() {
        service = new TaskService();
    }

    // Test 1: Adding a task increases count
    @Test
    void testAddTaskIncreasesCount() {

        assertEquals(0, service.getCount());

        service.addTask(new Task("Study Java"));

        assertEquals(1, service.getCount());
    }

    // Test 2: Removing a task decreases count
    @Test
    void testRemoveTaskDecreasesCount() {

        service.addTask(new Task("Learn JUnit"));

        service.removeTask("Learn JUnit");

        assertEquals(0, service.getCount());
    }

    // Test 3: Invalid action throws exception
    @Test
    void testInvalidActionThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> service.executeAction("UPDATE", new Task("Study Java"))
        );
    }
}
