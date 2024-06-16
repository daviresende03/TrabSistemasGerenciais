package domain.model.entities;

import java.util.Date;

public class FinanceModel extends BaseModel{
    private int financeId;
    private int cashRegisterId;
    private int type;
    private double value;
    private String description;
    private Date createdAt;
    
    public FinanceModel(int cashRegisterId, int type, double value, String description){
        this.cashRegisterId = cashRegisterId;
        this.type = type;
        this.value = value;
        this.description = description;
    }
    
    public FinanceModel(int financeId, int cashRegisterId, int type, double value, String description){
        setId(financeId);
        this.cashRegisterId = cashRegisterId;
        this.financeId = financeId;
        this.type = type;
        this.value = value;
        this.description = description;
    }
    
    public FinanceModel(){}

    public int getFinanceId() {
        return financeId;
    }

    public void setFinanceId(int financeId) {
        this.financeId = financeId;
    }
    
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCashRegisterId(int cashRegisterId){
        this.cashRegisterId = cashRegisterId;
    }

    public int getCashRegisterId(){
        return cashRegisterId;
    }
    
    public boolean validate(){
        if(type <= 0){
            addMessage("Tipo de registro é obrigatório.");
            return false;
        }
        
        if(value <= 0){
            addMessage("Valor é obrigatório.");
            return false;
        }
        
        if(description.isEmpty()){
            addMessage("Descrição é obrigatória.");
            return false;
        }
         
        return true;
    }
}
