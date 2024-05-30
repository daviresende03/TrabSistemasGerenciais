package Infra.DependencyInjection;

import java.sql.Connection;
import model.interfaces.repositories.IUnitRepository;
import repository.UnitRepository;

public class UnitDI {
    public IUnitRepository getUnitRepository(Connection con){
        return new UnitRepository(con);
    }
}
