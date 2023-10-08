package domain;

import java.time.LocalDateTime;

public class Task implements Comparable<Task> {

    private LocalDateTime dueDate;

    private LocalDateTime startDate;
    private int taskId;

    private int userId;
    private String title;
    private String description;
    private TaskStatus status;

    public Task(LocalDateTime dueDate, LocalDateTime startDate, String title, String description, TaskStatus status, int userId) {
        this.dueDate = dueDate;
        this.startDate = startDate;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Task() {

    }

    public Task(LocalDateTime dueDate, int taskId, String title, String description, TaskStatus status) {
        this.dueDate = dueDate;
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.setStartDate(LocalDateTime.now());
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        LocalDateTime dueDate = getDueDate();
        LocalDateTime startDate = getStartDate();
        return "TASK ID: " + getTaskId() +
                "\n" +
                "\tTASK TITLE: " + getTitle() +
                "\n" +
                "\tTASK DESCRIPTION: " + getDescription() +
                "\n" +
                "\tTASK DUE ON: " + dueDate.getMonth() + " " + dueDate.getDayOfMonth() + ", " + dueDate.getYear() + "\n" +
                "\tTASK STARTED ON: " + startDate.getMonth() + " " + startDate.getDayOfMonth() + ", " + startDate.getYear();
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public int compareTo(Task o) {
        return this.getDueDate().compareTo(o.getDueDate());
    }

    public int getUserId() {
        return userId;
    }
}
