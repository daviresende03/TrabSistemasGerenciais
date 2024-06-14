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

public class OrderController {
    private final OrderDI orderDependencyInjection;
    private final PersonDI personDependencyInjection;
    private final ProductDI productDependencyInjection;

    private final IOrderService orderService;
    private final IDataContext dataContext;
    private final OrderApplication orderApplication;

    public OrderController() {
        orderDependencyInjection = new OrderDI();
        personDependencyInjection = new PersonDI();
        productDependencyInjection = new ProductDI();

        dataContext = orderDependencyInjection.getDataContext();
        orderService = new OrderService(dataContext,
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
}
