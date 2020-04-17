package Model.DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static Utility.SQLConnection.SQLConnection;

import Model.Object.Sale;
import Model.Object.Store;
import static Utility.StringDate.dateToSQLString;
import java.sql.Date;
import java.util.Calendar;
import static java.util.Calendar.*;
import java.util.LinkedList;

public class SaleDAO implements SaleDAOInterface {
    @Override
    public Sale insert(Sale sale) throws Exception {
        PreparedStatement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();

            query = "INSERT INTO sale (ref_user, ref_client, need_carrier, status, value) VALUES (";
            query +=       sale.getUserId()                            + ", ";
            query +=       sale.getClientId()                          + ", ";
            query +=      (sale.getCarrier() ? "1" : "0")       + ", ";
            query +=       sale.getStatus()                            + ", ";
            query +=       sale.getValue()                                   ;
            query += ");";

            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
            connection.commit();
            
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            
            sale.setSaleId(rs.getInt("GENERATED_KEY"));
            
            statement.close();
            connection.close();

            return sale;
        } catch(Exception exception) {
            throw exception;
        }
    }

    @Override
    public Sale retrieve(int id) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM sale WHERE id LIKE '" + id + "';";
            
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {            
                Sale sale = new Sale();
                sale.setSaleId(rs.getInt("id"));
                sale.setUserId(rs.getInt("ref_user"));
                sale.setClientId(rs.getInt("ref_client"));
                sale.setCarrier(rs.getBoolean("need_carrier"));
                sale.setStatus(rs.getInt("status"));
                sale.setValue(rs.getDouble("value"));
                sale.setDate(rs.getDate("date_register"));

                statement.close();
                rs.close();
                connection.close();

                return sale;
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
    public void update(Sale sale) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "UPDATE sale SET ";
            query += "ref_user = "           + sale.getUserId()                            + ", ";
            query += "ref_client = "         + sale.getClientId()                          + ", ";
            query += "need_carrier = "       +(sale.getCarrier() ? "TRUE" : "FALSE")       + ", ";
            query += "status = "             + sale.getStatus()                            + ", ";
            query += "value = "              + sale.getValue()                             + ", ";
            query += "date = "         + "'" + dateToSQLString(sale.getDate())       + "'" + " ";
            query += "WHERE id = "           + sale.getSaleId()                            + ";";
            
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
            connection.close();
        } catch(Exception exception) {
            throw exception;
        }
    }

    @Override
    public void delete(Sale sale) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "DELETE FROM sale WHERE id = " + sale.getSaleId() + ";";
            
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
            connection.close();
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public LinkedList<Sale> retrieveAll() throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM sale;";
            
            ResultSet rs = statement.executeQuery(query);
            LinkedList<Sale> list = new LinkedList<>();
            Sale sale;
            while(rs.next()) {
                sale = new Sale();
                sale.setSaleId(rs.getInt("id"));
                sale.setClientId(rs.getInt("ref_client"));
                sale.setUserId(rs.getInt("ref_user"));
                sale.setCarrier(rs.getBoolean("need_carrier"));
                sale.setDate(rs.getDate("date"));
                sale.setValue(rs.getDouble("value"));
                sale.setStatus(rs.getInt("status"));
                sale.setItems(new ProductDAO().retrieveSaleItems(sale));
                list.add(sale);
            }
            statement.close();
            rs.close();
            connection.close();
            
            return list;
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public LinkedList<Sale> retrieveAll(Store store) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM sale INNER JOIN item ON " +
                    "item.ref_store = " + store.getStoreId() +
                    "item.ref_sale = sale.id;";
            
            ResultSet rs = statement.executeQuery(query);
            LinkedList<Sale> list = new LinkedList<>();
            Sale sale;
            while(rs.next()) {
                sale = new Sale();
                sale.setSaleId(rs.getInt("id"));
                sale.setClientId(rs.getInt("ref_client"));
                sale.setUserId(rs.getInt("ref_user"));
                sale.setCarrier(rs.getBoolean("need_carrier"));
                sale.setDate(rs.getDate("date"));
                sale.setValue(rs.getDouble("value"));
                sale.setStatus(rs.getInt("status"));
                sale.setItems(new ProductDAO().retrieveSaleItems(sale));
                list.add(sale);
            }
            statement.close();
            rs.close();
            connection.close();
            
            return list;
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public LinkedList<Sale> retrieveDailyAll() throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            Calendar data = Calendar.getInstance();
            int month = data.get(MONTH)+1;
            
            query = "SELECT * FROM sale " + 
                    "WHERE date_purchase >= " + "'" + data.get(YEAR) + "-" + month + "-" + data.get(DAY_OF_MONTH) + "'" + ";";
                    //"WHERE date_purchase >= '2017-07-19';";
            
            ResultSet rs = statement.executeQuery(query);
            LinkedList<Sale> list = new LinkedList<>();
            Sale sale;
            while(rs.next()) {
                sale = new Sale();
                sale.setSaleId(rs.getInt("id"));
                sale.setClientId(rs.getInt("ref_client"));
                sale.setUserId(rs.getInt("ref_user"));
                sale.setCarrier(rs.getBoolean("need_carrier"));
                sale.setDate(rs.getDate("date_purchase"));
                sale.setValue(rs.getDouble("value"));
                sale.setStatus(rs.getInt("status"));
                sale.setItems(new ProductDAO().retrieveSaleItems(sale));
                list.add(sale);
            }
            statement.close();
            rs.close();
            connection.close();
            
            return list;
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public LinkedList<Sale> retrieveDailyAll(Store store) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM sale INNER JOIN item ON " +
                    "item.ref_store = " + store.getStoreId() +
                    " AND date >= " + new Date((System.currentTimeMillis() % 86400000) * 86400000).toString() +
                    " AND item.ref_sale = sale.id;";
            
            ResultSet rs = statement.executeQuery(query);
            LinkedList<Sale> list = new LinkedList<>();
            Sale sale;
            while(rs.next()) {
                sale = new Sale();
                sale.setSaleId(rs.getInt("id"));
                sale.setClientId(rs.getInt("ref_client"));
                sale.setUserId(rs.getInt("ref_user"));
                sale.setCarrier(rs.getBoolean("need_carrier"));
                sale.setDate(rs.getDate("date"));
                sale.setValue(rs.getDouble("value"));
                sale.setStatus(rs.getInt("status"));
                sale.setItems(new ProductDAO().retrieveSaleItems(sale));
                list.add(sale);
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
