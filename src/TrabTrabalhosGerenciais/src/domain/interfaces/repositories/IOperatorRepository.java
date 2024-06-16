package domain.interfaces.repositories;

import domain.model.entities.OperatorModel;

public interface IOperatorRepository extends IBaseRepository<OperatorModel>{
    OperatorModel selectByPasswordHash(String passwordHash);
}
