package dao;

import model.Forester;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

import static dao.DbConnection.getConnection;

/**
 * Foresters access class.
 * Contains methods with SQL queries.
 * @see Forester
 * @author Anastasiia Rybakova
 * @since 04.2016
 */
public class DaoForester {

    private final static Logger logger = Logger.getLogger(dao.DaoForester.class);
    private Connection connection;

    /**
     * DaoForester constructor.
     * Creates database connection.
     * @throws SQLException
     */
    public DaoForester() throws SQLException {
        connection = getConnection();
    }

    /**
     * Adds new forester in database.
     * @param forester
     */
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
            logger.error(e + "\n Cannot perform SQL statement " + query);
        }
    }

    /**
     * Checks, whether there's forester with such email and password.
     * @param email forester's email
     * @param password forester's password
     * @return true if there's such forester
     */
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
            logger.error(e + "\n Cannot perform SQL statement " + query);
            return false;
        }
        return result != 0;
    }

    /**
     * Returns list of all foresters.
     * @param foresters list of foresters
     * @return list of all foresters
     */
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
            logger.error(e + "\n Cannot perform SQL statement " + query);
        }
        return foresters;
    }

    /**
     *
     * @param foresters
     */
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
            logger.error(e + "\n Cannot perform SQL statement " + query);
        }
    }

    /**
     * Returns forester by his email.
     * @param email forester's email
     * @return forester by his email
     */
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
            logger.error(e + "\n Cannot perform SQL statement " + query);
        }
        return forester;
    }
}