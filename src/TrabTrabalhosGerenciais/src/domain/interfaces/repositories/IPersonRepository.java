package domain.interfaces.repositories;

import java.sql.SQLException;
import domain.model.entities.PersonModel;

public interface IPersonRepository extends IBaseRepository<PersonModel>{
    PersonModel select(String document) throws SQLException;
    boolean exist(int id) throws SQLException;
}
