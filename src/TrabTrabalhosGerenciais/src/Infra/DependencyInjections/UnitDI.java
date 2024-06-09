package Infra.DependencyInjections;

import java.sql.Connection;
import domain.interfaces.repositories.IUnitRepository;
import data.repositories.UnitRepository;

public class UnitDI {
    public IUnitRepository getUnitRepository(Connection con){
        return new UnitRepository(con);
    }
}
