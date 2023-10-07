package screen;

import dao.TaskDaoImpl;
import dao.UserDaoImpl;
import domain.Task;
import domain.User;
import services.TaskService;
import util.UserInput;

import java.util.List;

public class Homepage {
    private UserDaoImpl userDao = new UserDaoImpl();

    private static TaskService taskService = new TaskService();
    private static TaskDaoImpl taskDao = new TaskDaoImpl();
    static User user = new User();
    public Homepage(User user){
        this.user = user;
    }
    public static void open(){
        System.out.println("Welcome, " + user.getFirstName());
        provideOptions();
    }

    private static void provideOptions() {

        System.out.println("Please choose from the following options:");
        System.out.println("""
                (1) See tasks
                (2) Add task
                (3) Update status of task
                (4) Complete task
                (5) Delete task
                (x) Exit
                
                """);
        int input = UserInput.getIntInput();
        UserInput.getStringInput();
        switch(input) {
            case 1:
                taskService.showTasks(user.getUserId());

                break;
            case 2:
                taskService.addTask(user.getUserId());
                break;
            case 3:
                taskService.updateTask(user.getUserId());
                break;
            case 4:
                break;
            case 5:
                break;
            case 'x':
                System.out.println("Thank you for using the BLIT ToDoList App!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input.\nTry again!");

        }

    }
}
