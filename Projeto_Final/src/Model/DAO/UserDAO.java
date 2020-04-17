package Model.DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static Utility.SQLConnection.SQLConnection;

import Model.Object.User;
import Model.Object.Person;
import Model.Object.Store;
import java.util.LinkedList;

public class UserDAO implements UserDAOInterface {
    @Override
    public User insert(User user) throws Exception {
        PreparedStatement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            
            Person person = new Person();
            person.setName(user.getName());
            person.setCPF(user.getCPF());
            person.setPhone(user.getPhone());
            person.setBirthday(user.getBirthday());
            PersonDAO persondao = new PersonDAO();
            person = persondao.insert(person);
            
            query = "INSERT INTO user (login, password, is_admin, ref_store, ref_person) VALUES (";
            query += "'" + user.getUsername() + "'" + ", ";
            query += "'" + user.getPassword() + "'" + ", ";
            query += "FALSE"                        + ", ";
            query +=       user.getStoreId()        + ", ";
            query += "'" + person.getCPF()    + "'" + ");";

            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
            connection.commit();
            
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            
            user.setUserId(rs.getInt("GENERATED_KEY"));
            
            rs.close();
            statement.close();
            connection.close();
            
            return user;
        } catch(Exception exception) {
            throw exception;
        }
    }

    @Override
    public User retrieve(int id) throws Exception {
        Statement statement;
        String query;

        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();

            query = "SELECT * FROM user INNER JOIN person ON user.id LIKE '" + id + "' AND person.cpf = user.ref_person;";

            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("id"));
                user.setPersonId(rs.getInt("ref_person"));
                user.setStoreId(rs.getInt("ref_store"));
                user.setUsername(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setAdmin(rs.getBoolean("is_admin"));
                user.setName(rs.getString("name"));
                user.setCPF(rs.getString("cpf"));
                user.setPhone(rs.getString("phone"));
                user.setBirthday(rs.getDate("birthday"));
                user.setDate(rs.getDate("date_register"));
                user.getDate().toString();

                statement.close();
                rs.close();
                connection.close();

                return user;
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
    public User retrieveByName(String name) throws Exception {
        Statement statement;
        String query;

        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();

            query = "SELECT * FROM user INNER JOIN person ON person.name LIKE '" + name + "' AND person.cpf = user.ref_person;";

            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("id"));
                user.setPersonId(rs.getInt("ref_person"));
                user.setUsername(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setAdmin(rs.getBoolean("is_admin"));
                user.setName(rs.getString("name"));
                user.setCPF(rs.getString("cpf"));
                user.setPhone(rs.getString("phone"));
                user.setBirthday(rs.getDate("birthday"));
                user.setDate(rs.getDate("date_register"));

                statement.close();
                rs.close();
                connection.close();

                return user;
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
    public void update(User user) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            Person person = new Person();
            person.setName(user.getName());
            person.setCPF(user.getCPF());
            person.setPhone(user.getPhone());
            person.setBirthday(user.getBirthday());
            PersonDAO persondao = new PersonDAO();
            
            persondao.update(person);
            
            query = "UPDATE user SET ";
            query += "login = "            + "'" + user.getUsername() + "'" + ", ";
            query += "password = "         + "'" + user.getPassword() + "'" + " ";
            query += "WHERE ref_person = " + "'" + user.getCPF()      + "'" + ";";
            
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
            connection.close();
        } catch(Exception exception) {
            throw exception;
        }
    }

    @Override
    public void delete(User user) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            Person person = new Person();
            person.setCPF(user.getCPF());
            PersonDAO persondao = new PersonDAO();
            
            query = "DELETE FROM user WHERE ref_person = '" + user.getCPF() + "';";
            
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
            connection.close();
            persondao.delete(person);
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public LinkedList<User> retrieveAll() throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM user INNER JOIN person ON person.cpf = user.ref_person;";
            
            LinkedList<User> users = new LinkedList<>();
            User temp;
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                temp = new User();
                temp.setUserId(rs.getInt("id"));
                temp.setPersonId(rs.getInt("ref_person"));
                temp.setStoreId(rs.getInt("ref_store"));
                temp.setName(rs.getString("name"));
                temp.setCPF(rs.getString("cpf"));
                temp.setPhone(rs.getString("phone"));
                temp.setBirthday(rs.getDate("birthday"));
                temp.setDate(rs.getDate("date_register"));
                temp.setUsername(rs.getString("login"));
                temp.setPassword(rs.getString("password"));
                temp.setAdmin(rs.getBoolean("is_admin"));
                users.add(temp);
            }
            statement.close();
            rs.close();
            connection.close();
            
            return users;
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public LinkedList<User> retrieveAll(Store store) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM user INNER JOIN person ON " +
                    "user.ref_store = " + store.getStoreId() +
                    " AND person.cpf = user.ref_person;";
            
            LinkedList<User> users = new LinkedList<>();
            User temp;
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                temp = new User();
                temp.setUserId(rs.getInt("id"));
                temp.setPersonId(rs.getInt("ref_person"));
                temp.setStoreId(rs.getInt("ref_store"));
                temp.setName(rs.getString("name"));
                temp.setCPF(rs.getString("cpf"));
                temp.setPhone(rs.getString("phone"));
                temp.setBirthday(rs.getDate("birthday"));
                temp.setDate(rs.getDate("register_date"));
                temp.setUsername(rs.getString("username"));
                temp.setPassword(rs.getString("password"));
                temp.setAdmin(rs.getBoolean("is_admin"));
                users.add(temp);
            }
            statement.close();
            rs.close();
            connection.close();
            
            return users;
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public User retrieveByUsername(String username) throws Exception {
        Statement statement;
        String query;

        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();

            query = "SELECT DISTINCT * FROM user INNER JOIN person ON user.login LIKE '" + username + "' AND person.cpf = user.ref_person;";

            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user.id"));
                user.setPersonId(rs.getInt("person.id"));
                user.setStoreId(rs.getInt("ref_store"));
                user.setUsername(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setAdmin(rs.getBoolean("is_admin"));
                user.setName(rs.getString("name"));
                user.setCPF(rs.getString("cpf"));
                user.setPhone(rs.getString("phone"));
                user.setBirthday(rs.getDate("birthday"));
                user.setDate(rs.getDate("date_register"));

                statement.close();
                rs.close();
                connection.close();

                return user;
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
    public User retrieveByCPF(String cpf) throws Exception {
        Statement statement;
        String query;

        //try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();

            query = "SELECT * FROM user INNER JOIN person ON person.cpf LIKE '" + cpf + "' AND person.cpf = user.ref_person;";

            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("id"));
                user.setPersonId(rs.getInt("ref_person"));
                user.setStoreId(rs.getInt("ref_store"));
                user.setUsername(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setAdmin(rs.getBoolean("is_admin"));
                user.setName(rs.getString("name"));
                user.setCPF(rs.getString("cpf"));
                user.setPhone(rs.getString("phone"));
                user.setBirthday(rs.getDate("birthday"));
                user.setDate(rs.getDate("date_register"));

                statement.close();
                rs.close();
                connection.close();

                return user;
            } else {
                statement.close();
                rs.close();
                connection.close();
                
                return null;
            }
        //} catch(Exception exception) {
        //    throw new Exception(exception.getMessage());
        //}
    }
    
    @Override
    public String retrievePassword(String username) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT password FROM user WHERE login LIKE '" + username + "'";
            
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {            
                String password = rs.getString("password");

                statement.close();
                connection.close();

                return password;
            } else {
                statement.close();
                connection.close();
                
                return null;
            }
        } catch(Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
}
