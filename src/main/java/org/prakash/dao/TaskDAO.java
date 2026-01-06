package org.prakash.dao;

import org.prakash.model.Task;
import org.prakash.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    // INSERT → always PENDING
    public void addTask(Task task) throws Exception {
        String sql = "INSERT INTO tasks (title, description, status) VALUES (?, ?, ?)";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, task.getTitle());
            ps.setString(2, task.getDescription());
            ps.setString(3, "PENDING");

            ps.executeUpdate();
        }
    }

    // GET ALL
    public List<Task> getAllTasks() throws Exception {
        String sql = "SELECT * FROM tasks";
        List<Task> list = new ArrayList<>();

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(mapRowToTask(rs));
            }
        }
        return list;
    }

    // FILTER BY STATUS
    public List<Task> getTasksByStatus(String status) throws Exception {
        String sql = "SELECT * FROM tasks WHERE status = ?";
        List<Task> list = new ArrayList<>();

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRowToTask(rs));
                }
            }
        }
        return list;
    }

    // UPDATE → COMPLETED (returns false if ID not found)
    public boolean markTaskCompleted(int id) throws Exception {
        String sql = "UPDATE tasks SET status = 'COMPLETED' WHERE id = ?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    // DELETE (returns false if ID not found)
    public boolean deleteTask(int id) throws Exception {
        String sql = "DELETE FROM tasks WHERE id = ?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    // COMMON RESULTSET → TASK MAPPER
    private Task mapRowToTask(ResultSet rs) throws SQLException {
        Task t = new Task(
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("status"),
                rs.getTimestamp("created_at")
        );
        t.setId(rs.getInt("id"));
        return t;
    }
}
