package controllers;

import application.applications.FinanceApplication;
import application.viewModels.FinanceVM;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.services.IFinanceService;
import domain.model.entities.ResponseService;
import infra.dependencyInjections.CashRegisterDI;
import infra.dependencyInjections.FinanceDI;
import java.util.List;

public class FinanceController {
    private final FinanceApplication financeApplication;
    
    public FinanceController() {
        FinanceDI financeDependencyInjection = new FinanceDI();
        CashRegisterDI cashRegisterDependencyInjection = new CashRegisterDI();
        IDataContext dataContext = financeDependencyInjection.getDataContext();
        IFinanceService financeService = financeDependencyInjection.getFinanceService(
                dataContext,
                financeDependencyInjection.getFinanceRepository(dataContext.getConnection()),
                cashRegisterDependencyInjection.getCashRegisterRepository(dataContext.getConnection()));
        
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
    
    public List<FinanceVM> getAll(){
        return financeApplication.getAll();
    }

    public List<FinanceVM> getAllByCashRegisterId(int cashRegisterId){
        return this.financeApplication.getAllByCashRegisterId(cashRegisterId);
    }
}
