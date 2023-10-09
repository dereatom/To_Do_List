package screen;

import exceptions.NoSuchUserException;
import exceptions.PasswordLengthException;
import exceptions.UserEmailTakenException;
import services.UserService;
import util.UserInput;

public class HomeScreen {
	static UserService userService;

	public static void open() throws NoSuchUserException, UserEmailTakenException {
		userService = new UserService();
		sayHello();
		while (true) {
			provideOptions();

			receiveInput();
		}
	}

	private static void receiveInput() throws NoSuchUserException, UserEmailTakenException {

		infinite: while (true) {
			try {
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
					break infinite;
				default:
					System.out.println("Invalid input. Please try again");
					break infinite;
				}

			} catch (UserEmailTakenException | NoSuchUserException | PasswordLengthException e) {
				System.out.println("There was an issue with the input you provided\nSee error message below:\n");
				System.out.println(e.getMessage());
				continue;

			}
		}
	}

	private static void provideOptions() {
		System.out.println("What would you like to do today?\n" + """
				(1) Sign up
				(2) Log in
				(3) Exit
				""");

	}

	private static void sayHello() {
		System.out.println("Welcome to BinaryToDoList!");
	}
}
