package org.prakash.model;

import java.sql.Timestamp;

public class Task {

    private int id;
    private String title;
    private String description;
    private String status;
    private Timestamp createdAt;

    // Constructor for INSERT (Menu to DAO)
    public Task(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    // Constructor for READ (DAO to Menu)
    public Task(String title, String description, String status, Timestamp createdAt) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
    }

    // Empty constructor (optional but safe)
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
