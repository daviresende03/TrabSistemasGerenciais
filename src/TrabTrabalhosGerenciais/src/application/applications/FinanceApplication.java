package application.applications;

import application.mappers.FinanceMap;
import application.viewModels.FinanceVM;
import domain.interfaces.services.IFinanceService;
import domain.model.entities.ResponseService;
import java.util.List;

public class FinanceApplication {
    private final IFinanceService financeService;
    
    public FinanceApplication(IFinanceService financeService){
        this.financeService = financeService;
    }
    
    public ResponseService getResponseService(){
        return financeService.getResponseService();
    }
    
    public void create(FinanceVM financeVM){
        financeService.insert(FinanceMap.getFinanceModel(financeVM));
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
