package application.applications;

import application.mappers.CashRegisterMap;
import application.viewModels.CashRegisterVM;
import domain.interfaces.services.ICashRegisterService;
import domain.model.entities.ResponseService;

public class CashRegisterApplication {
    private final ICashRegisterService cashRegisterService;

    public CashRegisterApplication(ICashRegisterService cashRegisterService){
        this.cashRegisterService = cashRegisterService;
    }

    public ResponseService getResponseService(){
        return cashRegisterService.getResponseService();
    }

    public void close(int id){
        this.cashRegisterService.close(id);
    }

    public CashRegisterVM open(){
        return CashRegisterMap.getCashRegisterVM(this.cashRegisterService.open());
    }

    public boolean existOpen(){
        return this.cashRegisterService.existCashRegisterOpen();
    }

    public int getIdCashIsOpen(){
        return this.cashRegisterService.selectIdThatStatusIsOpen();
    }
}
