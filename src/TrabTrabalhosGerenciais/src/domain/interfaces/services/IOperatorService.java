package domain.interfaces.services;

import domain.model.entities.OperatorModel;
import domain.model.entities.ResponseService;

public interface IOperatorService {
    ResponseService getResponseService();
    OperatorModel login(OperatorModel operator);
}
