package model.interfaces.repositories;

import java.sql.SQLException;
import model.entities.PersonModel;

public interface IPersonRepository extends IBaseRepository<PersonModel>{
    PersonModel select(String document) throws SQLException;
    boolean exist(int id) throws SQLException;
}
