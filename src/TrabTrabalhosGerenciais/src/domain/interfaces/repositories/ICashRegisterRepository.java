package domain.interfaces.repositories;

import domain.model.entities.CashRegisterModel;

import java.sql.SQLException;

public interface ICashRegisterRepository extends IBaseRepository<CashRegisterModel>{
    int selectIdThatStatusIsOpen();
    void updateAmount(CashRegisterModel model) throws SQLException;
}
