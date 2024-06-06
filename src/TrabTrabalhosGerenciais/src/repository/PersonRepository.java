package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import domain.model.entities.PersonModel;
import domain.interfaces.repositories.IPersonRepository;
import java.sql.Date;
import java.util.List;
import domain.model.enums.PersonTypeEnum;
import domain.model.valueObjects.Address;

public class PersonRepository implements IPersonRepository{
    
    private final Connection connect;
    
    public PersonRepository(Connection connect){
        this.connect = connect;
    }
    
    @Override
    public void insert(PersonModel person) throws SQLException { 
        String query = "INSERT INTO person("
                + "name,"
                + "document,"
                + "type,"
                + "address_street,"
                + "address_number,"
                + "address_neighborhood,"
                + "address_city,"
                + "address_state,"
                + "address_postal_code,"
                + "address_country,"
                + "birth_date,"
                + "observation,"
                + "customer,"
                + "staff,"
                + "supplier,"
                + "created_at,"
                + "updated_at)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
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
        statement.setDate(16, new Date(person.getCreatedDate().getTime()));
        statement.setDate(17, new Date(person.getUpdatedDate().getTime()));
        
        statement.executeUpdate();
    }

    @Override
    public void update(PersonModel model) throws SQLException {
        String query = "UPDATE person SET"
                + "name = ?"
                + "document = ?"
                + "type = ?"
                + "address_street = ?"
                + "address_number = ?,"
                + "address_neighborhood = ?"
                + "address_city = ?"
                + "address_state = ?"
                + "address_postal_code = ?"
                + "address_country = ?"
                + "birth_date = ?"
                + "observation = ?"
                + "customer = ?"
                + "staff = ?"
                + "supplier = ?"
                + "updated_at = ?"
                + "WHERE person_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setString(1, model.getName());
        statement.setString(2, model.getDocument());
        statement.setInt(3, model.getType().getValue());
        statement.setString(4, model.getAddress().getStreet());
        statement.setString(5, model.getAddress().getNumber());
        statement.setString(6, model.getAddress().getNeighborhood());
        statement.setString(7, model.getAddress().getCity());
        statement.setString(8, model.getAddress().getState());
        statement.setString(9, model.getAddress().getPostalCode());
        statement.setString(10, model.getAddress().getCountry());
        statement.setDate(11, new Date(model.getBirthDate().getTime()));
        statement.setString(12, model.getObservation());
        statement.setBoolean(13, model.getCustomer());
        statement.setBoolean(14, model.getStaff());
        statement.setBoolean(15, model.getSupplier());
        statement.setDate(17, new Date(model.getUpdatedDate().getTime()));
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM person WHERE person_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    @Override
    public PersonModel select(int id) throws SQLException {
        PersonModel person = new PersonModel();
        try{
            String query = "SELECT * FROM person WHERE person_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String document = resultSet.getString("document");
            int type = resultSet.getInt("type");
            String address_street = resultSet.getString("address_street");
            String address_number = resultSet.getString("address_number");
            String address_neighborhood = resultSet.getString("address_neighborhood");
            String address_city = resultSet.getString("address_city");
            String address_state = resultSet.getString("address_state");
            String address_postal_code = resultSet.getString("address_postal_code");
            String address_country = resultSet.getString("address_country");
            Date birth_date = resultSet.getDate("birth_date");
            String observation = resultSet.getString("observation");
            boolean customer = resultSet.getBoolean("customer");
            boolean staff = resultSet.getBoolean("staff");
            boolean supplier = resultSet.getBoolean("supplier");
            
            return new PersonModel(id, name, document, PersonTypeEnum.fromInteger(type), new Address(address_street, address_number, address_neighborhood, address_city, address_state, address_postal_code, address_country), birth_date, observation, customer, staff, supplier);
        }
        return person;
        }catch(Exception ex){
            return person;
        }
    }
    
    @Override
    public PersonModel select(String doc) throws SQLException {
        PersonModel person = new PersonModel();
        try{
            String query = "SELECT * FROM person WHERE document = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setString(1, doc);
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            int id = resultSet.getInt("person_id");
            String name = resultSet.getString("name");
            int type = resultSet.getInt("type");
            String address_street = resultSet.getString("address_street");
            String address_number = resultSet.getString("address_number");
            String address_neighborhood = resultSet.getString("address_neighborhood");
            String address_city = resultSet.getString("address_city");
            String address_state = resultSet.getString("address_state");
            String address_postal_code = resultSet.getString("address_postal_code");
            String address_country = resultSet.getString("address_country");
            Date birth_date = resultSet.getDate("birth_date");
            String observation = resultSet.getString("observation");
            boolean customer = resultSet.getBoolean("customer");
            boolean staff = resultSet.getBoolean("staff");
            boolean supplier = resultSet.getBoolean("supplier");
            
            return new PersonModel(id, name, doc, PersonTypeEnum.fromInteger(type), new Address(address_street, address_number, address_neighborhood, address_city, address_state, address_postal_code, address_country), birth_date, observation, customer, staff, supplier);
        }
        return person;
        }catch(Exception ex){
            return person;
        }
    }

    @Override
    public List<PersonModel> select() throws SQLException {
        List<PersonModel> people = new ArrayList<PersonModel>();
        try{
            String query = "SELECT * FROM person";
        
        PreparedStatement statement = connect.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        
        while (resultSet.next()) {
            int id = resultSet.getInt("person_id");
            String name = resultSet.getString("name");
            String document = resultSet.getString("document");
            int type = resultSet.getInt("type");
            String address_street = resultSet.getString("address_street");
            String address_number = resultSet.getString("address_number");
            String address_neighborhood = resultSet.getString("address_neighborhood");
            String address_city = resultSet.getString("address_city");
            String address_state = resultSet.getString("address_state");
            String address_postal_code = resultSet.getString("address_postal_code");
            String address_country = resultSet.getString("address_country");
            Date birth_date = resultSet.getDate("birth_date");
            String observation = resultSet.getString("observation");
            boolean customer = resultSet.getBoolean("customer");
            boolean staff = resultSet.getBoolean("staff");
            boolean supplier = resultSet.getBoolean("supplier");
            
            people.add(new PersonModel(id, name, document, PersonTypeEnum.fromInteger(type), new Address(address_street, address_number, address_neighborhood, address_city, address_state, address_postal_code, address_country), birth_date, observation, customer, staff, supplier));
        }
        return people;
        }catch(Exception ex){
            return people;
        }
    }

    @Override
    public boolean exist(int id) throws SQLException {
        try{
            String query = "SELECT null FROM person WHERE person_id = ?";
            
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            return resultSet.next();
        }catch(Exception ex){
            return false;
        }
    }
    
}
