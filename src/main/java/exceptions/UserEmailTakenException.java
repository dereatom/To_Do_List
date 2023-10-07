package exceptions;

public class UserEmailTakenException extends RuntimeException {
    public UserEmailTakenException() {
        super("User with that email address is already in the database");

    }
}
