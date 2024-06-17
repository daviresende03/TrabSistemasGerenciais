package application.mappers;

import application.viewModels.PersonVM;
import domain.model.entities.PersonModel;
import domain.model.enums.PersonTypeEnum;
import domain.model.valueObjects.Address;

import java.util.ArrayList;
import java.util.List;

public class PersonMap {
    public static PersonModel getPerson(PersonVM personVM){
        return new PersonModel(
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
    }

    public static PersonVM getPersonVM(PersonModel model){
        return new PersonVM(
            model.getId(),
            model.getName(),
            model.getDocument(),
            model.getType().getValue(),
            model.getAddress().getStreet(),
            model.getAddress().getNumber(),
            model.getAddress().getNeighborhood(),
            model.getAddress().getCity(),
            model.getAddress().getState(),
            model.getAddress().getPostalCode(),
            model.getAddress().getCountry(),
            model.getBirthDate(),
            model.getObservation(),
            model.getCustomer(),
            model.getStaff(),
            model.getSupplier()
        );
    }

    public static List<PersonVM> getPeopleVM(List<PersonModel> people){
        List<PersonVM> peopleVM = new ArrayList<PersonVM>();
        for(PersonModel person : people){
            peopleVM.add(getPersonVM(person));
        }
        return peopleVM;
    }
}
