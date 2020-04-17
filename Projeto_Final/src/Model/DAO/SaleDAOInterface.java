package Model.DAO;

import Model.Object.Sale;
import Model.Object.Store;
import java.util.LinkedList;

public interface SaleDAOInterface extends InterfaceDAO<Sale> {
    public LinkedList<Sale> retrieveAll() throws Exception;
    public LinkedList<Sale> retrieveAll(Store store) throws Exception;
    public LinkedList<Sale> retrieveDailyAll() throws Exception;
    public LinkedList<Sale> retrieveDailyAll(Store store) throws Exception;
}
