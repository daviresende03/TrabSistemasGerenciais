package controllers;

import application.applications.OrderApplication;
import application.viewModels.OrderVM;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.services.IOrderService;
import domain.model.entities.ResponseService;
import domain.services.OrderService;
import infra.dependencyInjections.*;

import java.util.List;

public class OrderController {
    private final OrderApplication orderApplication;

    public OrderController() {
        OrderDI orderDependencyInjection = new OrderDI();
        PersonDI personDependencyInjection = new PersonDI();
        ProductDI productDependencyInjection = new ProductDI();
        CashRegisterDI cashRegisterDependencyInjection = new CashRegisterDI();
        FinanceDI financeDependencyInjection = new FinanceDI();
        IDataContext dataContext = orderDependencyInjection.getDataContext();
        IOrderService orderService = new OrderService(dataContext,
                orderDependencyInjection.getOrderRepository(dataContext.getConnection()),
                orderDependencyInjection.getOrderItemRepository(dataContext.getConnection()),
                personDependencyInjection.getPersonRepository(dataContext.getConnection()),
                productDependencyInjection.getProductRepository(dataContext.getConnection()),
                cashRegisterDependencyInjection.getCashRegisterRepository(dataContext.getConnection()),
                financeDependencyInjection.getFinanceRepository(dataContext.getConnection()));

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

    public int count(boolean invoiced){
        return orderApplication.count(invoiced);
    }

    public int countCanceleds(){
        return orderApplication.countCanceleds();
    }

    public OrderVM get(int id){
        return orderApplication.get(id);
    }

    public void cancel(int id){
        orderApplication.cancel(id);
    }
}
