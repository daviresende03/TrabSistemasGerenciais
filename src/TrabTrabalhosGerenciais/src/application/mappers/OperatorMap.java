package application.mappers;

import application.viewModels.OperatorLoginVM;
import application.viewModels.OperatorVM;
import domain.model.entities.OperatorModel;

public class OperatorMap {
    public static OperatorModel getOperator(OperatorLoginVM loginVM){
        return new OperatorModel(0, loginVM.username, loginVM.password, true);
    }

    public static OperatorVM getOperatorVM(OperatorModel operatorModel){
        return new OperatorVM(operatorModel.getId(), operatorModel.getUsername(), "", operatorModel.getIsAdmin());
    }
}
