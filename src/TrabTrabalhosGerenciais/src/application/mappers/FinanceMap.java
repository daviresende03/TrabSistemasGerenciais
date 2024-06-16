package application.mappers;

import application.viewModels.FinanceVM;
import domain.model.entities.FinanceModel;

import java.util.ArrayList;
import java.util.List;

public class FinanceMap {
    public static FinanceVM getFinanceVM(FinanceModel model){
        return new FinanceVM(model.getId(), model.getCashRegisterId(), model.getType().getValue(), model.getDescription(), model.getValue());
    }

    public static List<FinanceVM> getFinancesVM(List<FinanceModel> models){
        List<FinanceVM> vms = new ArrayList<>();
        for(FinanceModel model : models){
            vms.add(getFinanceVM(model));
        }
        return vms;
    }
}
