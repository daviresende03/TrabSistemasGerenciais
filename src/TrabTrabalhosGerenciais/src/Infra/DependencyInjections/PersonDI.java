package Infra.DependencyInjections;

import java.sql.Connection;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.repositories.IPersonRepository;
import domain.interfaces.services.IPersonService;
import data.repositories.PersonRepository;
import data.context.DataContext;
import domain.services.PersonService;

public class PersonDI {
    public IDataContext getDataContext(){
       return new DataContext(); 
    }
    
    public IPersonRepository getPersonRepository(Connection con){
        return new PersonRepository(con);
    }
    
    public IPersonService getPersonService(IDataContext dataContext, IPersonRepository personRepository){
        return new PersonService(dataContext, personRepository);
    }
}
