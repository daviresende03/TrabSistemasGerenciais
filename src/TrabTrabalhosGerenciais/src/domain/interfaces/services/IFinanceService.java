package domain.interfaces.services;

import domain.model.entities.FinanceModel;

import java.util.List;

public interface IFinanceService extends IBaseService<FinanceModel>{
    List<FinanceModel> getAllByCashRegisterId(int cashRegisterId);
}
