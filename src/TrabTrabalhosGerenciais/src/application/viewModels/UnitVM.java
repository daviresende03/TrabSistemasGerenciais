package application.viewModels;

import domain.model.entities.UnitModel;

public class UnitVM {
    public int id;
    public String name;
    public String symbol;
    
    public UnitVM(){}
    
    public UnitVM(UnitModel unitModel){
        id = unitModel.getId();
        name = unitModel.getName();
        symbol = unitModel.getSymbol();
    }
}
