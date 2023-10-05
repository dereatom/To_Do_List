package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/task_db"; // replace with your database URL
    private static final String USER = "root"; // replace with your MySQL username
    private static final String PASSWORD = "donato2023"; // replace with your MySQL password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}