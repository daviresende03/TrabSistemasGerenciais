package domain.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderModel extends BaseModel{
        private PersonModel customer;
        private PersonModel waiter;
        private boolean isCanceled;
        private List<OrderItemModel> products;
        private boolean invoiced;
        private double discountTotal;
        private double orderTotal;
        private String observation;

    public OrderModel(int id, PersonModel customer, PersonModel waiter, List<OrderItemModel> products, boolean isCanceled, boolean invoiced, double discountTotal, String observation) {
        setId(id);
        this.customer = Objects.requireNonNullElse(customer, new PersonModel());
        this.waiter = Objects.requireNonNullElse(waiter, new PersonModel());
        this.products = Objects.requireNonNullElse(products, new ArrayList<OrderItemModel>());
        this.isCanceled = isCanceled;
        this.invoiced = invoiced;
        this.discountTotal = discountTotal;
        this.observation = Objects.requireNonNullElse(observation,"");
        totalOrder();
    }
    
    public OrderModel(PersonModel customer, PersonModel waiter, List<OrderItemModel> products, boolean isCanceled, boolean invoiced, double discountTotal, String observation) {
        this.customer = Objects.requireNonNullElse(customer, new PersonModel());
        this.waiter = Objects.requireNonNullElse(waiter, new PersonModel());
        this.products = Objects.requireNonNullElse(products, new ArrayList<OrderItemModel>());
        this.isCanceled = isCanceled;
        this.invoiced = invoiced;
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
    
    public boolean getInvoiced(){
        return invoiced;
    }
    
    public void setInvoiced(boolean invoiced){
        this.invoiced = invoiced;
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
    
    public double getAmount(){
        return orderTotal;
    }
    
    public void setAmount(double amount){
        this.orderTotal = amount;
    }

    public boolean getIsCanceled(){
        return this.isCanceled;
    }

    public void setIsCanceled(boolean isCanceled){
        this.isCanceled = isCanceled;
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
        if(discountTotal < 0 || discountTotal >= totalOrderItems()){
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
