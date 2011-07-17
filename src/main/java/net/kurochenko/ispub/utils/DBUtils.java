package net.kurochenko.ispub.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Andrej Kuročenko <kurochenko@mail.muni.cz>
 */
public class DBUtils {

    private static Logger logger = Logger.getLogger(DBUtils.class);

    /**
     * Closes connection if any exists
     * 
     * @param connection connection to be closed
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                logger.log(Level.ERROR, "Error while closing statement", ex);
            }
        }
    }

    /**
     * Reads SQL statements from file. SQL commands in file must be separated
     * by a semicolon.
     * @param url url of the file
     * @return array of command  strings
     */
    private static String[] readSqlStatements(URL url) {
        try {
            char buffer[] = new char[256];
            StringBuilder result = new StringBuilder();
            InputStreamReader reader =
                    new InputStreamReader(url.openStream(), "UTF-8");
            while (true) {
                int count = reader.read(buffer);
                if (count < 0) {
                    break;
                }
                result.append(buffer, 0, count);
            }
            return result.toString().split(";");
        } catch (IOException ex) {
            throw new RuntimeException("Cannot read " + url, ex);
        }
    }

    /**
     * Create tables.
     * @param ds datasource
     * @throws SQLException
     */
    public static void createTables(DataSource ds) throws SQLException {
        executeSqlScript(ds, "createTables.sql");
    }
    
    /**
     * Tries to create table if they don't exist. If tables are already created
     * nothing happens
     * 
     * @param ds Data source
     * @throws SQLException 
     */
    public static void tryCreateTables(DataSource ds) {
        if (ds == null) {
            throw new IllegalArgumentException("DataSource is null");
        }
        try {
            createTables(ds);
            logger.warn("Tables created");
        } catch (SQLException ex) {
            if ("X0Y32".equals(ex.getSQLState())) {
                // This code represents "Table/View/... already exists"
                // This code is Derby specific!
                return;
            } else {
                System.err.println("Failed to create tables. " + ex.getMessage());
            }
        }
    }

    /**
     * Drop tables.
     * @param ds datasource
     * @throws SQLException
     */
    public static void dropTables(DataSource ds) throws SQLException {
        executeSqlScript(ds, "dropTables.sql");
    }

    /**
     * Executes SQL script.
     * @param ds datasource
     * @param scriptName script to execute
     * @throws SQLException
     */
    private static void executeSqlScript(DataSource ds, String scriptName)
            throws SQLException {
        Connection conn = null;
        try {
            conn = ds.getConnection();
            URL url = DBUtils.class.getResource(scriptName);
            for (String sqlStatement : readSqlStatements(url)) {
                if (!sqlStatement.trim().isEmpty()) {
                    conn.prepareStatement(sqlStatement).executeUpdate();
                }
            }
        } finally {
            closeConnection(conn);
        }
    }

    /**
     * Gets ID from resultset
     *
     * @param keys
     * @return id contained in resultset
     * @throws SQLException
     */
    public static Long getId(ResultSet keys) throws SQLException {
        if (keys == null) {
            throw new IllegalArgumentException("Parameter [keys] is null.");
        }
        if (keys.getMetaData().getColumnCount() != 1) {
            throw new IllegalArgumentException("Given ResultSet contains more columns");
        }
        if (keys.next()) {
            Long result = keys.getLong(1);
            if (keys.next()) {
                throw new IllegalArgumentException("Given ResultSet contains more rows");
            }
            return result;
        } else {
            throw new IllegalArgumentException("Given ResultSet contain no rows");
        }
    }
}
