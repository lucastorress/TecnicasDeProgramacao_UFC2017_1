package Model.DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static Utility.SQLConnection.SQLConnection;

import Model.Object.Person;
import static Utility.StringDate.dateToSQLString;

public class PersonDAO implements PersonDAOInterface {
    @Override
    public Person insert(Person person) throws Exception {
        PreparedStatement statement;
        String query;

        try {
            Connection connection = SQLConnection();
            
            query = "INSERT INTO person (name, cpf, phone, birthday) VALUES (";
            query += "'" + person.getName()                      + "'" + ", ";
            query += "'" + person.getCPF()                       + "'" + ", ";
            query += "'" + person.getPhone()                     + "'" + ", ";
            query += "'" + dateToSQLString(person.getBirthday()) + "'" + ");";
            
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
            connection.commit();
            
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            
            person.setPersonId(rs.getInt("GENERATED_KEY"));
            
            statement.close();
            connection.close();
            
            return person;
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public Person retrieve(int id) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM person WHERE id LIKE '" + id + "';";
            
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {            
                Person person = new Person();
                person.setPersonId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setCPF(rs.getString("cpf"));
                person.setPhone(rs.getString("phone"));
                person.setBirthday(rs.getDate("birthday"));
                person.setDate(rs.getDate("date_register"));

                statement.close();
                rs.close();
                connection.close();

                return person;
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
    public void update(Person person) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "UPDATE person SET ";
            query += "name = "      + "'" + person.getName()                      + "'" + ", ";
            query += "phone = "     + "'" + person.getPhone()                     + "'" + ", ";
            query += "birthday = "  + "'" + dateToSQLString(person.getBirthday()) + "'" + " ";
            query += "WHERE cpf = " + "'" + person.getCPF()                       + "'" + ";";
            
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
            connection.close();
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public void delete(Person person) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "DELETE FROM person WHERE cpf = '" + person.getCPF() + "';";
            
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
            connection.close();
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public Person retrieveByCPF(String cpf) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM person WHERE person.cpf LIKE '" + cpf + "';";
            
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {            
                Person person = new Person();
                person.setPersonId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setCPF(rs.getString("cpf"));
                person.setPhone(rs.getString("phone"));
                person.setBirthday(rs.getDate("birthday"));
                person.setDate(rs.getDate("date_register"));
                statement.close();
                rs.close();
                connection.close();

                return person;
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
}
