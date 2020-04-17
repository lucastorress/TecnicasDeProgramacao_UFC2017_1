package Model.Object;

public class Carrier {
    int carrierId;
    String name;
    String cnpj;
    
    public void setCarrierId(int carrierId) {
        this.carrierId = carrierId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public int getCarrierId() {
        return this.carrierId;
    }

    public String getName() {
        return this.name;
    }

    public String getCNPJ() {
        return this.cnpj;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + " / CNPJ: " + getCNPJ() + " / ID: " + getCarrierId();
    }
}
