package domain.model.enums;

public enum PersonTypeEnum {
    PF(1),
    PJ(2);
    
    private final int value;
    
    PersonTypeEnum(int value){
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }
    
     public static PersonTypeEnum fromInteger(int type){
        switch(type){
            case 1:
                return PF;
            case 2:
                return PJ;
        }
        return null;
    }
}

