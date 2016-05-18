package dao;

import model.Owner;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static dao.DbConnection.getConnection;

/**
 * Owners access class.
 * Contains methods with SQL queries.
 * @see Owner
 * @author Anastasiia Rybakova
 * @since 04.2016
 */
public class DaoOwner {

    private final static Logger logger = Logger.getLogger(dao.DaoOwner.class);
    private Connection connection;

    /**
     * DaoOwner constructor.
     * Creates database connection.
     * @throws SQLException
     */
    public DaoOwner() throws SQLException {
        connection = getConnection();
    }

    /**
     * Adds new owner in database.
     * @param owner
     */
    public void addOwner(Owner owner) {

        String query = "INSERT INTO owners (first_name, last_name, park_name, email, password) " +
                "VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, owner.getFirstName());
            preparedStatement.setString(2, owner.getLastName());
            preparedStatement.setString(3, owner.getParkName());
            preparedStatement.setString(4, owner.getEmail());
            preparedStatement.setString(5, owner.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e + "\n Cannot perform SQL statement " + query);
        }
    }

    /**
     * Checks, whether there's owner with such email and password.
     * @param email owner's email
     * @param password owner's password
     * @return true if there's such owner
     */
    public boolean isOwnerCorrect(String email, String password) {

        if (email == null || password == null)
            return false;
        String query = "SELECT owner_id FROM owners WHERE email = ? AND password = ?";
        int result = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                result = resultSet.getInt("owner_id");
            else
                return false;
        } catch (SQLException e) {
            logger.error(e + "\n Cannot perform SQL statement " + query);
        }
        return result != 0;
    }

    /**
     * Returns list of all owners.
     * @param owners list of owners
     * @return list of all owners
     */
    public List<Owner> getAllOwners(List<Owner> owners) {

        String query = "SELECT * FROM owners";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                owners.add(new Owner(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error(e + "\n Cannot perform SQL statement " + query);
        }
        return owners;
    }

    /**
     * Returns owner by his email.
     * @param email owner's email
     * @return owner by his email
     */
    public Owner getOwnerByEmail(String email) {

        Owner owner = new Owner();
        String query = "SELECT owner_id, first_name, last_name from owners WHERE email = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                owner.setOwnerId(resultSet.getInt("owner_id"));
                owner.setFirstName(resultSet.getString("first_name"));
                owner.setLastName(resultSet.getString("last_name"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error(e + "\n Cannot perform SQL statement " + query);
        }
        return owner;
    }
}
