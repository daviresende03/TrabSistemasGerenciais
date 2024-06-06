package domain.interfaces.repositories;

import java.sql.SQLException;
import domain.model.entities.UnitModel;

public interface IUnitRepository extends IBaseRepository<UnitModel>{
    UnitModel select(String name) throws SQLException;
    boolean exist(String name) throws SQLException;
    boolean exist(int id) throws SQLException;
}
