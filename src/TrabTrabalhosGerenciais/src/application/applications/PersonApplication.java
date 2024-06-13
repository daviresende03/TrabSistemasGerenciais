package application.applications;

import application.viewModels.PersonVM;
import domain.model.entities.PersonModel;
import domain.model.entities.ResponseService;
import domain.model.enums.PersonTypeEnum;
import domain.interfaces.services.IPersonService;
import domain.model.valueObjects.Address;
import java.util.ArrayList;
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
        PersonModel personModel = new PersonModel(
                personVM.name,
                personVM.document,
                PersonTypeEnum.fromInteger(personVM.type),
                new Address(personVM.street, personVM.number, personVM.neighborhood, personVM.city, personVM.state, personVM.postalCode, personVM.country),
                personVM.birthDate,
                personVM.observation,
                personVM.customer,
                personVM.staff,
                personVM.supplier
        );
        personService.insert(personModel);
    }
    
    public List<PersonVM> getAll(boolean isCustomer, boolean isStaff, boolean isSupplier) {
        List<PersonModel> peopleModel = personService.getAll(isCustomer, isStaff, isSupplier);
        List<PersonVM> peopleVM = new ArrayList<PersonVM>();
        
        for(PersonModel personModel : peopleModel){
            peopleVM.add(new PersonVM(personModel));
        }
        return peopleVM;
    }
    
    public PersonVM get(int id){
        PersonModel personModel = personService.get(id);
        return new PersonVM(personModel);
    }
    
    public void update(PersonVM personVM){
        PersonModel personModel = new PersonModel(
                personVM.id,
                personVM.name,
                personVM.document,
                PersonTypeEnum.fromInteger(personVM.type),
                new Address(personVM.street, personVM.number, personVM.neighborhood, personVM.city, personVM.state, personVM.postalCode, personVM.country),
                personVM.birthDate,
                personVM.observation,
                personVM.customer,
                personVM.staff,
                personVM.supplier
        );
        
        personService.update(personModel);
    }
    
    public void delete(int id){
        personService.remove(id);
    }
}
