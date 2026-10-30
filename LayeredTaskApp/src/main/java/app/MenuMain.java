package app;

import model.Task;
import service.TaskService;
import java.util.Scanner;

public class MenuMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskService service = new TaskService();

        while (true) {

            System.out.println("\n===== TASK MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Count Tasks");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {

                    case 1:
                        System.out.print("Enter task title: ");
                        String title = sc.nextLine();

                        service.executeAction("ADD", new Task(title));
                        System.out.println("Task added successfully!");
                        break;

                    case 2:
                        System.out.print("Enter task title to remove: ");
                        String removeTitle = sc.nextLine();

                        service.executeAction("REMOVE", new Task(removeTitle));
                        System.out.println("Task removed successfully!");
                        break;

                    case 3:
                        System.out.println("\nTask List:");

                        if (service.getCount() == 0) {
                            System.out.println("No tasks available.");
                        } else {
                            for (Task task : service.getAllTasks()) {
                                System.out.println("- " + task.getTitle());
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Total Tasks: " + service.getCount());
                        break;

                    case 0:
                        System.out.println("Exiting application...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid menu choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
