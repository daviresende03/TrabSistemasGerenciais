package domain.interfaces.repositories;

import java.sql.SQLException;
import java.util.List;

import domain.model.entities.FinanceModel;


public interface IFinanceRepository extends IBaseRepository<FinanceModel>{
    boolean exist(int id) throws SQLException;
    List<FinanceModel> selectByCashRegisterId(int cashRegisterId) throws SQLException;
}
