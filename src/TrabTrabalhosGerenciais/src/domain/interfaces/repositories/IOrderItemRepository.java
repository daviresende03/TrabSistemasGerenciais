package domain.interfaces.repositories;

import java.sql.SQLException;
import java.util.List;
import domain.model.entities.OrderItemModel;

public interface IOrderItemRepository extends IBaseRepository<OrderItemModel>{
    void deleteByOrderId(int orderId) throws SQLException;
    List<OrderItemModel> selectByOrderId(int orderId) throws SQLException;
}