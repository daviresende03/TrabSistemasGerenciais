package infra.dependencyInjections;

import data.context.DataContext;
import java.sql.Connection;
import domain.interfaces.repositories.IUnitRepository;
import data.repositories.UnitRepository;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.services.IUnitService;
import domain.services.UnitService;

public class UnitDI {
    public IDataContext getDataContext(){
       return new DataContext(); 
    }
    
    public IUnitRepository getUnitRepository(Connection con){
        return new UnitRepository(con);
    }
    
    public IUnitService getUnitService(IDataContext dataContext, IUnitRepository unitRepository){
        return new UnitService(dataContext, unitRepository);
    }
}
