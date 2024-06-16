package domain.interfaces.services;

import domain.model.entities.CashRegisterModel;

public interface ICashRegisterService extends IBaseService<CashRegisterModel>{
    CashRegisterModel open();
    void close(int id);
    boolean existCashRegisterOpen();
    int selectIdThatStatusIsOpen();
}
