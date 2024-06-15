package controllers;

import application.applications.OrderApplication;
import application.viewModels.OrderVM;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.services.IOrderService;
import domain.model.entities.ResponseService;
import domain.services.OrderService;
import infra.dependencyInjections.OrderDI;
import infra.dependencyInjections.PersonDI;
import infra.dependencyInjections.ProductDI;

import java.util.List;

public class OrderController {
    private final OrderApplication orderApplication;

    public OrderController() {
        OrderDI orderDependencyInjection = new OrderDI();
        PersonDI personDependencyInjection = new PersonDI();
        ProductDI productDependencyInjection = new ProductDI();
        IDataContext dataContext = orderDependencyInjection.getDataContext();
        IOrderService orderService = new OrderService(dataContext,
                orderDependencyInjection.getOrderRepository(dataContext.getConnection()),
                orderDependencyInjection.getOrderItemRepository(dataContext.getConnection()),
                personDependencyInjection.getPersonRepository(dataContext.getConnection()),
                productDependencyInjection.getProductRepository(dataContext.getConnection()));

        orderApplication = new OrderApplication(orderService);
    }

    public ResponseService getResponseService(){
        return orderApplication.getResponseService();
    }

    public void create(OrderVM orderVM){
        orderApplication.create(orderVM);
    }

    public List<OrderVM> getAll(boolean invoiced){
        return orderApplication.getAll(invoiced);
    }

    public void invoice(int id){
        orderApplication.invoice(id);
    }
}
