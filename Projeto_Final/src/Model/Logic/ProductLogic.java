package Model.Logic;

import java.util.LinkedList;

import Model.Object.Product;
import Model.DAO.ProductDAO;

public class ProductLogic {
    public void SignUp(String name, String description, double value, String barcode, String brand) throws Exception {
        ProductDAO productdao = new ProductDAO();
        Product product;

        product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(value);
        product.setBarcode(barcode);
        product.setBrand(brand);
        try {
            productdao.insert(product);
        } catch(Exception exception) {
            throw new Exception(exception);
        }
    }
    
    public Product searchId(int id){
        ProductDAO productdao = new ProductDAO();
        Product product;
        try{
            product = productdao.retrieve(id);
            return product;
        } catch(Exception e){
            //
        }
        return null;
    }
    
    public Product searchCodebar(String codebar) throws Exception {
        ProductDAO productdao = new ProductDAO();
        Product product;
        try{
            product = productdao.retrieveByBarcode(codebar);
            return product;
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
  
    public LinkedList<Product> search(String argument) throws Exception {
        ProductDAO productdao = new ProductDAO();
        LinkedList<Product> list = new LinkedList<>();
        try {
            list = productdao.retrieveListByName(argument, 10);
            return list;
        } catch(Exception exception) {
            throw exception;
        }
    }
  
    public void update(int productId, String name, String description, double value, String barcode, String brand) throws Exception {
        ProductDAO productdao = new ProductDAO();
        Product product;
        try {
            product = new Product();
            product.setProductId(productId);
            product.setName(name);
            product.setDescription(description);
            product.setPrice(value);
            product.setBarcode(barcode);
            product.setBrand(brand);
            productdao.update(product);
        } catch(Exception exception) {
      	    throw new Exception();
        }	
    }
  
    public void delete(int id) throws Exception {
  	ProductDAO productdao = new ProductDAO();
        Product product;
        try {
      	    product = new Product();
            product.setProductId(id);
            if(product == null){
                throw new Exception();
            } else {
                productdao.delete(product);
            }
        } catch(Exception exception) {
      	    throw new Exception();
        }
    }
}
