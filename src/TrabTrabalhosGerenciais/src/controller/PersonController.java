package controller;

import infra.DependencyInjection.PersonDI;
import application.PersonApplication;
import controller.viewModels.PersonVM;
import domain.model.entities.ResponseService;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.services.IPersonService;
import java.util.List;
import service.PersonService;

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
    
    public PersonVM get(int id){
        return this.personApplication.get(id);
    }
}
