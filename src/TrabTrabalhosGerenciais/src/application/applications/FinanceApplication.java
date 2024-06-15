package application.applications;

import application.viewModels.FinanceVM;
import domain.interfaces.services.IFinanceService;
import domain.model.entities.FinanceModel;
import domain.model.entities.ResponseService;

public class FinanceApplication {
    private final IFinanceService financeService;
    
    public FinanceApplication(IFinanceService financeService){
        this.financeService = financeService;
    }
    
    public ResponseService getResponseService(){
        return financeService.getResponseService();
    }
    
    public void create(FinanceVM financeVM){
        FinanceModel financeModel = new FinanceModel(financeVM.type, financeVM.value, financeVM.description);
        financeService.insert(financeModel);
    }
    
    public void delete(int id){
        financeService.remove(id);
    }
}
