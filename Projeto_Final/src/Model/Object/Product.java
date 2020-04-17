package Model.Object;

public class Product {
    int productId;
    String name;
    String description;
    double price;
    String barcode;
    String brand;

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPrice(double value){
        this.price = value;
    }
    
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getProductId(){
        return this.productId;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }
    
    public String getBarcode() {
        return this.barcode;
    }
    
    public String getBrand() {
        return this.brand;
    }

    @Override
    public String toString() {
        return "ID: " + getProductId() + " / Name: " + getName() + " / Price: " + getPrice();
    }
}
