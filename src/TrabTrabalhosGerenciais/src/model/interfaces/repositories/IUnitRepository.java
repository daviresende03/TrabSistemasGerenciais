package model.interfaces.repositories;

import java.sql.SQLException;
import model.entities.UnitModel;

public interface IUnitRepository extends IBaseRepository<UnitModel>{
    UnitModel select(String name) throws SQLException;
}