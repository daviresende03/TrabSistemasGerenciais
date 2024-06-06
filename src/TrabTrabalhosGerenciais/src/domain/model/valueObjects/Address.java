package domain.model.valueObjects;

import java.util.Objects;
import domain.model.entities.BaseModel;

public class Address extends BaseModel{
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    public Address(String street, String number, String neighborhood, String city, String state, String postalCode, String country) {
        this.street = Objects.requireNonNullElse(street,"");
        this.number = Objects.requireNonNullElse(number,"");
        this.neighborhood = Objects.requireNonNullElse(neighborhood,"");
        this.city = Objects.requireNonNullElse(city,"");
        this.state = Objects.requireNonNullElse(state,"");
        this.postalCode = Objects.requireNonNullElse(postalCode,"");
        this.country = Objects.requireNonNullElse(country,"");
    }
    
    public Address(){}

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public boolean validate(){
        if(street.isEmpty() || number.isEmpty() || neighborhood.isEmpty() || city.isEmpty() || state.isEmpty() || postalCode.isEmpty() || country.isEmpty() ){
            addMessage("Preencha todos os campos do endereço.");
            return false;
        }
        return true;
    }
    
}