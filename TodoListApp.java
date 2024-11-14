package ToDoListApplication;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {
    private static ArrayList<String> todoList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to the To-Do List Application!");

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. View To-Do List");
            System.out.println("2. Add Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    viewTodoList();
                    break;
                case 2:
                    addTask(scanner);
                    break;
                case 3:
                    removeTask(scanner);
                    break;
                case 4:
                    System.out.println("Exiting To-Do List Application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void viewTodoList() {
        System.out.println("\nTo-Do List:");
        if (todoList.isEmpty()) {
            System.out.println("Your to-do list is empty.");
        } else {
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.print("\nEnter the task to add: ");
        String task = scanner.nextLine();
        todoList.add(task);
        System.out.println("Task added successfully.");
    }

    private static void removeTask(Scanner scanner) {
        viewTodoList();
        if (!todoList.isEmpty()) {
            System.out.print("\nEnter the number of the task to remove: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (taskNumber > 0 && taskNumber <= todoList.size()) {
                todoList.remove(taskNumber - 1);
                System.out.println("Task removed successfully.");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
}