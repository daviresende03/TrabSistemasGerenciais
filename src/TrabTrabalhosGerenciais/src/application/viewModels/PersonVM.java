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
    
    public PersonVM(PersonModel model){
        id = model.getId();
        name = model.getName();
        document = model.getDocument();
        type = model.getType().getValue();
        street = model.getAddress().getStreet();
        number = model.getAddress().getNumber();
        neighborhood = model.getAddress().getNeighborhood();
        city = model.getAddress().getCity();
        state = model.getAddress().getState();
        postalCode = model.getAddress().getPostalCode();
        country = model.getAddress().getCountry();
        birthDate = model.getBirthDate();
        observation = model.getObservation();
        customer = model.getCustomer();
        staff = model.getStaff();
        supplier = model.getSupplier();
    }
}
