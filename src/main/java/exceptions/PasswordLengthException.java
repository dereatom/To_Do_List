package exceptions;

public class PasswordLengthException extends Exception {

    public PasswordLengthException() {
        super("You have entered a password with an invalid length");
    }
}
