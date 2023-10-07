package services;

import dao.TaskDaoImpl;
import domain.Task;
import domain.TaskStatus;
import util.UserInput;

import java.time.LocalDate;
import java.util.List;

public class TaskService {
    TaskDaoImpl taskDao = new TaskDaoImpl();

    public void showTasks(int userId) {
        List<Task> tasks = taskDao.readAll(userId);
        for(int i = 0;i<tasks.size();i++){
            System.out.println(i+1 +") " + tasks.get(i));
        }
    }

    public void addTask(int userId) {
        System.out.println("Please provide the title for your new task:");
        String title = UserInput.getStringInput();
        System.out.println("Please provide a description for your task:");
        String description = UserInput.getStringInput();
        Task task = new Task(LocalDate.now(),LocalDate.now(),title, description, TaskStatus.NOT_STARTED,userId);
        System.out.println("You have successfully created a task!");
        taskDao.create(task);
        showTasks(userId);
    }

    public void updateTask(int userId) {
        List<Task> myTasks = taskDao.readAll(userId);
        System.out.println("Select the task id of the task you want to update:");
        for(Task t : myTasks){
            System.out.println(t);
        }

        int taskId = UserInput.getIntInput();
        UserInput.getStringInput();
        Task task = taskDao.read(taskId);
        System.out.println("Choose a new title:");
        String newTitle = UserInput.getStringInput();
        System.out.println("Add a new description:");
        String newDescription = UserInput.getStringInput();
        System.out.println("What will the new status of your task be?\n" +
                "(1) NOT STARTED" +
                "(2) IN PROGRESS" +
                "(3) COMPLETED");
        int userInput = UserInput.getIntInput();
        TaskStatus newStatus;
        switch(userInput){
            case 1:
                newStatus = TaskStatus.NOT_STARTED;
                break;
            case 2:
                newStatus = TaskStatus.IN_PROGRESS;
                break;
            case 3:
                newStatus = TaskStatus.FINISHED;
                break;
            default:
                newStatus = task.getStatus();
                break;
        }
        task.setTitle(newTitle);
        task.setDescription(newDescription);
        task.setStatus(newStatus);

        taskDao.update(task);
        System.out.println("Task was successfully updated!");

    }
}
