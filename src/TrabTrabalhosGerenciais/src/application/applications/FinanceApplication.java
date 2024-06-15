package application.applications;

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
        FinanceModel financeModel = new FinanceModel(financeVM.type, financeVM.value, financeVM.description);
        financeService.insert(financeModel);
    }
    
    public void delete(int id){
        financeService.remove(id);
    }
    
    public List<FinanceVM> getAll(){
        List<FinanceModel> registersModel = financeService.getAll();
        List<FinanceVM> registersVM = new ArrayList<FinanceVM>();
        for(FinanceModel financeModel : registersModel){
            registersVM.add(new FinanceVM(financeModel));
        }
        return registersVM;
    }
}
