package domain.model.entities;

import domain.model.enums.FinanceTypeEnum;

import java.util.Date;

public class FinanceModel extends BaseModel{
    private int financeId;
    private int cashRegisterId;
    private FinanceTypeEnum type;
    private double value;
    private String description;
    private Date createdAt;
    
    public FinanceModel(int cashRegisterId, FinanceTypeEnum type, double value, String description){
        this.cashRegisterId = cashRegisterId;
        this.type = type;
        this.value = value;
        this.description = description;
    }
    
    public FinanceModel(int financeId, int cashRegisterId, FinanceTypeEnum type, double value, String description){
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
    
    public FinanceTypeEnum getType() {
        return type;
    }

    public void setType(FinanceTypeEnum type) {
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
        if(type.getValue() != FinanceTypeEnum.RECEIPT.getValue() &&
           type.getValue() != FinanceTypeEnum.PAYMENT.getValue()){
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
