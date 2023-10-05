package exceptions;

public class NoSuchUserException extends Exception {

    public NoSuchUserException(String input) {
        super("There is no user with the " + input + " provided");
    }
}
