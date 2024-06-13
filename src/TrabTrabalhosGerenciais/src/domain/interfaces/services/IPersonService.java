
package domain.interfaces.services;

import domain.model.entities.PersonModel;
import java.util.List;

public interface IPersonService extends IBaseService<PersonModel>{
    List<PersonModel> getAll(boolean isCustomer, boolean isStaff, boolean isSupplier);
}
