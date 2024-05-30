
package Infra.DependencyInjection;

import java.sql.Connection;
import model.interfaces.repositories.IDataContext;
import model.interfaces.repositories.IPersonRepository;
import model.interfaces.services.IPersonService;
import repository.PersonRepository;
import repository.context.DataContext;
import service.PersonService;

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
