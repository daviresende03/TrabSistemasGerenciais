package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.entities.PersonModel;
import model.interfaces.repositories.IPersonRepository;
import java.sql.Date;

public class PersonRepository implements IPersonRepository{
    
    private final Connection connect;
    
    public PersonRepository(Connection connect){
        this.connect = connect;
    }
    
    @Override
    public void insert(PersonModel person) throws SQLException { 
        String query = "INSERT INTO person(name, document, type, address_street, address_number, address_neighborhood, address_city, "
                + "address_state, address_postal_code, address_country, birth_date, observation, customer, staff, supplier, "
                + "created_at, updated_at) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connect.prepareStatement(query);
        
        statement.setString(1, person.getName());
        statement.setString(2, person.getDocument());
        statement.setInt(3, person.getType().getValue());
        statement.setString(4, person.getAddress().getStreet());
        statement.setString(5, person.getAddress().getNumber());
        statement.setString(6, person.getAddress().getNeighborhood());
        statement.setString(7, person.getAddress().getCity());
        statement.setString(8, person.getAddress().getState());
        statement.setString(9, person.getAddress().getPostalCode());
        statement.setString(10, person.getAddress().getCountry());
        statement.setDate(11, new Date(person.getBirthDate().getTime()));
        statement.setString(12, person.getObservation());
        statement.setBoolean(13, person.getCustomer());
        statement.setBoolean(14, person.getStaff());
        statement.setBoolean(15, person.getSupplier());
        statement.setDate(16, new Date(person.getBirthDate().getTime()));
        statement.setDate(17, new Date(person.getBirthDate().getTime()));
        
        statement.executeUpdate();
    }

    @Override
    public void update(PersonModel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PersonModel select(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<PersonModel> select() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
