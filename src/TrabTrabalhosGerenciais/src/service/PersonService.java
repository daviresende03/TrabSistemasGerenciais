package service;

import java.util.ArrayList;
import java.util.Date;
import model.entities.PersonModel;
import model.interfaces.repositories.IDataContext;
import model.interfaces.repositories.IPersonRepository;
import model.interfaces.services.IPersonService;

public class PersonService implements IPersonService {
    private final IPersonRepository personRepository;
    private final IDataContext dataContext;
    
    public PersonService(IDataContext dataContext, IPersonRepository personRepository){
        this.dataContext = dataContext;
        this.personRepository = personRepository;
    }
    
    @Override
    public String insert(PersonModel person){
        try{
            Date date = new Date();
            person.setUpdatedDate(date);
            person.setCreatedDate(date);
            
            personRepository.insert(person);
            dataContext.commit();
            return "";
        }catch(Exception ex){
            dataContext.rollback();
            return "";
        }
    }

    @Override
    public String remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String update(PersonModel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PersonModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<PersonModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
