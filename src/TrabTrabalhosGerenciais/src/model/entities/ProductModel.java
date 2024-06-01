package model.entities;

import java.util.Objects;
import model.enums.ProductTypeEnum;


public class ProductModel extends BaseModel{
    private String name;
    private ProductTypeEnum type;
    private UnitModel unit;
    private double costPrice;
    private double salePrice;
    private double stock;

    public ProductModel(int id, String name, ProductTypeEnum type, UnitModel unit, double costPrice, double salePrice, double stock) {
        setId(id);
        this.name = Objects.requireNonNullElse(name, "");
        this.type = Objects.requireNonNullElse(type, ProductTypeEnum.NONE);
        this.unit = Objects.requireNonNullElse(unit, new UnitModel("",""));
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.stock = stock;
    }
    
    public ProductModel(String name, ProductTypeEnum type, UnitModel unit, double costPrice, double salePrice, double stock) {
        this.name = Objects.requireNonNullElse(name, "");
        this.type = Objects.requireNonNullElse(type, ProductTypeEnum.NONE);
        this.unit = Objects.requireNonNullElse(unit, new UnitModel("",""));
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.stock = stock;
    }
    
    public ProductModel(){}
    
    public ProductModel(int id){
        setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductTypeEnum getType() {
        return type;
    }

    public void setType(ProductTypeEnum type) {
        this.type = type;
    }

    public UnitModel getUnit() {
        return unit;
    }

    public void setUnit(UnitModel unit) {
        this.unit = unit;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }
    
    public void increaseStock(double quantity){
        this.stock+=quantity;
    }
    
    public void decreaseStock(double quantity){
        this.stock-=quantity;
    }
    
    public boolean validate(){
        if(name.isEmpty()){
            addMessage("Nome do produto é obrigatório.");
            return false;
        }
        
        if(type.getValue() == 0){
            addMessage("Tipo do produto é obrigatório.");
            return false;
        }
        
        if(!unit.validate()){
            addMessage(unit.getMessage());
            return false;
        }
        
        if(costPrice <= 0){
            addMessage("Preço de Custo do produto precisa ser maior que zero.");
            return false;
        }
        
        if(salePrice <= 0 ){
            addMessage("Preço de Venda do produto precisa ser mair que zero.");
            return false;
        }
        
        if(stock < 0){
            addMessage("Estoque do produto precisar ser maior ou igual a zero.");
            return false;
        }
        
        return true;
    }
    
    
}
