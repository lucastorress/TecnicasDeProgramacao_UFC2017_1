package Model.Logic;

import Model.DAO.StoreDAO;
import Model.Object.Store;

public class StoreLogic {
    public Store search(int id) throws Exception {
        StoreDAO dao = new StoreDAO();
        try {
            Store store = dao.retrieve(id);
            return store;
        } catch(Exception ex) {
            throw ex;
        }
    }
    
    public void update(int id, String address, String phone) throws Exception {
        StoreDAO dao = new StoreDAO();
        try {
            Store store = new Store();
            store.setStoreId(id);
            store.setAddress(address);
            store.setPhone(phone);
            dao.update(store);
        } catch(Exception ex) {
            throw ex;
        }
    }
    
    public void delete(int id) throws Exception {
        StoreDAO dao = new StoreDAO();
        try {
            Store store = new Store();
            store.setStoreId(id);
            dao.delete(store);
        } catch(Exception ex) {
            throw ex;
        }
    }
    
    public Store signUp(String address, String phone) throws Exception {
        StoreDAO dao = new StoreDAO();
        try {
            Store store = new Store();
            store.setAddress(address);
            store.setPhone(phone);
            store = dao.insert(store);
            return store;
        } catch(Exception ex) {
            throw ex;
        }
    }
}
