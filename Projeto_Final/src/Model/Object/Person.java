package Model.Object;

import java.util.Date;

public class Person {
    int personId;
    String name;
    String cpf;
    String phone;
    Date birthday;
    Date registerDate;

    public void setPersonId(int id) {
        this.personId = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBirthday(Date data) {
        this.birthday = data;
    }
    
    public void setDate(Date date) {
        this.registerDate = date;
    }
    
    public int getPersonId() {
        return this.personId;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getCPF() {
        return this.cpf;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public Date getBirthday() {
        return this.birthday;
    }
    
    public Date getDate() {
        return this.registerDate;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + " / ID: " + getPersonId() + " / Phone: " + getPhone();
    }
}
