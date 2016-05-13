package dao;

import model.Owner;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static dao.DbConnection.getConnection;

/**
 * Created by rybatsky
 */

public class DaoOwner {

    private final static Logger logger = Logger.getLogger(DbConnection.class);
    private Connection connection;

    public DaoOwner() throws SQLException {
        connection = getConnection();
    }


    public void addOwner(Owner owner) {

        String query = "INSERT INTO owners (first_name, last_name, email, password) " +
                "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, owner.getFirstName());
            preparedStatement.setString(2, owner.getLastName());
            preparedStatement.setString(3, owner.getEmail());
            preparedStatement.setString(4, owner.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Cannot perform SQL statement" + query);
        }
    }

    public boolean isOwnerCorrect(String email, String password) {

        if (email == null || password == null)
            return false;
        String query = "SELECT owner_id FROM owners WHERE email = ? AND password = ?";
        int result;
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
            logger.error("Cannot perform SQL statement" + query);
            throw new RuntimeException(e);
        }
        return result != 0;
    }

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
            logger.error("Cannot perform SQL statement" + query);
        }
        return owner;
    }
}
