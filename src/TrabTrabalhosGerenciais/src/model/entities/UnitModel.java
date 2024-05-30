package model.entities;

import java.util.Objects;

public class UnitModel extends BaseModel{
    private String name;
    private String symbol;

    public UnitModel(String name, String symbol) {
        this.name = Objects.requireNonNullElse(name,"");
        this.symbol = Objects.requireNonNullElse(symbol,"");
    }
    
    public UnitModel(int id, String name, String symbol) {
        setId(id);
        this.name = Objects.requireNonNullElse(name,"");
        this.symbol = Objects.requireNonNullElse(symbol,"");
    }
    
    public UnitModel(int id){
        setId(id);
        this.name = Objects.requireNonNullElse(name,"");
        this.symbol = Objects.requireNonNullElse(symbol,"");
    }
    
    public UnitModel(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    public boolean validate(){
        if(name.isEmpty()){
            addMessage("Nome da unidade é obrigatório.");
            return false;
        }
        
        if(symbol.isEmpty()){
            addMessage("Símbolo da unidade é obrigatório.");
            return false;
        }
        
        return true;
    }
    
}
