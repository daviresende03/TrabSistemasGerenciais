package controllers;

import infra.dependencyInjections.PersonDI;
import application.applications.PersonApplication;
import application.viewModels.PersonVM;
import domain.model.entities.ResponseService;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.services.IPersonService;
import java.util.List;
import domain.services.PersonService;

public class PersonController {
    private final PersonDI personDependencyInjection;
    private final IPersonService personService;
    private final IDataContext dataContext;
    private final PersonApplication personApplication;
    
    public PersonController(){
        personDependencyInjection = new PersonDI();
        dataContext = personDependencyInjection.getDataContext();
        personService = new PersonService(dataContext, personDependencyInjection.getPersonRepository(dataContext.getConnection()));
        personApplication = new PersonApplication(personService);
    }
    
    public ResponseService getResponseService(){
        return personApplication.getResponseService();
    }
    
    public void create(PersonVM personVM){
        personApplication.create(personVM);
    }
    
    public List<PersonVM> getAll(){
        return this.personApplication.getAll();
    }
    
    public List<PersonVM> getAll(boolean isCustomer, boolean isStaff, boolean isSupplier){
        return this.personApplication.getAll(isCustomer, isStaff, isSupplier);
    }
    
    public PersonVM get(int id){
        return this.personApplication.get(id);
    }
    
    public void update(PersonVM personVM){
        this.personApplication.update(personVM);
    }
    
    public void delete(int id){
        this.personApplication.delete(id);
    }
}
