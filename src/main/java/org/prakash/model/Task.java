package org.prakash.model;

import java.sql.Timestamp;

public class Task {

    private int id;
    private String title;
    private String description;
    private String status;
    private Timestamp createdAt;

    // 1️⃣ Constructor for INSERT (Menu → DAO)
    public Task(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    // 2️⃣ Constructor for READ (DAO → Menu)
    public Task(String title, String description, String status, Timestamp createdAt) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
    }

    // 3️⃣ Empty constructor (optional but safe)
    public Task() {}

    // GETTERS & SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}
