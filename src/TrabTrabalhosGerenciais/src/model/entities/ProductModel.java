package model.entities;

import model.enums.ProductTypeEnum;


public class ProductModel extends BaseModel{
    private String name;
    private ProductTypeEnum type;
    private UnitModel unit;
    private double costPrice;
    private double salePrice;
    private double stock;

    public ProductModel(String name, ProductTypeEnum type, UnitModel unit, double costPrice, double salePrice, double stock) {
        this.name = name;
        this.type = type;
        this.unit = unit;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.stock = stock;
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
    
    
}
