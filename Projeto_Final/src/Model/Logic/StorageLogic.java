/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Logic;

import Model.DAO.ProductDAO;
import Model.DAO.StoreDAO;
import Model.Object.Product;
import Model.Object.Store;
import java.util.HashMap;

/**
 *
 * @author user
 */
public class StorageLogic {
    public void addProduct(Product product, int storeId , int amount) throws Exception{
        ProductDAO dao = new ProductDAO();
        StoreDAO storedao = new StoreDAO();
        try{
            int amountp = dao.retrieveStockCount(product);
            amount += amountp;
            Store store = storedao.retrieve(storeId);
            dao.insertIntoStock(product, store, amount);
        } catch(Exception e){
            throw e;
        }
        
    }
    
    public Product searchByBarCode(String barcode) throws Exception {
        ProductDAO dao = new ProductDAO();
        Product product;
        try{
            product = dao.retrieveByBarcode(barcode);
            return product;
        } catch(Exception e){
            throw e;
        }
        
    }
    
    public Product search(int id) throws Exception {
        ProductDAO dao = new ProductDAO();
        Product product;
        try{
            product = dao.retrieve(id);
            return product;
        } catch(Exception e){
            throw e;
        }
        
    }
    
    public int searchItemAmount(int storeId, Product product) throws Exception {
        ProductDAO dao = new ProductDAO();
        Store store = new Store();
        store.setStoreId(storeId);
        try {
            int amount = dao.retrieveStock(store, product);
            return amount;
        } catch(Exception ex) {
            throw ex;
        }
    }
    
    public HashMap<Product, Integer> searchStockByName(String name, int page) throws Exception {
        ProductDAO dao = new ProductDAO();
        HashMap<Product, Integer> map;
        try {
            map = dao.retrieveStockByList(name, page);
            return map;
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    public Product searchByName(String name) throws Exception {
        ProductDAO dao = new ProductDAO();
        Product product;
        try{
            product = dao.retrieveByName(name);
            return product;
        } catch(Exception e){
            throw e;
        }
        
    }
    public int getAmount(Product product) throws Exception{
        ProductDAO dao = new ProductDAO();
        try{
            int i = dao.retrieveStockCount(product);
            return i;
        } catch(Exception e){
            throw e;
        }
            
    }
    public void update(Product product, int storeId, int amount) throws Exception {
        ProductDAO dao = new ProductDAO();
        StoreDAO storedao = new StoreDAO();
        
        try{
            Store store = storedao.retrieve(storeId);
            dao.changeStock(product, store, amount) ;
            
        } catch(Exception e){
            throw e;
        }
    }
    public void delete(Product product, int storeId) throws Exception{
        ProductDAO dao = new ProductDAO();
        StoreDAO storedao = new StoreDAO();
        
        try{
            Store store = storedao.retrieve(storeId);
            dao.deleteFromStock(product, store) ;
            
        } catch(Exception e){
            throw e;
        }
    }
    
}
