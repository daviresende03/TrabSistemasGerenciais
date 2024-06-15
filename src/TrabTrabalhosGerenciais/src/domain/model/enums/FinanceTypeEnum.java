package domain.model.enums;

public enum FinanceTypeEnum {
    RECEBIMENTO(1),
    PAGAMENTO(2);
    
    private final int value;
    
    FinanceTypeEnum(int value){
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }
    
     public static FinanceTypeEnum fromInteger(int type){
        switch(type){
            case 1:
                return RECEBIMENTO;
            case 2:
                return PAGAMENTO;
        }
        return null;
    }
}

