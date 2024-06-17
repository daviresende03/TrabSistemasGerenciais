package application.viewModels;

import domain.model.entities.UnitModel;

public class UnitVM {
    public int id;
    public String name;
    public String symbol;
    
    public UnitVM(){}

    public UnitVM(int id, String name, String symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }
}
