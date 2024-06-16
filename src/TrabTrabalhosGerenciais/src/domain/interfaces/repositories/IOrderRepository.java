package domain.interfaces.repositories;

import domain.model.entities.OrderModel;

import java.sql.SQLException;
import java.util.List;

public interface IOrderRepository extends IBaseRepository<OrderModel> {
    List<OrderModel> select(boolean invoiced) throws SQLException;
    int count(boolean invoiced) throws SQLException;
    int countCanceleds() throws SQLException;
    void invoice(OrderModel order) throws SQLException;
    void cancel(int id) throws SQLException;
}
