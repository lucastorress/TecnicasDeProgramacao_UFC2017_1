package Model.DAO;

import Model.Object.Store;
import java.util.LinkedList;

public interface StoreDAOInterface extends InterfaceDAO<Store> {
    public LinkedList<Store> retrieveAll() throws Exception;
}
