package application.applications;

import application.mappers.OrderMap;
import application.viewModels.OrderVM;
import domain.interfaces.services.IOrderService;
import domain.model.entities.OrderModel;
import domain.model.entities.ResponseService;

import java.util.List;

public class OrderApplication {
    private final IOrderService orderService;
    
    public OrderApplication(IOrderService orderService){
        this.orderService = orderService;
    }
    
    public ResponseService getResponseService(){
        return orderService.getResponseService();
    }
    
    public void create(OrderVM orderVM){
        OrderModel orderModel = OrderMap.getOrderModel(orderVM);
        this.orderService.insert(orderModel);
    }

    public List<OrderVM> getAll(boolean invoiced){
        return OrderMap.getOrderVM(this.orderService.getAll(invoiced));
    }

    public void invoice(int id){
        this.orderService.invoice(id);
    }

    public int count(boolean invoiced){
        return this.orderService.count(invoiced);
    }

    public OrderVM get(int id){
        return OrderMap.getOrderVM(this.orderService.get(id));
    }
}
