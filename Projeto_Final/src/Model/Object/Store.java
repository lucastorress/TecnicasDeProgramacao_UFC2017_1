package Model.Object;

public class Store {
    int storeId;
    String address;
    String phone;

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStoreId() {
        return this.storeId;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhone() {
        return this.phone;
    }

    @Override
    public String toString() {
        return "ID: "+ getStoreId() + " / Phone: " + getPhone();
    }
}
