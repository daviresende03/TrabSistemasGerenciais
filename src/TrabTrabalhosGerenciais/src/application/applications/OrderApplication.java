package application.applications;

import application.mappers.OrderMap;
import application.viewModels.OrderVM;
import domain.interfaces.services.IOrderService;
import domain.model.entities.OrderModel;
import domain.model.entities.ResponseService;

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
        orderModel.setInvoiced(false);

        this.orderService.insert(orderModel);
    }
}
