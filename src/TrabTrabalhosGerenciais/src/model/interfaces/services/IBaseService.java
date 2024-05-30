
package model.interfaces.services;

import java.util.ArrayList;
import model.entities.ResponseService;

public interface IBaseService<T> {
    ResponseService insert(T model);
    ResponseService remove(int id);
    ResponseService update(T model);
    ResponseService<T> get(int id);
    ResponseService<ArrayList<T>> getAll();
}
