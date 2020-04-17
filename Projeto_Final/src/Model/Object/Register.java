package Model.Object;

import java.util.Date;

public class Register {
    int registerId;
    int storeId;
    int salesToday;
    double cashRegister;
    Date date;

    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }
    
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
    
    public void setSalesToday(int salesToday) {
        this.salesToday = salesToday;
    }
    
    public void setCashRegister(double cashRegister) {
        this.cashRegister = cashRegister;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public int getRegisterId() {
        return this.registerId;
    }
    
    public int getStoreId() {
        return this.storeId;
    }
    
    public int getSalesToday() {
        return this.salesToday;
    }
    
    public double getCashRegister() {
        return this.cashRegister;
    }
    
    public Date getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return "ID: " + getRegisterId() + " / Store: " + getStoreId() + " / Cash: " + getCashRegister();
    }
}
