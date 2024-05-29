/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.Date;
import model.enums.PersonTypeEnum;
import model.valueObjects.Address;

/**
 *
 * @author Davi
 */
public abstract class PersonModel extends BaseModel{
    private String name;
    private String document;
    private PersonTypeEnum type;
    private Address address;
    private Date birthDate;
    private String observation;
    private boolean customer;   
    private boolean staff;
    private boolean supplier;


    public PersonModel(String name, String document, PersonTypeEnum type, Address address, Date birthDate, String observation, boolean customer, boolean staff, boolean supplier) {
        this.name = name;
        this.document = document;
        this.type = type;
        this.address = address;
        this.birthDate = birthDate;
        this.observation = observation;
        this.customer = customer;
        this.staff = staff;
        this.supplier = supplier;
    }

    public PersonTypeEnum getType() {
        return type;
    }

    public void setType(PersonTypeEnum type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
    
    public boolean getCustomer() {
        return customer;
    }

    public void setCustomer(boolean customer) {
        this.customer = customer;
    }
    
    public boolean getStaff() {
        return staff;
    }

    public void setStaff(boolean staff) {
        this.staff = staff;
    }
    
    public boolean getSupplier() {
        return supplier;
    }

    public void setSupplier(boolean supplier) {
        this.supplier = supplier;
    }
    
}
