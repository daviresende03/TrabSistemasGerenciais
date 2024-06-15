package application.viewModels;

import java.util.List;


public class OrderVM {
    public int id;
    public PersonVM customer;
    public PersonVM waiter;
    public List<OrderItemVM> products;
    public boolean invoiced;
    public double discount;
    public double amount;
    public String observation;

    public OrderVM(){}
    
    public OrderVM(int id, PersonVM customer, PersonVM waiter, List<OrderItemVM> products, boolean invoiced, double discount, double amount, String observation) {
        this.id = id;
        this.customer = customer;
        this.waiter = waiter;
        this.products = products;
        this.invoiced = invoiced;
        this.amount = amount;
        this.discount = discount;
        this.observation = observation;
    }

    public OrderVM(PersonVM customer, PersonVM waiter, List<OrderItemVM> products, boolean invoiced, double discount, double amount, String observation) {
        this.customer = customer;
        this.waiter = waiter;
        this.products = products;
        this.invoiced = invoiced;
        this.amount = amount;
        this.discount = discount;
        this.observation = observation;
    }
}
