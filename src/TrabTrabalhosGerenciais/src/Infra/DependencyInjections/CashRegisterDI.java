package infra.dependencyInjections;

import data.context.DataContext;
import data.repositories.CashRegisterRepository;
import domain.interfaces.repositories.ICashRegisterRepository;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.services.ICashRegisterService;
import domain.services.CashRegisterService;

import java.sql.Connection;

public class CashRegisterDI {
    public IDataContext getDataContext(){
        return new DataContext();
    }

    public ICashRegisterRepository getCashRegisterRepository(Connection con){
        return new CashRegisterRepository(con);
    }

    public ICashRegisterService getCashRegisterService(IDataContext dataContext, ICashRegisterRepository cashRegisterRepository){
        return new CashRegisterService(dataContext, cashRegisterRepository);
    }
}
