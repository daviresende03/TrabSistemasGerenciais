package domain.services;

import java.util.Date;
import java.util.List;
import domain.model.entities.OrderItemModel;
import domain.model.entities.OrderModel;
import domain.model.entities.PersonModel;
import domain.model.entities.ProductModel;
import domain.model.enums.ResponseTypeEnum;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.repositories.IOrderItemRepository;
import domain.interfaces.repositories.IOrderRepository;
import domain.interfaces.repositories.IPersonRepository;
import domain.interfaces.repositories.IProductRepository;
import domain.interfaces.services.IOrderService;

public class OrderService extends BaseService implements IOrderService{
    private final IOrderRepository orderRepository;
    private final IOrderItemRepository orderItemRepository;
    private final IPersonRepository personRepository;
    private final IProductRepository productRepository;

    public OrderService(IDataContext dataContext, IOrderRepository orderRepository, IOrderItemRepository orderItemRepository, IPersonRepository personRepository, IProductRepository productRepository) {
        super(dataContext);
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.personRepository = personRepository;
        this.productRepository = productRepository;
    }    
    
    @Override
    public void insert(OrderModel model) {
        try{
            PersonModel customer = model.getCustomer();
            if(model.getId()>0 && !personRepository.exist(model.getId())){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Não foi possível encontrar o cliente informado.");
                return;
            }
            
            PersonModel waiter = model.getWaiter();
            if(waiter.getId()<=0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Obrigatório informar o id do atendente.");
                return;
            }
            if(!personRepository.exist(waiter.getId())){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Não foi possível encontrar o atendente informado.");
                return;
            }
            
            if(model.validate()){
                
                model.setUpdatedDate(new Date());
                model.setCreatedDate(new Date());
                
                orderRepository.insert(model);
                int orderId = model.getId();
                
                if(orderId>0){
                    insertOrderItems(orderId, model.getProducts());
                    if(responseService.getType() == ResponseTypeEnum.ERROR){
                        return;
                    }
                }
            }else{
                responseService.setResponse(ResponseTypeEnum.ERROR, model.getMessage());
                return;
            }
            
            dataContext.commit();
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "Pedido realizado com sucesso.");
        }catch(Exception ex){
            dataContext.rollback();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao realizar a gravação do pedido.");
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
    public OrderModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

            order.setInvoiced(true);
            order.setUpdatedDate(new Date());

            dataContext.commit();
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "Pedido faturado com sucesso,");
        }catch(Exception ex){
            dataContext.rollback();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao faturar o pedido.");
        }
    }
}
