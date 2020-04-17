package Model.DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static Utility.SQLConnection.SQLConnection;

import Model.Object.Store;
import java.util.LinkedList;

public class StoreDAO implements StoreDAOInterface {

    @Override
    public Store insert(Store store) throws Exception {
        PreparedStatement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();

            query = "INSERT INTO store (address, phone) VALUES (";
            query += "'" + store.getAddress() + "'" + ", ";
            query += "'" + store.getPhone()   + "'" + ");";

            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
            connection.commit();
            
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            
            store.setStoreId(rs.getInt("GENERATED_KEY"));
            
            statement.close();
            connection.close();
            
            return store;
        } catch(Exception exception) {
            throw exception;
        }
    }

    @Override
    public Store retrieve(int id) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM store WHERE id LIKE '" + id + "';";
            
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {            
                Store store = new Store();
                store.setStoreId(rs.getInt("id"));
                store.setAddress(rs.getString("address"));
                store.setPhone(rs.getString("phone"));

                statement.close();
                rs.close();
                connection.close();

                return store;
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
    public void update(Store store) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "UPDATE store SET ";
            query += "address = "  + "'" + store.getAddress() + "'" + ", ";
            query += "phone = "    + "'" + store.getPhone()   + "'" + " ";
            query += "WHERE id = "       + store.getStoreId()       + ";";
            
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
            connection.close();
        } catch(Exception exception) {
            throw exception;
        }
    }

    @Override
    public void delete(Store store) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "DELETE FROM store WHERE id = " + store.getStoreId() + ";";
            
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
            connection.close();
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public LinkedList<Store> retrieveAll() throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM store;";
            
            ResultSet rs = statement.executeQuery(query);
            LinkedList<Store> list = new LinkedList<>();
            Store store;
            while(rs.next()) {
                store = new Store();
                store.setStoreId(rs.getInt("id"));
                store.setAddress(rs.getString("address"));
                store.setPhone(rs.getString("phone"));
                list.add(store);
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
