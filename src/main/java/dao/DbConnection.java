package dao;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by rybatsky
 */

public class DbConnection {

    private final static Logger logger = Logger.getLogger(DbConnection.class);

    public static Connection getConnection() {

        DataSource ds;
        try {
            Context envCtx = (Context) new InitialContext().lookup("java:/comp/env");
            ds = (DataSource) envCtx.lookup("jdbc/park");
        } catch (NamingException n) {
            logger.error("This name is not allowed here" + n.getRemainingName() + ". " + n);
            return null;
        }

        try {
            return ds.getConnection();
        } catch (SQLException e) {
            logger.error("Cannot create database connection:" + e);
            return null;
        }
    }
}
