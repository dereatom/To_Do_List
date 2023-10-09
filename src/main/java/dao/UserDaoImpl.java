package dao;

import connection.JDBConnection;
import domain.User;
import exceptions.NoSuchUserException;
import exceptions.UserEmailTakenException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements Dao<User> {
	@Override
	public void create(User user) {
		if (userExists(user.getEmail())) {
			System.out.println("User email is already taken!\nPlease try again with another one");
		}

		final String CREATE_USER = "INSERT INTO users(user_first_name, user_last_name, user_email,user_password)"
				+ "VALUES (?,?,?,?)";

		try (Connection conn = JDBConnection.getConnection()) {

			PreparedStatement preparedStatement = conn.prepareStatement(CREATE_USER);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());

			preparedStatement.execute();

		} catch (SQLException e) {
			System.out.println(
					"There was a problem in your create method in UserDao when trying to create a connection to db: \n"
							+ e.getMessage());
		}
	}

	@Override
	public User read(int userId) throws NoSuchUserException {
		final String READ_USER = "SELECT * FROM users WHERE user_id = ?";

		try (Connection conn = JDBConnection.getConnection()) {
			PreparedStatement preparedStatement = conn.prepareStatement(READ_USER);
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserId(userId);
				user.setFirstName(rs.getString("user_first_name"));
				user.setLastName(rs.getString("user_last_name"));
				user.setEmail(rs.getString("user_email"));
				user.setPassword(rs.getString("user_password"));
				return user;
			}
			throw new NoSuchUserException();
		} catch (SQLException e) {
			System.out.println(
					"There was a problem in the read(int) method of your UserDaoImpl class when trying to create a connection to the database:\n"
							+ e.getMessage());
			return null;

		}

	}

	public User read(String email) throws NoSuchUserException {
		email = email.trim().toLowerCase();
		final String READ_USER_BY_EMAIL = "SELECT * FROM users WHERE user_email = ?";

		try (Connection conn = JDBConnection.getConnection()) {
			PreparedStatement preparedStatement = conn.prepareStatement(READ_USER_BY_EMAIL);
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("user_first_name"));
				user.setLastName(rs.getString("user_last_name"));
				user.setEmail(rs.getString("user_email"));
				user.setPassword(rs.getString("user_password"));
				return user;
			}
            throw new NoSuchUserException("email");
		} catch (SQLException e) {
			System.out.println(
					"There was a problem in your read(String) method of the UserDaoImpl class when trying to make a connection to the database:\n"
							+ e.getMessage());
			return null;
		}
	
	}

	@Override
	public List<User> readAll() {
		final String GET_ALL_USERS = "SELECT * FROM users";
		List<User> users = new ArrayList<>();
		try (Connection conn = JDBConnection.getConnection()) {
			PreparedStatement preparedStatement = conn.prepareStatement(GET_ALL_USERS);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("user_first_name"));
				user.setLastName(rs.getString("user_last_name"));
				user.setEmail(rs.getString("user_email").toLowerCase());
				user.setPassword(rs.getString("user_password"));
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println(
					"There was a problem in the readAll() method of your UserDaoImpl class when trying to connect to the database:\n"
							+ e.getMessage());

		}
		if (users.isEmpty()) {
			System.out.println("There are no users in the database");
			return null;
		} else {
			return users;
		}
	}

	@Override
	public void update(User user) throws NoSuchUserException {
        if (!userExists(user.getUserId())) {
            throw new NoSuchUserException("id");
        }

		final String UPDATE_USER = "UPDATE users SET user_first_name=?, user_last_name = ?,  user_email=?,user_password = ? WHERE user_id=?";
		try (Connection conn = JDBConnection.getConnection()) {
			PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_USER);
			preparedStatement.setString(1, user.getFirstName());

			preparedStatement.setString(2, user.getLastName());

			preparedStatement.setString(3, user.getEmail().toLowerCase());
			preparedStatement.setString(4, user.getPassword());

			preparedStatement.setInt(5, user.getUserId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(
					"There was a problem in the update(User) method of the UserDaoImpl class when creating a connection to the database:\n"
							+ e.getMessage());

		}
	}

	public boolean userExists(String email) {

		try {
			this.read(email);
			return true;
		} catch (NoSuchUserException e) {
			return false;
		}
	}

	public boolean userExists(int userId) {
		try {
			this.read(userId);
			return true;
		} catch (NoSuchUserException e) {
			return false;
		}
	}

	@Override
	public void delete(int id) {
		final String DELETE_USER = "DELETE FROM users WHERE user_id = ?";
		try (Connection conn = JDBConnection.getConnection()) {
			PreparedStatement preparedStatement = conn.prepareStatement(DELETE_USER);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(
					"There was a problem trying to delete a user from database when attempting to make a connection to the database:\n"
							+ e.getMessage());

		}
	}
}
