package screen;

import dao.TaskDaoImpl;
import dao.UserDaoImpl;
import domain.Task;
import domain.User;
import services.TaskService;
import services.UserService;
import util.UserInput;

import java.util.List;

public class Homepage {
    static User user = new User();
    private static TaskService taskService = new TaskService();
    private static TaskDaoImpl taskDao = new TaskDaoImpl();
    private static UserService userService = new UserService();
    private UserDaoImpl userDao = new UserDaoImpl();

    public Homepage(User user) {
        this.user = user;
    }

    public static void open() {
        System.out.println("Welcome, " + user.getFirstName());
        if(user.getEmail().equalsIgnoreCase("admin@email.com")){
            provideOptionsAdmin();
        }else {
            provideOptions();
        }
    }

    private static void provideOptionsAdmin() {

        while (true) {
            System.out.println("Please choose from the following options:");
            System.out.println("""
                    (1) See all users
                    (2) Add user
                    (3) Update user
                    (4) Delete user 
                    (5) Sort users by email
                    (6) Sort users by last name 
                    (7) Log out
                    (x) Exit
                                    
                    """);
            int input = UserInput.getIntInput();
            UserInput.getStringInput();
            switch (input) {
                case 1:
                    userService.showUsers();

                    break;
                case 2:
                    userService.addUser();
                    break;
                case 3:
                    userService.updateUser();
                    break;
                case 4:
                    userService.deleteUser();
                    break;
                case 5:
                    userService.sortUsersByEmail();
                    break;
                case 6:
                    userService.sortUsersByLastName();
                    break;
                case 7:
                    System.out.println("Logging out...");
                    return;


                case 'x':
                    System.out.println("Thank you for using the BLIT ToDoList App!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input.\nTry again!");

            }

        }

    }

    private static void provideOptions() {
        while (true) {
            System.out.println("Please choose from the following options:");
            System.out.println("""
                    (1) See tasks
                    (2) Add task
                    (3) Update status of task
                    (4) Complete task
                    (5) Delete task
                    (6) Update task 
                    (7) Sort tasks by due date
                    (8) Sort tasks by start date
                    (9) Show completed tasks
                    (10) Show in-progress tasks
                    (11) Show unstarted tasks
                    (12) Log out
                    (x) Exit
                                    
                    """);
            int input = UserInput.getIntInput();
            UserInput.getStringInput();
            switch (input) {
                case 1:
                    taskService.showTasks(user.getUserId());

                    break;
                case 2:
                    taskService.addTask(user.getUserId());
                    break;
                case 3:
                    taskService.updateStatus(user.getUserId());
                    break;
                case 4:
                    taskService.completeTask(user.getUserId());
                    break;
                case 5:
                    taskService.deleteTask(user.getUserId());
                    break;
                case 6:
                    taskService.updateTask(user.getUserId());
                    break;
                case 7:
                    List<Task> tasksSortedByDueDate = taskService.sortTasksByDueDate(user.getUserId());
                    taskService.printTasks(tasksSortedByDueDate);
                    break;
                case 8:
                    List<Task> tasksSortedByStartDate = taskService.sortTasksByStartDate(user.getUserId());
                    break;
                case 9:
                    taskService.showCompletedTasks(user.getUserId());
                    break;
                case 10:
                    taskService.showInProgressTasks(user.getUserId());
                    break;
                case 11:
                    taskService.showUnstartedTasks(user.getUserId());
                    break;
                case 12:
                    System.out.println("Logging out...");

                    return;
                case 'x':
                    System.out.println("Thank you for using the BLIT ToDoList App!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input.\nTry again!");

            }

        }
    }
}
