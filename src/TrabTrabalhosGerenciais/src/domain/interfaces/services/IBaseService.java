
package domain.interfaces.services;

import java.util.List;
import domain.model.entities.ResponseService;

public interface IBaseService<T> {
    void insert(T model);
    void remove(int id);
    void update(T model);
    T get(int id);
    List<T> getAll();
    ResponseService getResponseService();
}
