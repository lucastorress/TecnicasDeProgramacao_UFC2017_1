package Model.DAO;

import java.util.LinkedList;
import java.util.HashMap;

import Model.Object.Product;
import Model.Object.Sale;
import Model.Object.Store;

public interface ProductDAOInterface extends InterfaceDAO<Product> {
    public void insertIntoStock(Product product, Store store, int amount) throws Exception;
    public void insertIntoItem(Sale sale, Product product, int amount) throws Exception;
    public HashMap<Product, Integer> retrieveStock() throws Exception;
    public HashMap<Product, Integer> retrieveStock(Store store) throws Exception;
    public HashMap<Product, Integer> retrieveSaleItems(Sale sale) throws Exception;
    public LinkedList<Product> retrieveListByName(String param, int page) throws Exception;
    public HashMap<Product, Integer> retrieveStockByList(String param, int page) throws Exception;
}
