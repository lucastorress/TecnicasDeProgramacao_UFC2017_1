package Model.Object;

import java.util.HashMap;
import java.util.Date;

public class Sale {
    int saleId;
    int clientId;
    int userId;
    boolean needCarrier;
    int status;
    double value;
    HashMap<Product, Integer> items;
    Date dateTimeOfPurchase;

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCarrier(boolean needCarrier) {
        this.needCarrier = needCarrier;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public void setValue(double value) {
        this.value = value;
    }
    
    public void setItems(HashMap<Product, Integer> items) {
        this.items = items;
    }
    
    public void setDate(Date date) {
        this.dateTimeOfPurchase = date;
    }

    public int getSaleId() {
        return this.saleId;
    }

    public int getClientId() {
        return this.clientId;
    }

    public int getUserId() {
        return this.userId;
    }

    public boolean getCarrier() {
        return this.needCarrier;
    }

    public int getStatus() {
        return this.status;
    }

    public double getValue() {
        return this.value;
    }
    
    public HashMap<Product, Integer> getItems() {
        return this.items;
    }

    public Date getDate() {
        return this.dateTimeOfPurchase;
    }

    @Override
    public String toString() {
        String retorno = "ID: " + getSaleId() + " / Vendedor ID: " + getUserId() + " / Cliente: " + (getClientId() == -1 ? "Não cadastrado" : getClientId());
        for (Product product:getItems().keySet()){
            retorno += "\n        ";
            retorno += "ID do Produto: " + product.getProductId() + " / ";
            retorno += "Nome: " + product.getName() + " / ";
            retorno += "Quantidade: " + getItems().get(product) + " / ";
            retorno += "Preço: " + product.getPrice();
        }
        return retorno;
    }
    
    public String toStringGuest() {
        String retorno = "ID: " + getSaleId() + " / Vendedor ID: " + getUserId() + " / Cliente: Não registrado.";
        for (Product product:getItems().keySet()){
            retorno += "\n        ";
            retorno += "ID do Produto: " + product.getProductId() + " / ";
            retorno += "Nome: " + product.getName() + " / ";
            retorno += "Quantidade: " + getItems().get(product) + " / ";
            retorno += "Preço: " + product.getPrice();
        }
        return retorno;
    }
}
