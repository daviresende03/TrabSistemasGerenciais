package model.enums;

public enum ProductTypeEnum {
    PRODUCT_SALE(1),
    PLATE_LUNCH(2);
    
    private final int value;
    
    ProductTypeEnum(int value){
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }
}
