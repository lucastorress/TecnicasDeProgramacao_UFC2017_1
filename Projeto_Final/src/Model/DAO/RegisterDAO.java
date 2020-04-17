package Model.DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static Utility.SQLConnection.SQLConnection;

import Model.Object.Register;
import static Utility.StringDate.dateToSQLString;
import java.util.LinkedList;

public class RegisterDAO implements RegisterDAOInterface {
    @Override
    public Register insert(Register register) throws Exception {
        PreparedStatement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();

            query = "INSERT INTO register (ref_store, sales_today, cash_register, date) VALUES (";
            query += "'" + register.getStoreId()               + "'" + ", ";
            query +=     + register.getSalesToday()                  + ", ";
            query +=     + register.getCashRegister()                + ", ";
            query += "'" + dateToSQLString(register.getDate()) + "'" + ");";

            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
            connection.commit();
            
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            
            register.setRegisterId(rs.getInt("GENERATED_KEY"));
            
            statement.close();
            connection.close();
            
            return register;
        } catch(Exception exception) {
            throw exception;
        }
    }

    @Override
    public Register retrieve(int id) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM person WHERE cpf LIKE '" + id + "';";
            
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {            
                Register register = new Register();
                register.setRegisterId(rs.getInt("id"));
                register.setStoreId(rs.getInt("ref_store"));
                register.setSalesToday(rs.getInt("sales_today"));
                register.setCashRegister(rs.getDouble("cash_register"));
                register.setDate(rs.getDate("date"));

                statement.close();
                rs.close();
                connection.close();

                return register;
            } else {
                statement.close();
                rs.close();
                connection.close();
                
                return null;
            }
        } catch(Exception exception) {
            throw exception;
        }
    }

    @Override
    public void update(Register register) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "UPDATE register SET ";
            query += "ref_store = "     + "'" + register.getStoreId()               + "'" + ", ";
            query += "sales_today = "         + register.getSalesToday()                  + ", ";
            query += "cash_register = "       + register.getCashRegister()                + ", ";
            query += "date = "          + "'" + dateToSQLString(register.getDate()) + "'" + " ";
            query += "WHERE id = "            + register.getRegisterId()                  + ";";
            
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
            connection.close();
        } catch(Exception exception) {
            throw exception;
        }
    }

    @Override
    public void delete(Register register) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "DELETE FROM register WHERE id = " + register.getRegisterId() + ";";
            
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
            connection.close();
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public LinkedList<Register> retrieveAll() throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM register_store;";
            
            ResultSet rs = statement.executeQuery(query);
            LinkedList<Register> list = new LinkedList<>();
            Register register;
            while(rs.next()) {
                register = new Register();
                register.setRegisterId(rs.getInt("id"));
                register.setStoreId(rs.getInt("ref_store"));
                register.setSalesToday(rs.getInt("sales_today"));
                register.setCashRegister(rs.getDouble("cash_register"));
                register.setDate(rs.getDate("date"));
                list.add(register);
            }
            statement.close();
            rs.close();
            connection.close();
            
            return list;
        } catch(Exception exception) {
            throw exception;
        }
    }
}
