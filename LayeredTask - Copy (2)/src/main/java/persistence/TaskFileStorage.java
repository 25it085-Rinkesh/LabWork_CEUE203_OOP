package persistence;

import model.Task;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class TaskFileStorage {

    public void saveTasks(List<Task> tasks, Path file)
            throws IOException {

        Path absolutePath = file.toAbsolutePath();

        Files.createDirectories(absolutePath.getParent());

        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             Files.newOutputStream(absolutePath))) {

            out.writeObject(new ArrayList<>(tasks));
        }
    }

    public List<Task> loadTasks(Path file) throws IOException {

        try (ObjectInputStream in =
                     new ObjectInputStream(
                             Files.newInputStream(file))) {

            Object data = in.readObject();

            if (!(data instanceof List<?> savedTasks)) {
                throw new IOException("Invalid task data");
            }

            List<Task> tasks = new ArrayList<>();

            for (Object item : savedTasks) {
                if (!(item instanceof Task task)) {
                    throw new IOException("Invalid task object");
                }

                tasks.add(task);
            }

            return tasks;

        } catch (ClassNotFoundException e) {
            throw new IOException("Unable to load task objects", e);
        }
    }
}
