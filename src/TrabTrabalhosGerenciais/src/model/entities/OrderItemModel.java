package model.entities;

import java.util.Objects;

public class OrderItemModel extends BaseModel{
    private OrderModel order;
    private ProductModel product;
    private double quantity;
    private double salePrice;

    public OrderItemModel(int id, OrderModel order, ProductModel product, double quantity, double salePrice) {
        setId(id);
        this.order = Objects.requireNonNullElse(order, new OrderModel());
        this.product = Objects.requireNonNullElse(product, new ProductModel());;
        this.quantity = quantity;
        this.salePrice = salePrice;
    }   
    
    public OrderItemModel(){}
    
    public double totalPrice(){
        return quantity*salePrice;
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
    
    
}
