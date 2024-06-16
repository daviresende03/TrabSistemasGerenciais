package application.applications;

import application.mappers.OperatorMap;
import application.viewModels.OperatorLoginVM;
import application.viewModels.OperatorVM;
import domain.interfaces.services.IOperatorService;
import domain.model.entities.ResponseService;

public class OperatorApplication {
    private final IOperatorService operatorService;

    public OperatorApplication(IOperatorService operatorService){
        this.operatorService = operatorService;
    }

    public ResponseService getResponseService(){
        return operatorService.getResponseService();
    }

    public OperatorVM login(OperatorLoginVM operatorLoginVM){
        return OperatorMap.getOperatorVM(operatorService.login(OperatorMap.getOperator(operatorLoginVM)));
    }
}
