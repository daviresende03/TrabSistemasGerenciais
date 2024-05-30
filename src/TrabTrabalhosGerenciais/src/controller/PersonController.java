/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Infra.DependencyInjection.PersonDI;
import application.PersonApplication;
import controller.viewModels.PersonVM;
import model.interfaces.repositories.IDataContext;
import model.interfaces.services.IPersonService;
import service.PersonService;

/**
 *
 * @author joaov
 */
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
    
    public void create(PersonVM personVM){
        personApplication.create(personVM);
    }
}
