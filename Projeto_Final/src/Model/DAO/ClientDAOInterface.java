package Model.DAO;

import Model.Object.Client;
import java.sql.Date;
import java.util.LinkedList;

public interface ClientDAOInterface extends InterfaceDAO<Client> {
    public LinkedList<Client> retrieveAll() throws Exception;
    public LinkedList<Client> retrieveAll(Date start) throws Exception;
    public LinkedList<Client> retrieveAll(Date start, Date end) throws Exception;
    public LinkedList<Client> retrieveAll(String param) throws Exception;
    public LinkedList<Client> retrieveAll(String param, Date start) throws Exception;
    public LinkedList<Client> retrieveAll(String param, Date start, Date end) throws Exception;
    public Client retrieveByCPF(String cpf) throws Exception;
}
