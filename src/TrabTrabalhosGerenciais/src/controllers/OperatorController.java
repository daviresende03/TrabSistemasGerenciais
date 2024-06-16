package controllers;

import application.applications.OperatorApplication;
import application.viewModels.OperatorLoginVM;
import application.viewModels.OperatorVM;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.services.IOperatorService;
import domain.model.entities.ResponseService;
import infra.dependencyInjections.OperatorDI;

public class OperatorController {
    private final OperatorApplication operatorApplication;

    public OperatorController(){
        OperatorDI operatorDependencyInjection = new OperatorDI();
        IDataContext dataContext = operatorDependencyInjection.getDataContext();
        IOperatorService operatorService = operatorDependencyInjection.getOperatorService(
                dataContext,
                operatorDependencyInjection.geOperatorRepository(dataContext.getConnection()));

        operatorApplication = new OperatorApplication(operatorService);
    }

    public ResponseService getResponseService(){
        return operatorApplication.getResponseService();
    }

    public OperatorVM login(OperatorLoginVM loginVM){
        return this.operatorApplication.login(loginVM);
    }
}
