package Model.DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.LinkedList;

import static Utility.SQLConnection.SQLConnection;

import Model.Object.Product;
import Model.Object.Sale;
import Model.Object.Store;
import java.util.HashMap;

public class ProductDAO implements ProductDAOInterface {
    @Override
    public Product insert(Product product) throws Exception {
        PreparedStatement statement;
        String query;

        try {
            Connection connection = SQLConnection();

            query = "INSERT INTO product (name, description, price, code_bar, brand_origin) VALUES (";
            query += "'" + product.getName()        + "'" + ", ";
            query += "'" + product.getDescription() + "'" + ", ";
            query +=       product.getPrice()             + ", ";
            query += "'" + product.getBarcode()     + "'" + ", ";
            query += "'" + product.getBrand()       + "'" + ");";

            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
            connection.commit();
            
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            
            product.setProductId(rs.getInt("GENERATED_KEY"));
            
            statement.close();
            connection.close();
            
            return product;
        } catch(Exception exception) {
            throw exception;
        }
    }

    @Override
    public Product retrieve(int id) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM product WHERE id LIKE '" + id + "';";
            
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {            
                Product product = new Product();
                product.setProductId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setBarcode(rs.getString("code_bar"));
                product.setBrand(rs.getString("brand_origin"));

                statement.close();
                rs.close();
                connection.close();

                return product;
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
    public void update(Product product) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "UPDATE product SET ";
            query += "name = "         + "'" + product.getName()        + "'" + ", ";
            query += "description = "  + "'" + product.getDescription() + "'" + ", ";
            query += "price = "              + product.getPrice()             + ", ";
            query += "code_bar = "     + "'" + product.getBarcode()     + "'" + ", ";
            query += "brand_origin = " + "'" + product.getBrand()       + "'" + " ";
            query += "WHERE id = "           + product.getProductId()         + ";";
            
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
            connection.close();
        } catch(Exception exception) {
            throw exception;
        }
    }

    @Override
    public void delete(Product product) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "DELETE FROM product WHERE id = " + product.getProductId() + ";";
            
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
            connection.close();
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public void insertIntoStock(Product product, Store store, int amount) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "INSERT INTO storage (ref_storage, ref_product, amount) VALUES (" +
                    store.getStoreId() + ", " +
                    product.getProductId() + ", " +
                    amount + ");";
            
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
            connection.close();
        } catch(Exception exception) {
            throw exception;
        }
    }

    @Override
    public void insertIntoItem(Sale sale, Product product, int amount) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "INSERT INTO item (ref_sale, ref_product, amount) VALUES (" +
                    sale.getSaleId() + ", " +
                    product.getProductId() + ", " +
                    amount + ");";
            
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
            connection.close();
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public HashMap<Product, Integer> retrieveStock() throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM product INNER JOIN storage ON ";
            query += "storage.ref_product = product.id;";
            
            ResultSet rs = statement.executeQuery(query);
            HashMap<Product, Integer> stock = new HashMap<>();
            Product product;
            while(rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setBarcode(rs.getString("code_bar"));
                product.setBrand(rs.getString("brand_origin"));
                if(stock.get(product) == null) {
                    stock.put(product, rs.getInt("amount"));
                } else {
                    stock.put(product, stock.get(product) + rs.getInt("amount"));
                }
            }
            statement.close();
            rs.close();
            connection.close();
            
            return stock;
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public HashMap<Product, Integer> retrieveStock(Store store) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM product INNER JOIN storage ON ";
            query += "storage.ref_storage = " + store.getStoreId();
            query += "AND storage.ref_product = product.id;";
            
            ResultSet rs = statement.executeQuery(query);
            HashMap<Product, Integer> stock = new HashMap<>();
            Product product;
            while(rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setBarcode(rs.getString("code_bar"));
                product.setBrand(rs.getString("brand_origin"));
                stock.put(product, rs.getInt("amount"));
            }
            statement.close();
            rs.close();
            connection.close();
            
            return stock;
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    public int retrieveStock(Store store, Product produc) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM product INNER JOIN storage ON ";
            query += "storage.ref_storage = " + store.getStoreId();
            query += " AND storage.ref_product = product.id";
            query += " AND product.id = " + produc.getProductId() + ";";
            
            ResultSet rs = statement.executeQuery(query);
            int stock = 0;
            if(rs.next()) {
                stock += rs.getInt("amount");
            }
            statement.close();
            rs.close();
            connection.close();
            
            return stock;
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public HashMap<Product, Integer> retrieveSaleItems(Sale sale) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM product INNER JOIN item ON ";
            query += "item.ref_sale = " + sale.getSaleId();
            query += " AND item.ref_product = product.id;";
            
            ResultSet rs = statement.executeQuery(query);
            HashMap<Product, Integer> stock = new HashMap<>();
            Product product;
            while(rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("product.id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setBarcode(rs.getString("code_bar"));
                product.setBrand(rs.getString("brand_origin"));
                stock.put(product, rs.getInt("amount"));
            }
            statement.close();
            rs.close();
            connection.close();
            
            return stock;
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public LinkedList<Product> retrieveListByName(String param, int page) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM product WHERE name LIKE '%" + param + "%' ";
            query += "LIMIT " + 10*(page - 1) + ", 10";
            
            ResultSet rs = statement.executeQuery(query);
            
            LinkedList<Product> list = new LinkedList<>();
            Product product;
            while(rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("value"));
                product.setBarcode(rs.getString("code_bar"));
                product.setBrand(rs.getString("brand_origin"));
                list.add(product);
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
    public HashMap<Product, Integer> retrieveStockByList(String param, int page) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT DISTINCT * FROM product INNER JOIN storage ON "
                    + "product.name LIKE '%" + param + "%' "
                    + "AND product.id = storage.ref_product ";
            query += "LIMIT " + 10*(page - 1) + ", 10";
            
            ResultSet rs = statement.executeQuery(query);
            
            HashMap<Product, Integer> map = new HashMap<>();
            Product product;
            while(rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("value"));
                product.setBarcode(rs.getString("code_bar"));
                product.setBrand(rs.getString("brand_origin"));
                map.put(product, rs.getInt("amount"));
            }
            
            statement.close();
            rs.close();
            connection.close();
            
            return map;
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    public void changeStock(Product product, Store store, int amount) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "UPDATE storage ";
            query += "SET amount = " + amount + " ";
            query += "WHERE ref_storage LIKE '" + store.getStoreId() + "' ";
            query += "AND ref_product LIKE '" + product.getProductId() + "';";
            
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
            connection.close();
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    public Product retrieveByBarcode(String barcode) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM product WHERE code_bar LIKE '" + barcode + "';";
            
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {            
                Product product = new Product();
                product.setProductId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setBarcode(rs.getString("code_bar"));
                product.setBrand(rs.getString("brand_origin"));

                statement.close();
                rs.close();
                connection.close();

                return product;
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
    public Product retrieveByName(String name) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM product WHERE name LIKE '" + name + "';";
            
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {            
                Product product = new Product();
                product.setProductId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setBarcode(rs.getString("code_bar"));
                product.setBrand(rs.getString("brand_origin"));

                statement.close();
                rs.close();
                connection.close();

                return product;
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
    public void deleteFromStock(Product product, Store store) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "DELETE FROM storage WHERE ref_product = " + product.getProductId() + " ";
            query += " AND ref_storage = " + store.getStoreId() + ";";
            
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
            connection.close();
        } catch(Exception exception) {
            throw exception;
        }
    }
    public int retrieveStockCount(Product product) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT amount FROM storage ";
            query += "WHERE ref_product LIKE '" + product.getProductId() + "';";
            
            ResultSet rs = statement.executeQuery(query);
            int quantity = 0;
            while(rs.next()) {
                quantity += rs.getInt("amount");
            }
            
            statement.close();
            rs.close();
            connection.close();
            
            return quantity;
        } catch(Exception exception) {
            throw exception;
        }
    }
}
