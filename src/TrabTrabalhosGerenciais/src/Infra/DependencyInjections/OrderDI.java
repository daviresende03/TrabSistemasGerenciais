package infra.dependencyInjections;

import data.context.DataContext;
import data.repositories.OrderItemRepository;
import data.repositories.OrderRepository;
import domain.interfaces.repositories.*;
import domain.interfaces.services.IOrderService;
import domain.services.OrderService;

import java.sql.Connection;

public class OrderDI {
    public IDataContext getDataContext(){ return new DataContext(); }

    public IOrderRepository getOrderRepository(Connection con){ return new OrderRepository(con); }

    public IOrderItemRepository getOrderItemRepository(Connection con){ return new OrderItemRepository(con); }

    public IOrderService getOrderService(IDataContext dataContext,
                                         IOrderRepository orderRepository,
                                         IOrderItemRepository orderItemRepository,
                                         IPersonRepository personRepository,
                                         IProductRepository productRepository,
                                         ICashRegisterRepository cashRegisterRepository,
                                         IFinanceRepository financeRepository){
        return new OrderService(dataContext, orderRepository, orderItemRepository, personRepository, productRepository, cashRegisterRepository, financeRepository);
    }
}
