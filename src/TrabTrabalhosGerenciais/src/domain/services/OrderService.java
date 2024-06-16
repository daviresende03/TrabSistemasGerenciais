package domain.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.interfaces.repositories.*;
import domain.interfaces.services.IFinanceService;
import domain.model.entities.*;
import domain.model.enums.FinanceTypeEnum;
import domain.model.enums.ResponseTypeEnum;
import domain.interfaces.services.IOrderService;

public class OrderService extends BaseService implements IOrderService{
    private final IOrderRepository orderRepository;
    private final IOrderItemRepository orderItemRepository;
    private final IPersonRepository personRepository;
    private final IProductRepository productRepository;
    private final ICashRegisterRepository cashRepository;
    private final IFinanceRepository financeRepository;

    public OrderService(IDataContext dataContext,
                        IOrderRepository orderRepository,
                        IOrderItemRepository orderItemRepository,
                        IPersonRepository personRepository,
                        IProductRepository productRepository,
                        ICashRegisterRepository cashRegisterRepository,
                        IFinanceRepository financeRepository) {
        super(dataContext);
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.personRepository = personRepository;
        this.productRepository = productRepository;
        this.cashRepository = cashRegisterRepository;
        this.financeRepository = financeRepository;
    }

    public void save(OrderModel model){
        try{
            PersonModel customer = model.getCustomer();
            if(customer.getId() <= 0 || !personRepository.exist(customer.getId())){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Não foi possível encontrar o cliente informado.");
                return;
            }

            PersonModel waiter = model.getWaiter();
            if(waiter.getId() <= 0 || !personRepository.exist(waiter.getId())){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Não foi possível encontrar o atendente informado.");
                return;
            }

            if(model.validate()){
                model.setUpdatedDate(new Date());
                if(model.getId() <= 0){ //New Order
                    model.setCreatedDate(new Date());
                    model.setIsCanceled(false);
                    orderRepository.insert(model);
                    int orderId = model.getId();

                    if(orderId>0){
                        insertOrderItems(orderId, model.getProducts());
                        if(responseService.getType() == ResponseTypeEnum.ERROR){
                            return;
                        }
                    }
                }else{ //Existing Order
                    orderRepository.update(model);
                    updateOrderItems(model.getId(), model.getProducts());
                    if(responseService.getType() == ResponseTypeEnum.ERROR){
                        return;
                    }
                }
            }else{
                responseService.setResponse(ResponseTypeEnum.ERROR, model.getMessage());
                return;
            }

            dataContext.commit();
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "Pedido salvo com sucesso.");
        }catch(Exception ex){
            dataContext.rollback();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao realizar a gravação do pedido.");
        }
    }

    private void updateOrderItems(int orderId, List<OrderItemModel> orderItems) throws SQLException {
        List<OrderItemModel> itemsInDataBase = orderItemRepository.selectByOrderId(orderId);

        List<OrderItemModel> onlyInDataBase = new ArrayList<>();
        List<OrderItemModel> onlyInCurrentFunction = new ArrayList<>();

        for(OrderItemModel item : orderItems){
            boolean existInBothLocales = false;
            for(OrderItemModel itemDataBase : itemsInDataBase){
                existInBothLocales = item.getId() == itemDataBase.getId();
                if(existInBothLocales){
                    break;
                }
            }

            if(!existInBothLocales){
                onlyInCurrentFunction.add(item);
            }
        }

        for(OrderItemModel itemDataBase : itemsInDataBase){
            boolean existInBothLocales = false;
            for(OrderItemModel item : orderItems){
                existInBothLocales = item.getId() == itemDataBase.getId();
                if(existInBothLocales){
                    break;
                }
            }

            if(!existInBothLocales){
                onlyInDataBase.add(itemDataBase);
            }
        }

        deleteOrderItemsInDataBase(onlyInDataBase);
        insertOrderItemsInDataBase(orderId, onlyInCurrentFunction);
    }

    private void deleteOrderItemsInDataBase(List<OrderItemModel> orderItems) throws SQLException {
        for(OrderItemModel model : orderItems){
            ProductModel product = productRepository.select(model.getProduct().getId());
            product.increaseStock(model.getQuantity());
            productRepository.updateStock(product.getId(), product.getStock());

            orderItemRepository.delete(model.getId());
        }
    }

    private void insertOrderItemsInDataBase(int orderId, List<OrderItemModel> orderItems) throws SQLException {
        for(OrderItemModel model : orderItems){

            if(!model.validate()){
                responseService.setResponse(ResponseTypeEnum.ERROR, model.getMessage());
                return;
            }

            ProductModel product = productRepository.select(model.getProduct().getId());
            product.decreaseStock(model.getQuantity());
            productRepository.updateStock(product.getId(), product.getStock());

            model.setProduct(product);
            model.setOrder(new OrderModel(orderId));
            model.setUpdatedDate(new Date());
            model.setCreatedDate(new Date());

            orderItemRepository.insert(model);
        }
    }
    
    private void insertOrderItems(int orderId, List<OrderItemModel> orderItems) throws Exception{
        for(OrderItemModel item : orderItems){
            OrderModel order = new OrderModel(orderId);

            ProductModel product = productRepository.select(item.getProduct().getId());
            if(product.getId()<=0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Produto não encontrado.");
                return;
            }
            
            if(!item.validate()){
                responseService.setResponse(ResponseTypeEnum.ERROR, item.getMessage());
                return;
            }
            
            product.decreaseStock(item.getQuantity());
            productRepository.updateStock(product.getId(), product.getStock());

            item.setProduct(product);
            item.setOrder(order);
            item.setUpdatedDate(new Date());
            item.setCreatedDate(new Date());

            orderItemRepository.insert(item);
            responseService.setResponse(ResponseTypeEnum.SUCCESS,"");
        }
    }
    
    private void removeOrderItems(int orderId, List<OrderItemModel> orderItems) throws Exception{
        for(OrderItemModel item : orderItems){
            ProductModel product = productRepository.select(item.getProduct().getId());
            if(product.getId()<=0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Produto não encontrado.");
                return;
            }
            
            if(!item.validate()){
                responseService.setResponse(ResponseTypeEnum.ERROR, item.getMessage());
                return;   
            }
            
            product.increaseStock(item.getQuantity());
            productRepository.updateStock(product.getId(), product.getStock());
        }
        
        orderItemRepository.deleteByOrderId(orderId);
        responseService.setResponse(ResponseTypeEnum.SUCCESS, "");
    }

    @Override
    public void remove(int id) {
        try{
            if(id <= 0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
                return;
            }
            
            OrderModel order = orderRepository.select(id);
            
            if(order.getId() <= 0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Pedido não encontrado.");
                return;
            }
            
            List<OrderItemModel> orderItems = orderItemRepository.selectByOrderId(id);
            removeOrderItems(id, orderItems);
            
            if(responseService.getType() == ResponseTypeEnum.ERROR){
                return;
            }
            
            orderItemRepository.deleteByOrderId(id);
            orderRepository.delete(id);
            
            dataContext.commit();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Pedido deletado com sucesso.");
        }catch(Exception ex){
            dataContext.rollback();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao deletar o produto.");
        }
    }

    @Override
    public void update(OrderModel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(OrderModel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OrderModel get(int id) {
        try{
            if(id <= 0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
                return new OrderModel();
            }

            OrderModel order = orderRepository.select(id);
            order.setProducts(orderItemRepository.selectByOrderId(id));

            for(OrderItemModel item : order.getProducts()){
                ProductModel product = productRepository.select(item.getProduct().getId());
                item.setProduct(product);
            }

            if(order.getId() <= 0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Produto não encontrado.");
            }else{
                responseService.setResponse(ResponseTypeEnum.SUCCESS, "");
            }
            return order;
        }catch(Exception ex){
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar o produto.");
            return new OrderModel();
        }
    }

    @Override
    public List<OrderModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OrderModel> getAll(boolean invoiced) {
        try{
            List<OrderModel> orders = orderRepository.select(invoiced);            
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "");
            return orders;
        }catch(Exception ex){
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar os pedidos filtrados.");
            return null;
        }
    }

    @Override
    public void invoice(int id) {
        try{
            OrderModel order = orderRepository.select(id);
            if(order.getId()<=0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Pedido não encontrado.");
                return;
            }

            int cashRegisterId = cashRepository.selectIdThatStatusIsOpen();
            if(cashRegisterId<=0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "É necessário primeiramente abrir o caixa.");
                return;
            }

            order.setInvoiced(true);
            order.setUpdatedDate(new Date());

            orderRepository.invoice(order);
            CashRegisterModel cashReg = cashRepository.select(cashRegisterId);
            if(cashReg.getId()<=0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Não foi possível obter o caixa em aberto.");
                return;
            }

            cashReg.increaseValue(order.getAmount());
            cashReg.setUpdatedDate(new Date());
            cashRepository.updateAmount(cashReg);

            FinanceModel finance = new FinanceModel();
            finance.setCashRegisterId(cashReg.getId());
            finance.setType(FinanceTypeEnum.RECEIPT);
            finance.setDescription("LANC. AUTOMÁTICO: FATURAMENTO DO PEDIDO "+order.getId());
            finance.setValue(order.getAmount());
            finance.setUpdatedDate(new Date());
            finance.setCreatedDate(new Date());
            financeRepository.insert(finance);


            dataContext.commit();
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "Pedido faturado com sucesso.");
        }catch(Exception ex){
            dataContext.rollback();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao faturar o pedido.");
        }
    }

    @Override
    public int count(boolean invoiced) {
        try{
            int count = orderRepository.count(invoiced);
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "");
            return count;
        }catch(Exception ex){
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao contabilizar os pedidos filtrados.");
            return 0;
        }
    }

    @Override
    public void cancel(int id){
        try{
            OrderModel order = orderRepository.select(id);
            if(order.getId() <= 0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Não foi possível recuperar o pedido.");
                return;
            }
            if(order.getIsCanceled()){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Não é possível cancelar um pedido já cancelado.");
                return;
            }

            int cashRegId = cashRepository.selectIdThatStatusIsOpen();
            if(cashRegId<=0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "É necessário primeiramente abrir o caixa.");
                return;
            }
            CashRegisterModel cashRegister = cashRepository.select(cashRegId);
            if(cashRegister.getId()<=0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Não foi possível recuperar o caixa em aberto.");
                return;
            }

            orderRepository.cancel(id);

            if(order.getInvoiced()){
                cashRegister.decreaseValue(order.getAmount());
                cashRegister.setUpdatedDate(new Date());
                cashRepository.updateAmount(cashRegister);

                FinanceModel finance = new FinanceModel();
                finance.setCashRegisterId(cashRegister.getId());
                finance.setType(FinanceTypeEnum.PAYMENT);
                finance.setDescription("LANC. AUTOMÁTICO: CANCELAMENTO DO PEDIDO "+order.getId());
                finance.setValue(order.getAmount());
                finance.setUpdatedDate(new Date());
                finance.setCreatedDate(new Date());
                financeRepository.insert(finance);
            }

            dataContext.commit();
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "Pedido cancelado com sucesso.");
        }catch(Exception ex){
            dataContext.rollback();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao cancelar o pedido.");
        }
    }
}
