package domain.interfaces.repositories;

import domain.model.entities.CashRegisterModel;

public interface ICashRegisterRepository extends IBaseRepository<CashRegisterModel>{
    boolean existOpenCashRegister();
}
