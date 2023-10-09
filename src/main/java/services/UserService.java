package services;

import dao.UserDaoImpl;
import domain.User;
import exceptions.NoSuchUserException;
import exceptions.PasswordLengthException;
import exceptions.UserEmailTakenException;
import screen.Homepage;
import util.UserInput;

import java.util.Collections;
import java.util.List;

public class UserService {
    UserDaoImpl userDao = new UserDaoImpl();

    public void sortUsersByEmail() {
        List<User> users = userDao.readAll();
        Collections.sort(users, new UserComparatorEmail());

        for (User u : users) {
            System.out.println(u);
        }
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
        if (!userDao.userExists(email)) {
            System.out.println("No user exists with that email");
            return;
        }
        System.out.println("Password:");
        String password = UserInput.getStringInput();

        User user = userDao.read(email);

        if (!user.getPassword().trim().equals(password.trim())) {
            System.out.println("Wrong password.\nPlease try again");
            return;
        }
        Homepage userHomepage = new Homepage(user);
        userHomepage.open();

    }

    public void showUsers() {
        List<User> users = userDao.readAll();
        if (users.isEmpty()) {
            System.out.println("There are no users in the database");
        } else {
            for (User u : users) {
                System.out.println(u);
            }
        }
    }

    public void addUser() {
        System.out.println("What is the new user's first name?");
        String firstName = UserInput.getStringInput();
        System.out.println("What is the new user's last name?");
        String lastName = UserInput.getStringInput();
        System.out.println("What is the new user's email address?");
        String email = UserInput.getStringInput().trim().toLowerCase();
//        if(userDao.userExists(email)){
//
//                throw new UserEmailTakenException();
//        }

        System.out.println("Please enter password below:\n");
        String password = UserInput.getStringInput();
        User user = new User(firstName, lastName, email, password);
        userDao.create(user);

        System.out.println("User successfully created! Information is below\n");
        user = userDao.read(user.getEmail().trim().toLowerCase());
        System.out.println(user);


    }

    public void updateUser() {
        System.out.println("Please enter the id of the user you'd like to update:");
        List<User> users = userDao.readAll();
        users.forEach(System.out::println);
        int userId = UserInput.getIntInput();
        UserInput.getStringInput();
//        User user = null;
//        if(!userDao.userExists(userId))
//            throw new NoSuchUserException();
//        else
//            user = userDao.read(userId);
        User user = userDao.read(userId);
        user.setEmail("INVALID");
        userDao.update(user);
        System.out.println("Please choose a new first name:");
        String firstName = UserInput.getStringInput();
        System.out.println("Please choose a new last name:");
        String lastName = UserInput.getStringInput();

        System.out.println("Please choose a new email:");
        String email = UserInput.getStringInput();
//        if(userDao.userExists(email)){
//            throw new UserEmailTakenException();
//        }
        System.out.println("Please choose a new password:\n");
        String password = UserInput.getStringInput();
        user = new User(userId, firstName, lastName, email, password);
        userDao.update(user);

        System.out.println("User successfully updated!\nThe new user information is below:\n");
        user = userDao.read(userId);
        System.out.println(user);
    }

    public void deleteUser() {
        System.out.println("Please choose the user you'd like to remove from\n" +
                "the database by entering their id:\n");
        List<User> users = userDao.readAll();
        for (User u : users) {
            System.out.println(u);
        }
        int userId = UserInput.getIntInput();
        UserInput.getStringInput();

//        if(!userDao.userExists(userId)){
//            throw new NoSuchUserException();
//        }else {
        userDao.delete(userId);
        System.out.println("User successfully deleted!");
//        }
    }

    public void sortUsersByLastName() {
        List<User> users = userDao.readAll();
        Collections.sort(users, new UserComparatorLastName());
        for (User u : users) {
            System.out.println(u);
        }

    }
}





