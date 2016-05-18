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
 * Tasks access class.
 * Contains methods with SQL queries.
 * @see Task
 * @author Anastasiia Rybakova
 * @since 04.2016
 */
public class DaoTask {

    private final static Logger logger = Logger.getLogger(dao.DaoTask.class);
    private int ownerId;
    private int foresterId;
    private Connection connection;

    /**
     * DaoOTask constructor.
     * Creates database connection.
     * @throws SQLException
     */
    public DaoTask() throws SQLException {
        connection = getConnection();
    }

    /**
     * Returns task by its id.
     * @param taskId task id
     * @param task
     * @return task
     */
    public Task getTaskById (int taskId, Task task) {

        String query = "SELECT task_id, " +
                "owner_id, " +
                "forester_id, " +
                "plant, " +
                "type, " +
                "comments, " +
                "done, " +
                "confirmed " +
                "FROM tasks " +
                "WHERE task_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, taskId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                task.setTaskId(resultSet.getInt(1));
                task.setOwnerId(resultSet.getInt(2));
                task.setForesterId(resultSet.getInt(3));
                task.setPlant(resultSet.getString(4));
                task.setType(resultSet.getString(5));
                task.setComments(resultSet.getString(6));
                task.setDone(resultSet.getBoolean(7));
                task.setConfirmed(resultSet.getBoolean(8));
            }
            if (taskId == 0) {
                logger.error("Cannot perform SQL statement " + query + "\n id = 0");
                return null;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error(e + "\n Cannot perform SQL statement " + query);
        }
        return task;
    }

    /**
     * Returns list of all tasks.
     * @param tasks
     * @return list of all tasks
     */
    public List<Task> getAllTasks (List<Task> tasks) {

        String query = "SELECT * FROM tasks";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tasks.add(new Task(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getBoolean(7),
                        resultSet.getBoolean(8)));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error(e + "Cannot perform SQL statement " + query);
        }
        return tasks;
    }

    /**
     * Returns list of tasks for current forester.
     * @param tasks
     * @param foresterId current forester's id
     * @return list of tasks
     */
    public List<Task> getTasksForForester (List<Task> tasks, int foresterId) {

        String query = "SELECT * FROM tasks WHERE forester_id = ?";
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
                        resultSet.getString(6),
                        resultSet.getBoolean(7),
                        resultSet.getBoolean(8)));

            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error(e + "\n Cannot perform SQL statement " + query);
        }
        return tasks;
    }

    /**
     * Returns list of tasks for current owner.
     * @param tasks
     * @param ownerId current owner's id
     * @return list of tasks
     */
    public List<Task> getTasksForOwner(List<Task> tasks, int ownerId) {

        String query = "SELECT * FROM tasks WHERE owner_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, ownerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tasks.add(new Task(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getBoolean(7),
                        resultSet.getBoolean(8)));

            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error(e + "\n Cannot perform SQL statement " + query);
        }
        return tasks;
    }

    /**
     * Adds new task in database.
     * @param task
     */
    public void addTask(Task task) {

        String query = "INSERT INTO tasks (owner_id, forester_id, plant, type, comments) " +
                "VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, getOwnerId());
            preparedStatement.setInt(2, getForesterId());
            preparedStatement.setString(3, task.getPlant());
            preparedStatement.setString(4, task.getType());
            preparedStatement.setString(5, task.getComments());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error(e + "\n Cannot perform SQL statement " + query);
        }
    }

    /**
     * Deletes task from database.
     * @param taskId task id
     */
    public void delTask(int taskId) {

        String query = "DELETE FROM tasks WHERE task_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, taskId);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            logger.error(e + "\n Cannot perform SQL statement " + query);
        }
    }

    /**
     * Edits task.
     * @param taskId task id
     * @param foresterId forester id
     * @param plant
     * @param type
     * @param comments
     * @param done
     * @param confirmed
     */
    public void editTask(int taskId,
                         int foresterId,
                         String plant,
                         String type,
                         String comments,
                         boolean done,
                         boolean confirmed) {

        String query = "UPDATE tasks " +
                "SET forester_id = ?," +
                "plant = ?," +
                "type = ?," +
                "comments = ?," +
                "done = ?," +
                "confirmed = ? " +
                "WHERE task_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, foresterId);
            preparedStatement.setString(2, plant);
            preparedStatement.setString(3, type);
            preparedStatement.setString(4, comments);
            preparedStatement.setBoolean(5, done);
            preparedStatement.setBoolean(6, confirmed);
            preparedStatement.setInt(7, taskId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error(e + "\n Cannot perform SQL statement " + query);
        }
    }

    /**
     * Changes task's status: done/undone.
     * @param taskId task id
     * @param done
     */
    public void editIsDoneTask(int taskId, boolean done) {

        String query = "UPDATE tasks SET done = ? WHERE task_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBoolean(1, done);
            preparedStatement.setInt(2, taskId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error(e + "\n Cannot perform SQL statement " + query);
        }
    }

    /**
     * Gets forester's id by task's id.
     * @param taskId task id
     * @return forester id
     */
    public int getIdForesterByTaskId(int taskId) {

        String query = "SELECT forester_id from tasks WHERE task_id = ?";
        int foresterId = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, taskId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                foresterId = resultSet.getInt("forester_id");
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error(e + "\n Cannot perform SQL statement " + query);
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
