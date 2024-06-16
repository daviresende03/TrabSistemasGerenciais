package application.applications;

import application.mappers.FinanceMap;
import application.viewModels.FinanceVM;
import domain.interfaces.services.IFinanceService;
import domain.model.entities.FinanceModel;
import domain.model.entities.ResponseService;
import java.util.ArrayList;
import java.util.List;
import domain.model.enums.FinanceTypeEnum;

public class FinanceApplication {
    private final IFinanceService financeService;
    
    public FinanceApplication(IFinanceService financeService){
        this.financeService = financeService;
    }
    
    public ResponseService getResponseService(){
        return financeService.getResponseService();
    }
    
    public void create(FinanceVM financeVM){
        FinanceModel financeModel = new FinanceModel(financeVM.cashRegisterId, financeVM.type, financeVM.value, financeVM.description);
        financeService.insert(financeModel);
    }
    
    public void delete(int id){
        financeService.remove(id);
    }
    
    public List<FinanceVM> getAll(){
        return FinanceMap.getFinancesVM(this.financeService.getAll());
    }

    public List<FinanceVM> getAllByCashRegisterId(int cashRegisterId){
        return FinanceMap.getFinancesVM(this.financeService.getAllByCashRegisterId(cashRegisterId));
    }
}
