package domain;

import java.time.LocalDate;

public class Task implements Comparable<Task> {

    private LocalDate dueDate;

    private LocalDate startDate;
    private int taskId;
    private String title;
    private String description;
    private TaskStatus status;

    public Task() {

    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Task(LocalDate dueDate, int taskId, String title, String description, TaskStatus status) {
        this.dueDate = dueDate;
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.setStartDate(LocalDate.now());
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
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
}
