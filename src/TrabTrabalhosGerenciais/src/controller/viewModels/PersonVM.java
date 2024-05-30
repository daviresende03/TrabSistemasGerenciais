package controller.viewModels;

import java.util.Date;
import model.valueObjects.Address;

public class PersonVM {
    public int id;
    public String name;
    public String document;
    public int type;
    public Address address;
    public Date birthDate;
    public String observation;
    public boolean customer;
    public boolean staff;
    public boolean supplier;
}
