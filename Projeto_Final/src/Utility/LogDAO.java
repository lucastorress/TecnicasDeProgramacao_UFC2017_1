package Utility;

import static Utility.SQLConnection.SQLConnection;
import java.sql.Connection;
import java.sql.Statement;

public class LogDAO {
    public static void write(String log) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "INSERT INTO `logcommands` (`description_command`) VALUES (" +
                    "'" + log + "')";
            
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
            connection.close();
        } catch(Exception exception) {
            throw exception;
        }
    }
}
