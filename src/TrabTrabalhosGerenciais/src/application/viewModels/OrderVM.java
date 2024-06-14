package application.viewModels;

import java.util.List;


public class OrderVM {
    public PersonVM customer;
    public PersonVM waiter;
    public List<OrderItemVM> products;
    public double discount;
    public String observation;

    public OrderVM(PersonVM customer, PersonVM waiter, List<OrderItemVM> products, double discount, String observation) {
        this.customer = customer;
        this.waiter = waiter;
        this.products = products;
        this.discount = discount;
        this.observation = observation;
    }
}
