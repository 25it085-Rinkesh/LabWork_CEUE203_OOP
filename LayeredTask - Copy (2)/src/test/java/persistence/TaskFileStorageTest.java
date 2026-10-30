package persistence;

import model.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskFileStorageTest {

    @TempDir
    Path tempDir;

    @Test
    void testSaveAndReloadTasks() throws IOException {

        List<Task> originalTasks = List.of(
                new Task("Study Java"),
                new Task("Practice JUnit"),
                new Task("Complete MiniBank")
        );

        Path file = tempDir.resolve("tasks.dat");

        TaskFileStorage storage = new TaskFileStorage();

        storage.saveTasks(originalTasks, file);

        List<Task> loadedTasks = storage.loadTasks(file);

        assertEquals(originalTasks.size(), loadedTasks.size());

        assertEquals(
                originalTasks.stream().map(Task::getTitle).toList(),
                loadedTasks.stream().map(Task::getTitle).toList()
        );

        assertTrue(java.nio.file.Files.exists(file));
    }
}
