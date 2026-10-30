package service;

import model.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }

        tasks.add(task);
    }

    public boolean removeTask(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid task title");
        }

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTitle().equalsIgnoreCase(title.trim())) {
                tasks.remove(i);
                return true;
            }
        }

        return false;
    }

    public void executeAction(String action, Task task) {

        if (action == null) {
            throw new IllegalArgumentException("Action cannot be null");
        }

        switch (action.trim().toUpperCase()) {

            case "ADD":
                addTask(task);
                break;

            case "REMOVE":
                if (task == null || !removeTask(task.getTitle())) {
                    throw new IllegalArgumentException("Task not found");
                }
                break;

            default:
                throw new IllegalArgumentException("Invalid action: " + action);
        }
    }

    public int getCount() {
        return tasks.size();
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }
}
