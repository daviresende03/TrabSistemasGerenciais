/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.ArrayList;

/**
 *
 * @author joaov
 */
public class OrderModel extends BaseModel{
        private PersonModel customer;
        private PersonModel waiter;
        private ArrayList<ProductModel> products;
        private double orderTotal;
        private double discountTotal;
        private String observation;

    public OrderModel(PersonModel customer, PersonModel waiter, ArrayList<ProductModel> products, double orderTotal, double discountTotal, String observation) {
        this.customer = customer;
        this.waiter = waiter;
        this.products = products;
        this.orderTotal = orderTotal;
        this.discountTotal = discountTotal;
        this.observation = observation;
    }

    public OrderModel() {}
        
    public PersonModel getCustomer() {
        return customer;
    }

    public void setCustomer(PersonModel customer) {
        this.customer = customer;
    }

    public ArrayList<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductModel> products) {
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
        
}
