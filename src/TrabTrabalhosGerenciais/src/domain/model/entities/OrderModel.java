package domain.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderModel extends BaseModel{
        private PersonModel customer;
        private PersonModel waiter;
        private List<OrderItemModel> products;
        private double discountTotal;
        private double orderTotal;
        private String observation;

    public OrderModel(int id, PersonModel customer, PersonModel waiter, List<OrderItemModel> products, double discountTotal, String observation) {
        setId(id);
        this.customer = Objects.requireNonNullElse(customer, new PersonModel());
        this.waiter = Objects.requireNonNullElse(waiter, new PersonModel());
        this.products = Objects.requireNonNullElse(products, new ArrayList<OrderItemModel>());
        this.discountTotal = discountTotal;
        this.observation = Objects.requireNonNullElse(observation,"");
        totalOrder();
    }

    public OrderModel() {}
    
    public OrderModel(int id){
        setId(id);
    }
        
    public PersonModel getCustomer() {
        return customer;
    }

    public void setCustomer(PersonModel customer) {
        this.customer = customer;
    }

    public List<OrderItemModel> getProducts() {
        return products;
    }

    public void setProducts(List<OrderItemModel> products) {
        this.products = products;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public double getDiscountTotal() {
        return discountTotal;
    }

    public void setDiscountTotal(double discountTotal) {
        this.discountTotal = discountTotal;
    }

    public PersonModel getWaiter() {
        return waiter;
    }

    public void setWaiter(PersonModel waiter) {
        this.waiter = waiter;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
    
    private double totalOrderItems(){
        double total = 0;
        for(OrderItemModel orderItemModel : products){
            total+=orderItemModel.totalPrice();
        }
        return total;
    }
    
    public void totalOrder(){
        this.orderTotal = totalOrderItems() - discountTotal;
    }
    
    public boolean validate(){
        totalOrder();
        
        if(products.size()==0){
            addMessage("Pedido sem produtos registrados.");
            return false;
        }
        if(discountTotal < 0 || discountTotal >= orderTotal){
            addMessage("Desconto inválido.");
            return false;
        }
        if(orderTotal != (totalOrderItems() - discountTotal)){
            addMessage("Valor do pedido inválido.");
            return false;
        }
        return true;
    }        
}