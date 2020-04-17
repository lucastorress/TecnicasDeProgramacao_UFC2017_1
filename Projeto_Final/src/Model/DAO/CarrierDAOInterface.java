package Model.DAO;

import Model.Object.Carrier;
import java.util.LinkedList;

public interface CarrierDAOInterface extends InterfaceDAO<Carrier> {
    public LinkedList<Carrier> retrieveAll() throws Exception;
}
