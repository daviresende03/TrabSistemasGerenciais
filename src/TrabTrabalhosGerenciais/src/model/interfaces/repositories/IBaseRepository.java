package model.interfaces.repositories;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IBaseRepository<T> {
    void insert(T model) throws SQLException;
    void update(T model) throws SQLException;
    void delete(int id) throws SQLException;
    T select(int id) throws SQLException;
    List<T> select() throws SQLException;
}
