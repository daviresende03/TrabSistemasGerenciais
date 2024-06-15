package controllers;

import application.applications.CashRegisterApplication;
import application.viewModels.CashRegisterVM;
import data.context.DataContext;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.services.ICashRegisterService;
import domain.model.entities.ResponseService;
import domain.services.CashRegisterService;
import infra.dependencyInjections.CashRegisterDI;

public class CashRegisterController {
    private final CashRegisterApplication cashRegisterApplication;

    public CashRegisterController(){
        CashRegisterDI cashRegisterDI = new CashRegisterDI();
        IDataContext dataContext = new DataContext();
        ICashRegisterService cashRegisterService = new CashRegisterService(
                dataContext,
                cashRegisterDI.getCashRegisterRepository(dataContext.getConnection())
        );

        this.cashRegisterApplication = new CashRegisterApplication(cashRegisterService);
    }

    public ResponseService getResponseService(){
        return cashRegisterApplication.getResponseService();
    }

    public void close(int id){
        this.cashRegisterApplication.close(id);
    }

    public CashRegisterVM open(){
        return this.cashRegisterApplication.open();
    }

}
