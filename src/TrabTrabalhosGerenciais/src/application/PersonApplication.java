package application;

import controller.viewModels.PersonVM;
import domain.model.entities.PersonModel;
import domain.model.entities.ResponseService;
import domain.model.enums.PersonTypeEnum;
import domain.interfaces.services.IPersonService;
import domain.model.valueObjects.Address;

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
