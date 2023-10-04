package domain;

import java.time.LocalDate;

public class Task {

    private  int taskId;
    private  String taskTitle;
    private  String taskDescription;
    private String taskStatus;
    private LocalDate dueDate;
    private LocalDate startDate;


    public Task() {
    }

    public Task(int taskId, String taskTitle, String taskDescription, String taskStatus, LocalDate dueDate, LocalDate startDate) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
        this.dueDate = dueDate;
        this.startDate = startDate;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public LocalDate getDueDate() {
        return dueDate;
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
                ", taskTitle='" + taskTitle + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", dueDate=" + dueDate +
                ", startDate=" + startDate +
                '}';
    }
}
