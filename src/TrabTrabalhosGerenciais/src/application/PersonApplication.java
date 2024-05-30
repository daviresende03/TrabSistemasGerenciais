package application;

import controller.viewModels.PersonVM;
import model.entities.PersonModel;
import model.enums.PersonTypeEnum;
import model.interfaces.services.IPersonService;

public class PersonApplication {
    private final IPersonService personService;
    
    public PersonApplication(IPersonService personService){
        this.personService = personService;
    }
    
    public void create(PersonVM personVM){
        PersonModel personModel = new PersonModel(
                personVM.name,
                personVM.document,
                PersonTypeEnum.fromInteger(personVM.type),
                personVM.address,
                personVM.birthDate,
                personVM.observation,
                personVM.customer,
                personVM.staff,
                personVM.supplier
        );
        personService.insert(personModel);
    }
}
