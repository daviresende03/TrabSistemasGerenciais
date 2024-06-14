package domain.model.entities;

import java.util.Objects;

public class OrderItemModel extends BaseModel{
    private OrderModel order;
    private ProductModel product;
    private double quantity;
    private double salePrice;
    private double totalItem;

    public OrderItemModel(int id, OrderModel order, ProductModel product, double quantity, double salePrice) {
        setId(id);
        this.order = Objects.requireNonNullElse(order, new OrderModel());
        this.product = Objects.requireNonNullElse(product, new ProductModel());;
        this.quantity = quantity;
        this.salePrice = salePrice;
        totalItem();
    }
    
    public OrderItemModel(){}
    
    public double totalPrice(){
        return quantity*salePrice;
    }
    
    public void setOrder(OrderModel order){
        this.order = order;
    }
    
    public void setProduct(ProductModel product){
        this.product = product;
    }

    public OrderModel getOrder() {
        return order;
    }

    public ProductModel getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getSalePrice() {
        return salePrice;
    }
    
    public void totalItem(){
        totalItem = quantity * salePrice;
    }
    
    public boolean validate(){
        totalItem();
        
        if(quantity<=0){
            addMessage("Quantidade vendida inválida.");
            return false;
        }
        if(salePrice<=0){
            addMessage("Preço de venda inválido.");
            return false;
        }
        if(totalItem != (quantity*salePrice)){
            addMessage("Valor total do item é inválido.");
            return false;
        }
        return true;
    }
}
