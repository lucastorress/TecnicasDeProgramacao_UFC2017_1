package Model.DAO;

import Model.Object.Person;

public interface PersonDAOInterface extends InterfaceDAO<Person> {
    public Person retrieveByCPF(String cpf) throws Exception;
}
