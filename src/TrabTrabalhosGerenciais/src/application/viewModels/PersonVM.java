package application.viewModels;

import domain.model.entities.PersonModel;
import java.util.Date;

public class PersonVM {
    public int id;
    public String name;
    public String document;
    public int type;
    public String street;
    public String number;
    public String neighborhood;
    public String city;
    public String state;
    public String postalCode;
    public String country;
    public Date birthDate;
    public String observation;
    public boolean customer;
    public boolean staff;
    public boolean supplier;
    
    public PersonVM(){}

    public PersonVM(int id, String name, String document, int type, String street, String number, String neighborhood, String city, String state, String postalCode, String country, Date birthDate, String observation, boolean customer, boolean staff, boolean supplier) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.type = type;
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.birthDate = birthDate;
        this.observation = observation;
        this.customer = customer;
        this.staff = staff;
        this.supplier = supplier;
    }
}
