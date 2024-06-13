package domain.interfaces.repositories;

import java.sql.SQLException;
import domain.model.entities.PersonModel;
import java.util.List;

public interface IPersonRepository extends IBaseRepository<PersonModel>{
    PersonModel select(String document) throws SQLException;
    List<PersonModel> select(boolean isCustomer, boolean isStaff, boolean isSupplier) throws SQLException;
    boolean exist(int id) throws SQLException;
}
