package domain.interfaces.services;

import domain.model.entities.OrderModel;

import java.util.List;


public interface IOrderService extends IBaseService<OrderModel>{
    List<OrderModel> getAll(boolean invoiced);
    void invoice(int id);
}
