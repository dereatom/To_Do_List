package exceptions;

public class NoSuchUserException extends RuntimeException {

    public NoSuchUserException(String input) {
        super("There is no user with the " + input + " provided");
    }

    public NoSuchUserException() {
        super("There is no user with the information provided");
    }
}
