package exceptions;

public class UserEmailTakenException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserEmailTakenException() {
        super("User with that email address is already in the database");

    }
}
