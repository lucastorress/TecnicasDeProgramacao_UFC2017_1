package Model.DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;;
import java.sql.Date;

import static Utility.SQLConnection.SQLConnection;

import Model.Object.Client;
import Model.Object.Person;
import java.sql.ResultSetMetaData;
import java.util.LinkedList;

public class ClientDAO implements ClientDAOInterface {
    @Override
    public Client insert(Client client) throws Exception {
        PreparedStatement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            
            Person person = new Person();
            person.setName(client.getName());
            person.setCPF(client.getCPF());
            person.setPhone(client.getPhone());
            person.setBirthday(client.getBirthday());
            PersonDAO persondao = new PersonDAO();
            person = persondao.insert(person);
            
            query = "INSERT INTO client (ref_person) VALUES (";
            query += "'" + person.getCPF() + "'" + ");";
            
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
            connection.commit();
            
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            
            client.setClientId(rs.getInt("GENERATED_KEY"));
            
            statement.close();
            connection.close();
            
            return client;
        } catch(Exception exception) {
            throw exception;
        }
    }

    @Override
    public Client retrieve(int id) throws Exception {
        Statement statement;
        String query;

        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();

            query = "SELECT * FROM client INNER JOIN person ON client.id LIKE '" + id + "' AND person.cpf = client.ref_person;";

            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {
                Client client = new Client();
                client.setClientId(rs.getInt("id"));
                client.setPersonId(rs.getInt("ref_person"));
                client.setName(rs.getString("name"));
                client.setCPF(rs.getString("cpf"));
                client.setPhone(rs.getString("phone"));
                client.setBirthday(rs.getDate("birthday"));
                client.setDate(rs.getDate("date_register"));

                statement.close();
                rs.close();
                connection.close();

                return client;
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
    public void update(Client client) throws Exception {
        Person person = new Person();
        person.setName(client.getName());
        person.setCPF(client.getCPF());
        person.setPhone(client.getPhone());
        person.setBirthday(client.getBirthday());
        
        PersonDAO persondao = new PersonDAO();
        persondao.update(person);
    }

    @Override
    public void delete(Client client) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            Person person = new Person();
            person.setCPF(client.getCPF());
            PersonDAO persondao = new PersonDAO();
            
            query = "DELETE FROM client WHERE ref_person = '" + client.getCPF() + "';";
            
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
    public LinkedList<Client> retrieveAll() throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM client INNER JOIN person ON person.cpf = client.ref_person;";
            
            LinkedList<Client> clients = new LinkedList<>();
            Client temp;
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                temp = new Client();
                temp.setClientId(rs.getInt("id"));
                temp.setPersonId(rs.getInt("ref_person"));
                temp.setName(rs.getString("name"));
                temp.setCPF(rs.getString("cpf"));
                temp.setPhone(rs.getString("phone"));
                temp.setBirthday(rs.getDate("birthday"));
                temp.setDate(rs.getDate("date_register"));
                clients.add(temp);
            }
            statement.close();
            rs.close();
            connection.close();
            
            return clients;
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public LinkedList<Client> retrieveAll(Date start) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM client INNER JOIN person ON " +
                    "person.date_register => " + start.toString() + 
                    " AND person.cpf = user.ref_person;";
            
            LinkedList<Client> clients = new LinkedList<>();
            Client temp;
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                temp = new Client();
                temp.setClientId(rs.getInt("id"));
                temp.setPersonId(rs.getInt("ref_person"));
                temp.setName(rs.getString("name"));
                temp.setCPF(rs.getString("cpf"));
                temp.setPhone(rs.getString("phone"));
                temp.setBirthday(rs.getDate("birthday"));
                temp.setDate(rs.getDate("register_date"));
                clients.add(temp);
            }
            statement.close();
            rs.close();
            connection.close();
            
            return clients;
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public LinkedList<Client> retrieveAll(Date start, Date end) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM client INNER JOIN person ON " +
                    "person.date_register >= " + start.toString() +
                    " AND person.date_register <= " + end.toString() +
                    " AND person.cpf = user.ref_person;";
            
            LinkedList<Client> clients = new LinkedList<>();
            Client temp;
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                temp = new Client();
                temp.setClientId(rs.getInt("id"));
                temp.setPersonId(rs.getInt("ref_person"));
                temp.setName(rs.getString("name"));
                temp.setCPF(rs.getString("cpf"));
                temp.setPhone(rs.getString("phone"));
                temp.setBirthday(rs.getDate("birthday"));
                temp.setDate(rs.getDate("register_date"));
                clients.add(temp);
            }
            statement.close();
            rs.close();
            connection.close();
            
            return clients;
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public LinkedList<Client> retrieveAll(String param) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM client INNER JOIN person ON " + 
                    "client.name LIKE '%" + param + "%'" +
                    " AND person.cpf = user.ref_person;";
            
            LinkedList<Client> clients = new LinkedList<>();
            Client temp;
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                temp = new Client();
                temp.setClientId(rs.getInt("id"));
                temp.setPersonId(rs.getInt("ref_person"));
                temp.setName(rs.getString("name"));
                temp.setCPF(rs.getString("cpf"));
                temp.setPhone(rs.getString("phone"));
                temp.setBirthday(rs.getDate("birthday"));
                temp.setDate(rs.getDate("register_date"));
                clients.add(temp);
            }
            statement.close();
            rs.close();
            connection.close();
            
            return clients;
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public LinkedList<Client> retrieveAll(String param, Date start) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM user INNER JOIN person ON " +
                    "client.name LIKE '%" + param + "%'" +
                    " AND person.date_register => " + start.toString() + 
                    " AND person.cpf = user.ref_person;";
            
            LinkedList<Client> clients = new LinkedList<>();
            Client temp;
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                temp = new Client();
                temp.setClientId(rs.getInt("id"));
                temp.setPersonId(rs.getInt("ref_person"));
                temp.setName(rs.getString("name"));
                temp.setCPF(rs.getString("cpf"));
                temp.setPhone(rs.getString("phone"));
                temp.setBirthday(rs.getDate("birthday"));
                temp.setDate(rs.getDate("register_date"));
                clients.add(temp);
            }
            statement.close();
            rs.close();
            connection.close();
            
            return clients;
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public LinkedList<Client> retrieveAll(String param, Date start, Date end) throws Exception {
        Statement statement;
        String query;
        
        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();
            
            query = "SELECT * FROM user INNER JOIN person ON " +
                    "client.name LIKE '%" + param + "%'" +
                    " AND person.date_register => " + start.toString() +
                    " AND person.date_register <= " + end.toString() +
                    " AND person.cpf = user.ref_person;";
            
            LinkedList<Client> clients = new LinkedList<>();
            Client temp;
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                temp = new Client();
                temp.setClientId(rs.getInt("id"));
                temp.setPersonId(rs.getInt("ref_person"));
                temp.setName(rs.getString("name"));
                temp.setCPF(rs.getString("cpf"));
                temp.setPhone(rs.getString("phone"));
                temp.setBirthday(rs.getDate("birthday"));
                temp.setDate(rs.getDate("register_date"));
                clients.add(temp);
            }
            statement.close();
            rs.close();
            connection.close();
            
            return clients;
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    @Override
    public Client retrieveByCPF(String cpf) throws Exception {
        Statement statement;
        String query;

        try {
            Connection connection = SQLConnection();
            statement = connection.createStatement();

            query = "SELECT * FROM client INNER JOIN person ON person.cpf LIKE '" + cpf + "' AND person.cpf = client.ref_person;";

            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {
                Client client = new Client();
                client.setClientId(rs.getInt("id"));
                client.setPersonId(rs.getInt("ref_person"));
                client.setName(rs.getString("name"));
                client.setCPF(rs.getString("cpf"));
                client.setPhone(rs.getString("phone"));
                client.setBirthday(rs.getDate("birthday"));
                client.setDate(rs.getDate("date_register"));

                statement.close();
                rs.close();
                connection.close();

                return client;
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
