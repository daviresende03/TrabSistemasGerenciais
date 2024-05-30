package model.enums;

public enum ProductTypeEnum {
    NONE(0),
    PRODUCT_SALE(1),
    PLATE_LUNCH(2);
    
    private final int value;
    
    ProductTypeEnum(int value){
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }
    
    public static ProductTypeEnum fromInteger(int type){
        switch(type){
            case 1:
                return PRODUCT_SALE;
            case 2:
                return PLATE_LUNCH;
        }
        return NONE;
    }
}
