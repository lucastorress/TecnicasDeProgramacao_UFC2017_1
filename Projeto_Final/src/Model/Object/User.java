package Model.Object;

public class User extends Person {
    int userId;
    int storeId;
    String username;
    String password;
    boolean admin;

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public int getUserId() {
        return this.userId;
    }
    
    public int getStoreId() {
        return this.storeId;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean getAdmin() {
        return this.admin;
    }

    @Override
    public String toString() {
        if(this.admin)
            return super.toString()+ " / Administrator";
        else
            return super.toString();
    }
}
