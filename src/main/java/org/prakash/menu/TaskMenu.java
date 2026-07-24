package org.prakash.menu;

import org.prakash.dao.TaskDAO;
import org.prakash.model.Task;

import java.util.List;
import java.util.Scanner;

public class TaskMenu {

    private final TaskDAO dao = new TaskDAO();

    // ADD
    public void addTask(String title, String desc) throws Exception {
        dao.addTask(new Task(title, desc, "PENDING"));
        System.out.println("Task added.");
    }

    // VIEW ALL
    public void viewAllTasks() throws Exception {
        printTasks(dao.getAllTasks(), "ALL");
    }

    // VIEW PENDING
    public void viewPendingTasks() throws Exception {
        printTasks(dao.getTasksByStatus("PENDING"), "PENDING");
    }

    // VIEW COMPLETED
    public void viewCompletedTasks() throws Exception {
        printTasks(dao.getTasksByStatus("COMPLETED"), "COMPLETED");
    }

    // MARK COMPLETED. The displayed serial number is mapped to the real database id.
    public void markCompleted(Scanner scanner) throws Exception {
        Task task = selectTask(scanner, dao.getAllTasks(), "mark as completed");
        if (task == null) {
            return;
        }

        if (dao.markTaskCompleted(task.getId())) {
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Task not found.");
        }
    }

    // DELETE. The displayed serial number is mapped to the real database id.
    public void deleteTask(Scanner scanner) throws Exception {
        Task task = selectTask(scanner, dao.getAllTasks(), "delete");
        if (task == null) {
            return;
        }

        if (dao.deleteTask(task.getId())) {
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }
    }

    // COMMON PRINTER
    private void printTasks(List<Task> list, String label) {
        System.out.println("\n" + label);
        if (list.isEmpty()) {
            System.out.println("No " + label + " tasks.");
            return;
        }

        int serialNumber = 1;
        for (Task t : list) {
            System.out.println(
                    serialNumber++ + ". " +
                            t.getTitle() + " | " +
                            t.getDescription() + " | " +
                            t.getCreatedAt()
            );
        }
    }

    /**
     * Displays the current list and converts the user's displayed serial
     * number to the corresponding Task. Database operations must use
     * Task#getId(), never the displayed serial number.
     */
    private Task selectTask(Scanner scanner, List<Task> tasks, String action) {
        if (tasks == null || tasks.isEmpty()) {
            System.out.println("No tasks available to " + action + ".");
            return null;
        }

        printTasks(tasks, "AVAILABLE TASKS");

        while (true) {
            System.out.print("Task number: ");
            if (!scanner.hasNextLine()) {
                System.out.println("\nNo task number entered.");
                return null;
            }

            String input = scanner.nextLine().trim();
            final int serialNumber;
            try {
                serialNumber = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid task number.");
                continue;
            }

            if (serialNumber < 1) {
                System.out.println("Task number must be at least 1.");
            } else if (serialNumber > tasks.size()) {
                System.out.println("Task number must be between 1 and " + tasks.size() + ".");
            } else {
                return tasks.get(serialNumber - 1);
            }
        }
    }
}
