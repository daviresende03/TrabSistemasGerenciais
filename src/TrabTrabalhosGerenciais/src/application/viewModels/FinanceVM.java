package application.viewModels;

import domain.model.entities.FinanceModel;

public class FinanceVM {
    public int type;
    public double value;
    public String description;
    
    public FinanceVM(){}
    
    public FinanceVM(FinanceModel financeModel){
        type = financeModel.getType();
        value = financeModel.getValue();
        description = financeModel.getDescription();
    }
}
