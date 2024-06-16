package application.viewModels;

import domain.model.entities.FinanceModel;

public class FinanceVM {
    public int id;
    public int cashRegisterId;
    public int type;
    public double value;
    public String description;
    
    public FinanceVM(){}

    public FinanceVM(int id, int cashRegisterId, int type, String description, double value){
        this.id = id;
        this.cashRegisterId = cashRegisterId;
        this.type = type;
        this.description = description;
        this.value = value;
    }
}
