package application.viewModels;

import domain.model.entities.CashRegisterModel;

public class CashRegisterVM {
    public int id;
    public boolean isClosed;
    public double amount;

    public CashRegisterVM(){}
    public CashRegisterVM(int id, boolean isClosed, double amount){
        this.id = id;
        this.isClosed = isClosed;
        this.amount = amount;
    }
}
