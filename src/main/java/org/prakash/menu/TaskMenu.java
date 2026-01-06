package org.prakash.menu;

import org.prakash.dao.TaskDAO;
import org.prakash.model.Task;

import java.util.List;

public class TaskMenu {

    private final TaskDAO dao = new TaskDAO();

    // ADD
    public void addTask(String title, String desc) throws Exception {
        dao.addTask(new Task(title, desc, "PENDING"));
        System.out.println("✔ Task added");
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

    // MARK COMPLETED
    public void markCompleted(int id) throws Exception {
        if (dao.markTaskCompleted(id)) {
            System.out.println("✔ Task marked as completed");
        } else {
            System.out.println("⚠ Task ID not found");
        }
    }

    // DELETE
    public void deleteTask(int id) throws Exception {
        if (dao.deleteTask(id)) {
            System.out.println("✔ Task deleted");
        } else {
            System.out.println("⚠ Task ID not found");
        }
    }

    // COMMON PRINTER
    private void printTasks(List<Task> list, String label) {
        System.out.println("\n" + label);
        if (list.isEmpty()) {
            System.out.println("⚠ No " + label + " tasks.");
            return;
        }

        for (Task t : list) {
            System.out.println(
                    "[" + t.getId() + "] " +
                            t.getTitle() + " | " +
                            t.getDescription() + " | " +
                            t.getCreatedAt()
            );
        }
    }
}
