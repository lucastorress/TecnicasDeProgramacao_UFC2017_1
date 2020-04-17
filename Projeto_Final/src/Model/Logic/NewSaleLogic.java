package Model.Logic;

import Model.Object.Client;
import Model.Object.Product;
import Model.Object.Sale;
import Model.Object.User;

import Model.DAO.ClientDAO;
import Model.DAO.ProductDAO;
import Model.DAO.SaleDAO;
import Model.DAO.UserDAO;

import java.util.HashMap;

public class NewSaleLogic {
    public HashMap<Product, Integer> products;
    
    public void addProduct(int n, Product product){
        products.put(product, n);
    }
    public void deleteProduct(String codebar){
        for(Product product : products.keySet()) {
            if(product.getBarcode().equals(codebar)) {
                products.remove(product);
            }
        }
    }
    public void cancelSale(){
        products.clear();
    }
    public void changeProduct(int n, Product product){
        products.put(product, n);
    }
    public double getTotal() {
        double var = 0;
        for(Product product : products.keySet()) {
            var += product.getPrice() * products.get(product);
        }
        return var;
    }
    public void finishSale(String cpf, int sellerId, boolean carrier) throws Exception{
        ClientDAO clientdao = new ClientDAO();
        SaleDAO saledao = new SaleDAO();
        ProductDAO productdao = new ProductDAO();
        Sale sale = new Sale();
        Client client = new Client();
        try{
            client = clientdao.retrieveByCPF(cpf);
            if(client == null) {
                client = new Client();
                client.setClientId(-1);
            }
        } catch (Exception ex) {
        
        }
        if(client == null) {
            sale.setClientId(-1);
        } else {
            sale.setClientId(client.getClientId());
        }
        sale.setUserId(sellerId);
        sale.setCarrier(carrier);
        sale.setValue(getTotal());
        sale.setStatus(1); //0 - Não concluida / 1 - Finalizada
        try{
            sale = saledao.insert(sale);
            for(Product product : products.keySet()) {
                productdao.insertIntoItem(sale, product, products.get(product));
            }
            products.clear();
        } catch(Exception e) {
            throw e;
        }
    }
}
