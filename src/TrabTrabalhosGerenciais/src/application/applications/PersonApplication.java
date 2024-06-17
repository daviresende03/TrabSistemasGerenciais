package application.applications;

import application.mappers.PersonMap;
import application.viewModels.PersonVM;
import domain.model.entities.ResponseService;
import domain.interfaces.services.IPersonService;
import java.util.List;

public class PersonApplication {
    private final IPersonService personService;
    
    public PersonApplication(IPersonService personService){
        this.personService = personService;
    }
    
    public ResponseService getResponseService(){
        return personService.getResponseService();
    }
    
    public void create(PersonVM personVM){
        personService.insert(PersonMap.getPerson(personVM));
    }
    
    public List<PersonVM> getAll(boolean isCustomer, boolean isStaff, boolean isSupplier) {
        return PersonMap.getPeopleVM(personService.getAll(isCustomer, isStaff, isSupplier));
    }
    
    public PersonVM get(int id){
        return PersonMap.getPersonVM(personService.get(id));
    }
    
    public void update(PersonVM personVM){
        personService.update(PersonMap.getPerson(personVM));
    }
    
    public void delete(int id){
        personService.remove(id);
    }
}
