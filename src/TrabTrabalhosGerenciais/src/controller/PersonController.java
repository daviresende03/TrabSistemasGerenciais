package controller;

import infra.DependencyInjection.PersonDI;
import application.PersonApplication;
import controller.viewModels.PersonVM;
import model.entities.ResponseService;
import model.interfaces.repositories.IDataContext;
import model.interfaces.services.IPersonService;
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
}
