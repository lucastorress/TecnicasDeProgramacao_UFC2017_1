package Utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection {
    private static final String USERNAME = "sql10185589";
    private static final String PASSWORD = "W7wDb7kg2l";
    private static final String URL = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10185589?zeroDateTimeBehavior=convertToNull";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    
    public static Connection SQLConnection() throws Exception {
        Connection connection;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection.setAutoCommit(false);
            
            return connection;
        } catch(Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
}
