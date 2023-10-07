package screen;

import exceptions.NoSuchUserException;
import exceptions.UserEmailTakenException;
import util.UserInput;
import services.UserService;
public class HomeScreen {
    static UserService userService;
    public static void open() throws NoSuchUserException, UserEmailTakenException {
        userService = new UserService();
        sayHello();

        provideOptions();

        receiveInput();
    }

    private static void receiveInput() throws NoSuchUserException, UserEmailTakenException {

        infinite: while(true) {
            int input = UserInput.getIntInput();
            UserInput.getStringInput();
            switch (input) {
                case 1:
                    userService.signUp();
                    break infinite;
                case 2:
                    userService.logIn();

                    break infinite;
                case 3:

                    System.out.println("Thank you for using the BLIT ToDoList App!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Please try again");
            }
        }
    }



    private static void provideOptions() {
        System.out.println("What would you like to do today?\n"+
                """
                        (1) Sign up
                        (2) Log in
                        (3) Exit
                        """);


    }

    private static void sayHello() {
        System.out.println("Welcome to BinaryToDoList!");
    }
}
