package model;

import java.io.Serializable;

public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    public Task(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Task title cannot be empty");
        }

        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
