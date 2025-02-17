package daos;

import java.sql.Connection;
import java.util.List;

public abstract class Dao<T>{

    public final Connection connection;

    public Dao(Connection connection){
        super();
        this.connection = connection;
    }

    public abstract T findById(int id);

    public abstract List<T> findAll();

    public abstract T create(T dto);

    public abstract T update(T dto);

    public abstract void delete(int id);

}
