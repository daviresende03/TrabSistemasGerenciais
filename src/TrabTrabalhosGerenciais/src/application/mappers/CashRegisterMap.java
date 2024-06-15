package application.mappers;

import application.viewModels.CashRegisterVM;
import domain.model.entities.CashRegisterModel;

public class CashRegisterMap {
    public static CashRegisterVM getCashRegisterVM(CashRegisterModel model){
        return new CashRegisterVM(model.getId(), model.getIsClosed(), model.getAmount());
    }

}
