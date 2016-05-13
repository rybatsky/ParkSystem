package dao;

import model.Task;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static dao.DbConnection.getConnection;

/**
 * Created by rybatsky
 */

public class DaoTask {

    private final static Logger logger = Logger.getLogger(DbConnection.class);
    private int ownerId;
    private int foresterId;
    private Connection connection;

    public DaoTask() throws SQLException {
        connection = getConnection();
    }

    public Task getTaskById(int taskId, Task task) {

        String query = "SELECT task_id," +
                "owner_id," +
                "forester_id," +
                "type," +
                "comments," +
                "done," +
                "confirmed " +
                "FROM tasks";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, taskId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                task.setTaskId(resultSet.getInt(1));
                task.setOwnerId(resultSet.getInt(2));
                task.setForesterId(resultSet.getInt(3));
                task.setType(resultSet.getString(4));
                task.setComments(resultSet.getString(5));
                task.setDone(resultSet.getBoolean(6));
                task.setConfirmed(resultSet.getBoolean(7));
            }
            if (taskId == 0) {
                logger.error("Cannot perform SQL statement" + query + ". id = 0");
                return null;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error("Cannot perform SQL statement" + query);
        }
        return task;
    }


    public List<Task> getAllTasks(List<Task> tasks) {

        String query = "SELECT task_id," +
                "owner_id," +
                "forester_id," +
                "type," +
                "comments," +
                "done," +
                "confirmed " +
                "FROM tasks";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tasks.add(new Task(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getBoolean(6),
                        resultSet.getBoolean(7)));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error("Cannot perform SQL statement" + query);
        }
        return tasks;
    }


    public List<Task> getTasksForForester(List<Task> tasks, int foresterId) {

        String query = "SELECT task_id," +
                "owner_id," +
                "forester_id," +
                "type," +
                "comments," +
                "done," +
                "confirmed\n" +
                "FROM tasks \n" +
                "WHERE forester_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, foresterId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tasks.add(new Task(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getBoolean(6),
                        resultSet.getBoolean(7)));

            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error("Cannot perform SQL statement" + query);
        }
        return tasks;
    }


    public int getForesterIdByNames(String firstName, String lastName) {

        int id = 0;
        String query = "SELECT forester_id from foresters WHERE first_name = ? AND last_name = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("forester_id");
            }
            if (id == 0) {
                throw new SQLException("There's no forester with such id.");
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error("Cannot perform SQL statement" + query);
        }
        return id;
    }


    public void addTask(Task task) {

        String query = "INSERT INTO tasks (owner_id, forester_id, type, comments) " +
                "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, getOwnerId());
            preparedStatement.setInt(2, getForesterId());
            preparedStatement.setString(3, task.getType());
            preparedStatement.setString(4, task.getComments());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error("Cannot perform SQL statement" + query);
        }
    }

    public void delTask(int taskId) {

        String query = "DELETE FROM tasks WHERE task_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, taskId);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            logger.error("Cannot perform SQL statement" + query);
        }
    }

    public void editTask(int taskId,
                         int foresterId,
                         String type,
                         String comments,
                         boolean done,
                         boolean confirmed) {

        String query = "UPDATE tasks " +
                "SET forester_id = ?," +
                "type = ?," +
                "comments = ?," +
                "done = ?," +
                "confirmed = ? " +
                "WHERE task_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, foresterId);
            preparedStatement.setString(2, type);
            preparedStatement.setString(3, comments);
            preparedStatement.setBoolean(4, done);
            preparedStatement.setBoolean(5, confirmed);
            preparedStatement.setInt(6, taskId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error("Cannot perform SQL statement" + query);
        }
    }


    public void editIsDoneTask(int task_id, boolean done) {

        String query = "UPDATE tasks SET done = ? WHERE task_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBoolean(1, done);
            preparedStatement.setInt(2, task_id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error("Cannot perform SQL statement" + query);
        }
    }

    public int getIdForesterByTaskId(int task_id) {

        String query = "SELECT forester_id from tasks WHERE task_id = ?";
        int foresterId = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, task_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                foresterId = resultSet.getInt("forester_id");
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error("Cannot perform SQL statement" + query);
        }
        return foresterId;
    }

    public int getForesterId() {
        return foresterId;
    }

    public void setForesterId(int foresterId) {
        this.foresterId = foresterId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
