package infra.dependencyInjections;

import data.context.DataContext;
import data.repositories.OperatorRepository;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.repositories.IOperatorRepository;
import domain.interfaces.services.IOperatorService;
import domain.services.OperatorService;

import java.sql.Connection;

public class OperatorDI {
    public IDataContext getDataContext(){
        return new DataContext();
    }

    public IOperatorRepository geOperatorRepository(Connection con){
        return new OperatorRepository(con);
    }

    public IOperatorService getOperatorService(IDataContext dataContext, IOperatorRepository operatorRepository){
        return new OperatorService(dataContext, operatorRepository);
    }
}
