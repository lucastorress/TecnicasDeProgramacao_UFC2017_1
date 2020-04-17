package Model.DAO;

import Model.Object.Store;
import java.util.LinkedList;

import Model.Object.User;

public interface UserDAOInterface extends InterfaceDAO<User> {
    public LinkedList<User> retrieveAll() throws Exception;
    public LinkedList<User> retrieveAll(Store store) throws Exception;
    public User retrieveByUsername(String username) throws Exception;
    public User retrieveByCPF(String cpf) throws Exception;
    public String retrievePassword(String username) throws Exception;
}
