package Model.DAO;

import Model.Object.Register;
import java.util.LinkedList;

public interface RegisterDAOInterface extends InterfaceDAO<Register> {
    public LinkedList<Register> retrieveAll() throws Exception;
}
