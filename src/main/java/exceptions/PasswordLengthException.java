package exceptions;

public class PasswordLengthException extends RuntimeException {

    public PasswordLengthException(){
        super("You have entered a password with an invalid length");
    }
}
