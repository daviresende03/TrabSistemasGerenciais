package application.viewModels;

import java.util.List;


public class OrderVM {
    public PersonVM customer;
    public PersonVM waiter;
    public List<OrderItemVM> products;
    public boolean invoiced;
    public double discount;
    public String observation;

    public OrderVM(PersonVM customer, PersonVM waiter, List<OrderItemVM> products, boolean invoiced, double discount, String observation) {
        this.customer = customer;
        this.waiter = waiter;
        this.products = products;
        this.invoiced = invoiced;
        this.discount = discount;
        this.observation = observation;
    }
}
