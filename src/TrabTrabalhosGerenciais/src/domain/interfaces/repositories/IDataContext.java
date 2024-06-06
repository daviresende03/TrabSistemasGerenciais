package domain.interfaces.repositories;

import java.sql.Connection;

public interface IDataContext {
    Connection getConnection();
    void commit();
    void rollback();
    void close();
}
