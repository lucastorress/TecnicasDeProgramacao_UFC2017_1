package Model.DAO;

public interface InterfaceDAO<T> {
    public T insert(T object) throws Exception;
    public T retrieve(int id) throws Exception;
    public void update(T object) throws Exception;
    public void delete(T object) throws Exception;
}
