package controllers;

import application.applications.FinanceApplication;
import application.viewModels.FinanceVM;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.services.IFinanceService;
import domain.model.entities.ResponseService;
import infra.dependencyInjections.FinanceDI;

public class FinanceController {
    private final FinanceApplication financeApplication;
    
    public FinanceController() {
        FinanceDI financeDependencyInjection = new FinanceDI();
        IDataContext dataContext = financeDependencyInjection.getDataContext();
        IFinanceService financeService = financeDependencyInjection.getFinanceService(dataContext, financeDependencyInjection.getFinanceRepository(dataContext.getConnection()));
        
        financeApplication = new FinanceApplication(financeService);
    }
    
    public ResponseService getResponseService(){
        return financeApplication.getResponseService();
    } 
    
    public void create(FinanceVM financeVM){
        financeApplication.create(financeVM);
    }
    
    public void delete(int id){
        this.financeApplication.delete(id);
    }
}
