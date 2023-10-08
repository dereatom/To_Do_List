package dao;

import connection.JDBConnection;
import domain.Task;
import domain.TaskStatus;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class TaskDaoImpl implements Dao<Task> {



    @Override
    public void create(Task task) {
        final String CREATE_TASK = "INSERT INTO tasks(task_title, task_description, task_status, task_start_date, task_due_date, user_id) VALUES(?,?,?,?,?,?)";

        try (Connection conn = JDBConnection.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(CREATE_TASK);
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setString(3, task.getStatus().toString());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(task.getStartDate()));
            preparedStatement.setTimestamp(5, Timestamp.valueOf(task.getDueDate()));
            preparedStatement.setInt(6, task.getUserId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("There was a problem in the create(Task) method in the TaskDaoImpl class when trying to create a connection with the database:\n" + e.getMessage());
        }
    }


    @Override
    public Task read(int taskId) {
        final String READ_TASK = "SELECT * FROM tasks WHERE task_id = ?";
        Task task = null;
        try (Connection conn = JDBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(READ_TASK);
            stmt.setInt(1, taskId);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                task = new Task();
                task.setTaskId(rs.getInt("task_id"));
                task.setTitle(rs.getString("task_title"));
                task.setDescription(rs.getString("task_description"));
                task.setStatus(TaskStatus.valueOf(rs.getString("task_status")));
                task.setStartDate(rs.getTimestamp("task_start_date").toLocalDateTime());
                task.setDueDate(rs.getTimestamp("task_due_date").toLocalDateTime());

            }
        } catch (SQLException e) {
            System.out.println("There was a problem in the read(int) method of the TaskDaoImpl class when trying to make a connection with the database:\n" + e.getMessage());

        }
        return task;
    }

    @Override
    public List<Task> readAll() {
        final String READ_ALL = "SELECT * FROM tasks";
        List<Task> tasks = new ArrayList<Task>();
        try (Connection conn = JDBConnection.getConnection()) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(READ_ALL);
            while (rs.next()) {
                Task task = new Task();
                task.setStatus(TaskStatus.valueOf(rs.getString("task_status")));
                task.setTaskId(rs.getInt("task_id"));
                task.setDescription(rs.getString("task_description"));
                task.setTitle(rs.getString("task_title"));
                task.setStartDate(rs.getTimestamp("task_start_date").toLocalDateTime());
                task.setDueDate(rs.getTimestamp("task_due_date").toLocalDateTime());

                tasks.add(task);
            }


        } catch (SQLException e) {
            System.out.println("There was a problem in the readAll() method of the TaskDaoImpl class when trying to make a connection with the database:\n" + e.getMessage());
        }
        return tasks;
    }


    public List<Task> readAll(int userId) {
        final String READ_ALL = "SELECT * FROM tasks WHERE user_id = " + userId;
        List<Task> tasks = new ArrayList<Task>();
        try (Connection conn = JDBConnection.getConnection()) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(READ_ALL);
            while (rs.next()) {
                Task task = new Task();
                task.setStatus(TaskStatus.valueOf(rs.getString("task_status")));
                task.setTaskId(rs.getInt("task_id"));
                task.setDescription(rs.getString("task_description"));
                task.setTitle(rs.getString("task_title"));
                task.setStartDate(rs.getTimestamp("task_start_date").toLocalDateTime());
                task.setDueDate(rs.getTimestamp("task_due_date").toLocalDateTime());

                tasks.add(task);
            }


        } catch (SQLException e) {
            System.out.println("There was a problem in the readAll() method of the TaskDaoImpl class when trying to make a connection with the database:\n" + e.getMessage());
        }
        return tasks;
    }

    @Override
    public void update(Task task) {
        final String UPDATE_TASK = "UPDATE tasks SET task_title=?, task_description=?, task_status = ?, task_start_date = ?, task_due_date = ? WHERE task_id=?";

        try (Connection conn = JDBConnection.getConnection()) {

            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_TASK);
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setString(3, task.getStatus().toString());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(task.getStartDate()));
            preparedStatement.setTimestamp(5, Timestamp.valueOf(task.getDueDate()));
            preparedStatement.setInt(6, task.getTaskId());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            System.out.println("There was a problem with the update(Task) method in the UserDaoImpl class when trying to make a connection with the database:\n" + e.getMessage());
        }


    }

    @Override
    public void delete(int id) {
        final String DELETE_TASK = "DELETE FROM tasks WHERE task_id = ?";
        try (Connection conn = JDBConnection.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_TASK);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("There was a problem in the delete(int) method of the TaskDaoImpl class. The error message can be found below:\n" + e.getMessage());
        }
    }
}
