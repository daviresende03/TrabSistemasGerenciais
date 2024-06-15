package infra.dependencyInjections;

import data.context.DataContext;
import data.repositories.FinanceRepository;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.repositories.IFinanceRepository;
import domain.interfaces.services.IFinanceService;
import domain.services.FinanceService;
import java.sql.Connection;

public class FinanceDI {
    public IDataContext getDataContext(){
       return new DataContext(); 
    }
    
    public IFinanceRepository getFinanceRepository(Connection con){
        return new FinanceRepository(con);
    }
    
    public IFinanceService getFinanceService(IDataContext dataContext, IFinanceRepository unitRepository){
        return new FinanceService(dataContext, unitRepository);
    }
}
