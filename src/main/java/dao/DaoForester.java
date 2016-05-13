package dao;

import model.Forester;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

import static dao.DbConnection.getConnection;

/**
 * Created by rybatsky
 */

public class DaoForester {

    private final static Logger logger = Logger.getLogger(DbConnection.class);
    private Connection connection;

    public DaoForester() throws SQLException {
        connection = getConnection();
    }

    public void addForester(Forester forester) {

        String query = "INSERT INTO foresters (first_name, last_name, email, password) " +
                "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, forester.getFirstName());
            preparedStatement.setString(2, forester.getLastName());
            preparedStatement.setString(3, forester.getEmail());
            preparedStatement.setString(4, forester.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Cannot perform SQL statement" + query);
        }
    }

    public boolean isForesterCorrect(String email, String password) {

        if (email == null || password == null)
            return false;
        String query = "SELECT forester_id FROM foresters WHERE email = ? AND password = ?";
        int result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                result = resultSet.getInt("forester_id");
            else
                return false;
        } catch (SQLException e) {
            logger.error("Cannot perform SQL statement" + query);
            throw new RuntimeException(e);
        }
        return result != 0;
    }

    public List<Forester> getAllForesters(List<Forester> foresters) {

        String query = "SELECT * FROM foresters";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                foresters.add(new Forester(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error("Cannot perform SQL statement" + query);
        }
        return foresters;
    }

    public void getForestersNamesAndId(List<Forester> foresters) {

        String query = "SELECT forester_id, first_name, last_name FROM foresters";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                foresters.add(new Forester(resultSet.getInt(1),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error("Cannot perform SQL statement" + query);
        }
    }

    public Forester getForesterByEmail(String email) {

        Forester forester = new Forester();
        String query = "SELECT forester_id, first_name, last_name from foresters WHERE email = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                forester.setForesterId(resultSet.getInt("forester_id"));
                forester.setFirstName(resultSet.getString("first_name"));
                forester.setLastName(resultSet.getString("last_name"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error("Cannot perform SQL statement" + query);
        }
        return forester;
    }
}
