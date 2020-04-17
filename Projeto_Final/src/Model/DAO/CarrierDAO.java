package Model.DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static Utility.SQLConnection.SQLConnection;

import Model.Object.Carrier;
import java.util.LinkedList;

public class CarrierDAO implements CarrierDAOInterface {

    @Override
    public Carrier insert(Carrier carrier) throws Exception {
        PreparedStatement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            
            query = "INSERT INTO carrier (name, cnpj) VALUES (";
            query += "'" + carrier.getName() + "', ";
            query += "'" + carrier.getCNPJ() + "');";
            
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
            connection.commit();
            
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            
            carrier.setCarrierId(rs.getInt("GENERATED_KEY"));
            
            statement.close();
            connection.close();
            
            return carrier;
        } catch(Exception exception) {
            throw exception;
        }
    }

    @Override
    public Carrier retrieve(int id) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM carrier WHERE id LIKE '" + id + "';";
            
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {
                Carrier carrier = new Carrier();
                carrier.setCarrierId(rs.getInt("id"));
                carrier.setName(rs.getString("name"));
                carrier.setCNPJ(rs.getString("cnpj"));

                statement.close();
                rs.close();
                connection.close();

                return carrier;
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
    public Carrier retrieveByName(String name) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM carrier WHERE name LIKE '" + name + "';";
            
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {
                Carrier carrier = new Carrier();
                carrier.setCarrierId(rs.getInt("id"));
                carrier.setName(rs.getString("name"));
                carrier.setCNPJ(rs.getString("cnpj"));

                statement.close();
                rs.close();
                connection.close();

                return carrier;
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
    public Carrier retrieveByCNPJ(String cnpj) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM carrier WHERE cnpj LIKE '" + cnpj + "';";
            
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {
                Carrier carrier = new Carrier();
                carrier.setCarrierId(rs.getInt("id"));
                carrier.setName(rs.getString("name"));
                carrier.setCNPJ(rs.getString("cnpj"));

                statement.close();
                rs.close();
                connection.close();

                return carrier;
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
    public void update(Carrier carrier) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "UPDATE carrier SET ";
            query += "name = '" + carrier.getName()      + "'" + ", ";
            query += "cnpj = '" + carrier.getCNPJ()      + "'" + " ";
            query += "WHERE id = "  + carrier.getCarrierId()   + ";";
            
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
            connection.close();
        } catch(Exception exception) {
            throw exception;
        }
    }

    @Override
    public void delete(Carrier carrier) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "DELETE FROM carrier WHERE id = " + carrier.getCarrierId() + ";";
            
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
            connection.close();
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public LinkedList<Carrier> retrieveAll() throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM carrier;";
            
            ResultSet rs = statement.executeQuery(query);
            LinkedList<Carrier> list = new LinkedList<>();
            Carrier carrier;
            while(rs.next()) {
                carrier = new Carrier();
                carrier.setCarrierId(rs.getInt("id"));
                carrier.setName(rs.getString("name"));
                carrier.setCNPJ(rs.getString("cnpj"));
                list.add(carrier);
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
