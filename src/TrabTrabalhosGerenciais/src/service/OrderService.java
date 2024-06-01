package service;

import java.util.Date;
import java.util.List;
import model.entities.OrderItemModel;
import model.entities.OrderModel;
import model.entities.PersonModel;
import model.entities.ProductModel;
import model.enums.ResponseTypeEnum;
import model.interfaces.repositories.IDataContext;
import model.interfaces.repositories.IOrderItemRepository;
import model.interfaces.repositories.IOrderRepository;
import model.interfaces.repositories.IPersonRepository;
import model.interfaces.repositories.IProductRepository;
import model.interfaces.services.IOrderService;

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
            if(model.getId() > 0){
                customer = personRepository.select(model.getId());
                if(customer.getId()<=0){
                    responseService.setResponse(ResponseTypeEnum.ERROR, "Não foi possível recuperar o cliente informado.");
                    return;
                }
            }
            
            PersonModel waiter = model.getWaiter();
            if(waiter.getId()<=0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Obrigatório informar o id do atendente.");
                return;
            }else{
                waiter = personRepository.select(waiter.getId());
                if(waiter.getId()<=0){
                    responseService.setResponse(ResponseTypeEnum.ERROR, "Não foi possível recuperar o atendente informado.");
                    return;
                }
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
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "");
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
}
