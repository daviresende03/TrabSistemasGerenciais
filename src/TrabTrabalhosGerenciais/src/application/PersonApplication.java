package application;

import controller.viewModels.PersonVM;
import model.entities.PersonModel;
import model.entities.ResponseService;
import model.enums.PersonTypeEnum;
import model.interfaces.services.IPersonService;
import model.valueObjects.Address;

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
}
