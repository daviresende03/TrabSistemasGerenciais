package domain.model.enums;

public enum FinanceTypeEnum {
    RECEIPT(1),
    PAYMENT(2);

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
                return RECEIPT;
            case 2:
                return PAYMENT;
        }
        return null;
    }
}

