package services;

import dao.UserDaoImpl;
import domain.User;
import exceptions.NoSuchUserException;
import exceptions.PasswordLengthException;
import exceptions.UserEmailTakenException;
import screen.Homepage;
import util.UserInput;

import java.util.List;

public class UserService {
    UserDaoImpl userDao = new UserDaoImpl();

    List<User> sortUsersByEmail(List<User> users) {

        return null;
    }

    public void signUp() throws UserEmailTakenException, NoSuchUserException {
        System.out.println("What is your first name?");
        String firstName = UserInput.getStringInput();
        System.out.println("What is your last name?");
        String lastName = UserInput.getStringInput();
        System.out.println("What is your email address?");
        String email = UserInput.getStringInput();
//        while(true) {
//            if (userDao.userExists(email)) {
//                throw new UserEmailTakenException();
//            }else {
//                break;
//            }
//        }
        System.out.println("Please choose a password no longer than 16 characters");
        String password = UserInput.getStringInput();

        if (password.length() < 1 || password.length() > 16) {
            throw new PasswordLengthException();
        }
        User user = new User(firstName, lastName, email, password);
        userDao.create(user);
    }

    public void logIn() {
        System.out.println("Username/email:");
        String email = UserInput.getStringInput();
        if(!userDao.userExists(email)){
            System.out.println("No user exists with that email");
            return;
        }
        System.out.println("Password:");
        String password = UserInput.getStringInput();

        User user = userDao.read(email);

        if(!user.getPassword().trim().equals(password.trim())){
            System.out.println("Wrong password.\nPlease try again");
            return;
        }
        Homepage userHomepage = new Homepage(user);
        userHomepage.open();

    }
}
