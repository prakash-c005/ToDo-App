package org.prakash;

import org.prakash.menu.TaskMenu;

import java.util.Scanner;

public class Main {

    public static void main(String[] unused) throws Exception {

        TaskMenu menu = new TaskMenu();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== TO-DO APP ====");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. View Pending Tasks");
            System.out.println("4. View Completed Tasks");
            System.out.println("5. Mark Task as Completed");
            System.out.println("6. Delete Task");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter numbers only.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Title: ");
                    String title = sc.nextLine().trim();
                    if (title.isEmpty()) {
                        System.out.println("Title cannot be empty.");
                        break;
                    }
                    System.out.print("Description: ");
                    String desc = sc.nextLine().trim();
                    menu.addTask(title, desc);
                }

                case 2 -> menu.viewAllTasks();
                case 3 -> menu.viewPendingTasks();
                case 4 -> menu.viewCompletedTasks();

                case 5 -> menu.markCompleted(sc);
                case 6 -> menu.deleteTask(sc);

                case 0 -> {
                    System.out.println("Goodbye.");
                    sc.close();
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }

}
