package dao;

import domain.Task;

import java.util.List;

public interface TaskDaoInterface {
    void addTask(Task task);
    Task getTaskById(int taskId);
    List<Task> getAllTask();

    void  updateTask(Task task);
    void  deleteTaskById(int taskId);

    Task getTaskFullInfo(int taskId);



}
